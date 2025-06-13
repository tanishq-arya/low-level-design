package FlyWeightPattern.Example.Solution;

public class GameClient {
    public static void main(String[] args) {
        // 5 Red objects for example
        for(int i=0; i<5; i++) {
            Bullet bullet = new Bullet("Red", i*10, i*12, 5);
        }

        // 5 Green bullet objects
        for(int i=0; i<5; i++) {
            Bullet bullet = new Bullet("Green", i*10, i*12, 5);
        }
    }
}