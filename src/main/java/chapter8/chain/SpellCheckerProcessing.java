package chapter8.chain;

/**
 * Created by fall1999y on 2016. 7. 22..
 */
public class SpellCheckerProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return input.replace("labda", "lambda");
    }
}
