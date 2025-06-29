package ElevatorSystem;

import ElevatorSystem.States.DoorOpenState;
import ElevatorSystem.States.ElevatorState;
import ElevatorSystem.States.IdleState;
import ElevatorSystem.States.MovingState;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator implements Runnable{
    private final int id;
    private final int capacity;

    // resources
    private int currentFloor;
    private int destinationFloor;
    private ElevatorState currentState;
    private final Queue<Request> requests;

    // States
    private final IdleState idleState;
    private final MovingState movingState;
    private final DoorOpenState doorOpenState;

    public Elevator(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.currentFloor = 0; // Default starting at ground floor
        this.destinationFloor = 0;
        this.requests = new LinkedList<>();

        idleState = new IdleState();
        movingState = new MovingState();
        doorOpenState = new DoorOpenState();
        this.currentState = idleState; // initial state
    }

    // Functional methods
    public synchronized void addRequest(Request request) {
        int reqFloor =  request.getFloor();
        // If already at that floor, handle immediately
        if (reqFloor == currentFloor) {
            System.out.println("Elevator " + id + " already at floor " + reqFloor + ", opening doors");
            // bump state to DoorOpen so it'll open on next tick
            this.setState(getDoorOpenState());
            return;
        }
        // Otherwise enqueue if not duplicate
        if (requests.stream().noneMatch(r -> r.getFloor() == reqFloor)) {
            requests.offer(request);
        }
    }

    public synchronized boolean hasRequests() {return !requests.isEmpty();}

    public synchronized Request peekRequest() {return requests.peek();}

    public synchronized void pollRequest() {requests.poll();}

    public void moveUp() {
        currentFloor++;
        System.out.println("Elevator " + id + " moving up to " + currentFloor);
    }

    public void moveDown() {
        currentFloor--;
        System.out.println("Elevator " + id + " moving down to " + currentFloor);
    }


    @Override
    public void run() {
        while (true) {
            currentState.handle(this);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Elevator " + id + " shutting down.");
                return;
            }
        }
    }

    // Setters and getters
    public int getId() {return id;}
    public int getCapacity() {return capacity;}
    public Queue<Request> getRequests() {return requests;}
    public int getCurrentFloor() {return currentFloor;}
    public int getDestinationFloor() {return destinationFloor;}
    public IdleState getIdleState() {return idleState;}
    public MovingState getMovingState() {return movingState;}
    public DoorOpenState getDoorOpenState() {return doorOpenState;}

    public void setCurrentFloor(int currentFloor) {this.currentFloor = currentFloor;}
    public void setDestinationFloor(int destinationFloor) {this.destinationFloor = destinationFloor;}
    public void setState(ElevatorState currentState) {this.currentState = currentState;}
}