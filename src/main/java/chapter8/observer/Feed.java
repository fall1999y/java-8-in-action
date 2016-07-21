package chapter8.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fall1999y on 2016. 7. 22..
 */
public class Feed {
    private final List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }

    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());

        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");

        f.registerObserver(s -> {
            if(s != null && s.contains("wine")) {
                System.out.println("Le Monde news ! : "+s);
            }
        });

        f.notifyObservers("queen like wine");
    }
}
