package FactoryPattern.Example.Solution;

public class Car implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver by car");
    }
}