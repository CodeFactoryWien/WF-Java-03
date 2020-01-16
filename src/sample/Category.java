package sample;

public class Category {
    private int categoryID;
    private String categoryName;
    private double categoryPrice;
    public Category(int categoryID, String categoryName, double categoryPrice){
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.categoryPrice = categoryPrice;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getCategoryPrice() {
        return categoryPrice;
    }

    public void setCategoryPrice(double categoryPrice) {
        this.categoryPrice = categoryPrice;
    }
}
