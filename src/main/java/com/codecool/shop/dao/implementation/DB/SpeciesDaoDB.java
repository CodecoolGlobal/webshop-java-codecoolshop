package com.codecool.shop.dao.implementation.DB;

import com.codecool.shop.dao.SpeciesDao;
import com.codecool.shop.databaseHandler.CodecoolShopDB;
import com.codecool.shop.model.Species;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpeciesDaoDB implements SpeciesDao {
    private static SpeciesDaoDB instance;
    private CodecoolShopDB cdb;

    private SpeciesDaoDB() {
        cdb = CodecoolShopDB.getInstance();
    }

    public static SpeciesDaoDB getInstance() {
        if (instance == null) instance = new SpeciesDaoDB();
        return instance;
    }

    @Override
    public void add(Species species) {
        try {
            cdb.executeUpdate(String.format("INSERT INTO species VALUES(default, '%1$s', '%2$s', '%3$s')",
                    species.getName(),
                    species.getFamily(),
                    species.getDescription()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Species find(int id) {
        ResultSet result;
        try {
            result = cdb.executeQuery(String.format("SELECT * FROM species WHERE id = %1$d", id));
            if (result.next()) {
                return getSpeciesFromResultSet(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Species find(String name) {
        ResultSet result;
        try {
            result = cdb.executeQuery(String.format("SELECT * FROM species WHERE name = '%1$s'", name));
            if (result.next()) {
                return getSpeciesFromResultSet(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(int id) {
        try {
            cdb.executeUpdate(String.format("DELETE FROM species WHERE id = %1$d", id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Species> getAll() {
        List<Species> species = new ArrayList<>();
        ResultSet result;
        try {
            result = cdb.executeQuery("SELECT * FROM species");
            while(result.next()) {
                species.add(getSpeciesFromResultSet(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return species;
    }

    private Species getSpeciesFromResultSet(ResultSet result) throws SQLException {
        return new Species(
                result.getInt("id"),
                result.getString("name"),
                result.getString("family"),
                result.getString("description"));
    }
}
