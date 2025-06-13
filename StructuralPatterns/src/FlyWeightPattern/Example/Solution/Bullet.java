package FlyWeightPattern.Example.Solution;

public class Bullet {
    // Intrinsic property shared by all objects
    BulletType bulletType;

    private final int x;
    private final int y; // Extrinsic properties > unique for each object
    private final int velocity;

    public Bullet(String color, int x, int y, int velocity) {
        // This same object is shared by bullets of same color
        this.bulletType = BulletTypeFactory.getBulletType(color);
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        System.out.println("Creating bullet at (" + x + "," + y + ") with velocity " + velocity);
    }

    public void display() {
        System.out.println("Bullet at (" + x + "," + y + ") moving at velocity " + velocity);
    }
}