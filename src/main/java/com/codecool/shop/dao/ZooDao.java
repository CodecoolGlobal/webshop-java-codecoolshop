package com.codecool.shop.dao;

import com.codecool.shop.model.Zoo;

import java.util.List;

public interface ZooDao {

    void add(Zoo supplier);
    Zoo find(int id);
    Zoo find(String name);
    void remove(int id);

    List<Zoo> getAll();
}
