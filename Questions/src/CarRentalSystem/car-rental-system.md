```text
+------------------------+        +--------------------+       +------------------+
|     CarRentalService   |<>------|  ReservationManager|       |  PaymentProcessor|
+------------------------+        +--------------------+       +------------------+
| + searchCars(...)      |        | + createResv(...)  |       | + process(...)   |
| + createReservation()  |        | + modifyResv(...)  |       +------------------+
| + modifyReservation()  |        | + cancelResv(...)  |
| + cancelReservation()  |        +--------------------+
+------------------------+                 ^
           ^                               |
           |                               |
           | uses                          |
           v                               |
+----------------+       +---------------+ |       +---------------+
|  BranchManager |       |  Car          | |       |  Reservation  |
+----------------+       +---------------+ |       +---------------+
| + addBranch()  |       | id            | |___<> | id            |
| + addCar()     |<>-----| make, model   |         | car: Car      |
+----------------+       | status        |         | customer      |
                         +---------------+         | startDate     |
                                                   | endDate       |
+----------------+       +---------------+         | status        |
|  Customer      |       |  Payment      |         +---------------+
+----------------+       +---------------+
| id, name,      |       | id, amount    |
+----------------+       | status        |
                         +---------------+

Enums:
CarType, CarStatus, ReservationStatus, PaymentStatus

```