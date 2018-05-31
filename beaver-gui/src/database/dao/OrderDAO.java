package database.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import java.util.List;
import database.DBInstance;
import database.model.Order;


import java.util.ArrayList;

/**
 * @author Ola Dahl
 */
public class OrderDAO {
    private static String ORDERS_COLLECTION = "orders";

    public static void insertOrder(Order order) {
        MongoCollection<Order> collection = DBInstance.connectDB().getCollection(ORDERS_COLLECTION, Order.class);
        collection.insertOne(order);
    }

    public static List<Order> getOrders() {
        MongoCollection<Order> collection = DBInstance.connectDB().getCollection(ORDERS_COLLECTION, Order.class);
        return getOrdersList(collection.find());
    }

    private static List<Order> getOrdersList(FindIterable<Order> orderRes) {
        List<Order> orders = new ArrayList<Order>();
        for (Order order : orderRes) {
            orders.add(order);
        }
        return orders;
    }
}
