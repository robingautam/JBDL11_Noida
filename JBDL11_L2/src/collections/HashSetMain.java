package collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetMain {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(23);
        set.add(34);
        set.add(23);
       // set.clear();
        set.remove(34);
        System.out.println(set.size());


        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
