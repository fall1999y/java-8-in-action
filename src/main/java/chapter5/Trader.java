package chapter5;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by fall1999y on 2016. 7. 7..
 */
public class Trader {
    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
