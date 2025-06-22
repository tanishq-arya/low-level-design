package TrafficSignalSystem;

import java.util.ArrayList;
import java.util.List;

public class TrafficController {
    // 1. static instance
    private static TrafficController instance;

    // resources
    private final List<Road> roads;
    private boolean emergency;

    // 2. private constructor
    private TrafficController () {
        roads = new ArrayList<>();
        emergency = false;
    }

    // 3. public getInstance
    public static synchronized TrafficController getInstance() {
        if (instance == null) {
            instance = new TrafficController();
        }
        return instance;
    }

    public void addRoad(Road road) {
        this.roads.add(road);
    }

    public List<Road> getRoads() {
        return roads;
    }

    // Start the system
    public void start() {
        System.out.println("Traffic Control started ...");
        while (true) {
            if (emergency) {
                System.out.println("Emergency mode: All signals stay RED.");
                try {
                    Thread.sleep(1000); // check every second
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                break; // break normal cycle
            }

            for (Road road: roads) {
                TrafficLight light = road.getTrafficLight();
                light.changeSignal();
                light.notifyObserver();
                try {
                    Thread.sleep(light.getCurrentDuration() * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void handleEmergency() {
        System.out.println("Emergency detected! Switching all lights to RED.");
        emergency = true;
        for (Road road: roads) {
            road.getTrafficLight().setCurrentSignal(Signal.RED); // force change to RED
        }
    }

    public void clearEmergency() {
        System.out.println("Emergency cleared. Resuming normal operation.");
        emergency = false;
        start(); // start again
    }
}