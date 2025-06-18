package ThreadSafety;

public class DeadlockSimulation {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    Thread thread1 = new Thread(() -> {
        synchronized (lock1) {
            System.out.println("Thread 1: Holding lock1...");

            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

            System.out.println("Thread 1: Waiting for lock2...");
            synchronized (lock2) {
                System.out.println("Thread 1: Acquired lock2!");
                System.out.println("Thread 1: Holding lock1 and lock2...");
            }
        }
    });

    Thread thread2 = new Thread(() -> {
        synchronized (lock2) {
            System.out.println("Thread 2: Holding lock2...");

            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

            System.out.println("Thread 2: Waiting for lock1...");
            synchronized (lock1) {
                System.out.println("Thread 2: Acquired lock1!");
                System.out.println("Thread 2: Holding lock2 and lock1...");
            }
        }
    });

    public static void main(String[] args) {
        DeadlockSimulation simulation = new DeadlockSimulation();

        System.out.println("Deadlock Simulation");
        simulation.thread1.start();
        simulation.thread2.start();

        // This program runs forever -> Deadlock
        // Both the threads want to acquire a lock which is held by the other
    }
}