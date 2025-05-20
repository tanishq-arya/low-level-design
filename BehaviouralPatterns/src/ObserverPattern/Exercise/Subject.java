// The Subject interface defines methods for registering, removing, and notifying observers about stock price changes.

package ObserverPattern.Exercise;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String stockSymbol, double newPrice);
}