```text
+---------------------------------------------------+
|             CoffeeVendingMachine                  |
+---------------------------------------------------+
| - recipes: Map<String, CoffeeRecipe>              |
| - ingredientStore: IngredientStore                |
| - paymentProcessor: PaymentProcessor              |
| - dispenser: Dispenser                            |
+---------------------------------------------------+
| + displayMenu(): void                             |
| + selectCoffee(name): CoffeeRecipe                |
| + dispenseCoffee(recipe, payment): void           |
| + refillIngredient(ingredient, qty): void         |
| + showIngredients(): void                         |
+---------------------------------------------------+


                        uses
                         |
                         v


+----------------------------+      +------------------------------+      +---------------------------+
|      CoffeeRecipe          |      |       IngredientStore        |      |    PaymentProcessor       |
+----------------------------+      +------------------------------+      +---------------------------+
| - name: String             |      | - inventory: Map<String,Int> |      |                           |
| - price: double            |      +------------------------------+      +---------------------------+
| - recipe: Map<String,Int>  |      | + hasEnoughIngredient(req):Boolean | | + process(price, paid): double |
+----------------------------+      | + consume(req): void          |      +---------------------------+
| + getName(): String        |      | + refill(ing, qty): void      |      
| + getPrice(): double       |      | + getLevel(ing): int          |      
| + getRecipe(): Map         |      | + getAllIngredients(): Map    |      
+----------------------------+      +------------------------------+      


                        uses
                         |
                         v


+-----------------------------+      +-------------------------+
|          Dispenser          |      |        Payment          |
+-----------------------------+      +-------------------------+
|                             |      | - amount: double        |
+-----------------------------+      +-------------------------+
| + prepareDrink(recipe): void|      | + getAmount(): double   |
+-----------------------------+      +-------------------------+

```