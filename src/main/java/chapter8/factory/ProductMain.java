package chapter8.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by fall1999y on 2016. 7. 22..
 */
public class ProductMain {
    public static void main(String[] args) {
        Product p = ProductFactory.createProduct("loan");
        System.out.println(p);

        Supplier<Product> loanSupplier = Loan::new;
        Loan loan = (Loan) loanSupplier.get();
        System.out.println(loan);

        System.out.println(createProduct("stock"));

    }

    public static Product createProduct(String name) {
        Supplier<Product> p = map.get(name);
        if(p != null) return p.get();
        throw new IllegalArgumentException("No such product" + name);
    }

    final static Map<String, Supplier<Product>> map = new HashMap<>();
    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
    }
}
