package blevi.autoszerviz.controller;

import blevi.autoszerviz.model.wrappers.ClientData;
import blevi.autoszerviz.model.wrappers.EmployeeData;

/**
 * Access layer between the view and business logic, redirects the calls from the gui to the business logic,
 * and provides the necessary data from the business logic for the gui.
 */
public class LogicAccessInterface {
    private static EmployeeData employeesData;
    private static ClientData clientsData;
    private LogicAccessInterface() {
        throw new IllegalStateException("Utility class, cannot be instantiated");
    }
    public static void setTables() {
        employeesData = new EmployeeData();
        clientsData = new ClientData();
    }
    
    public static ClientData getClientsData() {
        return clientsData;
    }
    
    public static EmployeeData getEmployeesData() {
        return employeesData;
    }
}
