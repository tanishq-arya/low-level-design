// The PausedState class represents the playing state of the Media Player.

package StatePattern.Exercise;

public class PausedState implements State {

    @Override
    public void pressPlay() {
        System.out.println("Resuming playback");
    }

    @Override
    public void pressStop() {
        System.out.println("Stopping playback from pause");
    }

    @Override
    public void pressPause() {
        System.out.println("Pausing playback");
    }

    @Override
    public void display() {
        System.out.println("Current State: Paused");
    }
}