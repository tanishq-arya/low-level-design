package CarRentalSystem;

public class Car {
    private final String id;
    private final String make;
    private final String model;
    private final int year;
    private final String licensePlate;
    private final double dailyRate;
    private final CarType type;
    private CarStatus status;

    public Car(String id, String make, String model, int year, String licensePlate, double dailyRate, CarType type) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
        this.dailyRate = dailyRate;
        this.type = type;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    public String getId() { return id; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getLicensePlate() { return licensePlate; }
    public double getDailyRate() { return dailyRate; }
    public CarType getType() { return type; }
}