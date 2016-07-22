package chapter8.chain;

/**
 * Created by fall1999y on 2016. 7. 22..
 */
public class HeaderTextProcessing extends ProcessingObject<String> {

    @Override
    protected String handleWork(String input) {
        return "From Raoul, Mario and Alan: "  + input;
    }
}
