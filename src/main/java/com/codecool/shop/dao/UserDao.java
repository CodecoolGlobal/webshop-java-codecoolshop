package com.codecool.shop.dao;

import com.codecool.shop.model.User;

public interface UserDao {

    void add(User user);
    public User find(int id);
    void remove(int id);

}
