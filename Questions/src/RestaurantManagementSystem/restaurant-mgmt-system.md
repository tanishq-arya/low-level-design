```text
+--------------------------------------------------------------------------------------+
|                               RestaurantSystem                                       | <<Facade>>  
+--------------------------------------------------------------------------------------+
| + viewMenu(): List<MenuItem>                                                         |
| + makeReservation(customer, dateTime, partySize): Reservation                        |
| + placeOrder(customer, items, strategy): Order                                       |
| + processPayment(orderId, method): Payment                                           |
| + generateReport(type): Report                                                       |
+-------------------------------------------+------------------------------------------+
                                            |
                                            v
+----------------------+          +--------------------------+       +--------------------------+
|   ReservationManager |          |      OrderManager        |       |   InventoryManager       |
+----------------------+          +--------------------------+       +--------------------------+
| - reservations: Map  |          | - orders: Map            |       | - stock: Map             |
+----------------------+          +--------------------------+       +--------------------------+
| + create(r):Resv     |          | + create(o):Order        |       | + checkAvail(item):bool  |
| + cancel(id): void   |          | + updateStatus(id,s):void|       | + deduct(ing,qty):void   |
| + listByCustomer(id) |          | + listByCustomer(id):List|       | + replenish(ing,qty):void|
+----------------------+          +--------------------------+       +--------------------------+
    |                                  |                                   |
    | manages                          | manages                           | manages
    v                                  v                                   v
+------------+      1            *   +--------+       *            *      +-------------+
| Reservation|<--------------------> | Order  |<------------------------->|  Ingredient |
+------------+                       +--------+                           +-------------+
| - id       |                       | - id   |                           | - id        |
| - customer |                       | - customer                         | - name      |
| - table    |                       | - items: List<MenuItem>            | - quantity  |
| - dateTime |                       | - status|                          | - unit      |
+------------+                       | - totalAmount                      +-------------+
| + confirm()|                      +---------+       *            1
| + cancel() |                                                +-------------+
+------------+                                                 |  MenuItem   |
                                                              +-------------+
                                                              | - id        |
                                                              | - name      |
                                                              | - price     |
                                                              | - category  |
                                                              | - ingredients: List<Ingredient> |
                                                              +-------------+

    ^                                      ^
    | uses                                 | uses
    |                                      |
    v                                      v
+----------------------+          +------------------------+
|  OrderingStrategy    |          |      ReportGenerator   |
+----------------------+          +------------------------+
| <<interface>>        |          | <<interface>>          |
| + placeOrder(c,i):Order |       | + generate():Report    |
+----------------------+          +------------------------+
    ^             ^                         ^             ^
    |             |                         |             |
+-----------+ +-------------+         +-------------+ +-------------+
| DineInOrder| | AppOrder   |         | SalesReport | | InventoryReport |
+-----------+ +-------------+         +-------------+ +-------------+
| + placeOrder()| | + placeOrder()|   | + generate()| | + generate()|
+-----------+ +-------------+         +-------------+ +-------------+

+-------------------+
|      Customer     |
+-------------------+
| - id              |
| - name            |
| - contactInfo     |
+-------------------+

+-------------------+
|       Staff       |
+-------------------+
| - id              |
| - name            |
| - role            |
| - schedule        |
+-------------------+

+-------------------+
|      Payment      |
+-------------------+
| - id              |
| - order: Order    |
| - amount          |
| - method          |
| - status          |
+-------------------+

Enums:
- ReservationStatus { PENDING, CONFIRMED, CANCELLED }
- OrderStatus       { PLACED, PREPARING, SERVED, COMPLETED, CANCELLED }
- PaymentStatus     { PENDING, PAID, FAILED }

```