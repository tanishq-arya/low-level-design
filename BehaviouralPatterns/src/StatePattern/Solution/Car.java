package StatePattern.Solution;

public class Car implements TransportationMode{
    @Override
    public int getETA() {
        System.out.println("Calculating car ETA");
        return 10;
    }

    @Override
    public String getDirections() {
        return "Directions for car";
    }
}