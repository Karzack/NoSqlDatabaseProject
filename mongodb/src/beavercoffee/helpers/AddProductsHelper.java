package beavercoffee.helpers;

import beavercoffee.DBInstance;
import beavercoffee.models.Unit;
import beavercoffee.models.product.*;
import com.mongodb.client.MongoCollection;

import java.util.Arrays;
import java.util.List;

public class AddProductsHelper {

    public static void addProducts() {
        MongoCollection<Product> collection = DBInstance.getInstance().getCollection("products", Product.class);

        collection.drop(); //TODO Inte bra lösning, fixa.

        List<Product> products = Arrays.asList(
                new Product(
                        new ProductName("Bönkaffe Espresso Rostning", "Espresso Roast"),
                        new ProductPrice(15.0, 1.1),
                        Arrays.asList(
                                new IngridientItem(new Ingridient("Espresso Roast", Unit.GRAM), 500)
                        )),
                new Product(
                        new ProductName("Bönkaffe Fransk Rostning", "Whole Bean French Roast"),
                        new ProductPrice(80, 8),
                        Arrays.asList(
                                new IngridientItem(new Ingridient("Whole Bean French Roast", Unit.GRAM), 500)
                        )),
                new Product(
                        new ProductName("Bönkaffe Ljus Rostning", "Whole Bean Light Roast"),
                        new ProductPrice(80, 8),
                        Arrays.asList(
                                new IngridientItem(new Ingridient("Whole Bean Light Roast", Unit.GRAM), 500)
                        )),
                new Product(
                        new ProductName("Espresso", "Espresso"),
                        new ProductPrice(20, 1.2),
                        Arrays.asList(
                                new IngridientItem(new Ingridient("Espresso Roast", Unit.GRAM), 20)
                        )),
                new Product(
                        new ProductName("Kaffe med mjölk", "Coffee with milk"),
                        new ProductPrice(15, 1),
                        Arrays.asList(
                                new IngridientItem(new Ingridient("Whole Bean Light Roast", Unit.GRAM), 20),
                                new IngridientItem(new Ingridient("Milk", Unit.LITRE), 0.2)
                        ))
        );

        collection.insertMany(products);
    }

    public void testListProducts() {
        MongoCollection<Product> collection = DBInstance.getInstance().getCollection("products", Product.class);
        for (Product product : collection.find()) {
            System.out.println(product.getName().getEnglish() + "\nContains:");
            for (IngridientItem item : product.getIngridients()) {
                switch (item.getIngridient().getUnit()) {
                    case GRAM:
                        System.out.println(item.getIngridient().getName() + ": " + item.getQuantity() + " grams");
                        break;
                    case LITRE:
                        System.out.println(item.getIngridient().getName() + ": " + item.getQuantity() + " litres");
                        break;
                }
            }

            System.out.println();
        }
    }




}
