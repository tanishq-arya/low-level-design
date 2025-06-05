package StatePattern.Solution;

public class Walking implements TransportationMode{
    @Override
    public int getETA() {
        System.out.println("Calculating walking ETA (Walking)");
        return 7;
    }

    @Override
    public String getDirections() {
        return "Directions for walking";
    }
}