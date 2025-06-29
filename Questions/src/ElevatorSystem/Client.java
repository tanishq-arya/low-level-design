package ElevatorSystem;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        // Create elevators
        Elevator e1 = new Elevator(1, 8);
        Elevator e2 = new Elevator(2, 8);

        // Controller with nearest scheduling
//        ElevatorController controller = new ElevatorController(List.of(e1, e2), new NearestScheduler());
        ElevatorController controller = new ElevatorController(List.of(e1, e2), new PriorityScheduler());

        // Start elevator threads
        new Thread(e1).start();
        new Thread(e2).start();

        // Simulate requests
        controller.requestHall(3, Direction.UP);
        controller.requestHall(7, Direction.DOWN);
        controller.requestCab(1, 5); // inside elevator 1
        controller.requestCab(2, 0); // inside elevator 2


        // Let system run for a bit
        try { Thread.sleep(10000); } catch (InterruptedException ignored) {}

        // Shutdown elevator threads
        System.exit(0);
    }
}