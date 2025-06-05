package StatePattern.Solution;

public class Cycling implements TransportationMode{
    @Override
    public int getETA() {
        System.out.println("Calculating cycling ETA");
        return 10;
    }

    @Override
    public String getDirections() {
        return "Directions for cycling";
    }
}