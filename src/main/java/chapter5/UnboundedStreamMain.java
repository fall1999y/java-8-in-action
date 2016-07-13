package chapter5;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by fall1999y on 2016. 7. 12..
 */
public class UnboundedStreamMain {
    public static void main(String[] args) {

        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

        // Stream.iterate UnaryOperator<T>
        Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]}).limit(20).forEach(a -> System.out
                .println("(" + a[0] + ", " + a[1] + ")"));

        Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]}).map(a -> a[0]).limit(10).forEach(System
                .out::println);

        // Stream.generate Supplier<T>
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        // unboxing  IntSupplier
        IntStream ones = IntStream.generate(() -> 1).limit(5);
        ones.forEach(System.out::println);

        System.out.println("\n");
        // mutable
        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;
            @Override
            public int getAsInt() {
                int old = this.previous;
                int next = this.previous + current;

                this.previous = this.current;
                this.current = next;

                return old;
            }
        };

        IntStream.generate(fib).limit(10).forEach(System.out::println);
        
    }

}
