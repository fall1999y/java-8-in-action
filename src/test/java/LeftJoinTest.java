import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by fall1999y on 2016. 7. 26..
 */
public class LeftJoinTest {

    @Test
    public void emptyTest() {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> compareInt = Arrays.asList(1, 3, 4, 5, 7, 8);

        List<String> result = ints.stream().map(i -> compareInt.stream().filter((Integer j) -> i.equals(j)).findFirst().map(j ->
                new String(i + "|" + j)).orElse(new String( i+"|null"))).collect(toList());

        System.out.println(result);
    }
}
