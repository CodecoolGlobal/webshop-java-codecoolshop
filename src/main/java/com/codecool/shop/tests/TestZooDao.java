package com.codecool.shop.tests;

import com.codecool.shop.dao.ZooDao;
import com.codecool.shop.dao.implementation.ZooDaoMem;
import com.codecool.shop.model.Zoo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestZooDao {
    private ZooDao zooDao;

    /**
     * Make a new instance every time before running a test
     */
    @BeforeEach
    void setup() {
        zooDao = ZooDaoMem.getInstance();
    }

    @Test
    void testAdd() {
        Zoo newZoo = new Zoo("Sample", "Sample", "Sample", "Sample");
        zooDao.add(newZoo);
        assert(zooDao.getAll().contains(newZoo));
    }

    @Test
    void testFindById() {
        String expected = "id: 1, name: Montgomery Zoo, description: Montgomery Zoo is a 40-acre (16 ha) zoo located on the north side of Montgomery, Alabama. The zoo is an independent city family, and is aided by The Montgomery Area Zoolocal Society. It is home to approximately 750 animals representing 140 species.";
        assertEquals(expected, zooDao.find(1).toString());
    }

    @Test
    void testFindByName() {
        String expected = "id: 1, name: Montgomery Zoo, description: Montgomery Zoo is a 40-acre (16 ha) zoo located on the north side of Montgomery, Alabama. The zoo is an independent city family, and is aided by The Montgomery Area Zoolocal Society. It is home to approximately 750 animals representing 140 species.";
        assertEquals(expected, zooDao.find("Montgomery Zoo").toString());
    }

    @Test
    void testGetAll() {
        assertEquals(13, zooDao.getAll().size());
    }
}
