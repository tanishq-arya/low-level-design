package ProxyPattern.Example.Solution;

public class ProxyImage implements Image{
    private final String filename;

    private RealImage realImage; // Proxy reference to real Image

    public ProxyImage(String filename) {
        this.filename = filename;
        System.out.println("ProxyImage object created.");
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); // Image is loaded + cached
        }
        realImage.display();
    }
}