package collections;

import java.util.LinkedList;

public class LinkedListMain {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("Elements in the linked list:");
        for (String fruit : list) {
            System.out.println(fruit);
        }

        list.remove("Banana");
        System.out.println("\nAfter removing Banana:");
        for (String fruit : list) {
            System.out.println(fruit);
        }
    }
}
