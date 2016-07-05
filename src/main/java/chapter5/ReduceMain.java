package chapter5;

import java.util.Arrays;
import java.util.List;

import static chapter4.MenuMain.menu;

/**
 * Created by fall1999y on 2016. 7. 6..
 */
public class ReduceMain {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 4, 5, 7, 8, 9);

        Integer result = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(result);
        System.out.println(numbers.stream().reduce(1, Integer::max));
        System.out.println(numbers.stream().reduce(1, (a, b) -> a * b));

        numbers.stream().reduce(Integer::max).ifPresent(System.out::println);
        numbers.stream().reduce(Integer::min).ifPresent(System.out::println);
        menu.stream().map(d -> 1).reduce(Integer::sum).ifPresent(System.out::println);
        System.out.println(menu.stream().count());
    }
}
