package V2;

abstract class Vehicle {
    String numberPlate;

    public Vehicle(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    // Fare Calculation
    public abstract double getFarePerKm();
}