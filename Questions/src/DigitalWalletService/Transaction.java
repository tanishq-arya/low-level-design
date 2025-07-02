package DigitalWalletService;

import java.time.Instant;
import java.util.UUID;

public class Transaction {
    private final String id;
    private final Wallet fromWallet;
    private final Wallet toWallet;
    private final double amount;
    private final Currency currency;
    private final Instant timestamp;
    private TransactionStatus status;

    public Transaction(Wallet fromWallet, Wallet toWallet, double amount, Currency currency) {
        this.id = UUID.randomUUID().toString();
        this.fromWallet = fromWallet;
        this.toWallet = toWallet;
        this.amount = amount;
        this.currency = currency;
        this.timestamp = Instant.now();
        this.status = TransactionStatus.PENDING;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public String getId()           { return id; }
    public Wallet getFromWallet()   { return fromWallet; }
    public Wallet getToWallet()     { return toWallet; }
    public double getAmount()       { return amount; }
    public Currency getCurrency()   { return currency; }
    public Instant getTimestamp()   { return timestamp; }
}