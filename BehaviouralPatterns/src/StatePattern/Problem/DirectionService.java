package StatePattern.Problem;

enum TransportationMode {
    WALKING, CYCLING, CAR, TRAIN
}

public class DirectionService {
    private TransportationMode mode;

    public DirectionService() {}

    public void setMode(TransportationMode mode) {
        this.mode = mode;
    }

    // Method to calculate ETA based on mode of transport
    public int getETA() {
        switch (mode) {
            case WALKING -> {
                System.out.println("ETA for walking 10");
                return 10;
            }
            case CYCLING -> {
                System.out.println("ETA for cycling 5");
                return 5;
            }
            case CAR -> {
                System.out.println("ETA for car 3");
                return 3;
            }
            case TRAIN -> {
                System.out.println("ETA for train 7");
                return 7;
            }
            default -> throw new IllegalArgumentException("Unknown mode");
        }
    }

    public String getDirections() {
        switch (mode) {
            case WALKING -> {
                return "Directions for walking";
            }
            case CYCLING -> {
                return "Directions for cycling";
            }
            case CAR -> {
                return "Directions for car";
            }
            case TRAIN -> {
                return "Directions for train";
            }
            default -> {
                return "No directions";
            }
        }
    }
}