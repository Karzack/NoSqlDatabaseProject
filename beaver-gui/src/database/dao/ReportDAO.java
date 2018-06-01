package database.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import database.DBInstance;
import database.model.Order;
import database.model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ReportDAO {

    public static List<Order> getReport(){
        MongoCollection<Order> collection = DBInstance.connectDB().getCollection("orders",Order.class);

        return getOrderList(collection.find());
    }
    public static List<Order> getReport(Product product, String locationName){
        MongoCollection<Order> collection = DBInstance.connectDB().getCollection("orders",Order.class);

        FindIterable<Order> result = collection.find();
        List<Order> orders = new ArrayList<Order>();
        for (Order order : result) {
            boolean hasfoundReport = false;
            for(Product productLoop : order.getOrderItems()){
                if(productLoop.getName().getSwedish().equals(product.getName().getSwedish()) && !hasfoundReport) {
                    orders.add(order);
                    hasfoundReport=true;
                }
            }
        }

        return orders;
    }

    public static List<Order> getOrderList(FindIterable<Order> orderRes){
        List<Order> orders = new ArrayList<Order>();
        for (Order order : orderRes) {

            orders.add(order);
        }
        return orders;
    }
}
