package TrafficSignalSystem;

public class Road {
    private final String id;
    private final String name;
    private final TrafficLight trafficLight;

    public Road(String id, String name, TrafficLight trafficLight) {
        this.id = id;
        this.name = name;
        this.trafficLight = trafficLight;
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }

    public String getName() {
        return name;
    }
}