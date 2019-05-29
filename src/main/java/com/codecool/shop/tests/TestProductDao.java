package com.codecool.shop.tests;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProductDao {
    private ProductDao productDao;

    /**
     * Make a new instance every time before running a test
     */
    @BeforeEach
    void setup() {
        productDao = ProductDaoMem.getInstance();
    }

    @Test
    void testGetBySupplier() {
        Supplier supplier = SupplierDaoMem.getInstance().find(1);
        List<Product> expected = new ArrayList<>();
        expected.add(productDao.find(12));
        expected.add(productDao.find(24));
        expected.add(productDao.find(36));
        expected.add(productDao.find(48));
        assertEquals(productDao.getBy(supplier), expected);
    }

    @Test
    void testGetByProductCategory() {
        ProductCategory productCategory = ProductCategoryDaoMem.getInstance().find(1);
        List<Product> expected = new ArrayList<>();
        expected.add(productDao.find(1));
        expected.add(productDao.find(2));
        expected.add(productDao.find(3));
        expected.add(productDao.find(4));
        expected.add(productDao.find(5));
        expected.add(productDao.find(6));
        expected.add(productDao.find(7));
        expected.add(productDao.find(8));
        expected.add(productDao.find(9));
        expected.add(productDao.find(10));
        expected.add(productDao.find(11));
        expected.add(productDao.find(12));
        assertEquals(productDao.getBy(productCategory), expected);
    }
}
