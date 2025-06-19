package VendingMachine.State;

public class Client {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        // Add products to the inventory
        Product coke = vendingMachine.addProduct("Coke", 15, 3);
        Product pepsi = vendingMachine.addProduct("Pepsi", 15, 2);
        Product water = vendingMachine.addProduct("Water", 10, 5);

        // Select a product
        vendingMachine.selectProduct(coke);

        // Insert coins
        vendingMachine.insertCoin(Coin.FIVE);
        vendingMachine.insertCoin(Coin.FIVE);
        vendingMachine.insertCoin(Coin.FIVE);
        vendingMachine.insertCoin(Coin.FIVE);

        // Dispense the product
        vendingMachine.dispenseProduct();

        // Return change
        vendingMachine.returnChange();

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