package chapter8.observer;

/**
 * Created by fall1999y on 2016. 7. 22..
 */
public class Guardian implements Observer {
    @Override
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("queen")) {
            System.out.println("Yet another news in London.." + tweet);
        }
    }
}
