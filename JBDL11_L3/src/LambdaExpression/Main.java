package LambdaExpression;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Predicate<Integer> predicate = (i) ->  i%2 == 0;

        System.out.println("Is 4 even? " + predicate.test(4));  // true
        System.out.println("Is 7 even? " + predicate.test(7));  // false


        Function<Integer,Integer> function = (i) -> i*i;

        System.out.println("Square of 5: " + function.apply(5));  // 25
        System.out.println("Square of 10: " + function.apply(10));  //

        Supplier<Integer> supplier = () ->  0;

        System.out.println("Random Number: " + supplier.get());

        Consumer<Integer> consumer = ( integer) ->System.out.println("Consumed value: " + integer);
       // System.out.println("Hello");
        consumer.accept(10);
    }
}
