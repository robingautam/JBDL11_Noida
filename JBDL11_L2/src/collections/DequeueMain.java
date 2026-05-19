package collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeueMain {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(23);
        deque.add(34);
        deque.addFirst(12);
        deque.addLast(56);

        System.out.println(deque.remove());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeFirst());

    }
}
