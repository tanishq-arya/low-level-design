package V1;

public class Vehicle {
    String numberPlate;
    String type;

    public Vehicle(String numberPlate, String type) {
        this.numberPlate = numberPlate;
        this.type = type;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getType() {
        return type;
    }
}