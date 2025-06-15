package V1;

public class Client {
    public static void main(String[] args) {
        // Locations
        Location loc1 = new Location(12.9716, 77.5946);
        Location loc2 = new Location(12.9352, 77.6245);
        Location loc3 = new Location(13.0352, 77.6175);

        // Create Vehicles
        Vehicle car = new Vehicle("AB123CD", "Car");
        Vehicle bike = new Vehicle("XY987Z", "Bike");

        // Create Drivers
        Driver driver1 = new Driver("Alice", car, loc2);
        Driver driver2 = new Driver("Bob", bike, loc3);

        // Create V1.Passenger
        Passenger passenger1 = new Passenger("John", loc1);
        Passenger passenger2 = new Passenger("Rahul", loc3);

        // Ride Sharing
        RideSharingAppService app = new RideSharingAppService();
        app.addDriver(driver1);
        app.addDriver(driver2);

        app.addPassenger(passenger1);
        app.addPassenger(passenger2);

        // Book the Ride
        app.bookRide(passenger1, 10);
        app.bookRide(passenger2, 20);
        app.bookRide(passenger2, 20);

        // Problems >
        // 1. SRP violation - RideSharing App > V1.Driver/passenger mgmt, booking, fare, distance
        // 2. OCP violation - new Vehicles require code modification
        // 3. LSP violation - checking if vehicle type is car
        // 4. ISP violation - No separation between concerns
        // 5. DIP violation - high-level class (Ride sharing app) is dependent on calculate fare
    }
}