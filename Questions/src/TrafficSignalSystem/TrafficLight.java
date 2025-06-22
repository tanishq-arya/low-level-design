package TrafficSignalSystem;

public class TrafficLight {
    private final String id;
    private Signal currentSignal; // current state
    private int redDuration; // seconds
    private int yellowDuration;
    private int greenDuration;

    public TrafficLight(String id, int redDuration, int yellowDuration, int greenDuration) {
        this.id = id;
        this.redDuration = redDuration;
        this.yellowDuration = yellowDuration;
        this.greenDuration = greenDuration;

        currentSignal = Signal.RED; // default start state
    }

    public Signal getCurrentSignal() {
        return currentSignal;
    }

    public void setCurrentSignal(Signal currentSignal) {
        this.currentSignal = currentSignal;
    }

    public void changeSignal() {
        switch (currentSignal) {
            case RED -> currentSignal = Signal.YELLOW;
            case YELLOW -> currentSignal = Signal.GREEN;
            case GREEN -> currentSignal = Signal.RED;
        }
        System.out.println("TrafficLight [" + id + "] changed to: " + currentSignal);
    }

    public int getCurrentDuration() {
        return switch (currentSignal) {
            case RED -> redDuration;
            case YELLOW -> yellowDuration;
            case GREEN -> greenDuration;
            default -> 0;
        };
    }

    // Observer Pattern > notify road
    public void notifyObserver() {
        System.out.println("TrafficLight [" + id + "] notifying: Signal is now " + currentSignal);
    }
}