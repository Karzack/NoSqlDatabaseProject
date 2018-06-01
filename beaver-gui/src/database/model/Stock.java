package database.model;

import database.model.product.Ingredient;
import org.bson.types.ObjectId;

/**
 * @author Ola Dahl
 */
public class Stock {
    private ObjectId locationId;
    private Ingredient ingredient;
    private double quantity;

    public Stock() {}
    public Stock(ObjectId locationId, Ingredient ingredient, double quantity) {
        this.locationId = locationId;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public ObjectId getLocationId() {
        return locationId;
    }

    public void setLocationId(ObjectId locationId) {
        this.locationId = locationId;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "locationId=" + locationId +
                ", ingredient=" + ingredient +
                ", quantity=" + quantity +
                '}';
    }
}
