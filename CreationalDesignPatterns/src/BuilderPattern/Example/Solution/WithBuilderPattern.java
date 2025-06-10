package BuilderPattern.Example.Solution;


public class WithBuilderPattern {
    public static void main(String[] args) {
        // Solution -> Builder class for house

        // 1. Chain methods in any order
        // 2. Optional parameters
        House house = new House.HouseBuilder("Concrete", "Wood", "Tile")
                .setHasGarden(true) // returns houseBuilder
                .setHasSwimmingPool(true) // returns houseBuilder
                .setHasGarage(false) // returns houseBuilder
                .build(); // returns House

        // 3. if we don't pass any optional parameter -> by default value in java will be taken
        System.out.println(house);
    }
}