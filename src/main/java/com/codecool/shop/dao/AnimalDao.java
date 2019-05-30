package com.codecool.shop.dao;

import com.codecool.shop.model.Zoo;
import com.codecool.shop.model.Animal;
import com.codecool.shop.model.Species;

import java.util.List;

public interface AnimalDao {

    void add(Animal product);
    Animal find(int id);
    void remove(int id);

    List<Animal> getAll();
    List<Animal> getBy(Zoo supplier);
    List<Animal> getBy(Species productCategory);
    List<Animal> getBy(Zoo supplier, Species productCategory);

}
