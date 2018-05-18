package helpers;

import com.mongodb.client.MongoCollection;
import database.DBInstance;
import database.model.Unit;
import database.model.product.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddProductsHelper {

    public static void addProducts() {
        MongoCollection<Product> collection = DBInstance.connectDB().getCollection("products", Product.class);

        collection.drop(); //TODO Inte bra lösning, fixa.

        List<Product> products = Arrays.asList(
                new Product(
                        new ProductName("Hela bönor", "Whole Bean Coffee"),
                        new ProductPrice(50, 4.5),
                        Collections.<IngredientItem>emptyList(),
                        Arrays.asList(
                                new IngredientItem(new Ingredient("Espresso Roast", Unit.GRAM), 500),
                                new IngredientItem(new Ingredient("Whole Bean French Roast", Unit.GRAM), 500),
                                new IngredientItem(new Ingredient("Whole Bean Light Roast", Unit.GRAM), 500)
                        )
                ),
                new Product(
                        new ProductName("Bryggkaffe", "Brewed Coffee"),
                        new ProductPrice(15, 1),
                        Arrays.asList(
                                new IngredientItem(new Ingredient("Whole Bean French Roast", Unit.GRAM), 50)
                        ),
                        Collections.<IngredientItem>emptyList()
                ),
                new Product(
                        new ProductName("Espresso", "Espresso"),
                        new ProductPrice(15, 1),
                        Arrays.asList(
                                new IngredientItem(new Ingredient("Espresso Roast", Unit.GRAM), 50)
                        ),
                        Collections.<IngredientItem>emptyList()
                ),
                new Product(
                        new ProductName("Latte", "Latte"),
                        new ProductPrice(20, 1.5),
                        Arrays.asList(
                                new IngredientItem(new Ingredient("Espresso Roast", Unit.GRAM), 70)
                        ),
                        Arrays.asList(
                                new IngredientItem(new Ingredient("Skim Milk", Unit.LITRE), 0.5),
                                new IngredientItem(new Ingredient("Soy Milk", Unit.LITRE), 0.5),
                                new IngredientItem(new Ingredient("Whole Milk", Unit.LITRE), 0.5),
                                new IngredientItem(new Ingredient("2% Milk", Unit.LITRE), 0.5)
                        )
                ),
                new Product(
                        new ProductName("Cappuccino", "Cappuccino"),
                        new ProductPrice(25, 2),
                        Arrays.asList(
                                new IngredientItem(new Ingredient("Espresso Roast", Unit.GRAM), 70)
                        ),
                        Arrays.asList(
                                new IngredientItem(new Ingredient("Skim Milk", Unit.LITRE), 0.3),
                                new IngredientItem(new Ingredient("Soy Milk", Unit.LITRE), 0.3),
                                new IngredientItem(new Ingredient("Whole Milk", Unit.LITRE), 0.3),
                                new IngredientItem(new Ingredient("2% Milk", Unit.LITRE), 0.3)
                        )
                ),
                new Product(
                        new ProductName("Varm choklad", "Hot chocolate"),
                        new ProductPrice(20, 1.5),
                        Arrays.asList(
                                new IngredientItem(new Ingredient("Cocoa Mix", Unit.GRAM), 30),
                                new IngredientItem(new Ingredient("Whole Milk", Unit.LITRE), 0.5)
                        ),
                        Arrays.asList(
                                new IngredientItem(new Ingredient("Whipped Cream", Unit.LITRE), 0.2)
                        )
                )
        );


        collection.insertMany(products);

    }

    public static void testListProducts() {
        MongoCollection<Product> collection = DBInstance.connectDB().getCollection("products", Product.class);
        for (Product product : collection.find()) {
            System.out.println(product.getName().getEnglish() + "\nContains:");
            for (IngredientItem item : product.getMandatoryIngredients()) {
                switch (item.getIngredient().getUnit()) {
                    case GRAM:
                        System.out.println(item.getIngredient().getName() + ": " + item.getQuantity() + " grams");
                        break;
                    case LITRE:
                        System.out.println(item.getIngredient().getName() + ": " + item.getQuantity() + " litres");
                        break;
                }
            }

            System.out.println("Alternatives:");
            for (IngredientItem item : product.getAlternatives()) {
                System.out.println(item.getIngredient().getName());
            }

            System.out.println();
        }

    }




}
