package abstracts;

public class Main {
    public static void main(String[] args) {
        Bank bank = new HDFCBank("HDFC", "MG Road");
        bank.acceptDeposit();
        bank.acceptDocumentsForLoan();
        long interest = bank.calculateInterest(100000);
        System.out.println("Interest from HDFC Bank: " + interest);


        Bank sbiBank = new SBIBank("SBI", "Brigade Road");
        sbiBank.acceptDeposit();
        sbiBank.acceptDocumentsForLoan();
        long sbiInterest = sbiBank.calculateInterest(100000);
        System.out.println("Interest from SBI Bank: " + sbiInterest);
    }
}
