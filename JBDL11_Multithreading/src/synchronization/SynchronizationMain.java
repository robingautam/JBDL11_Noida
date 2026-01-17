package synchronization;

public class SynchronizationMain {

    public static void main(String[] args) {
        Account account = new Account();
        NBThread nbThread1 = new NBThread(account,20);
        NBThread nbThread2 = new NBThread(account,30);

        nbThread1.start();
        nbThread2.start();


    }
}
