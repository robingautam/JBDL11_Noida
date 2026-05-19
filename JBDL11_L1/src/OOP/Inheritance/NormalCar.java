package OOP.Inheritance;

public class NormalCar extends BaseCar{
    boolean isAffordable;
    boolean isFuelEfficient;


    NormalCar(){}

    NormalCar(String engineType){
        super.engineType = engineType;
    }

    @Override
    public boolean isHybrid(){
        return true;
    }
}
