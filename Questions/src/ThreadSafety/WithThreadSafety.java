package ThreadSafety;

public class WithThreadSafety {
    private static int counter = 0;

    // Synchronized method to ensure thread safety
    // Synchronized -> only one thread can access this method at one time
    public static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Counter: " + counter); // Always 2000
    }
}