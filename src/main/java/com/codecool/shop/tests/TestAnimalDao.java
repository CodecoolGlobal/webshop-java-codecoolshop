package com.codecool.shop.tests;

import com.codecool.shop.dao.AnimalDao;
import com.codecool.shop.dao.implementation.DB.AnimalDaoDB;
import com.codecool.shop.dao.implementation.Mem.AnimalDaoMem;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAnimalDao {

    private static Stream daos() {
        return Stream.of(
                AnimalDaoMem.getInstance(),
                AnimalDaoDB.getInstance()
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("daos")
    void testFind(AnimalDao dao) {
        String expected = "id: 1, name: Griffon Vulture, defaultPrice: 1990,000000, defaultCurrency: USD, species: Bird, zoo: Montgomery Zoo";
        assertEquals(expected, dao.find(1).toString());
    }

//    @ParameterizedTest
//    @MethodSource("daos")
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
//    @ParameterizedTest
//    @MethodSource("daos")
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

    @ParameterizedTest
    @MethodSource("daos")
    void testGetAll(AnimalDao dao) {
        assertEquals(48, dao.getAll().size());
    }
}
