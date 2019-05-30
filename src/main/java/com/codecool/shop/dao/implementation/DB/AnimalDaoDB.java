package com.codecool.shop.dao.implementation.DB;

import com.codecool.shop.dao.AnimalDao;
import com.codecool.shop.model.Animal;
import com.codecool.shop.model.Species;
import com.codecool.shop.model.Zoo;

import java.util.List;

public class AnimalDaoDB implements AnimalDao {

    @Override
    public void add(Animal product) {

    }

    @Override
    public Animal find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Animal> getAll() {
        return null;
    }

    @Override
    public List<Animal> getBy(Zoo supplier) {
        return null;
    }

    @Override
    public List<Animal> getBy(Species productCategory) {
        return null;
    }

    @Override
    public List<Animal> getBy(Zoo supplier, Species productCategory) {
        return null;
    }
}
