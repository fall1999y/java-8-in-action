package chapter6;

import chapter4.Dish;
import chapter4.FatDish;

import java.util.*;
import java.util.stream.Collectors;

import static chapter4.MenuMain.menu;
import static java.util.stream.Collectors.*;

/**
 * Created by fall1999y on 2016. 7. 13..
 */
public class GroupMain {
    public enum CaloricLevel {DIET, NORMAL, FAT}

    public static void main(String[] args) {

        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);


        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(groupingBy(d -> {
            if (d.getCalories() <= 400)
                return CaloricLevel.DIET;

            return d.getCalories() <= 700 ? CaloricLevel.NORMAL : CaloricLevel.FAT;
        }));

        System.out.println(dishesByCaloricLevel);

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(groupingBy
                (Dish::getType, groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                })));

        System.out.println(dishesByTypeCaloricLevel);

        Map<Dish.Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, counting()));

        System.out.println(typesCount);

        Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream().collect(groupingBy(Dish::getType, maxBy
                (Comparator.comparingInt(Dish::getCalories))));

        System.out.println(mostCaloricByType);

        Map<Dish.Type, Dish> mostCaloricByType2 = menu.stream().collect(groupingBy(Dish::getType, Collectors
                .collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));

        System.out.println(mostCaloricByType2);

        Map<Dish.Type, Integer> totalCaloriesByType = menu.stream().collect(groupingBy(Dish::getType, summingInt
                (Dish::getCalories)));
        System.out.println(totalCaloriesByType);

        Map<Dish.Type, Set<CaloricLevel>> caloricLevelByType = menu.stream().collect(groupingBy(Dish::getType,
                mapping(dish -> {
            if (dish.getCalories() <= 400)
                return CaloricLevel.DIET;
            else if (dish.getCalories() <= 700)
                return CaloricLevel.NORMAL;
            else
                return CaloricLevel.FAT;
        }, toSet())));

        System.out.println(caloricLevelByType);

        Map<Dish.Type, Set<CaloricLevel>> caloricLevelByType2 = menu.stream().collect(groupingBy(Dish::getType,
                mapping(dish -> {
                    if (dish.getCalories() <= 400)
                        return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700)
                        return CaloricLevel.NORMAL;
                    else
                        return CaloricLevel.FAT;
                }, toCollection(HashSet::new))));

        System.out.println(caloricLevelByType2);

        List<?> mappingList = menu.stream().collect(mapping(dish -> {
            if(dish.getCalories() <= 400) {
                return dish;
            } else
                return new FatDish(dish.getName(), dish.isVegerarian(), dish.getCalories(), FatDish.Type.HIGHT);
        },toList()));

        System.out.println(mappingList);

    }
}
