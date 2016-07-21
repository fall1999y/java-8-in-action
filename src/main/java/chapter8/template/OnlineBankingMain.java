package chapter8.template;

/**
 * Created by fall1999y on 2016. 7. 22..
 */
public class OnlineBankingMain {
    public static void main(String[] args) {

        OnlineBanking b = new OnlineBanking() {
            @Override
            void makeCustomerHappy(String customer) {
                System.out.println(customer + " is happy");
            }
        };

        b.processCustomer(1);


        new OlineBankingLambda().processCustomer(2, (id) -> System.out.println(id + "is happy"));

    }
}
