package chapter8.observer;

/**
 * Created by fall1999y on 2016. 7. 22..
 */
public class LeMonde implements Observer {
    @Override
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("wine")) {
            System.out.println("Today cheese, wine and news ! " + tweet);
        }
    }
}
