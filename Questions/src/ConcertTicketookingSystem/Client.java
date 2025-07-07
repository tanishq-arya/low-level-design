package ConcertTicketookingSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        TicketService service = new TicketService();

        // ── 1) Create a concert with 10 seats (2 VIP, 8 STANDARD) ──
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            seats.add(new Seat("VIP" + i, SeatType.VIP));
        }
        for (int i = 1; i <= 8; i++) {
            seats.add(new Seat("STD" + i, SeatType.STANDARD));
        }
        Concert concert = service.createConcert(
                "Concert-1",
                "The Rolling Codes",
                LocalDateTime.now().plusDays(10),
                seats
        );
        System.out.println("Created Concert: " + concert);


        // ── 2) Search for the concert by artist ──
        List<Concert> found = service.searchConcerts("Rolling");
        System.out.println("\nSearch results for 'Rolling':");
        found.forEach(c -> System.out.println("  " + c.getArtist()
                + " [" + c.getId() + "]"));


        // ── 3) User Alice holds 2 VIP seats ──
        User alice = new User("Alice", "alice@example.com");
        List<Seat> toHoldAlice = concert.getSeats().subList(0, 2);
        Hold holdAlice = service.holdSeats(alice, concert.getId(), toHoldAlice, 30);
        System.out.println("\nAlice held seats: " +
                toHoldAlice.stream().map(Seat::getId).toList());


        // ── 4) Confirm Alice's booking ──
        double totalAlice = toHoldAlice.size() * 150.0; // assume ₹150 per VIP
        Booking bookingAlice = service.book(holdAlice, totalAlice);
        System.out.println("Alice booking confirmed (ID: " + bookingAlice.getId()
                + "), Seats: " + bookingAlice.getSeats().stream().map(Seat::getId).toList());


        // ── 5) Bob attempts to hold those same VIP seats ──
        User bob = new User("Bob", "bob@example.com");
        try {
            Hold holdBob = service.holdSeats(bob, concert.getId(), toHoldAlice, 30);
        } catch (IllegalStateException ex) {
            System.out.println("\nBob failed to hold VIP seats: " + ex.getMessage());
            // Bob joins waitlist
            service.addToWaitlist(bob, concert.getId());
            System.out.println("Bob added to waitlist for concert.");
        }


        // ── 6) List all bookings ──
        System.out.println("\nAll bookings for concert:");
        service.getAllBookings(concert.getId()).forEach(bk ->
                System.out.println("  Booking " + bk.getId() + " by " + bk.getUser().getName()
                        + " Seats: " + bk.getSeats().stream().map(Seat::getId).toList())
        );
        System.out.println("\nAll waitlist for concert:");
        service.getAllWaitlist(concert.getId()).forEach(wl ->
                System.out.println("  Waitlist " + wl.getId() + " by " + wl.getUser().getName())
        );
    }
}