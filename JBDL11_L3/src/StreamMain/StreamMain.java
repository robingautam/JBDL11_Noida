package StreamMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(23,45,67,89,12,34,56,78,90);

        List<Integer> ans = new ArrayList<>();

        for (int i=0;i<list.size();i++){
           int num = list.get(i);
           if (num%2==0){
               ans.add(num*num);
           }
        }

        Collections.sort(ans);

        System.out.println(ans);

        Predicate<Integer> predicate = i ->  i%2 == 0;

        Function<Integer,Integer> function = i ->  i*i;

        // Using Streams
          // (12,34,56,78,90)  ------------->(144,916,3136,6084,8100) -------------> sorted
      List<Integer> sortedList =  list.stream().filter(i ->  i%2 == 0).map(i ->  i*i).sorted().toList();

        System.out.println(sortedList);



    }
}
