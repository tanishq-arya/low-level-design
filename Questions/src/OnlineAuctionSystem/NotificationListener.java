package OnlineAuctionSystem;

public interface NotificationListener {
    void onAuctionClosed(AuctionItem item);
    void onOutbid(AuctionItem item, Bid previousHighest);
}