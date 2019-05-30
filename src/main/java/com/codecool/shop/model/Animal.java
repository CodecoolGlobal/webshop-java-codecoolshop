package com.codecool.shop.model;

import com.codecool.shop.dao.implementation.Mem.SpeciesDaoMem;
import com.codecool.shop.dao.implementation.Mem.ZooDaoMem;

import java.util.Currency;

public class Animal extends BaseModel {

    private double defaultPrice;
    private Currency defaultCurrency;
    private Species species;
    private Zoo zoo;
    private String imgLink;


    public Animal(String name, Species species, double defaultPrice, String currencyString, String description, String imgLink) {
        super(name, description);
        this.species = species;
        this.defaultPrice = defaultPrice;
        this.defaultCurrency = Currency.getInstance(currencyString);
        this.imgLink = imgLink;
        zoo = ZooDaoMem.getInstance().next();
    }

    public Animal(int id, String name, Species species, double defaultPrice, String currencyString, String description, String imgLink) {
        super(id, name, description);
        this.species = species;
        this.defaultPrice = defaultPrice;
        this.defaultCurrency = Currency.getInstance(currencyString);
        this.imgLink = imgLink;
        zoo = ZooDaoMem.getInstance().next();
    }

    public Animal(String[] data) {
        super(data[0], data[4]);
        species = SpeciesDaoMem.getInstance().find(data[1]);
        defaultPrice = Integer.valueOf(data[2]);
        defaultCurrency = Currency.getInstance(data[3]);
        imgLink = data[5];
        zoo = ZooDaoMem.getInstance().next();
    }

    public double getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(float defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public Currency getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(Currency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public String getPrice() {
        return String.valueOf(this.defaultPrice) + " " + this.defaultCurrency.toString();
    }

    public void setPrice(float price, String currency) {
        this.defaultPrice = price;
        this.defaultCurrency = Currency.getInstance(currency);
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
        this.species.addProduct(this);
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
        this.zoo.addProduct(this);
    }


    @Override
    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "defaultPrice: %3$f, " +
                        "defaultCurrency: %4$s, " +
                        "species: %5$s, " +
                        "zoo: %6$s",
                this.id,
                this.name,
                this.defaultPrice,
                this.defaultCurrency.toString(),
                this.species.getName(),
                this.zoo.getName());
    }

    public String getImgLink() {
        return imgLink;
    }
}