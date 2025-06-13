// This class represents the DVD player component of the home theater system.

package FacadePattern.Exercise;

public class DVDPlayer {
    
    public void play() {
        System.out.println("DVD Player: Playing the movie");
    }

    public void pause() {
        System.out.println("DVD Player: Paused the movie");
    }

    public void stop() {
        System.out.println("DVD Player: Stopped the movie");
    }
}