package DigitalWalletService.Managers;

import DigitalWalletService.Currency;
import DigitalWalletService.User;
import DigitalWalletService.Wallet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Manages wallet: create, deposit, withdraw
public class WalletManager {
    private final Map<String, Wallet> wallets = new ConcurrentHashMap<>();

    // create a wallet for a user in a specific currency
    public Wallet createWallet(User owner, Currency currency) {
        Wallet wallet = new Wallet(owner, currency);
        wallets.put(wallet.getId(), wallet);
        return wallet;
    }

    public Wallet getWallet(String walletId) {
        Wallet wallet = wallets.get(walletId);
        if (wallet == null) {
            throw new RuntimeException("Wallet not found: " + walletId);
        }
        return wallet;
    }

    public void deposit(String walletId, double amount) {
        try {
            Wallet wallet = getWallet(walletId);
            wallet.deposit(amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdraw(String walletId, double amount) {
        try {
            Wallet wallet = getWallet(walletId);
            wallet.withdraw(amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}