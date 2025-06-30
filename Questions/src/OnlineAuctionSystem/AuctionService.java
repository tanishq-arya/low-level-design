package OnlineAuctionSystem;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


// Facade
public class AuctionService {
    private final Map<String, AuctionItem> auctions = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final NotificationService notificationService;
    private final AuthService authService;

    public AuctionService(NotificationService notificationService, AuthService authService) {
        this.notificationService = notificationService;
        this.authService = authService;
    }

    // Create a new auction. Schedules activation and closing tasks.
    public AuctionItem createAuction(String token, String title, String desc, List<String> tags, double startPrice, double minIncrement, Instant startTime, Instant endTime) {
        User seller = authService.getUserByToken(token);
        AuctionItem item = new AuctionItem(title, desc, tags, seller, startPrice, minIncrement, startTime, endTime);
        auctions.put(item.getId(), item);
        notificationService.registerAuction(item);

        // Schedule activation
        long delayToStart = Math.max(0, startTime.toEpochMilli() - Instant.now().toEpochMilli());
        scheduler.schedule(item::activate, delayToStart, TimeUnit.MILLISECONDS);

        // Schedule closing
        long delayToEnd = Math.max(0, endTime.toEpochMilli() - Instant.now().toEpochMilli());
        scheduler.schedule(item::close, delayToEnd, TimeUnit.MILLISECONDS);

        return item;
    }

    // Search active or pending auctions by tag or title contains
    public List<AuctionItem> searchAuctions(String token, String keyword, String tag) {
        authService.getUserByToken(token); // validate user
        return auctions.values().stream()
                .filter(a -> a.getStatus() == AuctionStatus.ACTIVE
                        || a.getStatus() == AuctionStatus.PENDING)
                .filter(a -> keyword == null || a.getTitle().contains(keyword))
                .filter(a -> tag == null || a.getTags().contains(tag))
                .collect(Collectors.toList());
    }

    // Place a bid. User must subscribe first to get notifications.
    public void placeBid(String token, String auctionId, double amount) {
        User bidder = authService.getUserByToken(token); // validate user
        AuctionItem item = auctions.get(auctionId);
        if (item == null) throw new RuntimeException("Auction not found");

        // Subscribe bidder for notifications if not seller
        if (!item.getSeller().equals(bidder)) {
            notificationService.subscribe(auctionId, bidder);
        }

        Bid bid = new Bid(bidder, amount);
        item.addBid(bid);
    }

    // Manually close an auction before its scheduled end.
    public void closeAuction(String token, String auctionId) {
        authService.getUserByToken(token); // validate user
        AuctionItem item = auctions.get(auctionId);
        if (item == null) throw new RuntimeException("Auction not found");
        item.close();
    }

    // Shutdown the scheduler when done
    public void shutdown() {
        scheduler.shutdown();
    }
}