package OOP.Inheritance;

public class Main {

    public static void main(String[] args) {
        BaseCar normalCar = new NormalCar("I4 Engine");
        normalCar.carName = "Toyota";
        normalCar.topSpeed = 180;
        normalCar.carColor = "Red";
        normalCar.carModel = "Corolla";
        normalCar.carCompany = "Toyota Motors";
        normalCar.fuelType = "Petrol";
        normalCar.isHybrid = false;
      //  normalCar.isAffordable = true;
      //  normalCar.isFuelEfficient = true;
      //  normalCar.setEngineType();

        System.out.println("Car Name: " + normalCar.carName);
        System.out.println("Top Speed: " + normalCar.topSpeed + " km/h");
        System.out.println("Car Color: " + normalCar.carColor);
        System.out.println("Car Model: " + normalCar.carModel);

        System.out.println("Is Hybrid: " + normalCar.isHybrid());
        System.out.println(normalCar.engineType);




    }
}
