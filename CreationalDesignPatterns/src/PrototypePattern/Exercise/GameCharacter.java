// This interface defines the behavior for cloning and displaying attributes of character objects.

package PrototypePattern.Exercise;

public interface GameCharacter {
    GameCharacter clone();
    void displayAttributes();
}