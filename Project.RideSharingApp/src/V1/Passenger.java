package V1;

public class Passenger {
    public String name;
    Location location;

    public Passenger(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


}