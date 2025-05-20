// The StockMarketAlert class tracks stock price changes and notifies observers if the change exceeds a threshold.

package ObserverPattern.Exercise;

import java.util.ArrayList;
import java.util.List;

public class StockMarketAlert implements Subject {

    private final List<Observer> observers;
    private final double priceChangeThreshold;

    public StockMarketAlert(double priceChangeThreshold) {
        // TODO: Initialize the list of observers to keep track of registered observers.
        observers = new ArrayList<>();

        this.priceChangeThreshold = priceChangeThreshold;
    }

    @Override
    public void registerObserver(Observer o) {
        // TODO: Add observer to the list of observers
        observers.add(o);

    }

    @Override
    public void removeObserver(Observer o) {
        // TODO: Remove observer from the list of observers
        observers.remove(o);

    }

    @Override
    public void notifyObservers(String stockSymbol, double newPrice) {
        for (Observer observer : observers) {
            // TODO: Inform each observer about the updated stock price.

            observer.update(stockSymbol, newPrice);
        }
    }

    public void setStockPrice(String stockSymbol, double newPrice, double oldPrice) {
        double priceChange = Math.abs(newPrice - oldPrice) / oldPrice * 100;
        if (priceChange >= priceChangeThreshold) {
            // TODO: Notify observers if the price change exceeds the threshold
            notifyObservers(stockSymbol, newPrice);
        }
    }
}