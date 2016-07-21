package chapter8.strategy;

/**
 * Created by fall1999y on 2016. 7. 22..
 */
public class Validator {
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }

    public static void main(String[] args) {

        Validator numericValidator = new Validator(new isNumeric());
        System.out.println(numericValidator.validate("aaaa"));

        Validator lowerCaseValidator = new Validator(new IsAllowCase());
        System.out.println(lowerCaseValidator.validate("bbbb"));

        System.out.println("bbbb".matches("[a-z]+"));

        Validator lambdaValidator = new Validator((String s) -> s.matches("[a-z]+"));
        System.out.println(lambdaValidator.validate("bbbb"));
    }
}
