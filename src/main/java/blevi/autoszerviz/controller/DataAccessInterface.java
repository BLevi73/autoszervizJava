package blevi.autoszerviz.controller;

import blevi.autoszerviz.model.Database;


/**
 * Access layer between the business logic and database, redirects the calls from the business logic to the database,
 * and provides the necessary data from the database for the business logic.
 */
public class DataAccessInterface {
    private static Database database;

    private DataAccessInterface() {
        throw new IllegalStateException("Utility class, cannot be instantiated");
    }

    public static Database getDatabase() {
        return database;
    }

    public static void setDatabase(Database database) {
        DataAccessInterface.database = database;
    }
}
