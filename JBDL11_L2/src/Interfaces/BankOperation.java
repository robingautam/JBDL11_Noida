package Interfaces;

public interface BankOperation {

    void acceptDeposit();
    void acceptDocumentsForLoan();
    long calculateInterest(long amount);

    static void welcomeMessage() {
        System.out.println("Welcome to the Bank!");
    }

    default void thankYouMessage() {
        System.out.println("Thank you for banking with us!");
    }
}
