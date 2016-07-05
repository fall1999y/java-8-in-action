package chapter5;

import chapter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static chapter4.MenuMain.menu;

/**
 * Created by fall1999y on 2016. 7. 6..
 */
public class MatchMain {
    public static void main(String[] args) {
        if (menu.stream().anyMatch(Dish::isVegerarian)) {
            System.out.println("vegeraian");
        }

        boolean isHealth = menu.stream().allMatch(d -> d.getCalories() < 1000);
        System.out.println(isHealth);

        isHealth = menu.stream().noneMatch(d -> d.getCalories() > 1000);
        System.out.println(isHealth);

        Optional<Dish> dish = menu.stream().filter(Dish::isVegerarian).findFirst();
        System.out.println(dish.get());

        menu.stream().filter(Dish::isVegerarian).findAny().ifPresent(System.out::println);

        List<Integer> someNumbers = Arrays.asList(1,3,4,5,7,9);

        someNumbers.stream().map(x -> x * x).filter(x -> x % 3 == 0).findFirst().ifPresent(System.out::println);
    }
}
