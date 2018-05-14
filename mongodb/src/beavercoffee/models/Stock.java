package beavercoffee.models;

import beavercoffee.models.product.Ingridient;
import org.bson.types.ObjectId;

public class Stock {
    private ObjectId locationId;
    private Unit unitMeasurement;
    private Ingridient ingridient;
    private double quantity;

    public Stock() {}
    public Stock(ObjectId locationId, Unit unitMeasurement, Ingridient ingridient, double quantity) {
        this.locationId = locationId;
        this.unitMeasurement = unitMeasurement;
        this.ingridient = ingridient;
        this.quantity = quantity;
    }

    public ObjectId getLocationId() {
        return locationId;
    }

    public void setLocationId(ObjectId locationId) {
        this.locationId = locationId;
    }

    public Unit getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(Unit unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }

    public Ingridient getIngridient() {
        return ingridient;
    }

    public void setIngridient(Ingridient ingridient) {
        this.ingridient = ingridient;
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
                ", unitMeasurement=" + unitMeasurement +
                ", ingridient=" + ingridient +
                ", quantity=" + quantity +
                '}';
    }
}
