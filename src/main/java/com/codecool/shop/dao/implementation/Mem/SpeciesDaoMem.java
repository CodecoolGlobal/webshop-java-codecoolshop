package com.codecool.shop.dao.implementation.Mem;


import com.codecool.shop.dao.SpeciesDao;
import com.codecool.shop.model.Species;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SpeciesDaoMem implements SpeciesDao {
    private static final Path PATH = Paths.get(System.getProperty("user.dir"),"/src/data/csv/species.csv");


    private List<Species> data = new ArrayList<>();
    private static SpeciesDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private SpeciesDaoMem() {
        try {
            Files.lines(PATH).forEach(line -> {
                add(new Species(line.strip().split("\\|")));
            });
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No such file or something is wrong with the file... go figure");
        }
    }

    public static SpeciesDaoMem getInstance() {
        if (instance == null) {
            instance = new SpeciesDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Species species) {
        species.setId(data.size() + 1);
        data.add(species);
    }

    @Override
    public Species find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Species find(String name) {
        return data.stream().filter(species -> species.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<Species> getAll() {
        return data;
    }
}
