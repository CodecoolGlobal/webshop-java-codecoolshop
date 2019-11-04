package com.codecool.shop.dao.implementation.DB;

import com.codecool.shop.dao.ZooDao;
import com.codecool.shop.databaseHandler.CodecoolShopDB;
import com.codecool.shop.model.Zoo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZooDaoDB implements ZooDao {
    private static ZooDaoDB instance = null;
    private CodecoolShopDB cdb;
    private int current;
    private int numOfZoos;

    private ZooDaoDB() {
        cdb = CodecoolShopDB.getInstance();
        try {
            ResultSet result = cdb.executeQuery("SELECT COUNT(*) FROM zoos");
            if (result.next()) {
                numOfZoos = result.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ZooDaoDB getInstance() {
        if (instance == null) instance = new ZooDaoDB();
        return instance;
    }

    @Override
    public void add(Zoo zoo) {
        try {
            cdb.executeUpdate(String.format("INSERT INTO zoos VALUES(default, '%1$s', '%2$s', '%3$s', '%4$s')",
                    zoo.getName(),
                    zoo.getState(),
                    zoo.getCity(),
                    zoo.getDescription()));
            numOfZoos++;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Zoo find(int id) {
        ResultSet result;
        try {
            result = cdb.executeQuery(String.format("SELECT * FROM zoos WHERE id = %1$d", id));
            if (result.next()) {
                return getZooFromResultSet(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Zoo find(String name) {
        ResultSet result;
        try {
            result = cdb.executeQuery(String.format("SELECT * FROM zoos WHERE name = '%1$s'", name));
            if (result.next()) {
                return getZooFromResultSet(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(int id) {
        try {
            cdb.executeUpdate(String.format("DELETE FROM zoos WHERE id = %1$d", id));
            numOfZoos--;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Zoo> getAll() {
        List<Zoo> zoos = new ArrayList<>();
        ResultSet result;
        try {
            result = cdb.executeQuery("SELECT * FROM zoos");
            while(result.next()) {
                zoos.add(getZooFromResultSet(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zoos;
    }

    private Zoo getZooFromResultSet(ResultSet result) throws SQLException {
        return new Zoo(
                result.getInt("id"),
                result.getString("name"),
                result.getString("state"),
                result.getString("city"),
                result.getString("description"));
    }

    public Zoo next() {
        current = (current % numOfZoos) + 1;
        ResultSet result;
        try {
            result = cdb.executeQuery("SELECT * FROM zoos");
            for (int i = 0; i < current; i++) {
                result.next();
            }
            return getZooFromResultSet(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
