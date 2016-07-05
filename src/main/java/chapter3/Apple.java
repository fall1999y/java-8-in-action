package chapter3;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by fall1999y on 2016. 6. 27..
 */
public class Apple {

    private String color = "black";
    private Integer weight;

    public Apple(int i) {
        this.weight = i;
    }

    public Apple() {

    }

    public Apple(Integer integer, String s) {

        this.weight = integer;
        this.color = s;
    }

    public String getColor() {
        return color;
    }

    public Apple(Integer integer, String s, String s1) {

        this.weight = integer;
        this.color = s + s1;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
