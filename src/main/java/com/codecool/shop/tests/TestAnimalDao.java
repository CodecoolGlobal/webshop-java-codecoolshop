package com.codecool.shop.tests;

import com.codecool.shop.dao.AnimalDao;
import com.codecool.shop.dao.implementation.DB.AnimalDaoDB;
import com.codecool.shop.dao.implementation.Mem.AnimalDaoMem;

import com.codecool.shop.model.Animal;
import com.codecool.shop.model.Species;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAnimalDao {

    private static Stream getDAOs() {
        return Stream.of(
                AnimalDaoMem.getInstance(),
                AnimalDaoDB.getInstance()
        );
    }

    @ParameterizedTest
    @MethodSource("getDAOs")
    void testAdd(AnimalDao dao) {
        Animal newAnimal = new Animal(
                "Sample",
                new Species("", "", ""),
                0f,
                "USD",
                "",
                ""
        );
        dao.add(newAnimal);
        assertEquals(49, dao.getAll().size());
    }

    @ParameterizedTest
    @MethodSource("getDAOs")
    void testFind(AnimalDao dao) {
        String expected =
                "id: 1, " +
                "name: Griffon Vulture, " +
                "defaultPrice: 1990,000000, " +
                "defaultCurrency: USD, " +
                "species: Bird, " +
                "zoo: Montgomery Zoo";
        assertEquals(expected, dao.find(1).toString());
    }

    @ParameterizedTest
    @MethodSource("getDAOs")
    void testGetAll(AnimalDao dao) {
        assertEquals(48, dao.getAll().size());
    }
}
