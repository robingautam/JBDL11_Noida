package collections;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueMain {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayBlockingQueue<>(5);
        queue.add(23);
        queue.add(34);
        queue.add(1);
        queue.add(45);
        queue.add(67);
     //   queue.add(89); // This will throw IllegalStateException: Queue full
    }
}
