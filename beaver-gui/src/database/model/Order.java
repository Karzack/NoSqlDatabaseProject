package database.model;

import database.model.product.Product;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

/**
 * @author Ola Dahl
 */
public class Order {
    private ObjectId id;
    private ObjectId employeeId;
    private ObjectId clubMemberId;
    private ObjectId locationId;
    private Date orderDate;
    private double totalPrice;
    private List<Product> orderItems;

    public Order() { }

    public Order(ObjectId employeeId, ObjectId clubMemberId, ObjectId locationId, Date orderDate, double totalPrice, List<Product> orderItems) {
        this.employeeId = employeeId;
        this.clubMemberId = clubMemberId;
        this.locationId = locationId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.orderItems = orderItems;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(ObjectId employeeId) {
        this.employeeId = employeeId;
    }

    public ObjectId getClubMemberId() {
        return clubMemberId;
    }

    public void setClubMemberId(ObjectId clubMemberId) {
        this.clubMemberId = clubMemberId;
    }

    public ObjectId getLocationId() {
        return locationId;
    }

    public void setLocationId(ObjectId locationId) {
        this.locationId = locationId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Product> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Product> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", clubMemberId=" + clubMemberId +
                ", locationId=" + locationId +
                ", orderDate=" + orderDate +
                ", totalPrice=" + totalPrice +
                ", orderItems=" + orderItems +
                '}';
    }
}
