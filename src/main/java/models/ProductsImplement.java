package models;

import java.util.ArrayList;
import java.util.List;

public class ProductsImplement implements ProductInterface{
// data model
    public List<ProductBean> productBeanList = new ArrayList<>();

    @Override
    public List<ProductBean> listAllProducts() {
        return null;
    }

    @Override
    public void insert(ProductBean product){

    }
    //mock database
}
