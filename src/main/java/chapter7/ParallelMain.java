package chapter7;

import java.nio.channels.Pipe;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by fall1999y on 2016. 7. 15..
 */
public class ParallelMain {
    public static void main(String[] args) {

        System.out.println(sequnetialSum(29));
        System.out.println(iterativeSum(29));
        System.out.println(parallelSum(29));


        System.out.println(measureSumPref(ParallelMain::sequnetialSum, 10_000_000));
        System.out.println(measureSumPref(ParallelMain::parallelSum, 10_000_000));
        System.out.println(measureSumPref(ParallelMain::iterativeSum, 10_000_000));
        System.out.println(measureSumPref(ParallelMain::rangedSum, 10_000_000));
        System.out.println(measureSumPref(ParallelMain::parallelRangedSum, 10_000_000));
        System.out.println(measureSumPref(ParallelMain::sideEffectSum, 10_000_000));
        System.out.println(measureSumPref(ParallelMain::sideEffectParallelSum, 10_000_000));
        System.out.println(measureSumPref(ForkJoinSumCalculator::forkJoinSum, 10_000_000));
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(0L, Long::sum);
    }
    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
    }
    public static long sequnetialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i->i+1).limit(n).parallel().reduce(0L, Long::sum);
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for(long i = 1L; i<=n; i++) {
            result += i;
        }

        return result;
    }

    public static long measureSumPref(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for(int i = 0; i< 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1000000;
            System.out.println("Result : " + sum);
            if(duration < fastest) fastest = duration;
        }
        return fastest;
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }
}
