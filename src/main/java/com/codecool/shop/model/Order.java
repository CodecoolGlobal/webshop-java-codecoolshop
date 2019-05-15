package com.codecool.shop.model;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Order {

    private static int instanceCounter;
    private static Order instance = null;

    private static final String FOLDER_PATH = System.getProperty("user.dir") + "/orders/";

    private int id;
    private float sumOfPrice;
    private int sumOfProducts;
    private Map<Product, Integer> products;

    private Order(){
        this.id = ++instanceCounter;
        products = new HashMap<>();
    }

    public static Order getInstance() {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }

    public float getSumOfPrice(){
        sumOfPrice = 0;
        for (Map.Entry<Product, Integer> product : products.entrySet()){
            sumOfPrice += product.getKey().getDefaultPrice() * product.getValue();
        }
        return sumOfPrice;
    }
    public void add(Product product){
        products.merge(product, 1, Integer::sum);
    }

    public void reduce(Product product){
        if (products.get(product) != null) {
            if(products.get(product) == 1){
                products.remove(product);
            }else{
                products.put(product, products.get(product) - 1);
            }
        }
    }

    public int getNumberOfProducts(){
        sumOfProducts = 0;
        for(int value : products.values()){
            sumOfProducts += value;
        }
        return sumOfProducts;
    }

    public Map<Product, Integer> getProductsOfOrder(){
        return products;
    }

    public float getSumOfPriceBy(Product product) {
        if (products.get(product) != null) {
            return products.get(product) * product.getDefaultPrice();
        }
        return 0f;
    }

    public void complete() {
        saveOrderToFile();
        instance = new Order();
    }

    private void saveOrderToFile() {
        ObjectMapper mapper = new ObjectMapper();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");

        try {
            mapper.writeValue(new File(FOLDER_PATH + id + "_" + dateFormat.format(new Date()) + ".json"), instance);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Order order = Order.getInstance();
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        productDataStore.getAll().forEach(order::add);
        productDataStore.getAll().forEach(order::add);
        order.complete();
    }
}
