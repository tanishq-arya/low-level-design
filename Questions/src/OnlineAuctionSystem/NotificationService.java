package OnlineAuctionSystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Manages subscriptions of users to auctions and delivers notifications
public class NotificationService {
    // Map id -> AuctionItem
    private final Map<String, AuctionItem> auctions = new ConcurrentHashMap<>();

    // Register a new auction so we can subscribe listeners to it
    public void registerAuction(AuctionItem item) {
        auctions.put(item.getId(), item);
    }

    // Subscribe a user to notifications on this auction
    public void subscribe(String auctionId, User user) {
        AuctionItem item = auctions.get(auctionId);
        if (item == null) {
            System.out.println("Auction not found");
            return;
        }
        item.addListener(user);
    }
}