package chapter3;

import java.util.function.Function;

/**
 * Created by fall1999y on 2016. 6. 30..
 */
public class FunctionCombination {

    public static void main(String[] args) {

        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);

        System.out.println(h.apply(1));

        Function<Integer, Integer> j = f.compose(g);

        System.out.println(j.apply(1));

        Function<String, String> addHeader = Letter::addHeader;

        System.out.println(addHeader.apply("kkkk"));

        Function<String, String> addFooter = Letter::addFooter;
        Function<String, String> check = Letter::check;

        Function<String, String> transFormation = addHeader.andThen(addFooter).andThen(check);

        System.out.println(transFormation.apply("lamda"));
    }

    public static class Letter {
        public static String addHeader(String text) {
            return "Header : " + text;
        }

        public static String addFooter(String t) {
            return "footer : " + t;
        }

        public static String check(String t) {
            return t.replace("lamda", "lambda");
        }
    }
}
