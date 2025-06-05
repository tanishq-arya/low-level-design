package StatePattern.Solution;

public class WithStatePattern {
    public static void main(String[] args) {
        DirectionService directionService = new DirectionService(new Car());

        System.out.println("ETA: " + directionService.getETA());
        System.out.println("Directions: " + directionService.getDirections());
    }
}