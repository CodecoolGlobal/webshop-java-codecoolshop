package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Zoo extends BaseModel {
    private String state;
    private String city;
    private List<Animal> animals;

    public Zoo(String name, String state, String city, String description) {
        super(name, description);
        this.state = state;
        this.city = city;
        this.animals = new ArrayList<>();
    }

    public Zoo(int id, String name, String state, String city, String description) {
        super(id, name, description);
        this.state = state;
        this.city = city;
        this.animals = new ArrayList<>();
    }

    public Zoo(String[] data) {
        super(data[0], data[3]);
        state = data[1];
        city = data[2];
        this.animals = new ArrayList<>();
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }

    public void addProduct(Animal product) {
        this.animals.add(product);
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

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}