package OnlineAuctionSystem;

import java.util.UUID;

// Represents a bid placed by a user on an auction item
public class Bid {
    private final String id;
    private final User bidder;
    private final double amount;
    private final String timestamp;

    public Bid(User bidder, double amount) {
        this.id = UUID.randomUUID().toString();
        this.bidder = bidder;
        this.amount = amount;
        this.timestamp = String.valueOf(System.currentTimeMillis());
    }

    public String getId() { return id; }
    public User getBidder() { return bidder; }
    public double getAmount() { return amount; }
    public String getTimestamp() { return timestamp; }
}