package RestaurantManagementSystem;

import java.time.LocalDateTime;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        // ──────────── 1) Initialize System ────────────
        RestaurantSystem sys = new RestaurantSystem(); // Can be made Singleton

        // ──────────── 2) Populate inventory ────────────
        Ingredient cheese = new Ingredient("I1", "Cheese", 10, "slices");
        Ingredient dough  = new Ingredient("I2", "Dough", 5, "bases");
        Ingredient tomato = new Ingredient("I3", "Tomato Sauce", 8, "cups");
        Ingredient lettuce= new Ingredient("I4", "Lettuce", 5, "heads");

        sys.addIngredient(cheese);
        sys.addIngredient(dough);
        sys.addIngredient(tomato);
        sys.addIngredient(lettuce);

        // ──────────── 3) Define menu items ────────────
        MenuItem pizza = new MenuItem(
                "M1", "Cheese Pizza", 12.0, "Pizza",
                List.of(dough, tomato, cheese)
        );
        MenuItem salad = new MenuItem(
                "M2", "Caesar Salad", 8.0, "Salad",
                List.of(lettuce, cheese)
        );

        sys.addMenuItem(pizza);
        sys.addMenuItem(salad);

        System.out.println("Menu:");
        for (MenuItem item: sys.viewMenu()) {
            System.out.println("  " + item.getName() + " — ₹" + item.getPrice());
        }

        // ──────────── 4) Create a customer ────────────
        Customer alice = new Customer("Alice", "alice@example.com");

        // ──────────── 5) Place an order via Dine‑In ────────────
        OrderingStrategy dineIn = new DineInOrder();
        List<MenuItem> orderItems = List.of(pizza, salad);

        System.out.println("\nAlice is placing a dine‑in order for pizza + salad...");
        Order aliceOrder = sys.placeOrder(alice, orderItems, dineIn);

        // ──────────── 6) Process payment ────────────
        Payment payment = new Payment(aliceOrder, aliceOrder.getTotalAmount(), "CASH");
        payment.process();
        aliceOrder.markCompleted();
        System.out.println("Payment status: " + payment.getStatus());

        // ──────────── 7) Check inventory levels ────────────
        System.out.println("\nRemaining inventory:");
        for (Ingredient ing : List.of(cheese, dough, tomato, lettuce)) {
            System.out.println("  " + ing.getName() + ": " + ing.getQuantityInStock() + " " + ing.getUnit());
        }

        // ──────────── 8) Make a reservation ────────────
        System.out.println("\nAlice makes a reservation for 4 at " + LocalDateTime.now().plusHours(2));
        Reservation reservation = sys.makeReservation(alice, LocalDateTime.now().plusHours(2), 4);
        reservation.confirm();
        System.out.println("Reservation confirmed: " + reservation.getId()
                + " at " + reservation.getDateTime() + ", for party of " + reservation.getPartySize());

        // ──────────── 9) Generate Report ────────────
        Report salesReport = sys.generateSalesReport();
        System.out.println(salesReport.getContent());
    }
}