package ProdConsProblem;

public class Main {

    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        Producer producer = new Producer(sharedData);
        Consumer consumer = new Consumer(sharedData);

        producer.start();
        consumer.start();



    }
}
