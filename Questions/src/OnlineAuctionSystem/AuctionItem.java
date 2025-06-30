package OnlineAuctionSystem;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Subject - to be observed by observers
public class AuctionItem {
    private final String id;
    private final String title;
    private final String description;
    private final List<String> tags;
    private final User seller;
    private final double startingPrice;
    private final double minIncrement;
    private final Instant startTime;
    private final Instant endTime;

    private AuctionStatus status;
    private Bid currentHighestBid;
    private final List<Bid> bidHistory = new ArrayList<>();

    // Observers for bid/outbid and close events
    private final List<NotificationListener> listeners = new ArrayList<>();

    public AuctionItem(String title, String description, List<String> tags, User seller, double startingPrice, double minIncrement,
                       Instant startTime, Instant endTime) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.seller = seller;
        this.startingPrice = startingPrice;
        this.minIncrement = minIncrement;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = AuctionStatus.PENDING;
        this.currentHighestBid = null;
    }

    public void addListener(NotificationListener listener) {
        synchronized (listeners) {
            listeners.add(listener);
        }
    }

    // Place a bid on this auction. Thread-safe to handle concurrent bids.
    public synchronized void addBid(Bid bid) {
        Instant now = Instant.now();
        if (status != AuctionStatus.ACTIVE) {
            System.out.println("Auction is not active.");
            return;
        }

        if (now.isAfter(endTime)) {
            System.out.println("Auction has already ended.");
            return;
        }

        // Check if current bid is less
        double base = (currentHighestBid != null) ? currentHighestBid.getAmount() : startingPrice;
        if (bid.getAmount() < base + minIncrement) {
            System.out.println("Bid must be at least " + (base + minIncrement));
            return;
        }

        // Current bid is now the highest bid > update
        Bid previous = this.currentHighestBid;
        this.currentHighestBid = bid;
        bidHistory.add(bid);

        // Notify previous highest bidder > outbid
        if (previous != null) {
            notifyOutbid(previous);
        }
    }

    // Transition to CLOSED status and notify listeners of closure.
    public synchronized void close() {
        if (status == AuctionStatus.CLOSED) return;
        status = AuctionStatus.CLOSED;
        notifyClosed();
    }

    private void notifyClosed() {
        synchronized (listeners) {
            for (NotificationListener listener: listeners) {
                listener.onAuctionClosed(this);
            }
        }
    }

    // Mark auction active when startTime arrives
    public synchronized void activate() {
        if (status == AuctionStatus.PENDING && Instant.now().isAfter(startTime)) {
            status = AuctionStatus.ACTIVE;
        }
    }

    // Internal: notify outbid event
    private void notifyOutbid(Bid previous) {
        synchronized (listeners) {
            // Notify the previous highest bidder only ?
             previous.getBidder().onOutbid(this, previous);
        }
    }

    // getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public List<String> getTags() { return List.copyOf(tags); }
    public User getSeller() { return seller; }
    public AuctionStatus getStatus() { return status; }
    public Bid getCurrentHighestBid() { return currentHighestBid; }

    @Override
    public String toString() {
        return "AuctionItem{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", seller=" + seller +
                ", startingPrice=" + startingPrice +
                ", minIncrement=" + minIncrement +
                ", status=" + status +
                ", currentHighestBid=" + currentHighestBid +
                '}';
    }
}