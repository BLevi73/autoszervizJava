package blevi.autoszerviz.controller;

import blevi.autoszerviz.model.Database;



public class DataHandler {
    private static Database database;

    private DataHandler() {
        throw new IllegalStateException("Utility class, cannot be instantiated");
    }

    public static Database getDatabase() {
        return database;
    }

    public static void setDatabase(Database database) {
        DataHandler.database = database;
    }

    public static void addNewEmployeeEvent() {
        
    }
}
