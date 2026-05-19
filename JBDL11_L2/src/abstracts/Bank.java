package abstracts;

public abstract class Bank {
    String name;
    String branch;

    Bank(String name, String branch) {
        this.name = name;
        this.branch = branch;
    }
    public void acceptDeposit() {
        System.out.println("Deposit accepted in " + name + " bank, branch: " + branch);
    }

    public void acceptDocumentsForLoan() {
        System.out.println("Documents accepted for loan in " + name + " bank, branch: " + branch);
    }

    public abstract long calculateInterest(long amount);
}
