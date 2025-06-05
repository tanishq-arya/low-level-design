package StatePattern.Problem;

public class WithoutStatePattern {
    public static void main(String[] args) {
        DirectionService directionService = new DirectionService();

        directionService.setMode(TransportationMode.CYCLING);
        directionService.getDirections();
        System.out.println(directionService.getETA());
    }
}