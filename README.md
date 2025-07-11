## Low Level Design

### CourseNotes
[Notes](design-patterns-course-notes.pdf)

### DesignPatterns_SummaryTable
[DesignPatterns_SummaryTable](design-patterns-summary-table.pdf)

### How to approach an LLD Problem ?

### How to draw a UML diagram for any System ?
In practice, most designs are iterative: you sketch a quick top‑level controller, then dive bottom‑up into your domain, 
then adjust the controller, and so on. Over a few cycles you converge to a stable UML like the one you’ve drawn, with clear layers:

```graphql
Controller/Facade
↓
Strategy Interface
↓
Domain Objects ↔ State Patterns
↓
Simple Value Objects & Enums
```
That layered, top‑to‑bottom (or bottom‑to‑top) flow is the hallmark of maintainable, extensible UML designs.

### Questions
- [ThreadSafety](Questions/src/ThreadSafety/)
- [StackOverflow](Questions/src/StackOverflow/)
- [VendingMachine](Questions/src/VendingMachine/)
- [ATM](Questions/src/ATM/)
- [LoggerFramework](Questions/src/LoggerFramework/)
- [TrafficSignalSystem](Questions/src/TrafficSignalSystem/)
- [CoffeeVendingMachine](Questions/src/CoffeeVendingMachine/)
- [TaskManagementSystem](Questions/src/TaskManagementSystem/)
- [LRUCache](Questions/src/LRUCache/)
- [LinkedIn](Questions/src/LinkedIn/)
- [TicTacToe](Questions/src/TicTacToe/)
- [PubSubSystem](Questions/src/PubSubSystem/)
- [ElevatorSystem](Questions/src/ElevatorSystem/)
- [CarRentalSystem](Questions/src/CarRentalSystem/)
- [HotelManagementSystem](Questions/src/HotelManagementSystem/)
- [DigitalWalletService](Questions/src/DigitalWalletService/)
- [LibraryManagementSystem](Questions/src/LibraryManagementSystem/)
- [RestaurantManagementSystem](Questions/src/RestaurantManagementSystem/)
- [ConcertTicketookingSystem](Questions/src/ConcertTicketookingSystem/)
- [ChessGame](Questions/src/ChessGame/)