package com.codecool.shop.tests;

import com.codecool.shop.dao.SpeciesDao;
import com.codecool.shop.dao.implementation.SpeciesDaoMem;
import com.codecool.shop.model.Species;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSpeciesDao {
    private SpeciesDao speciesDao;

    /**
     * Make a new instance every time before running a test
     */
    @BeforeEach
    void setup() {
        speciesDao = SpeciesDaoMem.getInstance();
    }

    @Test
    void testAdd() {
        Species newSpecies = new Species("Sample", "Sample", "Sample");
        speciesDao.add(newSpecies);
        assert(speciesDao.getAll().contains(newSpecies));
    }

    @Test
    void testFindById() {
        String expected = "id: 1,name: Bird, family: Vertebrate, description: Birds (Aves) are a group of endothermic vertebrates, characterised by feathers, toothless beaked jaws, the laying of hard-shelled eggs, a high metabolic rate, a four-chambered heart, and a lightweight but strong skeleton.";
        assertEquals(expected, speciesDao.find(1).toString());
    }

    @Test
    void testFindByName() {
        String expected = "id: 1,name: Bird, family: Vertebrate, description: Birds (Aves) are a group of endothermic vertebrates, characterised by feathers, toothless beaked jaws, the laying of hard-shelled eggs, a high metabolic rate, a four-chambered heart, and a lightweight but strong skeleton.";
        assertEquals(expected, speciesDao.find("Bird").toString());
    }

    @Test
    void testGetAll() {
        assertEquals(5, speciesDao.getAll().size());
    }
}
