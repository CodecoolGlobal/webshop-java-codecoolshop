package com.codecool.shop.model;

import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;

import java.util.Currency;

public class Product extends BaseModel {

    private int defaultPrice;
    private Currency defaultCurrency;
    private ProductCategory productCategory;
    private Supplier supplier;
    private String imgLink;


    public Product(String name, ProductCategory productCategory, int defaultPrice, String currencyString, String description, String imgLink) {
        super(name, description);
        this.productCategory = productCategory;
        this.defaultPrice = defaultPrice;
        this.defaultCurrency = Currency.getInstance(currencyString);
        this.imgLink = imgLink;
    }

    public Product(String[] data) {
        super(data[0], data[4]);
        productCategory = ProductCategoryDaoMem.getInstance().find(data[1]);
        defaultPrice = Integer.valueOf(data[2]);
        defaultCurrency = Currency.getInstance(data[3]);
        imgLink = data[5];
    }

    public int getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(int defaultPrice) {
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

    public void setPrice(int price, String currency) {
        this.defaultPrice = price;
        this.defaultCurrency = Currency.getInstance(currency);
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
        this.productCategory.addProduct(this);
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
        this.supplier.addProduct(this);
    }

    @Override
    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "defaultPrice: %3$f, " +
                        "defaultCurrency: %4$s, " +
                        "productCategory: %5$s, " +
                        "supplier: %6$s",
                this.id,
                this.name,
                this.defaultPrice,
                this.defaultCurrency.toString(),
                this.productCategory.getName(),
                this.supplier.getName());
    }

    public String getImgLink() {
        return imgLink;
    }
}
