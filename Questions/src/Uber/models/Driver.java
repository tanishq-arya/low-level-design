package Uber.models;

public class Driver extends User{
    String id;
    Vehicle vehicle;
    boolean isAvailable;
    double rating;
    Location currentLocation;

    public void setIsAvailable(boolean value) {
        isAvailable = value;
    }

    public String getId() {
        return id;
    }
}
