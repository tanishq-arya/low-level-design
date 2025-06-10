// This file defines the Meal class, representing a meal's components and providing a method to print the summary.

package BuilderPattern.Exercise;

public class Meal {
    
    private final String mainDish;
    private final String sideDish;
    private final String drink;
    private final String dessert;
    private final String appetizer;

    private Meal(MealBuilder builder) {
        // TODO: Implement the Meal constructor to initialize Meal components from the MealBuilder.
        this.mainDish = builder.mainDish;
        this.sideDish = builder.sideDish;
        this.drink = builder.drink;
        this.dessert = builder.dessert;
        this.appetizer = builder.appetizer;
    }
    
    public static synchronized Meal getInstance(MealBuilder builder) {
        //TODO: Return a new instance of Meal using the provided MealBuilder
        return new Meal(builder);
    }

    public void printMealSummary() {
        System.out.println("Main Dish: " + mainDish);
        System.out.println("Side Dish: " + sideDish);
        System.out.println("Drink: " + drink);
        System.out.println("Dessert: " + dessert);
        System.out.println("Appetizer: " + appetizer);
    }
}