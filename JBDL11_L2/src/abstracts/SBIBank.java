package abstracts;

public class SBIBank extends Bank{

    SBIBank(String name, String branch) {
        super(name, branch);
    }

    @Override
    public long calculateInterest(long amount) {
        return (amount * 5) / 100;
    }
}
