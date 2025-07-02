package DigitalWalletService;

import DigitalWalletService.Managers.CurrencyConversionService;
import DigitalWalletService.Managers.PaymentMethodManager;
import DigitalWalletService.Managers.TransactionManager;
import DigitalWalletService.Managers.WalletManager;

import java.util.List;

public class WalletService {
    private final WalletManager walletManager = new WalletManager();
    private final TransactionManager txManager = new TransactionManager();
    private final CurrencyConversionService currencyConversionService = new CurrencyConversionService();
    private final PaymentMethodManager pmManager = new PaymentMethodManager();

    public Wallet createWallet(User user, Currency currency) {
        return walletManager.createWallet(user, currency);
    }

    public void addPaymentMethod(String walletId, PaymentMethod paymentMethod) {
        Wallet wallet = walletManager.getWallet(walletId);
        if (wallet != null) {
            pmManager.add(walletId, paymentMethod);
        }
    }

    public void removePaymentMethod(String walletId, PaymentMethod paymentMethod) {
        Wallet wallet = walletManager.getWallet(walletId);
        if (wallet != null) {
            pmManager.remove(walletId, paymentMethod);
        }
    }

    public Transaction transfer(String fromWalletId, String toWalletId, double amount) {
        Wallet from = walletManager.getWallet(fromWalletId);
        Wallet to = walletManager.getWallet(toWalletId);

        // Convert to target currency;
        double amountInFromCurrency = amount;
        if (from.getCurrency() != to.getCurrency()) {
            amountInFromCurrency = currencyConversionService.convert(to.getCurrency(), from.getCurrency(), amount);
        }

        // Withdraw and deposit
        from.withdraw(amountInFromCurrency);
        to.deposit(amount);

        // Create and record transaction
        Transaction tx = new Transaction(from, to, amount, to.getCurrency());
        tx.setStatus(TransactionStatus.COMPLETED);
        txManager.record(tx);

        return tx;
    }

    public List<Transaction> getStatement(String walletId) {
        // ensure wallet exists
        Wallet wallet = walletManager.getWallet(walletId);
        if (wallet != null) {
            return txManager.listByWallet(walletId);
        }
        return List.of();
    }
}