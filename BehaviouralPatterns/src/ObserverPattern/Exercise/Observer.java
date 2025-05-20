// The Observer interface defines the update method for receiving stock price change notifications.

package ObserverPattern.Exercise;

public interface Observer {
    void update(String stockSymbol, double newPrice);
}