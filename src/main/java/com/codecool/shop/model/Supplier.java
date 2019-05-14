package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Supplier extends BaseModel {
    private String state;
    private String city;
    private List<Product> products;

    public Supplier(String name, String state, String city, String description) {
        super(name, description);
        this.state = state;
        this.city = city;
        this.products = new ArrayList<>();
    }

    public Supplier(String[] data) {
        super(data[0], data[3]);
        state = data[1];
        city = data[2];
        this.products = new ArrayList<>();
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "description: %3$s",
                this.id,
                this.name,
                this.description
        );
    }
}