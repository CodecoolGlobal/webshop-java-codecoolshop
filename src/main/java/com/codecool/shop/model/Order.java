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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Order {

    private static int instanceCounter;
    private static Order instance = null;

    private static final String FOLDER_PATH = System.getProperty("user.dir") + "/orders/";

    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String country;
    private String city;
    private String address;
    private String zip;

    private int id;
    private float priceSum;
    private int sumOfProducts;
    private boolean confirmed;
    private boolean paid;
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

    public int getId() {
        return id;
    }

    public float getPriceSum(){
        priceSum = 0;
        for (Map.Entry<Product, Integer> product : products.entrySet()){
            priceSum += product.getKey().getDefaultPrice() * product.getValue();
        }
        return priceSum;
    }

    public int getNumberOfProducts(){
        sumOfProducts = 0;
        for(int value : products.values()){
            sumOfProducts += value;
        }
        return sumOfProducts;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public boolean isPaid() {
        return paid;
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
        confirmed = true;
        paid = true;
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
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        Order currentOrder = Order.getInstance();

        productDataStore.getAll().forEach(currentOrder::add);
        currentOrder.complete();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
