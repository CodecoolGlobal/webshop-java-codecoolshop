package com.codecool.shop.dao.implementation.DB;

import com.codecool.shop.dao.AnimalDao;
import com.codecool.shop.dao.UserDao;
import com.codecool.shop.databaseHandler.CodecoolShopDB;
import com.codecool.shop.model.Animal;
import com.codecool.shop.model.Species;
import com.codecool.shop.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDaoDB implements UserDao {

    private static UserDaoDB instance;
    private CodecoolShopDB cdb;

    private UserDaoDB() {
        cdb = CodecoolShopDB.getInstance();
    }

    public static UserDaoDB getInstance() {
        if (instance == null) instance = new UserDaoDB();
        return instance;
    }


    @Override
    public void add(User user) {
        try {
            cdb.executeUpdate(String.format("INSERT INTO users VALUES(default, '%1$s', '%2$s', '%3$s')",
                    user.getName(),
                    user.getEmail(),
                    user.getPassword()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(String name, String email, String password) {
        User user = new User(name, email, password);
        add(user);
    }

    @Override
    public User find(int id) {
        ResultSet result;
        try {
            result = cdb.executeQuery(String.format("SELECT * FROM users WHERE id = %1$d", id));
            if (result.next()) {
                return getUserFromResultSet(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(int id) {
        try {
            cdb.executeUpdate(String.format("DELETE FROM users WHERE id = %1$d", id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User getUserFromResultSet(ResultSet result) throws SQLException {
        return new User(
                result.getString("name"),
                result.getString("email"),
                result.getString("password"));
    }

}
