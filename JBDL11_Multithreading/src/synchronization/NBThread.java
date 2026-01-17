package synchronization;

public class NBThread extends Thread{

    int amount;
    Account account;

    NBThread(Account account, int amount){
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        this.account.withdraw(amount);
    }


}
