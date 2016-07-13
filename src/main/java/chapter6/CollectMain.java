package chapter6;

import chapter4.Dish;
import chapter4.MenuMain;

import java.util.*;

import static chapter4.MenuMain.menu;
import static java.util.stream.Collectors.*;

/**
 * Created by fall1999y on 2016. 7. 13..
 */
public class CollectMain {
    public static void main(String[] args) {
//        Comparator<Dish> dishComparator = Comparator.comparing(Dish::getCalories);
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = MenuMain.menu.stream().collect(maxBy(dishComparator));
        mostCalorieDish.ifPresent(System.out::println);

        int totalCalories = MenuMain.menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(totalCalories);

        System.out.println(MenuMain.menu.stream().collect(averagingInt(Dish::getCalories)));

        IntSummaryStatistics menuStatistics = MenuMain.menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);

        String shortMenu = MenuMain.menu.stream().map(Dish::getName).collect(joining());
        System.out.println(shortMenu);
        System.out.println(MenuMain.menu.stream().map(Dish::getName).collect(joining(", ")));

        totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println(totalCalories);

        mostCalorieDish = menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories
                () ? d1 : d2));

        System.out.println(mostCalorieDish);

        totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(totalCalories);

        int cnt = menu.stream().collect(reducing(0, m -> 1, Integer::sum));
        System.out.println(cnt);

        totalCalories = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        System.out.println(totalCalories);

        totalCalories = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(totalCalories);

        Map<String, List<Dish>> dishebyCaloricLevel = menu.stream().collect(groupingBy(dish -> {

            if (dish.getCalories() < 400)
                return "low";
            else if (dish.getCalories() <= 700)
                return "middle";
            else
                return "high";

        }));

        System.out.println(dishebyCaloricLevel);
    }
}
