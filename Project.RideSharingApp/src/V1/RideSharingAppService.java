package V1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RideSharingAppService {
    // Matching Service
    private List<Driver> drivers = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();

    private Set<Driver> isBooked = new HashSet<>();

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    // Methods to add Drivers and Passengers
    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    // Booking Ride
    public void bookRide(Passenger passenger, double distance) {
        // Corner cases
        if (drivers.isEmpty()) {
            System.out.println("No drivers are available " + passenger.name);
            return;
        }

        // Hard-coded assignment logic
        // find the nearest driver
        // O(n) Brute force approach
        Driver assignedDriver = null;
        double minDistance = Double.MAX_VALUE;

        for (Driver driver: drivers) {
            double currentDriverDistance = calcDistance(passenger.location, driver.location);
            if (currentDriverDistance < minDistance) {
                minDistance = currentDriverDistance;
                assignedDriver = driver;
            }
        }

        // Fare Calculation
        double expectedFare = calcFare(assignedDriver.vehicle, distance);

        // Temporarily block the driver
        // Track driver state > BOOKED / AVAILABLE
        if(isBooked.contains(assignedDriver)) {
            System.out.println("V1.Driver already booked. No drivers available.");
            return;
        } else {
            isBooked.add(assignedDriver);
        }

        // Show the driver and fare to the passenger
        System.out.println("Ride booked for " + passenger.name + " with driver " + assignedDriver.name + " for fare of $" + expectedFare);
        System.out.println("V1.Driver is on the way " + assignedDriver.name);
    }

    private double calcFare(Vehicle vehicle, double distance) {
        if (vehicle.type.equals("Car")) {
            return distance * 20;
        } else if (vehicle.type.equals("Bike")) {
            return distance * 10;
        } else {
            return distance * 8; // hard-coded value
        }
    }

    private double calcDistance(Location one, Location two) {
        // Euclidean distance
//        double x = one.getLatitude() - two.getLatitude();
//        double y = one.getLongitude() - two.getLongitude();
//        return = Math.sqrt(x * x + y * y);

        // Haversine Formula (Two points on sphere)
        final double R = 6371.0; // Radius of Earth in kilometers

        double lat1 = Math.toRadians(one.getLatitude());
        double lon1 = Math.toRadians(one.getLongitude());
        double lat2 = Math.toRadians(two.getLatitude());
        double lon2 = Math.toRadians(two.getLongitude());

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c; // distance in kilometers
    }
}