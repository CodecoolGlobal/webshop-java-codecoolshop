package com.codecool.shop.tests;

import com.codecool.shop.dao.ZooDao;
import com.codecool.shop.dao.implementation.DB.ZooDaoDB;
import com.codecool.shop.dao.implementation.Mem.ZooDaoMem;
import com.codecool.shop.model.Zoo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestZooDao {

    private static Stream daos() {
        return Stream.of(
                ZooDaoMem.getInstance(),
                ZooDaoDB.getInstance()
        );
    }

    @ParameterizedTest
    @MethodSource("daos")
    void testAdd(ZooDao dao) {
        Zoo newZoo = new Zoo("Sample", "Sample", "Sample", "Sample");
        dao.add(newZoo);
        assertEquals(13, dao.getAll().size());
    }

    @ParameterizedTest
    @MethodSource("daos")
    void testFindById(ZooDao dao) {
        String expected = "id: 1, name: Montgomery Zoo, description: Montgomery Zoo is a 40-acre (16 ha) zoo located on the north side of Montgomery, Alabama. The zoo is an independent city family, and is aided by The Montgomery Area Zoolocal Society. It is home to approximately 750 animals representing 140 species.";
        assertEquals(expected, dao.find(1).toString());
    }

    @ParameterizedTest
    @MethodSource("daos")
    void testFindByName(ZooDao dao) {
        String expected = "id: 1, name: Montgomery Zoo, description: Montgomery Zoo is a 40-acre (16 ha) zoo located on the north side of Montgomery, Alabama. The zoo is an independent city family, and is aided by The Montgomery Area Zoolocal Society. It is home to approximately 750 animals representing 140 species.";
        assertEquals(expected, dao.find("Montgomery Zoo").toString());
    }

    @ParameterizedTest
    @MethodSource("daos")
    void testGetAll(ZooDao dao) {
        assertEquals(13, dao.getAll().size());
    }
}
