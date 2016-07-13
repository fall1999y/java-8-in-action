package chapter5;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * Created by fall1999y on 2016. 7. 10..
 */
public class PythagoreanMain {
    public static void main(String[] args) {
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed().flatMap(
                a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b ->
                                new int[]{a, b, (int) Math.sqrt(a * a + b * b)}
                        )
        );

        pythagoreanTriples.limit(5).forEach(a -> System.out.println(a[0] + "|" + a[1] + "|" + a[2]));

        Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed().flatMap(
                a -> IntStream.rangeClosed(a, 100).mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0)
        );

        pythagoreanTriples2.limit(5).forEach(a -> {
            Arrays.stream(a).forEach(System.out::print);
            System.out.println("-----------");
        });
    }
}
