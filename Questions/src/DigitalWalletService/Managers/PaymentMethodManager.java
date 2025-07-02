package DigitalWalletService.Managers;

import DigitalWalletService.PaymentMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PaymentMethodManager {
    private final Map<String, List<PaymentMethod>> methodsByWallet = new ConcurrentHashMap<>();

    public void add(String walletId, PaymentMethod paymentMethod) {
        methodsByWallet
                .computeIfAbsent(walletId, k -> new ArrayList<>())
                .add(paymentMethod);
    }

    public void remove(String walletId, PaymentMethod paymentMethod) {
        List<PaymentMethod> list = methodsByWallet.get(walletId);
        if (list != null) {
            list.remove(paymentMethod);
        }
    }

    public List<PaymentMethod> getPayMethods(String walletId) {
        return methodsByWallet.getOrDefault(walletId, Collections.emptyList());
    }
}