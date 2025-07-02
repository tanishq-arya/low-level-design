package DigitalWalletService.Managers;

import DigitalWalletService.Transaction;
import DigitalWalletService.TransactionStatus;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Records and retrieves transactions.
public class TransactionManager {
    private final Map<String, Transaction> transactions = new ConcurrentHashMap<>();

    // Record a transaction
    public void record(Transaction tx) {
        transactions.put(tx.getId(), tx);
    }

    // Retrieve a transaction
    public Transaction retrieve(String transactionId) {
        return transactions.get(transactionId);
    }

    // List all transactions
    public List<Transaction> listByWallet(String walletId) {
        return transactions.values().stream()
                .filter(tx -> (tx.getToWallet() != null && walletId.equals(tx.getToWallet().getId())
                                      ||tx.getFromWallet() != null && walletId.equals(tx.getFromWallet().getId())))
                .sorted(Comparator.comparing(Transaction::getTimestamp))
                .toList();
    }

    // Update transaction status
    public void updateStatus(String txId, TransactionStatus status) {
        Transaction tx = transactions.get(txId);
        if (tx == null) throw new RuntimeException("Transaction not found: " + txId);
        tx.setStatus(status);
    }
}