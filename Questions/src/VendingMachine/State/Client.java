package VendingMachine.State;

public class Client {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        // Add products to the inventory
        Product coke = vendingMachine.addProduct("Coke", 15, 3);
        Product pepsi = vendingMachine.addProduct("Pepsi", 15, 2);
        Product water = vendingMachine.addProduct("Water", 10, 5);

        // Select a product
        vendingMachine.selectProduct(coke); // Idle > Ready

        // Insert coins
        vendingMachine.insertCoin(Coin.FIVE);
        vendingMachine.insertCoin(Coin.FIVE);
        vendingMachine.insertCoin(Coin.FIVE);
        vendingMachine.insertCoin(Coin.FIVE);  // Ready > Dispense, extra coin inserted

        // Dispense the product
        vendingMachine.dispenseProduct(); // Dispense > ReturnChange

        // Return change
        vendingMachine.returnChange(); // ReturnChange > Idle [base state]

        System.out.println("\n==== Select another product ====\n");
        // Select another product
        vendingMachine.selectProduct(pepsi);

        // Insert insufficient payment
        vendingMachine.insertCoin(Coin.FIVE);

        // Try to dispense the product
        vendingMachine.dispenseProduct();

        // Insert more coins
        vendingMachine.insertCoin(Coin.FIVE);
        vendingMachine.insertCoin(Coin.FIVE);
        vendingMachine.insertCoin(Coin.FIVE);
        vendingMachine.insertCoin(Coin.FIVE);

        // Dispense the product
        vendingMachine.dispenseProduct();

        // Return change
        vendingMachine.returnChange();
    }
}