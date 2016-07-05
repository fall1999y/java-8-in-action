package chapter5;

import chapter4.Dish;
import chapter4.MenuMain;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by fall1999y on 2016. 7. 5..
 */
public class DishMain {
    public static void main(String[] args) {
        List<Dish> dishes = MenuMain.menu.stream().filter(d -> d.getCalories() > 300).skip(2).collect(Collectors
                .toList());

        System.out.println(dishes);

        List<Dish> meatList = MenuMain.menu.stream().filter(d -> d.getType() == Dish.Type.MEAT).limit(2).collect
                (Collectors.toList());

        System.out.println(meatList);

        List<Integer> menuNameLength = MenuMain.menu.stream().map(m -> m.getName().length()).collect(Collectors
                .toList());
        System.out.println(menuNameLength);
    }
}
