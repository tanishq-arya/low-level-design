package SnakeAndLadderGame;

import java.util.Random;

public class Die {
    private final Random random = new Random();

    // Simulate a die roll, return value between 1 to 6
    public int roll() {
        return random.nextInt(6) + 1;
    }
}
