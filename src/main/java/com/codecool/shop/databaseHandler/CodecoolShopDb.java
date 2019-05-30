package com.codecool.shop.databaseHandler;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class CodecoolShopDb {
    private static final String DEFAULT_PATH = System.getProperty("user.dir") + "/src/data";
    private static final String DATABASE = "jdbc:postgresql://localhost:5432/codecoolshop";
    private static final String DB_USER = System.getenv("POSTGRES_DB_USER");
    private static final String DB_PASSWORD = System.getenv("POSTGRES_DB_PASSWORD");

    private static CodecoolShopDb instance;

    private CodecoolShopDb() {
        executeUpdateFromFile("/database/species.sql");
        executeUpdateFromFile("/database/zoo.sql");
        executeUpdateFromFile("/database/animal.sql");
    }

    public static CodecoolShopDb getInstance() {
        if (instance == null) instance = new CodecoolShopDb();
        return instance;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(DATABASE, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.err.println("ERROR: Connection error.");
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String query) throws SQLException {
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();

        } catch (SQLTimeoutException e) {
            System.err.println("ERROR: SQL Timeout");
        }
    }

    public void executeUpdateFromFile(String filePath) {
        try {
            String query = Files.readString(Paths.get(DEFAULT_PATH, filePath));
            executeUpdate(query);
        } catch (IOException fileError) {
            System.err.println("Bad filepath");
        } catch (SQLException sqlError) {
            System.err.println("Sql problem");
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeQuery();

        } catch (SQLTimeoutException e) {
            System.err.println("ERROR: SQL Timeout");
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        CodecoolShopDb cdb = CodecoolShopDb.getInstance();

        ResultSet birds = cdb.executeQuery("select * from animals where species='Bird'");
        while(birds.next()) {
            System.out.println(birds.getString(1));
        }
    }
}
