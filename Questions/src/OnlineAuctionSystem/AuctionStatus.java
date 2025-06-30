package OnlineAuctionSystem;

public enum AuctionStatus {
    PENDING,    // created but not started
    ACTIVE,     // currently accepting bids
    CLOSED      // bidding ended, winner declared
}