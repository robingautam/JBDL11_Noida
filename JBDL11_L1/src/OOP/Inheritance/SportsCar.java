package OOP.Inheritance;

public class SportsCar extends BaseCar {
    int noOfSeats;
    int wheels;
    String airBags;
    String advanceBreakingSystem;
    String launchControl;
    String highlySecuredAlarmSystem;
    boolean bulletProofGlass;
    boolean isHybrid=true;


    @Override
    public boolean hasSunroof() {
        return true;
    }
}
