package ConcertTicketookingSystem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class ConcertManager {
    private final Map<String, Concert> concerts = new HashMap<>();

    public Concert createConcert(String name, String artist, LocalDateTime dateTime, List<Seat> seats) {
        Concert concert = new Concert(name, artist, dateTime, seats);
        concerts.put(concert.getId(), concert);
        return concert;
    }

    public List<Concert> searchConcerts(String artist) {
        return concerts.values().stream()
                .filter(concert -> concert.getArtist().toLowerCase().contains(artist.toLowerCase()))
                .toList();
    }

    public Optional<Concert> getConcertById(String concertId) {
        return Optional.ofNullable(concerts.get(concertId));
    }
}