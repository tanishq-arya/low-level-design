package ConcertTicketookingSystem;

//Sends notifications via email or SMS.
public interface NotificationService {
    void notifyBookingConfirmation(User user, Booking booking);
    void notifyWaitlistPromotion(User user, Concert concert);
}