package synchronization;

public class Account {

    public int balance=100;

    /*public synchronized void withdraw(int amount){
        balance = balance-amount;
        print();
    }*/

    public  void withdraw(int amount){
        synchronized (Account.class){
            balance = balance-amount;
        }
        print();
    }

    public void print(){
        System.out.println(balance);
    }
}
