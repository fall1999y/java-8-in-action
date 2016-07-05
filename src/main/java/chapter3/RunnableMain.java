package chapter3;

/**
 * Created by fall1999y on 2016. 6. 27..
 */
public class RunnableMain {
    public static void main(String[] args) {

        Runnable r1 = () -> {
            System.out.println("1");
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("2");

            }
        };

        r1.run();
        r2.run();
        process(() -> {
            System.out.println(3);
        });



    }

    public static void process(Runnable r) {
        r.run();
    }
}
