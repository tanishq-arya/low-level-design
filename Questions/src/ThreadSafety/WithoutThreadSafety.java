package ThreadSafety;

public class WithoutThreadSafety {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() ->{
            for(int i=0; i<5000; i++) {
                counter++;
            }
        });

        Thread thread2 = new Thread(() ->{
            for(int i=0; i<5000; i++) {
                counter++;
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Counter: " + counter); // < 10000
        // Problems -> both threads access the same variable at the same time
        // 1. Data inconsistency
        // 2. Race conditions -> overwrite each other's work
        // 3. Data corruption
    }
}