package ElevatorSystem;

import java.util.List;

/**
 * A simple scheduler that picks the nearest elevator to the requested floor.
 */
public class NearestScheduler implements SchedulerStrategy{
    @Override
    public void assign(HallRequest request, List<Elevator> elevators) {
        Elevator bestElevator = null;
        int bestDistance = Integer.MAX_VALUE;
        int reqFloor = request.getFloor();

        for (Elevator elevator: elevators) {
            // Only consider idle or moving towards the request
            int distance = Math.abs(elevator.getCurrentFloor() - reqFloor);
            if (distance < bestDistance) {
                bestDistance = distance;
                bestElevator = elevator;
            }
        }

        if (bestElevator != null) {
            System.out.println("Scheduling request at floor " + reqFloor + " to Elevator " + bestElevator.getId());
            bestElevator.addRequest(request);
        }
    }
}