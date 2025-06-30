package OnlineAuctionSystem;

import java.util.ArrayList;
import java.util.List;

public class User implements NotificationListener {
    private final String name;
    private final String email;
    private final String passwordHash;

    // In-app notifications
    private final List<Notification> notifications = new ArrayList<>();

    public User(String name, String email, String passwordHash) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    // Notification-Listeners
    // Listen to these updates
    @Override
    public void onOutbid(AuctionItem item, Bid previousHighest) {
        String msg = String.format("You have been outbid on '%s'. New highest: ₹%.2f",
                item.getTitle(),
                item.getCurrentHighestBid().getAmount());
        notifications.add(new Notification(msg));
    }

    @Override
    public void onAuctionClosed(AuctionItem item) {
        Bid winning = item.getCurrentHighestBid();
        String msg;
        if (winning != null && winning.getBidder().equals(this)) { // check if current is winner
            msg = String.format("Congratulations! You won the auction for '%s' at ₹%.2f",
                    item.getTitle(), winning.getAmount());
        } else {
            msg = String.format("Auction for '%s' has ended. Winning bid: ₹%.2f",
                    item.getTitle(),
                    (winning != null ? winning.getAmount() : 0.0));
        }
        notifications.add(new Notification(msg));
    }

    // getters
    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getPasswordHash() {return passwordHash;}
    public List<Notification> getNotifications() {return notifications;}
}