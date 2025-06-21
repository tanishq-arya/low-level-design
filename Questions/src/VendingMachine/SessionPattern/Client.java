package VendingMachine.SessionPattern;

public class Client {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        vm.displayProducts();

        try {
            vm.insertCoin(Coin.TWENTY);
            vm.insertCoin(Coin.TEN);
            vm.selectProduct(1); // Buy coke
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}