package models;

import java.util.List;

public interface ProductInterface {
    //define method to implement interface
    List<ProductBean> listAllProducts(); //get all the product records
    void insert(ProductBean ProductBean); //persist new product to the database
}
