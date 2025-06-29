package ElevatorSystem;

import ElevatorSystem.States.MovingState;

import java.util.List;

// Facade for handling requests
public class ElevatorController {
    private final List<Elevator> elevators;
    private final SchedulerStrategy scheduler;

    public ElevatorController(List<Elevator> elevators, SchedulerStrategy scheduler) {
        this.elevators = elevators;
        this.scheduler = scheduler;
    }

    // Hall call > from outside the elevator
    public void requestHall(int floor, Direction direction) {
        HallRequest request = new HallRequest(floor, direction);
        scheduler.assign(request, elevators);
    }

    // Cab call > from inside the elevator
    public void requestCab(int elevatorId, int floor) {
        CabRequest request = new CabRequest(elevatorId, floor);
        for (Elevator elevator: elevators) {
            if (elevator.getId() == elevatorId) {
                System.out.println("Elevator " + elevatorId + " found for cab request.");
                elevator.addRequest(request); // add request to current elevator
                return;
            }
        }
        System.out.println("Elevator " + elevatorId + " not found for cab request.");
    }
}