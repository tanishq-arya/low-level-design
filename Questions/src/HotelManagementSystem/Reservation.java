package HotelManagementSystem;

import java.time.LocalDate;
import java.util.UUID;

public class Reservation {
    private final String id;
    private final Guest guest;
    private final Room room;
    private final LocalDate checkInDate;
    private final LocalDate checkOutDate;
    private ReservationStatus status;

    public Reservation(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.id = UUID.randomUUID().toString();
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = ReservationStatus.BOOKED;
    }

    // Update reservation status
    public synchronized void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public String getId() {return id;}
    public Guest getGuest() {return guest;}
    public Room getRoom() {return room;}
    public LocalDate getCheckInDate() {return checkInDate;}
    public LocalDate getCheckOutDate() {return checkOutDate;}
    public synchronized ReservationStatus getStatus() {return status;}
}