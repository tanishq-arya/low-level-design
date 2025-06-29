package CarRentalSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Reservation {
    private final String id;
    private final Car car;
    private final Customer customer;
    private final Branch branch;
    private LocalDate startDate;
    private LocalDate endDate;
    private ReservationStatus status;
    private double totalCost;

    public Reservation(Car car, Customer customer, Branch branch, LocalDate start, LocalDate end) {
        this.id = UUID.randomUUID().toString();
        this.car = car;
        this.customer = customer;
        this.branch = branch;
        this.startDate = start;
        this.endDate = end;
    }

    public double calculateCost() {
        long days = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        return days * car.getDailyRate();
    }

    public synchronized void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        this.totalCost = calculateCost();
    }

    public synchronized void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        this.totalCost = calculateCost();
    }

    public synchronized void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public String getId() { return id; }
    public Car getCar() { return car; }
    public Customer getCustomer() { return customer; }
    public Branch getBranch() { return branch; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public ReservationStatus getStatus() { return status; }
    public double getTotalCost() { return totalCost; }
}