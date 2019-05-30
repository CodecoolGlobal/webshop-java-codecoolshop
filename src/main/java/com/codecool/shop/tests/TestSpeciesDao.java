package com.codecool.shop.tests;

import com.codecool.shop.dao.SpeciesDao;
import com.codecool.shop.dao.implementation.DB.SpeciesDaoDB;
import com.codecool.shop.dao.implementation.Mem.SpeciesDaoMem;
import com.codecool.shop.model.Species;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSpeciesDao {

    private static Stream daos() {
        return Stream.of(
                SpeciesDaoMem.getInstance(),
                SpeciesDaoDB.getInstance()
        );
    }

    @ParameterizedTest
    @MethodSource("daos")
    void testAdd(SpeciesDao dao) {
        Species newSpecies = new Species("Sample", "Sample", "Sample");
        dao.add(newSpecies);
        assertEquals(5, dao.getAll().size());
    }

    @ParameterizedTest
    @MethodSource("daos")
    void testFindById(SpeciesDao dao) {
        String expected = "id: 1,name: Bird, family: Vertebrate, description: Birds (Aves) are a group of endothermic vertebrates, characterised by feathers, toothless beaked jaws, the laying of hard-shelled eggs, a high metabolic rate, a four-chambered heart, and a lightweight but strong skeleton.";
        assertEquals(expected, dao.find(1).toString());
    }

    @ParameterizedTest
    @MethodSource("daos")
    void testFindByName(SpeciesDao dao) {
        String expected = "id: 1,name: Bird, family: Vertebrate, description: Birds (Aves) are a group of endothermic vertebrates, characterised by feathers, toothless beaked jaws, the laying of hard-shelled eggs, a high metabolic rate, a four-chambered heart, and a lightweight but strong skeleton.";
        assertEquals(expected, dao.find("Bird").toString());
    }

    @ParameterizedTest
    @MethodSource("daos")
    void testGetAll(SpeciesDao dao) {
        assertEquals(5, dao.getAll().size());
    }
}
