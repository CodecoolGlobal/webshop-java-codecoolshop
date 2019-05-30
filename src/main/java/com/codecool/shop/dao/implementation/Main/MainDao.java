package com.codecool.shop.dao.implementation.Main;

import com.codecool.shop.dao.AnimalDao;
import com.codecool.shop.dao.SpeciesDao;
import com.codecool.shop.dao.ZooDao;
import com.codecool.shop.dao.implementation.DB.AnimalDaoDB;
import com.codecool.shop.dao.implementation.DB.SpeciesDaoDB;
import com.codecool.shop.dao.implementation.DB.ZooDaoDB;
import com.codecool.shop.dao.implementation.Mem.AnimalDaoMem;
import com.codecool.shop.dao.implementation.Mem.SpeciesDaoMem;
import com.codecool.shop.dao.implementation.Mem.ZooDaoMem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class MainDao {
    private static final Path PATH_TO_CONFIG = Paths.get(
            System.getProperty("user.dir"), "/config");

    private static AnimalDao animalDaoInstance;
    private static SpeciesDao speciesDaoInstance;
    private static ZooDao zooDaoInstance;

    private static String dataSource = getDataSource();

    public static AnimalDao getAnimalDaoInstance() {
        if (animalDaoInstance == null) {
            if (dataSource.equals("DB")) {
                animalDaoInstance = AnimalDaoDB.getInstance();
                System.out.println("Using DataBase");
            } else {
                animalDaoInstance = AnimalDaoMem.getInstance();
                System.out.println("Using Memory");
            }
        }
        return animalDaoInstance;
    }

    public static SpeciesDao getSpeciesDaoInstance() {
        if (speciesDaoInstance == null) {
            if (dataSource.equals("DB")) {
                speciesDaoInstance = SpeciesDaoDB.getInstance();
                System.out.println("Using DataBase");
            } else {
                speciesDaoInstance = SpeciesDaoMem.getInstance();
                System.out.println("Using Memory");
            }
        }
        return speciesDaoInstance;
    }

    public static ZooDao getZooDaoInstance() {
        if (zooDaoInstance == null) {
            if (dataSource.equals("DB")) {
                zooDaoInstance = ZooDaoDB.getInstance();
                System.out.println("Using DataBase");
            } else {
                zooDaoInstance = ZooDaoMem.getInstance();
                System.out.println("Using Memory");
            }
        }
        return zooDaoInstance;
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(Files.newBufferedReader(PATH_TO_CONFIG));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    private static String getDataSource() {
        return getProperties().getProperty("datasource");
    }
}
