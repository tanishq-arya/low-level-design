```text
+------------------------------------------------------------------------------------------------------------------+
|                                                 HotelService                                                     | <<Facade>>
+------------------------------------------------------------------------------------------------------------------+
| + bookRoom(guest, type, checkIn, checkOut): Reservation                                                          |
| + checkIn(reservationId): void                                                                                   |
| + checkOut(reservationId): void                                                                                  |
| + pay(reservationId, method): void                                                                               |
| + reportOccupancy(): Map<RoomType, Double>                                                                       |
+---------------------------------------------------------------+--------------------------------------------------+
                                                                |
                                                                v
+------------------------------------------------+  +------------------------------------------------+  +------------------------------------------------+
|             ReservationManager                 |  |               RoomManager                      |  |             BillingService                     |
+------------------------------------------------+  +------------------------------------------------+  +------------------------------------------------+
| + create(guest, type, start, end):Reservation  |  | + findAvailable(type, start, end): List<Room>  |  | + generateBill(reservation): double            |
| + checkIn(reservationId): void                 |  | + assignRoom(reservation): Room                |  | + collectPayment(reservation, method): Payment |
| + checkOut(reservationId): void                |  | + releaseRoom(room): void                      |  +------------------------------------------------+
+------------------------------------------------+  +------------------------------------------------+                |
       |                                                 |                                                            v
       v                                                 v                            +------------------------------------------------+
+-----------------------+                       +-----------------------+             |             ReportingService                   |
|     Reservation       |                       |         Room          |             +------------------------------------------------+
+-----------------------+                       +-----------------------+             | + occupancyByType(): Map<RoomType, Double>     |
| - id: String          |                       | - number: String      |             +------------------------------------------------+
| - guest: Guest        |                       | - type: RoomType      |
| - room: Room          |                       | - ratePerNight: double|
| - checkInDate: Date   |                       | - status: RoomStatus  |
| - checkOutDate: Date  |                       +-----------------------+
| - status: ReservationStatus |
+-----------------------+                                                                                  
       ^                                                                                                     
       |                                                                                                     
       | aggregates                                                                                         
+-----------------------+               +------------------------+               +-----------------------+
|        Guest          |               |       Payment          |               |    PaymentMethod     |
+-----------------------+               +------------------------+               +-----------------------+
| - id: String          |               | - id: String           |               | <<interface>>        |
| - name: String        |               | - reservation: Reservation |          | + pay(amount): PaymentStatus |
| - contactInfo: String |               | - amount: double       |               +-----------------------+
| - idProof: String     |               | - date: Date           |
+-----------------------+               | - method: PaymentMethod|
                                        | - status: PaymentStatus|
                                        +------------------------+

Enums:
- RoomType            { SINGLE, DOUBLE, DELUXE, SUITE }
- RoomStatus          { AVAILABLE, OCCUPIED, MAINTENANCE }
- ReservationStatus   { BOOKED, CHECKED_IN, CHECKED_OUT, CANCELLED }
- PaymentStatus       { PENDING, PAID, FAILED }

```