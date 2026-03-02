package Uber.models;

import Uber.enums.VehicleType;

import java.util.Map;

interface FareService {
    // base fare + per km rate + surge multiplier
    double calculateFare(Location pickup, Location drop, VehicleType type);
}

public class FareServiceImpl implements FareService {
    private static final Map<VehicleType, Double> BASE_RATE = Map.of(
            VehicleType.MICRO,  8.0,
            VehicleType.MINI,  10.0,
            VehicleType.SEDAN, 14.0,
            VehicleType.SUV,   20.0
    );

    private double surgeMultiplier = 1.0; // can be updated dynamically

    @Override
    public double calculateFare(Location pickup, Location drop, VehicleType type) {
        double distanceKm = 10 ; // Using geoHash
        double baseRate = BASE_RATE.getOrDefault(type, 10.0);
        return Math.round(baseRate * distanceKm * surgeMultiplier * 100.0) / 100.0;
    }

    public void setSurgeMultiplier(double surgeMultiplier) {
        this.surgeMultiplier = surgeMultiplier;
    }
}