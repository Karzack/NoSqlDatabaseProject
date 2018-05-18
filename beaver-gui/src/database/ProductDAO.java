package database;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import database.model.product.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class ProductDAO {

    public static List<Product> getProducts() {
        MongoDatabase db = DBInstance.connectDB();
        MongoCollection<Product> collection = db.getCollection("products", Product.class);

        FindIterable<Product> result = collection.find();
        List<Product> products = getProductList(result);

        return products;
    }

    private static List<Product> getProductList(FindIterable<Product> res) {
        ObservableList<Product> list = FXCollections.observableArrayList();
        for (Product product : res) {
            list.add(product);
        }

        return list;
    }
}
