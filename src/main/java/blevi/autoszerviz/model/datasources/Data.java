package blevi.autoszerviz.model.datasources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import blevi.autoszerviz.controller.filehandlers.SerializationType;
import blevi.autoszerviz.controller.filehandlers.ZipHandler;
import blevi.autoszerviz.model.datatypes.Car;
import blevi.autoszerviz.model.datatypes.Client;
import blevi.autoszerviz.model.datatypes.Employee;
import blevi.autoszerviz.model.datatypes.Part;
import blevi.autoszerviz.model.datatypes.Repair;

public class Data implements DataAccessor, Serializable {
    boolean isLoading;
    private ArrayList<Employee> employees;
    private ArrayList<Client> clients;
    private ArrayList<Car> cars;
    private ArrayList<Repair> repairs;
    private ArrayList<Part> parts;

    public Data() {
        isLoading = false;
        employees = new ArrayList<>();
        clients = new ArrayList<>();
        cars = new ArrayList<>();
        repairs = new ArrayList<>();
        parts = new ArrayList<>();
    }
    
    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public List<Client> getClients() {
        return clients;
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public List<Repair> getRepairs() {
        return repairs;
    }

    @Override
    public List<Part> getParts() {
        return parts;
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);        
    }

    @Override
    public void addClient(Client client) {
        clients.add(client);
    }

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public void addRepair(Repair repair) {
        repairs.add(repair);
    }

    @Override
    public void addPart(Part part) {
        parts.add(part);
    }

    @Override
    public void write(String filepath, SerializationType type) {
        switch (type) {
            case ZIP:
                try {
                    ZipHandler.writeToZip(this, filepath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case XML:
                break;
            default:
                break;
        }
        
    }

    @Override
    public void load(String filepath, SerializationType type) {
        try {
            Data data = ZipHandler.loadFromZip(filepath);
            this.employees = new ArrayList<>(data.getEmployees());
            this.clients = new ArrayList<>(data.getClients());
            this.cars = new ArrayList<>(data.getCars());
            this.repairs = new ArrayList<>(data.getRepairs());
            this.parts = new ArrayList<>(data.getParts());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
