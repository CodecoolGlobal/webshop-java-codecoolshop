package com.codecool.shop.dao.implementation.DB;

import com.codecool.shop.dao.AnimalDao;
import com.codecool.shop.databaseHandler.CodecoolShopDB;
import com.codecool.shop.model.Animal;
import com.codecool.shop.model.Species;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalDaoDB implements AnimalDao {

    private static AnimalDaoDB instance;
    private CodecoolShopDB cdb;

    private AnimalDaoDB() {
        cdb = CodecoolShopDB.getInstance();
    }

    public static AnimalDaoDB getInstance() {
        if (instance == null) instance = new AnimalDaoDB();
        return instance;
    }

    @Override
    public void add(Animal animal) {
        try {
            cdb.executeUpdate(String.format("INSERT INTO animals VALUES(default, '%1$s', '%2$s', %3$f, '%4$s', '%5$s', '%6$s')",
                    animal.getName(),
                    animal.getSpecies(),
                    animal.getDefaultPrice(),
                    animal.getDefaultCurrency(),
                    animal.getDescription(),
                    animal.getImgLink()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(String name, String speciesString, Double price, String currency, String description, String imgUrl) {
        Species species = SpeciesDaoDB.getInstance().find(speciesString);
        Animal animal = new Animal(name, species, price, currency, description, imgUrl);
        add(animal);
    }

    @Override
    public Animal find(int id) {
        ResultSet result;
        try {
            result = cdb.executeQuery(String.format("SELECT * FROM animals WHERE id = %1$d", id));
            if (result.next()) {
                return getAnimalFromResultSet(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(int id) {
        try {
            cdb.executeUpdate(String.format("DELETE FROM animals WHERE id = %1$d", id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Animal> getAll() {
        List<Animal> animals = new ArrayList<>();
        ResultSet result;
        try {
            result = cdb.executeQuery("SELECT * FROM animals");
            while(result.next()) {
                animals.add(getAnimalFromResultSet(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return animals;
    }

    private Animal getAnimalFromResultSet(ResultSet result) throws SQLException {
        Species species = SpeciesDaoDB.getInstance().find(result.getString("species"));
        return new Animal(
                result.getInt("id"),
                result.getString("name"),
                species,
                result.getDouble("price"),
                result.getString("currency"),
                result.getString("description"),
                result.getString("img_url"));
    }
}
