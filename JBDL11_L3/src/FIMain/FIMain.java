package FIMain;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FIMain {
    public static void main(String[] args) {
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2 == 0;  // checks if the number is even
            }
        };  // anonymous class implementation


        //System.out.println("Is 4 even? " + predicate.test(4));  // true
      //  System.out.println("Is 7 even? " + predicate.test(7));  // false


        // Function Implementation

        Function<Integer,Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer*integer;
            }
        };

       // System.out.println("Square of 5: " + function.apply(5));  // 25
       // System.out.println("Square of 10: " + function.apply(10));  // 100

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int)(Math.random()*100); // random number between 0 and 99
            }
        };

        //System.out.println("Random Number: " + supplier.get());

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("Consumed value: " + integer);
            }
        };

        consumer.accept(10);
    }
}
