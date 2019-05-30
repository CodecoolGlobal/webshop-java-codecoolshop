package com.codecool.shop.model;

public class User {

    String name;
    String email;
    String password;
    int id;
    private static int idCounter;

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.password = phone;
        this.id = idCounter++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
