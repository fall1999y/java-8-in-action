package chapter4;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by fall1999y on 2016. 7. 4..
 */
public class Dish {
    private final String name;
    private final boolean vegerarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegerarian, int calories, Type type) {
        this.name = name;
        this.vegerarian = vegerarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegerarian() {
        return vegerarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        MEAT, FISH, OTHER
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
