package Interfaces;

public class InterfaceMain {

    public static void main(String[] args) {
       /* BankOperation bank = new SBIBank();
        bank.acceptDeposit();
        bank.acceptDocumentsForLoan();
        long interest = bank.calculateInterest(100000);
        System.out.println("Interest from SBI Bank: " + interest);*/

        BankOperation operation = new SBIBank();
        BankOperation operation1 = new HDFCBank();
        operation1.thankYouMessage();
        operation.thankYouMessage();
    }
}
