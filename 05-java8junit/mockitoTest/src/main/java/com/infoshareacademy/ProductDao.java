package com.infoshareacademy;


import java.util.Collections;
import java.util.List;

public class ProductDao {

    public List<Product> getAllProducts() {
        return Collections.emptyList();
    }


    public List<Product> getAllProductsWithPriceGreaterThan(Integer price) {
        return Collections.emptyList();
    }


    public List<Product> getNCheapestProducts(Integer amount) {
        return Collections.emptyList();
    }


    public void updatePrice(Product product, Integer newPrice) {
        // no implementation yet
    }


    public Product getProductWithName(String productName) throws EntityNotFoundException{
        return null;
    }
}
