package ElevatorSystem;

import ElevatorSystem.States.MovingState;

import java.util.List;

// Strategy interface for assigning requests to elevators
public interface SchedulerStrategy {
//    Cab Requests originate inside a particular elevator car (a passenger presses a floor button).
//    You already know which elevator should handle it, so there’s no need to “choose” an elevator —
//    simply enqueue that request on the specified elevator’s queue.

//    Hall Requests come from outside (a call button on a floor),
//    so the system must decide which elevator to send.
//    That decision is exactly what the Scheduler strategy is for.
    void assign(HallRequest request, List<Elevator> elevators);
}