package abstracts;

public class HDFCBank extends Bank{

    HDFCBank(String name, String branch) {
        super(name, branch);
    }

    @Override
    public long calculateInterest(long amount) {
        return (amount * 7) / 100;
    }
}
