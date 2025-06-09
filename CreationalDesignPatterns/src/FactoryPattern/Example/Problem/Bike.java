package FactoryPattern.Example.Problem;

public class Bike implements Transport{
    @Override
    public void deliver() {
        System.out.println("Deliver by bike");
    }
}