package com.codecool.shop.model;

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
    private double priceSum;
    private int sumOfProducts;
    private boolean confirmed;
    private boolean paid;
    private Map<Animal, Integer> animals;

    private Order(){
        this.id = ++instanceCounter;
        animals = new HashMap<>();
    }

    public static Order getInstance() {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }

    public void add(Animal animal){
        animals.merge(animal, 1, Integer::sum);
    }

    public void reduce(Animal animal){
        if (animals.get(animal) != null) {
            if(animals.get(animal) == 1){
                animals.remove(animal);
            }else{
                animals.put(animal, animals.get(animal) - 1);
            }
        }
    }

    public int getId() {
        return id;
    }

    public double getPriceSum(){
        priceSum = 0;
        for (Map.Entry<Animal, Integer> animal : animals.entrySet()){
            priceSum += animal.getKey().getDefaultPrice() * animal.getValue();
        }
        return priceSum;
    }

    public int getNumberOfProducts(){
        sumOfProducts = 0;
        for(int value : animals.values()){
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

    public Map<Animal, Integer> getProductsOfOrder(){
        return animals;
    }

    public double getSumOfPriceBy(Animal animal) {
        if (animals.get(animal) != null) {
            return animals.get(animal) * animal.getDefaultPrice();
        }
        return 0.0;
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
