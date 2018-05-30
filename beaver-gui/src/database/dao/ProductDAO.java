package database.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.DBInstance;
import database.model.product.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * @author Ola Dahl
 */
public class ProductDAO {
    private static String PRODUCTS_COLLECTION = "products";

    public static List<Product> getProducts() {
        MongoDatabase db = DBInstance.connectDB();
        MongoCollection<Product> collection = db.getCollection(PRODUCTS_COLLECTION, Product.class);

        FindIterable<Product> result = collection.find();

        return getProductList(result);
    }

    private static List<Product> getProductList(FindIterable<Product> res) {
        ObservableList<Product> list = FXCollections.observableArrayList();
        for (Product product : res) {
            list.add(product);
        }

        return list;
    }
}
