package ElevatorSystem.States;

import ElevatorSystem.Elevator;

// State interface for Elevator behavior
public interface ElevatorState {
    // handle the action for this state
    void handle(Elevator elevator);

    // name of state, for logging / diagnostics
    String getName();
}