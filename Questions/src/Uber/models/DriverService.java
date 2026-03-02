package Uber.models;

import java.util.concurrent.ConcurrentHashMap;

public class DriverService {
    // thread-safe driver availability
    private final ConcurrentHashMap<String, Driver> availableDrivers = new ConcurrentHashMap<>();

    // Atomic operation: check + assign driver (no race condition)
    // at 10k req/min = 10k*100k = 1 billion distance calculations
    // O(n) - scans ALL drivers for every ride request
    public synchronized Driver assignDriver(String driverId, String tripId) throws Exception {
        Driver driver = availableDrivers.get(driverId); // atomic - only one thread gets not null
        if(driver == null || !driver.isAvailable) {
            throw new Exception("DriverNotAvailable");
        }

        driver.setIsAvailable(false);
        availableDrivers.remove(driverId);
        return driver;
    }

    public synchronized Driver assignDriverGeoHash(String driverId, String tripId) throws Exception {
        // I'll use a GeoHash library — but I know the encoding works by alternately bisecting longitude and
        // latitude ranges and mapping 5-bit groups to base32 characters.
        Driver driver = availableDrivers.get(driverId); // atomic - only one thread gets not null
        if(driver == null || !driver.isAvailable) {
            throw new Exception("DriverNotAvailable");
        }

        driver.setIsAvailable(false);
        availableDrivers.remove(driverId);
        return driver;
    }

}
