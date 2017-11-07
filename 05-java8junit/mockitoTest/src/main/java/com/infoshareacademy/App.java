package com.infoshareacademy;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }


    public App(ProductDao productDao) {
        this.productDao = productDao;
    }

    public App() {

    }


    private ProductDao productDao;



    public void increasePriceOfAllProducts(Integer perc) {
        List<Product> prodcs = productDao.getAllProducts();
        for (Product p : prodcs) {
            Integer newPrice = p.getPrice() * ((100 + perc)/ 100);
            productDao.updatePrice(p,newPrice);
        }
    }


    public Integer getCurrentPriceForProduct(String productName) {
        if(productName == null) {
            throw new IllegalArgumentException("productName can not be null!");
        }
        try {
            Product p = productDao.getProductWithName(productName);
            return p.getPrice();
        } catch(EntityNotFoundException entityNotFoundException) {
            return 0;
        }
    }



    public String listAllProductsAndPrices() {

        StringBuilder output = new StringBuilder();
        List<Product> prodcs = productDao.getAllProducts();
        for (Product p : prodcs) {
            output.append(p.getName()).append(" ")
                    .append(p.getPrice())
                    .append("\n");
        }
        return output.toString();
    }




}
