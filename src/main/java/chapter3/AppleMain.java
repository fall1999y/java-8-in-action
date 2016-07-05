package chapter3;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * Created by fall1999y on 2016. 6. 27..
 */
public class AppleMain {
    public static void main(String[] args) {

        Comparator<Apple> byWeight = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        };

        Comparator<Apple> byWeightLambda = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        List<Apple> heavyApples = filter(Arrays.asList(new Apple(80), new Apple(120), new Apple(100), new Apple(200)),
                (Apple a) -> a.getWeight().equals(new Integer(200)));

        System.out.println(heavyApples);
        for (Apple a :
                heavyApples) {
            System.out.println(a);
        }

        List<Apple> inventory = Arrays.asList(new Apple(80), new Apple(120), new Apple(100), new Apple(200), new Apple(100,"red"));
        inventory.sort((a, b) -> a.getWeight().compareTo(b.getWeight()));

        System.out.println(inventory);

        inventory.sort(comparing(Apple::getWeight));

        Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);

        System.out.println(stringConversionTest("1234", stringToInteger));
        System.out.println(stringConversionTest("3333", Integer::parseInt));

        Supplier<Apple> c1 = Apple::new;
        System.out.println(c1.get());

        c1 = () -> new Apple();
        System.out.println(c1.get());

        Function<Integer, Apple> c2 = Apple::new;
        System.out.println(c2.apply(123));

        c2 = i -> new Apple(i);
        System.out.println(c2.apply(1234));

        List<Integer> weights = Arrays.asList(12, 45, 1, 44);
        List<Apple> apples = map(weights, Apple::new);
        System.out.println(apples);

        BiFunction<Integer, String, Apple> bf = Apple::new;
        System.out.println(bf.apply(1234, "green"));

        BiFunction<Integer, String, Apple> bf2 = (i, s) -> new Apple(i, s);
        System.out.println(bf2.apply(22, "red"));
        System.out.println(map.get("red").apply(111));

        TriFunction<Integer, String, String, Apple> tf = Apple::new;

        System.out.println(tf.ap(77, "Gold", "Brown"));

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        System.out.println(inventory);

        inventory.sort(new AppleComporator());

        System.out.println(inventory);

        inventory.sort((a, b) -> a.getWeight().compareTo(b.getWeight()));

        System.out.println(inventory);

        inventory.sort(comparing(a -> a.getWeight()));

        inventory.sort(comparing(Apple::getWeight));
        System.out.println(inventory);

        inventory.sort(comparing(Apple::getWeight).reversed());
        System.out.println(inventory);

        long s = System.nanoTime();

        // 무게 정렬 -> 무게의 역순 정렬 -> 동일무게 색상 정렬
        inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        long e = System.nanoTime();

        System.out.println(e - s);

        System.out.println(inventory);

        s = System.nanoTime();

        // 무게 정렬 -> 동일무게 색상 정렬 -> *전체* 역순 정렬

        inventory.sort(comparing(Apple::getWeight).thenComparing(Apple::getColor).reversed());
        e = System.nanoTime();

        System.out.println(e - s);

        System.out.println(inventory);

        Predicate<Apple> p = a -> a.getColor().equals("black");
        List blackApples = inventory.stream().filter(p).collect(Collectors.toList());

        System.out.println(blackApples);
        Predicate p2 = p.negate();
        System.out.println(inventory.stream().filter(p2).collect(Collectors.toList()));

        System.out.println(inventory.stream().filter(p.and(a -> a.getWeight() > 100)).collect(Collectors.toList()));
    }

    public static class AppleComporator implements Comparator<Apple> {

        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight().compareTo(o2.getWeight());
        }

    }

    static Map<String, Function<Integer, Apple>> map = new HashMap<>();

    static {
        map.put("red", Apple::new);
        map.put("blue", Apple::new);
    }

    @FunctionalInterface
    public interface TriFunction<T, U, V, R> {
        R ap(T t, U u, V v);
    }

    private static List<Apple> map(List<Integer> weights, Function<Integer, Apple> f) {
        List<Apple> apples = new ArrayList<Apple>();
        for (Integer w :
                weights) {
            apples.add(f.apply(w));
        }

        return apples;
    }

    public static Integer stringConversionTest(String s, Function<String, Integer> f) {
        return f.apply(s);
    }

    public static <T> List<T> filter(List<T> inventory, Predicate<T> p) {
        List<T> result = new ArrayList<T>();
        for (T a :
                inventory) {
            if (p.test(a)) {
                result.add(a);
            }
        }

        return result;
    }
}
