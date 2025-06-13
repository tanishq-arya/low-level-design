// This class represents the Projector player component of the home theater system.

package FacadePattern.Exercise;

public class Projector {
    
    public void on() {
        System.out.println("Projector: Turned on");
    }

    public void off() {
        System.out.println("Projector: Turned off");
    }

    public void setInput() {
        System.out.println("Projector: Input set to DVD");
    }
}