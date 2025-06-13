package ProxyPattern.Example.Solution;

public class Client {
    public static void main(String[] args) {
        // Proxy image > fast and no resources [image is not loaded yet]
        Image img1 = new ProxyImage("dog.png");
        Image img2 = new ProxyImage("dog.png");

        // Displaying here -> loaded here when displaying
        img1.display(); // lazily loaded here
        img1.display(); // stored image is displayed
    }
}