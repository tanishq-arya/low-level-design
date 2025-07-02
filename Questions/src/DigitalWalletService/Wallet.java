package DigitalWalletService;

import java.util.UUID;

public class Wallet {
    private final String id;
    private final User owner;
    private final Currency currency;
    private double balance;
    private WalletStatus status;

    public Wallet(User owner, Currency currency) {
        this.id = UUID.randomUUID().toString();
        this.owner = owner;
        this.currency = currency;
        this.balance = 0.0;
        this.status = WalletStatus.ACTIVE;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {
        if (status != WalletStatus.ACTIVE) {
            System.out.println("Wallet not active.");
            return;
        }
        balance += amount; // update balance
    }

    public synchronized void withdraw(double amount) {
        if (status != WalletStatus.ACTIVE) {
            System.out.println("Wallet not active.");
            return;
        }

        if (balance < amount) {
            System.out.println("Insufficient funds.");
            return;
        }

        balance -= amount; // update balance
    }

    public synchronized WalletStatus getStatus() {
        return status;
    }

    public synchronized void setStatus(WalletStatus status) {
        this.status = status;
    }

    public String getId()          { return id; }
    public User getOwner()         { return owner; }
    public Currency getCurrency()  { return currency; }
}