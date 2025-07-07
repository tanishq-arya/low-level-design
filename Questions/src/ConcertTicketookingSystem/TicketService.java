package ConcertTicketookingSystem;

import java.time.LocalDateTime;
import java.util.List;

public class TicketService {
    private final ConcertManager concertManager = new ConcertManager();
    private final BookingManager bookingManager = new BookingManager();
    private final NotificationService notificationService = new ConsoleNotificationService();

    public Concert createConcert(String name, String artist, LocalDateTime dateTime, List<Seat> seats) {
        return concertManager.createConcert(name, artist, dateTime, seats);
    }

    public List<Concert> searchConcerts(String artist) {
        return concertManager.searchConcerts(artist);
    }

    public Hold holdSeats(User user, String concertId, List<Seat> seatsToHold, long seconds) {
        Concert concert = concertManager.getConcertById(concertId)
                .orElseThrow(() -> new IllegalArgumentException("Concert not found"));

        return bookingManager.holdSeats(user, concert, seatsToHold, seconds);
    }

    public Booking book(Hold hold, double totalAmount) {
        // 1. Process payment
        System.out.println("Payment success: " + totalAmount + " - CASH");

        // 2. Confirm booking
        Booking booking = bookingManager.confirmBooking(hold, totalAmount);

        // 3. **Notify the user**
        notificationService.notifyBookingConfirmation(booking.getUser(), booking);
        return booking;
    }

    public void addToWaitlist(User user, String concertId) {
        Concert concert = concertManager.getConcertById(concertId)
                .orElseThrow(() -> new IllegalArgumentException("Concert not found"));
        bookingManager.addToWaitlist(user, concert);
        // **Optionally** immediately confirm when seats free up:
        // notificationService.notifyWaitlistPromotion(user, concert);
    }

    public List<Booking> getAllBookings(String concertId) {
        return bookingManager.getBookingsForConcert(concertId);
    }

    public List<WaitlistEntry> getAllWaitlist(String concertId) {
        return bookingManager.getWaitlistForConcert(concertId);
    }
}