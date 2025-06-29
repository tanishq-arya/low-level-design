package ElevatorSystem;

/**
 * A hall (outside) call from a particular floor, wanting to go UP or DOWN.
 */
public class HallRequest extends Request {
    private final Direction direction;

    protected HallRequest(int floor, Direction direction) {
        super(floor);
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}