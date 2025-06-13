package ProxyPattern.Example.Problem;

public class Client {
    public static void main(String[] args) {
        // Image is loaded as soon as an object is created
        Image img1 = new RealImage("dog.png");
        Image img2 = new RealImage("dog.png");
        // Problem > Loaded 2 times

        // Displaying here -> Ideally load here when displaying
        img1.display(); // Ideally > lazily load here
        img1.display(); // Ideally > stored image is displayed

    }
}