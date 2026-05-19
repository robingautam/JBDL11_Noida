package collections;

import com.sun.source.tree.Tree;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain {

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();

        set.add(34);
        set.add(20);
        set.add(56);

        System.out.println(set);
    }
}
