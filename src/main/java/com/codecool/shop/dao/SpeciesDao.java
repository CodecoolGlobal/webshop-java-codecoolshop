package com.codecool.shop.dao;

import com.codecool.shop.model.Species;

import java.util.List;

public interface SpeciesDao {

    void add(Species species);
    Species find(int id);
    Species find(String name);

    void remove(int id);

    List<Species> getAll();

}
