package V2;

public interface FareStrategy {
    double calculateFare(Vehicle vehicle, double distance);
}

class StandardFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(Vehicle vehicle, double distance) {
        return vehicle.getFarePerKm() * distance;
    }
}

class SharedFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(Vehicle vehicle, double distance) {
        // 50% discount
        return vehicle.getFarePerKm() * distance * 0.50;
    }
}

class LuxuryStrategy implements FareStrategy {
    @Override
    public double calculateFare(Vehicle vehicle, double distance) {
        // additional 50% surcharge for luxury ride
        return vehicle.getFarePerKm() * distance * 1.5;
    }
}