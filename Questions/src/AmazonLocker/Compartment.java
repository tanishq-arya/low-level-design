package AmazonLocker;

public class Compartment {
    String id;
    Size size;
    boolean occupied;

    public boolean isOccupied() {
        return occupied;
    }

    public void markOccupied() {
        occupied = true;
    }

    public void markFree() {
        occupied = false;
    }

    public Size getSize() {
        return size;
    }

    public void openLock() {
        System.out.println("Opened : " + this.id);
    }
}
