package VendingMachine.SessionPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachine {
    private final Inventory<Product> productInventory = new Inventory<Product>();
    private final Inventory<Coin> cashInventory = new Inventory<Coin>();
    private int currentBalance = 0; // Cash which user inputs
    private Product currentProduct; // Which user selects

    public VendingMachine() {
        // Add some products and coins
        initialize();
    }

    private void initialize() {
        // Add Products
        Product coke = new Product(1, "Coke", 20);
        Product pepsi = new Product(2, "Pepsi", 20);
        Product sprite = new Product(3, "Sprite", 25);
        Product chips = new Product(4, "Chips", 30);

        productInventory.add(coke, 5);
        productInventory.add(pepsi, 5);
        productInventory.add(sprite, 5);
        productInventory.add(chips, 10);

        // Add Coins
        for (Coin coin: Coin.values()) {
            cashInventory.add(coin, 5); // 5 coins each
        }
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void insertCoin(Coin coin) {
        currentBalance += coin.getValue();
        cashInventory.add(coin);
    }

    public void selectProduct(int productId) throws Exception {
        for (Product p: productInventory.getInventory().keySet()) {
            if (p.getId() == productId) { // Product found in inventory
               currentProduct = p;
               if (productInventory.hasItem(p)) { // Check if available
                   if (currentBalance >= p.getPrice()) { // Check balance inserted
                       dispenseProduct();
                   } else {
                       throw new Exception("Insufficient funds. Please insert more coins");
                   }
               } else {
                   throw new Exception("Product out of stock.");
               }
               return;
            }
        }
        throw new Exception("Invalid product.");
    }

    private void dispenseProduct() throws Exception {
        productInventory.remove(currentProduct);
        int change = currentBalance - currentProduct.getPrice();
        System.out.println("Dispensing: " + currentProduct.getName());

        if (change > 0) {
            System.out.println("Returning change: " + change);
            refund(change); // Return change to user
        }

        // Reset
        currentProduct = null;
        currentBalance = 0;
    }

    private void refund(int amount) throws Exception {
        List<Coin> refundCoins = new ArrayList<>();

        int balance = amount;
        Coin[] coins = Coin.values();
        Arrays.sort(coins, (a,b) -> b.getValue() - a.getValue()); // Descending order

        for (Coin coin: coins) {
            while (balance >= coin.getValue() && cashInventory.getQuantity(coin) > 0) {
                refundCoins.add(coin);
                balance -= coin.getValue();
                cashInventory.remove(coin);
            }
        }
        if (balance != 0) {
            throw new Exception("Not enough change. Please contact support.");
        }

        System.out.println("Change coins returned: " + refundCoins);
    }

    public void cancel() throws Exception {
        System.out.println("Cancelling transaction. Refunding: " + currentBalance);
        refund(currentBalance);
        currentBalance = 0;
        currentProduct = null;
    }

    public void restockProduct(Product product, int quantity) {
        productInventory.add(product, quantity);
    }

    public void collectCash() {
        cashInventory.clear();
    }

    public void displayProducts() {
        System.out.println("Available products:");
        for (Product p : productInventory.getInventory().keySet()) {
            System.out.println(p.getId() + ": " + p.getName() + " - Price: " + p.getPrice() +
                    ", Quantity: " + productInventory.getQuantity(p));
        }
    }
}