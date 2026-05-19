package StreamMain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {

    public static void main(String[] args) {
        List<Integer> list = List.of(23,45,67,89,12,34,56,78,90,90,90,90);

        // Using Streams
       List<Integer> distinctElements = list.stream().distinct().toList();

        System.out.println("Original "+list);

      //  System.out.println("Distinct "+distinctElements);


        List<Integer> diviedList = list.stream().map(i->i/2).toList();

     //   System.out.println("Divided by 2: "+diviedList);

        // flat map example

        List<List<Integer>> listOfLists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8, 9)
        );
        List<Integer> flatMappedList = listOfLists.stream()
                .flatMap(innerList -> innerList.stream())
                .toList();

        System.out.println("FlatMapped List: " + flatMappedList);

        // limit example
        List<Integer> limitedList = list.stream().limit(5).toList();
        System.out.println("Limited List: " + limitedList);

        // skip example
        List<Integer> skippedList = list.stream().skip(5).toList();
        System.out.println("Skipped List: " + skippedList);


        // Terminal Operations: count, min, max, forEach, reduce, collect

       List<Integer> mapList = list.stream().map(i->i*i).collect(Collectors.toList());

       Set<Integer> mapSet = list.stream().map(i->i*i).collect(Collectors.toSet());

        System.out.println("Mapped List: " + mapList);

        System.out.println("Mapped Set: " + mapSet);

        // min example
        int min = list.stream().min((i1,i2)->i1-i2).get();
        System.out.println(min);

        // max example
        int max = list.stream().max((i1,i2)->i1-i2).get();
        System.out.println(max);

        // anyMatch example
        boolean anyMatch = list.stream().anyMatch(i->i>50);
        System.out.println("Any Match > 50: " + anyMatch);

        // allMatch example
        boolean allMatch = list.stream().allMatch(i->i>25);
        System.out.println("All Match > 10: " + allMatch);

    }
}
