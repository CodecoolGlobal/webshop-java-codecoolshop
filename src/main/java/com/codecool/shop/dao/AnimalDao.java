package com.codecool.shop.dao;

import com.codecool.shop.model.Animal;

import java.util.List;

public interface AnimalDao {

    void add(Animal animal);
    Animal find(int id);
    void remove(int id);

    List<Animal> getAll();

}
