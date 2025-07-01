package HotelManagementSystem;

public class Room {
    private final String number;
    private final RoomType type;
    private final double ratePerNight;
    private RoomStatus status;

    public Room(String number, RoomType type, double ratePerNight) {
        this.number = number;
        this.type = type;
        this.ratePerNight = ratePerNight;
        this.status = RoomStatus.AVAILABLE;
    }

    // Update room status
    public synchronized void setStatus(RoomStatus status) {
        this.status = status;
    }

    // Getters
    public String getNumber() {return number;}
    public RoomType getType() {return type;}
    public double getRatePerNight() {return ratePerNight;}
    public synchronized RoomStatus getStatus() {return status;}
}