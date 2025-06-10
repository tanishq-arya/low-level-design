package BuilderPattern.Example.Problem;

public class WithoutBuilderPattern {
    public static void main(String[] args) {
        House house = new House("Concrete", "Wood", "Shingles", true, true);
        System.out.println(house);

        // Give only 3 values and keep rest as default
        // Problem -> Constructor Explosion**
        // Difficult to understand and maintain this code
    }
}