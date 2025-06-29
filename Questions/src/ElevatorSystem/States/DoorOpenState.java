package ElevatorSystem.States;

import ElevatorSystem.Elevator;

public class DoorOpenState implements ElevatorState {
        @Override
        public void handle(Elevator elevator) {
            System.out.println("Elevator " + elevator.getId() + " doors opening at floor " + elevator.getCurrentFloor());
            // simulate door open time
            try {
                Thread.sleep(1000); // 1 second
            } catch (InterruptedException ignored) {}

            System.out.println("Elevator " + elevator.getId() + " doors closing");

            // Remove *all* matching requests for this floor
            elevator.getRequests().removeIf(r -> r.getFloor() == elevator.getCurrentFloor());

            // After doors close, go back to Idle to pick new request
            elevator.setDestinationFloor(0);
            elevator.setState(elevator.getIdleState());
        }

        @Override
        public String getName() {
            return "DoorOpen";
        }
    }