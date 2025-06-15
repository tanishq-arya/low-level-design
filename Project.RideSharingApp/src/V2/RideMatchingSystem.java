package V2;

import java.util.ArrayList;
import java.util.List;

// Mediator - Ride, Driver, Passenger
public class RideMatchingSystem {
    // Find the nearest driver available
    // In-memory DB to store data

    public List<Driver> availableDrivers = new ArrayList<>();

    public void addDriver(Driver driver) {
        availableDrivers.add(driver);
    }

    public void requestRide(Passenger passenger, double distance, FareStrategy fareStrategy) {
        // base case > no drivers
        if (availableDrivers.isEmpty()) {
            // mechanism to notify passengers
            passenger.notify("No drivers are available.");
            return;
        }

        // 1. Find the nearest driver available
        // modify > add radius limit to fn
        Driver nearestDriver = findNearestDriver(passenger.getLocation());

        // 2. Mediator > inform drivers & passengers
        availableDrivers.remove(nearestDriver);
        Ride ride = new Ride(passenger, nearestDriver, distance, fareStrategy);

        // 3. Calculate fare for ride
        ride.calculateFare();
        passenger.notify("Ride scheduled with fare Rs." + ride.getFare());
        nearestDriver.notify("You have a new ride request with fare Rs." + ride.getFare());

        // Send updates to users - observer pattern
        // 4. Change status of the Ride > in b/w
        ride.updateStatus(RideStatus.ONGOING);

        // 5. Change status of ride after ride is finished
        ride.updateStatus(RideStatus.COMPLETED);
        availableDrivers.add(nearestDriver);

        return;
    }

    private Driver findNearestDriver(Location location) {
        Driver assignedDriver = null;
        double minDist = Double.MAX_VALUE;

        for(Driver driver: availableDrivers) {
            double dist = driver.getLocation().calcDistance(location);
            if (dist < minDist) {
                minDist = dist;
                assignedDriver = driver;
            }
        }

        return assignedDriver;
    }
}