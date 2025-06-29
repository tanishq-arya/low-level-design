package ElevatorSystem.States;

import ElevatorSystem.Direction;
import ElevatorSystem.Elevator;
import ElevatorSystem.Request;

public class MovingState implements ElevatorState {
    @Override
    public void handle(Elevator elevator) {
        int currentFloor = elevator.getCurrentFloor();
        int destinationFloor = elevator.getDestinationFloor();

        if (currentFloor < destinationFloor) {
            elevator.moveUp();   // going UP
        } else {
            elevator.moveDown();  // going DOWN
        }

        // Arrived ?
        if (elevator.getCurrentFloor() == destinationFloor) {
            elevator.setState(elevator.getDoorOpenState());
        }
    }

    @Override
    public String getName() {
        return "Moving";
    }


}