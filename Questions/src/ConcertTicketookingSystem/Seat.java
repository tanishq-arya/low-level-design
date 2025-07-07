package ConcertTicketookingSystem;

public class Seat {
    private final String id;
    private final SeatType type;
    private SeatStatus status;

    public Seat(String id, SeatType type) {
        this.id = id;
        this.type = type;
        this.status = SeatStatus.AVAILABLE;
    }

    public String getId() {
        return id;
    }
    public SeatType getType() {
        return type;
    }
    public synchronized SeatStatus getStatus() {
        return status;
    }
    public synchronized void setStatus(SeatStatus status) {
        this.status = status;
    }
}