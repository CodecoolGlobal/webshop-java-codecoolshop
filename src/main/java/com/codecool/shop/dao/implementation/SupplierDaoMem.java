package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SupplierDaoMem implements SupplierDao {

    private static final Path PATH = Paths.get("/home/benjamin/Documents/Codecool/oop/4tw/webshop/src/data/suppliers.csv");

    private int current;
    private List<Supplier> data = new ArrayList<>();
    private static SupplierDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private SupplierDaoMem() {
        try {
            Files.lines(PATH).forEach(line -> {
                add(new Supplier(line.strip().split("\\|")));
            });
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No such file or something is wrong with the file... go figure");
        }
    }

    public static SupplierDaoMem getInstance() {
        if (instance == null) {
            instance = new SupplierDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Supplier supplier) {
        supplier.setId(data.size() + 1);
        data.add(supplier);
    }

    @Override
    public Supplier find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<Supplier> getAll() {
        return data;
    }

    public Supplier next() {
        return data.get((++current) % data.size());
    }

    public Supplier getRandom() {
        return data.get(new Random().nextInt(data.size()));
    }
}
