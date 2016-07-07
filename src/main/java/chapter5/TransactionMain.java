package chapter5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;

/**
 * Created by fall1999y on 2016. 7. 7..
 */
public class TransactionMain {

    public static void main(String[] args) {
        Trader raoul = new Trader("raoul", "Cambridge");
        Trader mario = new Trader("mario", "Milan");
        Trader alan = new Trader("alan", "Cambridge");
        Trader brian = new Trader("brian", "Cambridge");

        List<Transaction> transactionList = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));


        transactionList.stream().sorted(comparing(Transaction::getValue))
                .forEach(System.out::println);

        transactionList.stream().filter(t -> t.getYear() == 2011).sorted(comparing(Transaction::getValue))
                .forEach(System.out::println);

        transactionList.stream().map(d -> d.getTrader().getCity()).distinct().forEach(System.out::println);
        transactionList.stream().map(d -> d.getTrader().getCity()).collect(Collectors.toSet()).forEach(System
                .out::println);

        transactionList.stream().filter(d -> d.getTrader().getCity().equals("Cambridge")).map(t -> t.getTrader()
                .getName()).sorted().distinct()
                .forEach(System.out::println);
        transactionList.stream().map(Transaction::getTrader).filter(t -> t.getCity().equals("Cambridge")).distinct()
                .sorted
                        (comparing(Trader::getName)).forEach(System.out::println);

        transactionList.stream().map(t -> t.getTrader().getName()).distinct().sorted().reduce(
                (n1, n2) -> n1 + "|" + n2).ifPresent(System.out::println);

        System.out.println(transactionList.stream().map(t -> t.getTrader().getName()).distinct().sorted().collect
                (joining("|")));

        transactionList.stream().filter(t -> t.getTrader().getCity().equals("Milan")).findAny().ifPresent(d -> {
            System.out.println("exists");
        });

        transactionList.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));

        transactionList.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue)
                .reduce(Integer::sum).ifPresent(System.out::println);
        transactionList.stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue)
                .forEach(System.out::println);

        transactionList.stream().max((t1, t2) -> new Integer(t1.getValue()).compareTo(new Integer(t2.getValue())))
                .ifPresent(t -> System.out.println(t.getValue()));
        transactionList.stream().map(Transaction::getValue).reduce(Integer::max).ifPresent(System.out::println);
        transactionList.stream().max(comparing(Transaction::getValue)).ifPresent(System.out::println);

        transactionList.stream().min((t1, t2) -> new Integer(t1.getValue()).compareTo(new Integer(t2.getValue())))
                .ifPresent(t -> System.out.println(t.getValue()));
        transactionList.stream().map(Transaction::getValue).reduce(Integer::min).ifPresent(System.out::println);
        transactionList.stream().min(comparing(Transaction::getValue)).ifPresent(System.out::println);
    }
}
