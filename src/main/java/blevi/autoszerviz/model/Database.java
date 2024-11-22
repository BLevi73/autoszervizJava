package blevi.autoszerviz.model;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import blevi.autoszerviz.model.datatypes.Car;
import blevi.autoszerviz.model.datatypes.Client;
import blevi.autoszerviz.model.datatypes.Employee;
import blevi.autoszerviz.model.datatypes.Part;

public class Database implements Serializable {
    private String name;
    private ArrayList<Employee> employees;
    private ArrayList<Client> clients;
    private ArrayList<Car> cars;
    private ArrayList<Part> parts;

    public Database(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Client> getClients() {
        return clients;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
    
    public ArrayList<Part> getParts() {
        return parts;
    }
}
