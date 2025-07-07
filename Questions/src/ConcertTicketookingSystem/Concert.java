package ConcertTicketookingSystem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Concert {
    private final String id;
    private final String name;
    private final String artist;
    private final LocalDateTime dateTime;
    private final List<Seat> seats;

    public Concert(String name, String artist, LocalDateTime dateTime, List<Seat> seats) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.artist = artist;
        this.dateTime = dateTime;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getArtist() {
        return artist;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public List<Seat> getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return name + " - " + artist + " on " + dateTime + "(" + id + ")";
    }
}