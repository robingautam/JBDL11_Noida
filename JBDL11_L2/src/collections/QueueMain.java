package collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(23);
        queue.add(34);
        queue.add(45);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
      //  System.out.println(queue.poll());
        System.out.println(queue.remove());
    }
}
