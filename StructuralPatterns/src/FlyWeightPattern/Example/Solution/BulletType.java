package FlyWeightPattern.Example.Solution;

// Flyweight Class : Class for common properties
public class BulletType {
    private final String color; // Intrinsic property

    public BulletType(String color) {
        this.color = color;
        System.out.println("Creating bulletType with color: " + this.color);
    }
}