package database.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import database.DBInstance;
import database.model.Location;
import database.model.Stock;
import database.model.product.Ingredient;

import java.util.List;

import static com.mongodb.client.model.Updates.combine;

public class StockDAO {
    private static final String STOCKS_COLLECTION = "stocks";

    public static void addStocks(List<Stock> stockList) {
        MongoCollection<Stock> collection = DBInstance.connectDB().getCollection(STOCKS_COLLECTION, Stock.class);
        collection.insertMany(stockList);
    }

    public static void getStockItem(Ingredient ingredient, Location location) {
        MongoCollection<Stock> collection = DBInstance.connectDB().getCollection(STOCKS_COLLECTION, Stock.class);

        Stock item = collection.find(Filters.and(Filters.eq("locationId", location.getId()), Filters.eq("ingredient.name", ingredient.getName()))).first();


    }

    public static void updateStockQuantity(List<List<Stock>> stockItems) {
        MongoCollection<Stock> collection = DBInstance.connectDB().getCollection(STOCKS_COLLECTION, Stock.class);

        for (List<Stock> items : stockItems) {
            for (Stock item : items) {
                collection.updateOne(
                        Filters.and(Filters.eq("locationId", item.getLocationId()), Filters.eq("ingredient.name", item.getIngredient().getName())),
                        Updates.inc("quantity", -item.getQuantity())
                );
            }
        }
    }

}
