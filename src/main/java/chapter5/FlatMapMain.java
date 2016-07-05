package chapter5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fall1999y on 2016. 7. 5..
 */
public class FlatMapMain {
    public static void main(String[] args) {
        String[] words = {"Helloo2", "Worldo2"};
        List<String[]> wordList = Arrays.stream(words).map(word -> word.split("")).distinct().collect(Collectors
                .toList());
        wordList.stream().forEach(w -> {
            Arrays.stream(w).forEach(System.out::println);
        });

        Arrays.stream(words).map(w -> w.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::print);
        System.out.println("\n--");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream().map(i -> i * i).forEach(System.out::println);

        System.out.println("\n");
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> pair = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j})).collect
                (Collectors.toList());

        pair.stream().forEach(p -> {
            Arrays.stream(p).forEach(System.out::print);
            System.out.println("\n");
        });

        System.out.println("\n");
        numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j})).filter(k -> (k[0] + k[1]) % 3 ==
                0).forEach(n -> {
            Arrays.stream(n).forEach(System.out::print);
            System.out.println("\n");
        });

        System.out.println("\n");
        numbers1.stream().flatMap(i -> numbers2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j}))
                .forEach(k -> {
                    Arrays.stream(k).forEach(System.out::print);
                    System.out.println("\n");
                });
    }
}
