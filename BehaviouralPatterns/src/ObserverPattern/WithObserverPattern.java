package ObserverPattern;

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(float temp);
}

// Observers
class DisplayDeviceIn implements Observer {
    String name;

    DisplayDeviceIn(String deviceName) {
        this.name = deviceName;
    }

    @Override
    public void update(float temp) {
        System.out.println("Temp on " + name + " is: " + temp);
    }
}

class MobileDeviceIn implements Observer {
    @Override
    public void update(float temp) {
        System.out.println("Temp on Mobile is: " + temp);
    }
}

// Subject interface
interface Subject {
    void add(Observer obs);

    void remove(Observer obs);

    void notifyObservers(); // notify all observers
}

// Subject class / Observable
class WeatherStationIn implements Subject {
    private float temp;

    private List<Observer> observerList;

    WeatherStationIn() {
        observerList = new ArrayList<>();
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    @Override
    public void add(Observer obs) {
        observerList.add(obs);
    }

    @Override
    public void remove(Observer obs) {
        observerList.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for(Observer obs: observerList) {
            obs.update(temp);
        }
    }
}

public class WithObserverPattern {
    public static void main(String[] args) {
        // Created observable / publisher
        WeatherStationIn weatherStationNew = new WeatherStationIn();

        // Create observers / subscribers
        DisplayDeviceIn device = new DisplayDeviceIn("Samsung LED");
        MobileDeviceIn mobileDevice = new MobileDeviceIn();

        // Add the observers
        weatherStationNew.add(device);
        weatherStationNew.add(mobileDevice);

        // Testing
        weatherStationNew.setTemp(25);
        weatherStationNew.notifyObservers(); // this notifies both the devices
    }
}
