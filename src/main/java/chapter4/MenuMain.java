package chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Created by fall1999y on 2016. 7. 4..
 */
public class MenuMain {
    public static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", false, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

    public static void main(String[] args) {

        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : menu) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }

        lowCaloricDishes.sort(new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }

        });

        List<String> lowCaloricDishesName7 = new ArrayList<>();
        for (Dish d :
                lowCaloricDishes) {
            lowCaloricDishesName7.add(d.getName());
        }
        System.out.println(lowCaloricDishesName7);

        long s = System.nanoTime();

        List<String> lowCaloricDishesName = menu.stream().filter(m -> m.getCalories() < 400).sorted(comparing
                (Dish::getCalories)).map(Dish::getName).collect(toList());

        System.out.println(lowCaloricDishesName);

        long e = System.nanoTime();

        System.out.println(e - s);

        s = System.nanoTime();

        List<String> lowCaloricDishesNameParallel = menu.parallelStream().filter(m -> m.getCalories() < 400).sorted
                (comparing(Dish::getCalories)).map(Dish::getName).collect(toList());

        System.out.println(lowCaloricDishesNameParallel);

        e = System.nanoTime();

        System.out.println(e - s);

        List<String> highCaloricDishesName = menu.stream().filter(m -> m.getCalories() > 300).sorted(comparing
                (Dish::getCalories).reversed()).limit(3).map(Dish::getName).collect(Collectors.toList());
        System.out.println(highCaloricDishesName);

        List<String> names = menu.stream().filter(d -> {
            System.out.println("filter : " + d.getCalories());
            return d.getCalories() > 400;
        }).map(d -> {
            System.out.println("map : " + d.getName());
            return d.getName();
        }).limit(5).collect(Collectors.toList());

        menu.stream().forEach(System.out::println);

        List<Dish> vegetarianMenu = menu.stream().filter(Dish::isVegerarian).collect(Collectors.toList());
        System.out.println(vegetarianMenu);
    }
}
