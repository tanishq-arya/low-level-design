package Uber.models;

import Uber.enums.VehicleType;

import java.util.concurrent.ConcurrentHashMap;

// Responsible for managing rides
interface TripService {
    // 1. request ride
    Trip requestRide(String riderId, Location pickup, Location drop, VehicleType type);

    // 2. match driver - imp.** (core algorithm)
    Driver findNearestDriver(Location pickup, VehicleType type);

    // 3. driver accepts / rejects
    void acceptRide(String driverId, String tripId);

    // 4. Start & end
    void startRide(String tripId);
    void endRide(String tripId);

    // 5. Cancel
    void cancelRide(String tripId, String cancelledBy);
}

public class TripServiceImpl implements TripService {
    private final DriverLocationService locationService;
//    private final DriverAssignmentService assignmentService;
//    private final DriverMatchingStrategy matchingStrategy;
    private final FareService fareService;
    private final PaymentService paymentService;
    private final ConcurrentHashMap<String, Trip> tripStore = new ConcurrentHashMap<>();

    public TripServiceImpl(DriverLocationService locationService, /*DriverAssignmentService assignmentService,
                           DriverMatchingStrategy matchingStrategy,*/ FareService fareService,
                           PaymentService paymentService) {
        this.locationService = locationService;
//        this.assignmentService = assignmentService;
//        this.matchingStrategy = matchingStrategy;
        this.fareService = fareService;
        this.paymentService = paymentService;
    }

    @Override
    public Trip requestRide(String riderId, Location pickup, Location drop, VehicleType type) {
        return null;
    }

    @Override
    public Driver findNearestDriver(Location pickup, VehicleType type) {
        return null;
    }

    @Override
    public void acceptRide(String driverId, String tripId) {

    }

    @Override
    public void startRide(String tripId) {

    }

    @Override
    public void endRide(String tripId) {

    }

    @Override
    public void cancelRide(String tripId, String cancelledBy) {

    }
}