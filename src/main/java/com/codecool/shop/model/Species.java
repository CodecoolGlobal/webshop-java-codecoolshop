package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Species extends BaseModel {
    private String family;
    private List<Animal> animals;

    public Species(String name, String family, String description) {
        super(name);
        this.family = family;
        this.animals = new ArrayList<>();
    }

    public Species(String[] data) {
        super(data[0], data[2]);
        family = data[1];
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
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
        return String.format(
                "id: %1$d," +
                        "name: %2$s, " +
                        "family: %3$s, " +
                        "description: %4$s",
                this.id,
                this.name,
                this.family,
                this.description);
    }
}