package chapter3;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Created by fall1999y on 2016. 6. 28..
 */
public class BoxingPredicate {
    public static void main(String[] args) {

        IntPredicate evenNumber = (int i) -> i % 2 == 0;
        System.out.println(evenNumber.test(8));
        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 1;
        System.out.println(oddNumbers.test(4));


    }

}
