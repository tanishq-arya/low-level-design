```text
    +---------------------------------+
    | ElevatorController (Singleton)  |
    +---------------------------------+
    | - elevators: List<Elevator>     |
    | - scheduler: Scheduler          |
    +---------------------------------+
    | + requestHall(floor, dir)       |
    | + requestCab(id, floor) |
    +---------------------------------+
                    |
                    v
    +---------------------------------+
    |         Scheduler (interface)   |
    +---------------------------------+
    | + assign(request, elevators)    |
    +---------------------------------+
             /                \
            /                  \
    +--------------+     +-----------------+
    | SCANStrategy |     | NearestStrategy |
    +--------------+     +-----------------+
    | + assign(...)|     | + assign(...)   |
    +--------------+     +-----------------+
    
                   Horizontally interacts
                      with each
    
    +---------------------------------+
    |           Elevator              |
    +---------------------------------+
    | - id: int                       |
    | - currentFloor: int             |
    | - state: ElevatorState          |
    | - capacity: int                 |
    | - requests: Queue<Request>      |
    +---------------------------------+
    | + handleRequest(Request)        |
    | + run() [thread loop]           |
    +---------------------------------+
              /        |       \
             /         |        \
    +----------+  +------------+ +--------------+
    | IdleState|  | MovingState| | DoorOpenState|
    +----------+  +------------+ +--------------+
    | + move() |  | + move()   | | + openDoor() |
    +----------+  +------------+ +--------------+
    
    +-------------------+
    |   <<abstract>>    |
    |     Request       |
    +-------------------+
    | - floor: int      |
    +-------------------+
              /  \
             /    \
            v      v
    +-------------+  +---------------+
    | HallRequest |  | CabRequest    |
    +-------------+  +---------------+
    | - direction |  | - id  |
    +-------------+  +---------------+
    
    enum Direction { UP, DOWN }

```