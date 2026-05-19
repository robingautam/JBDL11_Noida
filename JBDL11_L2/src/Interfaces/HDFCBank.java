package Interfaces;

public class HDFCBank implements BankOperation{
    @Override
    public void acceptDeposit() {
        System.out.println("Deposit accepted in HDFC Bank");
    }

    @Override
    public void acceptDocumentsForLoan() {
        System.out.println("Documents accepted for loan in HDFC Bank");
    }

    @Override
    public long calculateInterest(long amount) {
        return (amount * 6) / 100;
    }

    @Override
    public void thankYouMessage() {
        System.out.println("Thank you for choosing HDFC Bank!");
    }
}
