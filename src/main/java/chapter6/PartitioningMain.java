package chapter6;

import chapter4.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static chapter4.MenuMain.menu;
import static java.util.stream.Collectors.*;

/**
 * Created by fall1999y on 2016. 7. 13..
 */
public class PartitioningMain {
    public static void main(String[] args) {
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream().collect(partitioningBy(Dish::isVegerarian));

        System.out.println(partitionedMenu);
        System.out.println(partitionedMenu.get(true));

        List<Dish> vegetarianDishes = menu.stream().filter(Dish::isVegerarian).collect(Collectors.toList());
        System.out.println(vegetarianDishes);

        Map<Boolean, List<Dish>> groupeddMenu = menu.stream().collect(groupingBy(Dish::isVegerarian));
        System.out.println(groupeddMenu);

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream().collect(partitioningBy
                (Dish::isVegerarian, collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)),
                        Optional::get)));

        System.out.println(mostCaloricPartitionedByVegetarian);

    }
}
