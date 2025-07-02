package DigitalWalletService;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        WalletService service = new WalletService();

        // Create users
        User alice = new User("Alice", "alice@example.com", "pw1");
        User bob   = new User("Bob",   "bob@example.com",   "pw2");

        // Create wallets
        Wallet wa = service.createWallet(alice, Currency.INR);
        Wallet wb = service.createWallet(bob,   Currency.USD);

        System.out.println("Alice's wallet: " + wa.getId() + " balance=" + wa.getBalance() + " " + wa.getCurrency());
        System.out.println("Bob's wallet:   " + wb.getId() + " balance=" + wb.getBalance() + " " + wb.getCurrency());

        // Deposit into Alice's wallet
        wa.deposit(10000);
        System.out.println("Alice deposits 10000 INR, balance=" + wa.getBalance());

        // Add payment methods
        service.addPaymentMethod(wa.getId(), new DummyPaymentMethod());

        // Transfer from Alice to Bob: 100 USD (converted from INR)
        Transaction tx = service.transfer(wa.getId(), wb.getId(), 100.0);
        System.out.println("Transfer completed: " + tx.getId()
                + " from " + tx.getFromWallet().getId() + "(" + tx.getAmount() + " " + tx.getCurrency() + ")"
                + " to   " + tx.getToWallet().getId());

        // Fetch statements
        List<Transaction> stmtA = service.getStatement(wa.getId());
        System.out.println("Alice's statement:");
        for (Transaction t : stmtA) {
            System.out.println("  " + t.getTimestamp()
                    + " " + t.getFromWallet().getOwner().getName()
                    + " -> " + t.getToWallet().getOwner().getName()
                    + " : " + t.getAmount() + " " + t.getCurrency());
        }

        List<Transaction> stmtB = service.getStatement(wb.getId());
        System.out.println("Bob's statement:");
        for (Transaction t : stmtB) {
            System.out.println("  " + t.getTimestamp()
                    + " " + t.getFromWallet().getOwner().getName()
                    + " -> " + t.getToWallet().getOwner().getName()
                    + " : " + t.getAmount() + " " + t.getCurrency());
        }

        System.out.println("Alice's wallet: " + wa.getId() + " balance=" + wa.getBalance() + " " + wa.getCurrency());
        System.out.println("Bob's wallet:   " + wb.getId() + " balance=" + wb.getBalance() + " " + wb.getCurrency());
    }
}