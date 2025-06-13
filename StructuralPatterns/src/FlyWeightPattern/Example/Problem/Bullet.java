package FlyWeightPattern.Example.Problem;

public class Bullet {
    private final String color; // Intrinsic property shared by all objects

    private final int x;
    private final int y; // Extrinsic properties > unique for each object
    private final int velocity;

    public Bullet(String color, int x, int y, int velocity) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        System.out.println("Creating bullet at (" + x + "," + y + ") with velocity " + velocity);
    }

    public void display() {
        System.out.println("Bullet at (" + x + "," + y + ") moving at velocity " + velocity);
    }
}