package ElevatorSystem;

/**
 A cab (from inside) call from a particular floor, wanting to go UP or DOWN.
 */
public class CabRequest extends Request {
    private final int elevatorId;

    protected CabRequest(int elevatorId, int floor) {
        super(floor);
        this.elevatorId = elevatorId;
    }

    public int getElevatorId() {
        return elevatorId;
    }
}