package database.model.product;

import org.bson.types.ObjectId;

import java.util.List;

public class Product {
    private ObjectId id;
    private ProductName name;
    private ProductPrice price;
    private List<IngredientItem> mandatoryIngredients;
    private List<IngredientItem> alternatives;

    public Product() {}

    public Product(ProductName name, ProductPrice price, List<IngredientItem> mandatoryIngredients, List<IngredientItem> alternatives) {
        this.name = name;
        this.price = price;
        this.mandatoryIngredients = mandatoryIngredients;
        this.alternatives = alternatives;
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

    public List<IngredientItem> getMandatoryIngredients() {
        return mandatoryIngredients;
    }

    public void setMandatoryIngredients(List<IngredientItem> mandatoryIngredients) {
        this.mandatoryIngredients = mandatoryIngredients;
    }

    public List<IngredientItem> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<IngredientItem> alternatives) {
        this.alternatives = alternatives;
    }

    @Override
    public String toString() {
        return name.getEnglish();
    }
}
