package chapter6;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * Created by fall1999y on 2016. 7. 13..
 */
public class PrimeMain {

    public boolean isPrime(int candidate) {
        int cadidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, cadidateRoot).noneMatch(i -> candidate % i == 0);
    }

    public Map<Boolean, List<Integer>> partitionPrime(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(partitioningBy(c -> isPrime(c)));
    }
    public static void main(String[] args) {

        System.out.println(new PrimeMain().partitionPrime(10));

    }
}
