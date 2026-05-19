package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapMain {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("Robin", 83737373);
        map.put("Bob", 83737444);
        map.put("Alice", 83737555);
        map.putIfAbsent("Robin",30);
        map.replace("Robin", 67);

        Map<String,Integer> childMap = new HashMap<>();
        childMap.put("Charlie", 83737666);
        childMap.put("David", 83737777);

        map.putAll(childMap);

        map.remove("David");

        System.out.println(map.get("David"));

       // System.out.println(map.containsKey("Rob"));
     //   System.out.println(map.getOrDefault("David", -1));

      //  System.out.println(map.get("Robin"));


        //1 . Using entryset() method
      Set<Map.Entry<String,Integer>> set =  map.entrySet();

      for (Map.Entry<String,Integer> e:set){
        //  System.out.println(e.getKey()+": "+e.getValue());
      }

      // 2. using the Key Set method
      //Set<String> keys =  map.keySet();
      for (String k: map.keySet()){
          System.out.println(k+": "+map.get(k));
      }




    }
}
