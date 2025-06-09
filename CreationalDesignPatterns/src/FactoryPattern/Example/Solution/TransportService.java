package FactoryPattern.Example.Solution;

public class TransportService {
    public static void main(String[] args) {
        // Delegate creation to factory class

        // Client -> calls factory
        Transport vehicle = TransportFactory.createTransport("car");
        vehicle.deliver();

        // Runtime -> vehicle can be changed
        vehicle = TransportFactory.createTransport("bus");
        vehicle.deliver();
    }
}