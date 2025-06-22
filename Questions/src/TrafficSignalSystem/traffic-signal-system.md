```text
+---------------------+
|      <<enum>>       |
|       Signal        |
+---------------------+
| +RED                |
| +YELLOW             |
| +GREEN              |
+---------------------+

           ^
           |
           |
+---------------------+
|      TrafficLight   |
+---------------------+
| - id: String        |
| - currentSignal: Signal |
| - redDuration: int  |
| - yellowDuration: int |
| - greenDuration: int |
+---------------------+
| + changeSignal(): void |
| + notifyObservers(): void |
+---------------------+

           ^
           |
           |
+---------------------+
|        Road         |
+---------------------+
| - id: String        |
| - name: String      |
| - trafficLight: TrafficLight |
+---------------------+
| + getTrafficLight(): TrafficLight |
+---------------------+

           ^
           |
           |
+----------------------------+
|   <<Singleton>> TrafficController |
+----------------------------+
| - roads: List<Road>        |
| - instance: TrafficController (static) |
+----------------------------+
| + getInstance(): TrafficController |
| + addRoad(road: Road): void |
| + startControl(): void      |
| + handleEmergency(): void   |
+----------------------------+

```