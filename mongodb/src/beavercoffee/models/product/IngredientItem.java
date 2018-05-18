package beavercoffee.models.product;

public class IngredientItem {
    private Ingredient ingredient;
    private double quantity;

    public IngredientItem() {}
    public IngredientItem(Ingredient ingredient, double quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
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
        return "IngredientItem{" +
                "ingredient=" + ingredient +
                ", quantity=" + quantity +
                '}';
    }
}
