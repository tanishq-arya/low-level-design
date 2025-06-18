package ThreadSafety;

public class BathroomLockSimulation {
    private static final Object lock = new Object();    // door lock

    public static void main(String[] args) {
        Runnable useBathroomWithoutLock = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " has entered the bathroom.");
            try {
                Thread.sleep(1000);  // Simulate time spent inside
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(name + " is exiting the bathroom.");
        };

        Runnable useBathroomWithLock = () -> {
            String name = Thread.currentThread().getName();
            synchronized (lock) {
                System.out.println(name + " has entered the bathroom.");
                try {
                    Thread.sleep(1000);  // Simulate time spent inside
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(name + " is exiting the bathroom.");
            }
        };

        // Without lock -> all three enter -> should not be the case
/*
        Thread thread1 = new Thread(useBathroomWithoutLock, "Alice");
        Thread thread2 = new Thread(useBathroomWithoutLock, "Bob");
        Thread thread3 = new Thread(useBathroomWithoutLock, "Charlie");
*/

        // Without lock -> all three enter -> should not be the case
        Thread thread1 = new Thread(useBathroomWithLock, "Alice");
        Thread thread2 = new Thread(useBathroomWithLock, "Bob");
        Thread thread3 = new Thread(useBathroomWithLock, "Charlie");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}