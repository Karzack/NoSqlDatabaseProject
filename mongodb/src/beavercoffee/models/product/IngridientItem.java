package beavercoffee.models.product;

public class IngridientItem {
    private Ingridient ingridient;
    private double quantity;

    public IngridientItem() {}
    public IngridientItem(Ingridient ingridient, double quantity) {
        this.ingridient = ingridient;
        this.quantity = quantity;
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
        return "IngridientItem{" +
                "ingridient=" + ingridient +
                ", quantity=" + quantity +
                '}';
    }
}
