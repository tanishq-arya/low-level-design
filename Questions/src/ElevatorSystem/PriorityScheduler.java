package ElevatorSystem;

import java.util.List;

public class PriorityScheduler implements SchedulerStrategy {
    @Override
    public void assign(HallRequest request, List<Elevator> elevators) {
        Elevator bestElevator = null;
        double bestScore = Double.MAX_VALUE;
        int reqFloor = request.getFloor();
        Direction reqDirection = request.getDirection();

        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - reqFloor);
            Direction elevatorDirection = elevator.getCurrentFloor() < elevator.getDestinationFloor()
                    ? Direction.UP : Direction.DOWN;

            // Prefer idle elevators or ones already heading in the right direction
            boolean isCompatible = elevatorDirection == reqDirection || elevator.getRequests().isEmpty();

            // Score: lower is better
            double score = (isCompatible ? 1 : 2) * distance + elevator.getRequests().size();

            if (score < bestScore) {
                bestScore = score;
                bestElevator = elevator;
            }
        }

        if (bestElevator != null) {
            System.out.println("Priority-scheduling request at floor " + reqFloor + " to Elevator " + bestElevator.getId());
            bestElevator.addRequest(request);
        }
    }
}