package Interfaces;

public class SBIBank implements BankOperation{
    @Override
    public void acceptDeposit() {
        System.out.println("Deposit accepted in SBI Bank");
    }

    @Override
    public void acceptDocumentsForLoan() {
        System.out.println("Documents accepted for loan in SBI Bank");
    }

    @Override
    public long calculateInterest(long amount) {
        return (amount * 5) / 100;
    }

    @Override
    public void thankYouMessage() {
        System.out.println("Thank you for choosing SBI Bank!");
    }
}
