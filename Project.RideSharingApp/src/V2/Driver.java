package V2;

public class Driver extends User {

    private final Vehicle vehicle;

    public Driver(String name, String email, Location location, Vehicle vehicle) {
        super(name, email, location);
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void notify(String msg) {
        System.out.println("Driver notified: "  + msg);
    }
}