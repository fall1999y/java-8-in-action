package chapter7;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by fall1999y on 2016. 7. 18..
 */
public class SpliteratorMain {

    public static int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;

            } else {
                if (lastSpace) {
                    counter++;
                }
                lastSpace = false;
            }
        }

        return counter;
    }

    static final String SENTENCE =
            " Nel    mezzo del cammin    di nostra   vita " +
                    "mi     ritrovai in una    selva oscura" +
                    " ch    la   dritta  via era    smarrita ";

    public static void main(String[] args) {
        System.out.println(countWordsIteratively(SENTENCE));

//        Stream<Character> stream = IntStream.range(0, SENTENCE.length()).mapToObj(SENTENCE::charAt);
//        System.out.println(countWord(stream));
//        System.out.println(countWord(stream.parallel()));

        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);
        System.out.println(countWord(stream));

    }

    private static int countWord(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true), WordCounter::accumulate,
                WordCounter::combine);
        return wordCounter.getCounter();
    }
}
