package com.codecool.shop.tests;

import com.codecool.shop.dao.AnimalDao;
import com.codecool.shop.dao.implementation.DB.AnimalDaoDB;
import com.codecool.shop.dao.implementation.Mem.AnimalDaoMem;
import com.codecool.shop.dao.implementation.Mem.SpeciesDaoMem;
import com.codecool.shop.dao.implementation.Mem.ZooDaoMem;
import com.codecool.shop.model.Animal;
import com.codecool.shop.model.Species;
import com.codecool.shop.model.Zoo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAnimalDao {
    private AnimalDao animalDao;

    /**
     * Make a new instance every time before running a test
     */
    @BeforeEach
    void setup() {
        animalDao = AnimalDaoMem.getInstance();
    }

    @Test
    void testFind() {
        String expected = "id: 1, name: Griffon Vulture, defaultPrice: 1990,000000, defaultCurrency: USD, species: Bird, zoo: Montgomery Zoo";
        assertEquals(expected, animalDao.find(1).toString());
    }

//    @Test
//    void testGetBySupplier() {
//        Zoo zoo = ZooDaoMem.getInstance().find(1);
//        List<Animal> expected = new ArrayList<>();
//        expected.add(animalDao.find(12));
//        expected.add(animalDao.find(24));
//        expected.add(animalDao.find(36));
//        expected.add(animalDao.find(48));
//        assertEquals(animalDao.getBy(zoo), expected);
//    }
//
//    @Test
//    void testGetByProductCategory() {
//        Species productCategory = SpeciesDaoMem.getInstance().find(1);
//        List<Animal> expected = new ArrayList<>();
//        expected.add(animalDao.find(1));
//        expected.add(animalDao.find(2));
//        expected.add(animalDao.find(3));
//        expected.add(animalDao.find(4));
//        expected.add(animalDao.find(5));
//        expected.add(animalDao.find(6));
//        expected.add(animalDao.find(7));
//        expected.add(animalDao.find(8));
//        expected.add(animalDao.find(9));
//        expected.add(animalDao.find(10));
//        expected.add(animalDao.find(11));
//        expected.add(animalDao.find(12));
//        assertEquals(animalDao.getBy(productCategory), expected);
//    }

    @Test
    void testGetAll() {
        assertEquals(48, animalDao.getAll().size());
    }
}
