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
        String expected = "id: 1, " +
                "name: Griffon Vulture, " +
                "defaultPrice: 1990,000000, " +
                "defaultCurrency: USD, " +
                "species: Bird, " +
                "zoo: Montgomery Zoo";
        assertEquals(expected, dao.find(1).toString());
    }

    @ParameterizedTest
    @MethodSource("daos")
    void testGetAll(AnimalDao dao) {
        assertEquals(48, dao.getAll().size());
    }
}
