package FlyWeightPattern.Example.Solution;

import java.util.HashMap;

// Manage creation of common properties
public class BulletTypeFactory {
    private static final HashMap<String, BulletType> bulletTypes = new HashMap<>();

    public static BulletType getBulletType(String color) {
        if(!bulletTypes.containsKey(color)) { // Create first time
            bulletTypes.put(color, new BulletType(color));
        }
        return bulletTypes.get(color); // Return from cache
    }
}