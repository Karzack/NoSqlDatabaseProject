package beavercoffee.models.product;

import org.bson.types.ObjectId;

import java.util.List;

public class Product {
    private ObjectId id;
    private ProductName name;
    private ProductPrice price;
    private List<IngridientItem> ingridients;

    public Product() {}

    public Product(ProductName name, ProductPrice price, List<IngridientItem> ingridients) {
        this.name = name;
        this.price = price;
        this.ingridients = ingridients;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ProductName getName() {
        return name;
    }

    public void setName(ProductName name) {
        this.name = name;
    }

    public ProductPrice getPrice() {
        return price;
    }

    public void setPrice(ProductPrice price) {
        this.price = price;
    }

    public List<IngridientItem> getIngridients() {
        return ingridients;
    }

    public void setIngridients(List<IngridientItem> ingridients) {
        this.ingridients = ingridients;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", ingridients=" + ingridients +
                '}';
    }
}
