package database.model.product;

/**
 * @author Ola Dahl
 */
public class ProductPrice {
    private double SEK;
    private double USD;

    public ProductPrice() {}

    public ProductPrice(double SEK, double USD) {
        this.SEK = SEK;
        this.USD = USD;
    }

    public double getSEK() {
        return SEK;
    }

    public void setSEK(double SEK) {
        this.SEK = SEK;
    }

    public double getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = USD;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "SEK=" + SEK +
                ", USD=" + USD +
                '}';
    }
}
