package beavercoffee.models.product;

public class ProductName {
    private String swedish;
    private String english;

    public ProductName() {}

    public ProductName(String swedish, String english) {
        this.swedish = swedish;
        this.english = english;
    }

    public String getSwedish() {
        return swedish;
    }

    public void setSwedish(String swedish) {
        this.swedish = swedish;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return "ProductName{" +
                "swedish='" + swedish + '\'' +
                ", english='" + english + '\'' +
                '}';
    }
}
