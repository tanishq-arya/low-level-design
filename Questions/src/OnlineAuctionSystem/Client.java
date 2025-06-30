package OnlineAuctionSystem;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Client {
    public static void main(String[] args) throws Exception {
        // Services
        AuthService authService = new AuthService();
        NotificationService notificationService = new NotificationService();
        AuctionService auctionService = new AuctionService(notificationService, authService);

        // Register users
        User alice = authService.register("Alice", "alice@mail", "hash1");
        User bob   = authService.register("Bob",   "bob@mail",   "hash2");
        User charlie   = authService.register("Charlie",   "charlie@mail",   "hash3");
        String aliceToken = authService.login("alice@mail", "hash1");
        String bobToken   = authService.login("bob@mail",   "hash2");
        String charlieToken   = authService.login("charlie@mail",   "hash3");

        // Create auction starting now, ending in 5 seconds
        Instant now = Instant.now();
        AuctionItem item = auctionService.createAuction(
                aliceToken,
                "Vintage Clock",
                "Antique wall clock",
                List.of("antiques","clock"),
                1000,    // start price ₹1000
                100,     // min increment ₹100
                now,
                now.plus(5, ChronoUnit.SECONDS)
        );
        System.out.println("Auction created: " + item);

        // Wait for activation
        Thread.sleep(1000);

        // Bob places a bid of ₹1100
        auctionService.placeBid(bobToken, item.getId(), 1100);
        System.out.println("Bob bid ₹1100");

        // Alice tries to outbid herself (invalid) – should fail
        try {
            System.out.println("Alice bids ₹1150");
            auctionService.placeBid(aliceToken, item.getId(), 1150);
        } catch (Exception e) {
            System.out.println("Expected failure: " + e.getMessage());
        }

        // Charlie bids ₹1200
        auctionService.placeBid(charlieToken, item.getId(), 1200);
        System.out.println("Charlie bid ₹1200");

        // Wait for auction to close automatically
        Thread.sleep(6000);

        // Check notifications
        System.out.println("Alice's notifications:");
        alice.getNotifications().forEach(n -> System.out.println(" - " + n.getMessage()));

        System.out.println("Bob's notifications:");
        bob.getNotifications().forEach(n -> System.out.println(" - " + n.getMessage()));

        System.out.println("Charlie's notifications:");
        charlie.getNotifications().forEach(n -> System.out.println(" - " + n.getMessage()));

        auctionService.shutdown();
    }
}