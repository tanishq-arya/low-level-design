```txt
                                    +----------------------------+
                                    | <<abstract>> User          |
                                    |----------------------------|
                                    | - name: String             |
                                    | - email: String            |
                                    | - location: Location       |
                                    |----------------------------|
                                    | + getLocation(): Location  |
                                    | + setLocation(l: Location) |
                                    | + notify(msg: String)      |
                                    +----------------------------+
                                     *--|       ^
                                        |       |
                                        |       |
                                        |   inherits
                                        |       |
                   +--------------------+       +-------------------+
                   |                                                |
    +------------------------+                     +----------------------+
    | Driver                 |                     | Passenger            |
    |------------------------|                     |----------------------|
    | - vehicle: Vehicle     |                     |                      |
    |------------------------|                     | + notify(msg): void  |
    | + getVehicle(): Vehicle|                     |                      |
    | + notify(msg): void    |                     +----------------------+
    +------------------------+
            *--|
               | has
               |
               V
    +----------------------------+
    | <<abstract>> Vehicle       |
    |----------------------------|
    | - numberPlate: String      |
    |----------------------------|
    | + getFarePerKm(): double   |
    +----------------------------+
             ^          ^
             |          |
    extends  |          |  extends
             |          |
    +--------+          +---------+
    |                            |
    |                            |
+-----------+             +-----------+
| Bike      |             | Car       |
|-----------|             |-----------|
| + getFare |             | + getFare |
|   PerKm() |             |   PerKm() |
+-----------+             +-----------+


+----------------------------+
| Location                   |
|----------------------------|
| - lat: double              |
| - lng: double              |
|----------------------------|
| + calcDistance(o: Location): double |
+----------------------------+
^       ^       ^
|       |       |
|       |       |
|       |  uses |
|  uses |       |
+       +       +
User  Driver Passenger


+-----------------------------------------------+
| Ride                                          |
|-----------------------------------------------|
| - passenger: Passenger                        |
| - driver: Driver                              |
| - distance: double                            |
| - fareStrategy: FareStrategy                  |
| - fare: double                                |
| - status: RideStatus                          |
|-----------------------------------------------|
| + calculateFare(): void                       |
| + getFare(): double                           |
| + updateStatus(s: RideStatus): void           |
+-----------------------------------------------+
o--|                 o--|          *--|      -->|
| has               | has        | has        | depends on
|                   |            |            |
V                   V            V            V
+-----------+        +-----------+ +------------+ +----------------+
| Passenger |        | Driver    | | FareStrategy | | Location      |
+-----------+        +-----------+ +------------+ +----------------+
^        ^
| implements
|
+-----------------+-----------+------------+----------------+
| StandardFare    | SharedFare  | LuxuryFare  |
| Strategy        | Strategy    | Strategy    |
+-----------------+-------------+-------------+

+-------------------------------------------------+
| RideMatchingSystem                              |
|-------------------------------------------------|
| - availableDrivers: List<Driver>                |
|-------------------------------------------------|
| + addDriver(d: Driver): void                    |
| + requestRide(p: Passenger, dist: double, strat: FareStrategy): void |
| - findNearestDriver(loc: Location): Driver      |
+-------------------------------------------------+
o--| has many
|
V
Driver

RideMatchingSystem ..> Ride         : creates
RideMatchingSystem ..> FareStrategy : uses/injects
RideMatchingSystem ..> Location     : uses in findNearestDriver
RideMatchingSystem --> Passenger    : notifies
RideMatchingSystem --> Driver       : notifies

<<enumeration>> RideStatus
- SCHEDULED
- ONGOING
- COMPLETED

```