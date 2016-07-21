package chapter8.strategy;

/**
 * Created by fall1999y on 2016. 7. 21..
 */
public class IsAllowCase  implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }

}
