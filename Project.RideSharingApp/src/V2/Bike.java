package V2;

public class Bike extends Vehicle {

    public Bike(String numberPlate) {
        super(numberPlate);
    }

    @Override
    public double getFarePerKm() {
        return 10; // Fare for Bike
    }
}