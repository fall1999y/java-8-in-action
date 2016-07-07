package chapter5;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Created by fall1999y on 2016. 7. 7..
 */
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;


    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
