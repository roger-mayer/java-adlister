package models;

public class ProductBean {
    //fields
    private String name;
    private double price;

    //zero argument constructor
    public ProductBean(){

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
