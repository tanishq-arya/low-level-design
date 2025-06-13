package ProxyPattern.Example.Problem;

public class RealImage implements Image{
    private final String filename;

    RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk(); // Expensive Operation
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image from disk: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying: " + filename);
    }
}