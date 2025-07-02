package DigitalWalletService.Managers;

import DigitalWalletService.Currency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Simple in-memory currency conversion
public class CurrencyConversionService {
    // rates[from][to] = multiplier
    private final Map<Currency, Map<Currency, Double>> rates = new ConcurrentHashMap<>();

    public CurrencyConversionService() {
        // initialize default 1:1
        for (Currency c1: Currency.values()) {
            rates.putIfAbsent(c1, new ConcurrentHashMap<>());
            for (Currency c2: Currency.values()) {
                rates.get(c1).put(c2, c1 == c2 ? 1.0 : 1.0);
            }
        }

        rates.get(Currency.USD).put(Currency.INR, 75.0);
        rates.get(Currency.INR).put(Currency.USD, 1/75.0);
    }

    // Convert amount from one currency to another
    public double convert(Currency from, Currency to, double amount) {
        Map<Currency, Double> inner = rates.get(from);
        if (inner == null || !inner.containsKey(to)) {
            throw new RuntimeException("Unsupported currency conversion: " + from + " to " + to);
        }
        return amount * inner.get(to);
    }
}