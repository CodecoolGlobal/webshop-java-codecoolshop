package com.codecool.shop.model;

import java.util.HashMap;
import java.util.Map;


public class Order {

    private static int instanceCounter;
    private int id;
    private float sumOfPrice;
    HashMap<Product, Integer> products;

    public Order(){
        this.id = instanceCounter++;
        products = new HashMap<>();
    }

    public float getSumOfPrice(){
        for (Map.Entry<Product, Integer> product : products.entrySet()){
            sumOfPrice += product.getKey().getDefaultPrice() * product.getValue();
        }
        return sumOfPrice;
    }
    public void add(Product product){
        if(products.get(product) != null){
            products.put(product, products.get(product) + 1);
        }else{
            products.put(product, 1);
        }
    }

    public void reduce(Product product){
        if(products.get(product) == 1){
            products.remove(product);
        }else{
            products.put(product, products.get(product) - 1);
        }
    }

    public HashMap<Product, Integer> getProductsOfOrder(){
        return products;
    }

}
