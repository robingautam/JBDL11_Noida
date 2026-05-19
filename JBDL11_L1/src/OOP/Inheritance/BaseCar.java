package OOP.Inheritance;

public class BaseCar {
    String carName;
    int topSpeed;
    String carColor;
    String carModel;
    String carCompany;
    String hasSunroof;
    String fuelType;
    boolean isHybrid=false;
    String engineType="V6 Engine";


    public boolean hasSunroof() {
        return false;
    }

    public boolean isHybrid(){
        return isHybrid;
    }
}
