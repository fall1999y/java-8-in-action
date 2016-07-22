package chapter8.chain;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Created by fall1999y on 2016. 7. 22..
 */
public class ChainMain {
    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);

        String result = p1.handle("Aren't labdas really sexy?!!");
        System.out.println(result);

        UnaryOperator<String> headerProcessing = t -> "From Raoul, Mario and Alan:" + t;
        UnaryOperator<String> spellCheckerProcessing = t -> t.replaceAll("labda", "lambda");

        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);

        System.out.println(pipeline.apply("Aren't labdas really sexy?!!"));

    }
}
