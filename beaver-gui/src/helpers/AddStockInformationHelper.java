package helpers;

import com.mongodb.client.MongoCollection;
import database.DBInstance;
import database.dao.LocationDAO;
import database.model.Location;
import database.model.Stock;
import database.model.Unit;
import database.model.product.Ingredient;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.List;

public class AddStockInformationHelper {
    private static final String STOCKS_COLLECTION = "stocks";

    public static void addInitialStockInformation() {
        List<Location> locations = LocationDAO.getAllLocations();
        MongoCollection<Stock> collection = DBInstance.connectDB().getCollection(STOCKS_COLLECTION, Stock.class);

        collection.drop();

        for (Location location : locations) {
            ObjectId id = location.getId();
            List<Stock> stockList = Arrays.asList(
                    new Stock(
                            id,
                            new Ingredient("Espresso Roast", Unit.GRAM),
                            10000
                    ),
                    new Stock(
                            id,
                            new Ingredient("Whole Bean French Roast", Unit.GRAM),
                            10000
                    ),
                    new Stock(
                            id,
                            new Ingredient("Whole Bean Light Roast", Unit.GRAM),
                            10000
                    ),
                    new Stock(
                            id,
                            new Ingredient("Skim Milk", Unit.LITRE),
                            100
                    ),
                    new Stock(
                            id,
                            new Ingredient("Soy Milk", Unit.LITRE),
                            100
                    ),
                    new Stock(
                            id,
                            new Ingredient("Whole Milk", Unit.LITRE),
                            100
                    ),
                    new Stock(
                            id,
                            new Ingredient("2% Milk", Unit.LITRE),
                            100
                    ),
                    new Stock(
                            id,
                            new Ingredient("Cocoa Mix", Unit.GRAM),
                            1000
                    ),
                    new Stock(
                            id,
                            new Ingredient("Whipped Cream", Unit.LITRE),
                            100
                    ),
                    new Stock(
                            id,
                            new Ingredient("Vanilla", Unit.LITRE),
                            10
                    ),
                    new Stock(
                            id,
                            new Ingredient("Caramel", Unit.LITRE),
                            10
                    ),
                    new Stock(
                            id,
                            new Ingredient("Irish Cream", Unit.LITRE),
                            10
                    )
            );

            collection.insertMany(stockList);
        }
    }
}
