package StatePattern.Solution;

public class Train implements TransportationMode{
    @Override
    public int getETA() {
        System.out.println("Calculating train ETA ");
        return 7;
    }

    @Override
    public String getDirections() {
        return "Directions for train";
    }
}