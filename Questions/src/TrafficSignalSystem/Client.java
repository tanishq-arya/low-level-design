package TrafficSignalSystem;

public class Client {
    public static void main(String[] args) {
        TrafficController controller = TrafficController.getInstance();

        TrafficLight light1 = new TrafficLight("TL1", 10, 3, 7);
        TrafficLight light2 = new TrafficLight("TL2", 10, 3, 7);

        Road road1 = new Road("R1", "Main Street", light1);
        Road road2 = new Road("R2", "2nd Avenue", light2);

        controller.addRoad(road1);
        controller.addRoad(road2);

        new Thread(controller::start).start();
        new Thread(() -> {
            try {
                Thread.sleep(10000);
                controller.handleEmergency();
                Thread.sleep(15000);
                controller.clearEmergency();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}