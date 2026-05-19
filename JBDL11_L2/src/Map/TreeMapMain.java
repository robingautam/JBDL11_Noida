package Map;

import com.sun.source.tree.Tree;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapMain {

    public static void main(String[] args) {
        TreeMap<String,Integer> treeMap = new TreeMap<>();
        treeMap.put("Five",5);
        treeMap.put("Two",2);
        treeMap.put("Three",3);
      //  treeMap.put("Four", null);

        System.out.println(treeMap.ceilingKey("Two"));

        for (String k: treeMap.keySet()){
            System.out.println(k+": "+treeMap.get(k));
        }
    }
}
