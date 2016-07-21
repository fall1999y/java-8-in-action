package chapter8.strategy;

/**
 * Created by fall1999y on 2016. 7. 22..
 */
public class isNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("\\d");
    }
}
