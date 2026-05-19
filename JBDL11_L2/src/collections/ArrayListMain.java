package collections;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {

    public static void main(String[] args) {
       /* List list = new ArrayList();
        list.add(1); // 1
        list.add(3); // 11
        list.add(56); // 111000
        list.add(45);
        list.add("Robin");
        list.add('d');
       System.out.println(list);
       // problem with non generic collection
        // 1. type safety
        // 2. need to do type casting

        for (int i=0;i<list.size();i++){
           int a = (int) list.get(i);
            System.out.println(Integer.toBinaryString(a));
        }*/

        List<Integer> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        subList.add(101);
        subList.add(102);
        list.add(1);
        list.add(34);
        list.add(0,36);
        list.set(0,45);
        list.add(56);
        list.addAll(subList);
        System.out.println(list);
      //  System.out.println(list.isEmpty());
        list.remove(0);
      //  list.clear();
      //  System.out.println(list);
      //  System.out.println(list.isEmpty());
        System.out.println(list);




    }
}
