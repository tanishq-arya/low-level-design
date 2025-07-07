package ConcertTicketookingSystem;

public class ConsoleNotificationService implements NotificationService {
    @Override
    public void notifyBookingConfirmation(User user, Booking booking) {
        System.out.println(
                "Notification to " + user.getContactInfo() +
                        ": Your booking (ID " + booking.getId() +
                        ") for concert '" + booking.getConcert().getArtist() +
                        "' is CONFIRMED. Seats: " +
                        booking.getSeats().stream()
                                .map(Seat::getId)
                                .toList()
        );
    }

    @Override
    public void notifyWaitlistPromotion(User user, Concert concert) {
        System.out.println(
                "Notification to " + user.getContactInfo() +
                        ": Good news! Seats have opened up for concert '" +
                        concert.getArtist() +
                        "'. You are next on the waitlist."
        );
    }
}