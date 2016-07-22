package chapter8.factory;

/**
 * Created by fall1999y on 2016. 7. 22..
 */
public class ProductFactory {

    public static Product createProduct(String name) {
        switch (name) {
            case "loan" :
                return new Loan();
            case "stock" :
                return new Stock();
            default :
                throw new RuntimeException("No such product" + name);
        }
    }

}
