package blevi.autoszerviz.model.datasources;

import java.io.IOException;
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
    private static boolean isLocked = false;
    private ArrayList<Employee> employees;
    private ArrayList<Client> clients;
    private ArrayList<Car> cars;
    private ArrayList<Repair> repairs;
    private ArrayList<Part> parts;

    public Data() {
        employees = new ArrayList<>();
        clients = new ArrayList<>();
        cars = new ArrayList<>();
        repairs = new ArrayList<>();
        parts = new ArrayList<>();
    }

    public static boolean isLocked() {
        return isLocked;
    }
    public static void setLocked(boolean isLocked) {
        Data.isLocked = isLocked;
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

    public void setEmployees(List<Employee> employees) {
        this.employees = new ArrayList<>(employees);
    }
    public void setClients(List<Client> clients) {
        this.clients = new ArrayList<>(clients);
    }
    public void setCars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }
    public void setRepairs(List<Repair> repairs) {
        this.repairs = new ArrayList<>(repairs);
    }
    public void setParts(List<Part> parts) {
        this.parts = new ArrayList<>(parts);
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
    public synchronized void write(String filepath, SerializationType type) {
        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        setLocked(true);
        switch (type) {
            case ZIP:
                try {
                    ZipHandler.writeToZip(this, filepath);
                } catch (IOException e) {
                    e.printStackTrace();
                    setLocked(false);
                }
                break;
            case XML:
                break;
            default:
                break;
        }
        setLocked(false);
        notifyAll();
    }

    @Override
    public synchronized void load(String filepath, SerializationType type) {
        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        setLocked(true);
        switch (type) {
            case ZIP:
                try {
                    Data tmp = ZipHandler.loadFromZip(filepath);
                    this.setEmployees(tmp.getEmployees());
                    this.setClients(tmp.getClients());
                    this.setCars(tmp.getCars());
                    this.setRepairs(tmp.getRepairs());
                    this.setParts(tmp.getParts());
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        setLocked(false);
        notifyAll();
    }
}
