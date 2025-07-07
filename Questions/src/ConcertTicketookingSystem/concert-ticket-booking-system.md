```text
+------------------------------------------------------------+
|                       TicketService                        |  <<Facade>>
+------------------------------------------------------------+
| + listConcerts(): List<Concert>                            |
| + searchConcerts(artist, date): List<Concert>              |
| + holdSeats(user, concertId, seatIds): Hold               |
| + confirmBooking(holdId, paymentMethod): Booking           |
| + joinWaitlist(user, concertId): WaitlistEntry             |
+----------------------------+-------------------------------+
                             |
      +----------------------+----------------+
      |                                       |
      v                                       v
+----------------------+             +---------------------+
|    ConcertManager    |             |    BookingManager   |
+----------------------+             +---------------------+
| + getAll():List<C>   |             | + holdSeats(...)    |
| + search(...)        |             | + confirmBooking(...)|
+----------------------+             | + releaseHold(...)  |
                                     +---------------------+

   Concert 1----* Seat
     |                |
     v                v
 +--------+       +-------+
 |Concert |       | Seat  |
 +--------+       +-------+
 | id     |       | id    |
 | artist |       | cat   |
 | date   |       | status|
 +--------+       +-------+

User 1---* Booking ---* Seat
  |           |
  v           v
Booking     WaitlistEntry

```