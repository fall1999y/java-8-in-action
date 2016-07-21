package chapter8.template;

import java.util.function.Consumer;

/**
 * Created by fall1999y on 2016. 7. 22..
 */
public class OlineBankingLambda {
    public void processCustomer(int id, Consumer<String> makeCustmerHappy) {
        // 아이디로 부터 고객정보를 가져온다
        String customer = id + " is id";

        // 지점은행마다 커스터마이징한다.
        makeCustmerHappy.accept(customer);
    }
}
