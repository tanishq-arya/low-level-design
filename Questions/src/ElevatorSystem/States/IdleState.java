package ElevatorSystem.States;

import ElevatorSystem.Elevator;
import ElevatorSystem.Request;

public class IdleState implements ElevatorState{
    @Override
    public void handle(Elevator elevator) {
        // if pending requests: transition to moving state
        if (elevator.hasRequests()) {
            Request next = elevator.peekRequest();
            int floor = next.getFloor();

            if (floor == elevator.getCurrentFloor()) {
                elevator.getRequests().removeIf(r -> r.getFloor() == floor);
                elevator.setState(elevator.getDoorOpenState()); // move to last state
            } else {
                elevator.setDestinationFloor(floor);
                elevator.setState(elevator.getMovingState()); // move to next state
            }
        }
        // else: no requests > remain idle
    }

    @Override
    public String getName() {
        return "Idle";
    }
}