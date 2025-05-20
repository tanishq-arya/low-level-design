package ObserverPattern;

class DisplayDevice {
    public void showTemp(float temp) {
        System.out.println("Current temp on displayDevice: " + temp + " C");
    }
}

class MobileDevice {
    public void showTemp(float temp) {
        System.out.println("Current temp on mobile : " + temp);
    }
}

class WeatherStation {
    private float temp;

    private final DisplayDevice displayDevice; // can be multiple such devices

    public WeatherStation(DisplayDevice displayDevice) {
        this.temp = 0f;
        this.displayDevice = displayDevice;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public void notifyDevice() {
        displayDevice.showTemp(temp);
    }
}

public class WithoutObserverPattern {
    public static void main(String[] args) {
        DisplayDevice device = new DisplayDevice();
        WeatherStation station = new WeatherStation(device);

        // Now set and notify
        station.setTemp(26);
        station.notifyDevice();

        // Problems:
        // 1. We have to update on mobile too.
        // 2. Create mobile device > Modify weatherStation to notify mobileDevice.
        // 3. We don't have any method to add / remove devices
        // Solution: observer pattern
    }
}
