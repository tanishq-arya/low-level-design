// The Exercise class facilitates user interaction to create a customized coffee by allowing the selection of various ingredients and then outputs the final coffee description and total cost.

package DecoratorPattern.Exercise;

import java.util.Scanner;

public class CoffeeMachineClient {

    // Do not modify the run method. It is designed to demonstrate the usage of the Decorator pattern for customizing coffee with various ingredients.
    public void run(){
        
        Scanner sc = new Scanner(System.in);

        Coffee coffee = new BasicCoffee();

        boolean addMoreIngredients = true;

        do {

            String choices = sc.nextLine();
            String[] ingredients = choices.split(" ");

            for (String choice : ingredients) {

                switch (choice) {
                    case "1":
                        // TODO: Complete the implementation for adding Milk to the coffee.
                        coffee = new Milk(coffee);

                        break;
                    case "2":
                        // TODO: Complete the implementation for adding Sugar to the coffee.
                        coffee = new Sugar(coffee);

                        break;
                    case "3":
                        // TODO: Complete the implementation for adding Whipped Cream to the coffee.
                        coffee = new WhippedCream(coffee);

                        break;
                    case "4":
                        addMoreIngredients = false;
                        break;
                    default:
                        System.out.println("Invalid choice: " + choice);
                        break;
                }
            }

        } while (addMoreIngredients);

        System.out.println("Final Coffee Description: " + coffee.getDescription());
        System.out.println("Total Cost: $" + coffee.getCost());
        
        sc.close();
    }
}