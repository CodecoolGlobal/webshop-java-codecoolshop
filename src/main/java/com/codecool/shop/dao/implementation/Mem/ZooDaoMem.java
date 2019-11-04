package com.codecool.shop.dao.implementation.Mem;

import com.codecool.shop.dao.ZooDao;
import com.codecool.shop.model.Zoo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZooDaoMem implements ZooDao {

    private static final Path PATH = Paths.get(System.getProperty("user.dir"),"/src/data/csv/zoos.csv");

    private int current;
    private List<Zoo> data = new ArrayList<>();
    private static ZooDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private ZooDaoMem() {
        try {
            Files.lines(PATH).forEach(line -> {
                add(new Zoo(line.strip().split("\\|")));
            });
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No such file or something is wrong with the file... go figure");
        }
    }

    public static ZooDaoMem getInstance() {
        if (instance == null) {
            instance = new ZooDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Zoo supplier) {
        supplier.setId(data.size() + 1);
        data.add(supplier);
    }

    @Override
    public Zoo find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Zoo find(String name) {
        return data.stream().filter(zoo -> zoo.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<Zoo> getAll() {
        return data;
    }

    public Zoo next() {
        return data.get((++current) % data.size());
    }

    public Zoo getRandom() {
        return data.get(new Random().nextInt(data.size()));
    }
}
