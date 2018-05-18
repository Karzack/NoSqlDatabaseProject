package database.model.product;

import database.model.Unit;
import org.bson.types.ObjectId;

public class Ingredient {
    private ObjectId id;
    private String name;
    private Unit unit;

    public Ingredient() {}
    public Ingredient(String name, Unit unit) {
        this.name = name;
        this.unit = unit;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
