package V2;

public class Client {
    public static void main(String[] args) {
        // Locations
        Location loc1 = new Location(12.9716, 77.5946);
        Location loc2 = new Location(12.9352, 77.6245);
        Location loc3 = new Location(13.0352, 77.6175);

        // Create Vehicles
        Vehicle car = new Car("AB123CD");
        Vehicle bike = new Bike("XY987Z");

        // Create Drivers
        Driver driver1 = new Driver("Alice", "alice@rideshare.com", loc2, car);
        Driver driver2 = new Driver("Bob", "bob@rideshare.com", loc3, bike);

        // Create Passenger
        Passenger passenger1 = new Passenger("John", "john@rideshare.com", loc1);
        Passenger passenger2 = new Passenger("Rahul", "rahul@rideshare.com", loc3);


        // Simulate System
        RideMatchingSystem rideMatchingSystem = new RideMatchingSystem();

        rideMatchingSystem.addDriver(driver1);
        rideMatchingSystem.addDriver(driver2);

        rideMatchingSystem.requestRide(passenger1, 10, new StandardFareStrategy());
    }
}