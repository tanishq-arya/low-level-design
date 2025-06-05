// The State interface defines the methods for different states of the Media Player. 

package StatePattern.Exercise;

public interface State {
    void pressPlay();
    void pressStop();
    void pressPause();
    void display();
}