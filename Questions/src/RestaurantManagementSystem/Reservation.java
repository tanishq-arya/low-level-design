package RestaurantManagementSystem;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reservation {
    private final String id;
    private final Customer customer;
    private final LocalDateTime dateTime;
    private final int partySize;
    private ReservationStatus status;

    public Reservation(Customer customer, LocalDateTime dateTime, int partySize) {
        this.id = UUID.randomUUID().toString();
        this.customer = customer;
        this.dateTime = dateTime;
        this.partySize = partySize;
        this.status = ReservationStatus.PENDING;
    }

    public void confirm() {this.status = ReservationStatus.CONFIRMED;}
    public void cancel() {this.status = ReservationStatus.CANCELLED;}

    public synchronized ReservationStatus getStatus() {return status;}

    public String getId() {return this.id;}
    public Customer getCustomer() {return this.customer;}
    public LocalDateTime getDateTime() {return this.dateTime;}
    public int getPartySize() {return this.partySize;}
}