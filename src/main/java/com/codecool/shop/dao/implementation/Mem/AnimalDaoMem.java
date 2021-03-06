package com.codecool.shop.dao.implementation.Mem;


import com.codecool.shop.dao.AnimalDao;
import com.codecool.shop.model.Animal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AnimalDaoMem implements AnimalDao {
    private static final Path PATH = Paths.get(System.getProperty("user.dir"),"/src/data/csv/animals.csv");

    private List<Animal> data = new ArrayList<>();
    private static AnimalDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private AnimalDaoMem() {
        try {
            Files.lines(PATH).forEach(line -> add(new Animal(line.strip().split("\\|"))));
        } catch (IOException e) {
            System.out.println("No such file or something is wrong with the file... go figure");
            e.printStackTrace();
        }
    }

    public static AnimalDaoMem getInstance() {
        if (instance == null) {
            instance = new AnimalDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Animal animal) {
        animal.setId(data.size() + 1);
        data.add(animal);
    }

    @Override
    public Animal find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<Animal> getAll() {
        return data;
    }
}
