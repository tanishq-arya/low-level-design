package FactoryPattern.Example.Problem;

public class TransportService {
    public static void main(String[] args) {
        // Directly create objects

        // Client -> Tightly coupled with other classes
        Transport car = new Car();
        Transport bike = new Bike();
        Transport bus = new Bus();

        // Should be loosely coupled
    }
}