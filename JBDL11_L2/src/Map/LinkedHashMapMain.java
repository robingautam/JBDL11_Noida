package Map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapMain {

    public static void main(String[] args) {
        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("One",1);
        map.put("Two",2);
        map.put("Three",3);
        map.put(null,null);

        for (String k: map.keySet()){
            System.out.println(k+": "+map.get(k));
        }
    }
}
