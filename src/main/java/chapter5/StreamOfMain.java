package chapter5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by fall1999y on 2016. 7. 12..
 */
public class StreamOfMain {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::print);

        Stream<String> emptyStream = Stream.empty();

        System.out.println("\n");
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);

//        System.out.println(System.getProperty("user.dir") + "/data.txt");

        System.out.println(DishMain.class.getResource("data.txt"));

        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get(StreamOfMain.class.getResource("data.txt").getPath()),
                Charset.defaultCharset())) {

            // split line array -> flatMap 으로 평면화.. array 단일화
           uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(uniqueWords);
    }
}
