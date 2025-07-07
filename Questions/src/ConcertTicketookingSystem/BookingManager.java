package ConcertTicketookingSystem;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BookingManager {
    // concert id -> holdList<>
    private final Map<String, List<Hold>> seatHolds = new ConcurrentHashMap<>();

    // id -> booking
    private final Map<String, List<Booking>> bookings = new ConcurrentHashMap<>();

    // concert id -> waitList<>
    private final Map<String, Queue<WaitlistEntry>> waitlists = new ConcurrentHashMap<>();

    // Simulate holding seats temporarily
    public synchronized Hold holdSeats(User user, Concert concert, List<Seat> requestedSeats, long holdSeconds) {
        List<Seat> availableSeats = requestedSeats.stream()
                .filter(seat -> seat.getStatus() == SeatStatus.AVAILABLE)
                .toList();

        if (availableSeats.size() != requestedSeats.size()) {
            throw new IllegalStateException("Some seats are already booked or held.");
        }

        // Mark seats as held
        availableSeats.forEach(seat -> seat.setStatus(SeatStatus.HELD));

        Hold hold = new Hold(user, concert, availableSeats, holdSeconds);
        seatHolds.computeIfAbsent(concert.getId(), k -> new ArrayList<>()).add(hold);
        return hold;
    }

    // book a ticket
    public synchronized Booking confirmBooking(Hold hold, double amount) {
        if (hold.isExpired()) {
            hold.getSeats().forEach(seat -> seat.setStatus(SeatStatus.AVAILABLE));
            throw new IllegalStateException("Hold expired");
        }

        hold.getSeats().forEach(seat -> seat.setStatus(SeatStatus.BOOKED));
        Booking booking = new Booking(hold.getUser(), hold.getConcert(), hold.getSeats(), amount);
        bookings.computeIfAbsent(hold.getConcert().getId(), k -> new ArrayList<>()).add(booking);
        return booking;
    }

    // add to waitlist for this concert
    public void addToWaitlist(User user, Concert concert) {
        WaitlistEntry entry = new WaitlistEntry(user, concert);
        waitlists.computeIfAbsent(concert.getId(), k -> new LinkedList<>()).add(entry);
    }

    // get all bookings for this concert
    public List<Booking> getBookingsForConcert(String concertId) {
        return bookings.getOrDefault(concertId, List.of());
    }

    public List<WaitlistEntry> getWaitlistForConcert(String concertId) {
        return waitlists.getOrDefault(concertId, new ArrayDeque<>()).stream().toList();
    }
}