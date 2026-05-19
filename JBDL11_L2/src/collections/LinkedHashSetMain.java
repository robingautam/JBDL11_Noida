package collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetMain {

    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();

        set.add(23);
        set.add(45);
        set.add(56);

        System.out.println(set);
    }
}
