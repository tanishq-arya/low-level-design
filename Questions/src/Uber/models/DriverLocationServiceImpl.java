package Uber.models;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

interface DriverLocationService {
    // Drivers continuously update their location
    void updateLocation(String driverId, Location loc);

    // Find drivers within radius (use GeoHash or KD-tree)
    List<Driver> getAvailableDriversNearby(Location pickup, double radiusKm);
}

public class DriverLocationServiceImpl implements DriverLocationService {

    private final ConcurrentHashMap<String, Location> driverLocations = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Driver> availableDrivers = new ConcurrentHashMap<>();

    @Override
    public void updateLocation(String driverId, Location location) {
        driverLocations.put(driverId, location);
    }

    @Override
    public List<Driver> getAvailableDriversNearby(Location pickup, double radiusKm) {
        return availableDrivers.values().stream()
                .filter(d -> distanceBetween(pickup, driverLocations.get(d.getId())) <= radiusKm)
                .collect(Collectors.toList());
    }

    // manhattan distance - simple
    private double distanceBetween(Location pickup, Location drop) {
        return drop.latitude - pickup.latitude + drop.longitude - pickup.longitude;
    }
}