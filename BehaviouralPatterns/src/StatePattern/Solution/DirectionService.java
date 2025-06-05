package StatePattern.Solution;

public class DirectionService {
    TransportationMode mode;

    DirectionService(TransportationMode mode) {
        this.mode = mode;
    }

    public void setMode(TransportationMode mode) {
        this.mode = mode;
    }

    public int getETA() {
        return mode.getETA();
    }

    public String getDirections() {
        return mode.getDirections();
    }
}