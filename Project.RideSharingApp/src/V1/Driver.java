package V1;

public class Driver {
    String name;

    Vehicle vehicle;

    Location location;

    public Driver(String name, Vehicle vehicle, Location location) {
        this.name = name;
        this.vehicle = vehicle;
        this.location = location;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}