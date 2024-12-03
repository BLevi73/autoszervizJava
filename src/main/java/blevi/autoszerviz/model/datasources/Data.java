package blevi.autoszerviz.model.datasources;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import blevi.autoszerviz.controller.filehandlers.*;
import blevi.autoszerviz.model.datatypes.*;

/**
 * Data class, contains the lists of employees, clients, cars, repairs and parts.
 */
public class Data implements DataAccessor, Serializable {
    // Fields
    private static boolean isLocked = false;
    private ArrayList<Employee> employees;
    private ArrayList<Client> clients;
    private ArrayList<Car> cars;
    private ArrayList<Repair> repairs;
    private ArrayList<Part> parts;

    // Constructor
    public Data() {
        employees = new ArrayList<>();
        clients = new ArrayList<>();
        cars = new ArrayList<>();
        repairs = new ArrayList<>();
        parts = new ArrayList<>();
    }

    // Synchronization lock methods
    /**
     * Locks writing and reading on the data.
     */
    private static void lock() {
        isLocked = true;
    }

    /**
     * Unlocks the lock if it was set.
     */
    private static void unlock() {
        isLocked = false;
    }

    // Getters
    @Override
    public synchronized List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public synchronized List<Client> getClients() {
        return clients;
    }

    @Override
    public synchronized List<Car> getCars() {
        return cars;
    }

    @Override
    public synchronized List<Repair> getRepairs() {
        return repairs;
    }

    @Override
    public synchronized List<Part> getParts() {
        return parts;
    }

    // Setters
    public synchronized void setEmployees(List<Employee> employees) {
        this.employees = new ArrayList<>(employees);
    }

    public synchronized void setClients(List<Client> clients) {
        this.clients = new ArrayList<>(clients);
    }

    public synchronized void setCars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public synchronized void setRepairs(List<Repair> repairs) {
        this.repairs = new ArrayList<>(repairs);
    }

    public synchronized void setParts(List<Part> parts) {
        this.parts = new ArrayList<>(parts);
    }

    // Adders
    /**
     * Adds a new employee.
     */
    @Override
    public synchronized boolean addEmployee(Employee employee) {
        for (Employee element : employees) {
            if (element.equals(employee)) {
                return false;
            }
        }
        employees.add(employee);
        return true;
    }

    /**
     * Adds a new client.
     */
    @Override
    public synchronized boolean addClient(Client client) {
        for (Client element : clients) {
            if (element.equals(client)) {
                return false;
            }
        }
        clients.add(client);
        return true;
    }

    /**
     * Adds a new car.
     */
    @Override
    public synchronized boolean addCar(Car car) {
        for (Car element : cars) {
            if (element.equals(car)) {
                return false;
            }
        }
        cars.add(car);
        return true;
    }

    /**
     * Adds a new repair.
     */
    @Override
    public synchronized boolean addRepair(Repair repair) {
        for (Repair element : repairs) {
            if (element.equals(repair)) {
                return false;
            }
        }
        repairs.add(repair);
        return true;
    }

    /**
     * Adds a new part.
     */
    @Override
    public synchronized boolean addPart(Part part) {
        for (Part element : parts) {
            if (element.equals(part)) {
                return false;
            }
        }
        parts.add(part);
        return true;
    }

    // Removers
    /**
     * Removes an employee from the data.
     */
    @Override
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    /**
     * Removes a client from the data.
     */
    @Override
    public void removeClient(Client client) {
        clients.remove(client);
    }

    /**
     * Removes a car from the data.
     */
    @Override
    public void removeCar(Car car) {
        cars.remove(car);
    }

    /**
     * Removes a repair from the data.
     */
    @Override
    public void removeRepair(Repair repair) {
        repairs.remove(repair);
    }

    /**
     * Removes a part from the data.
     */
    @Override
    public void removePart(Part part) {
        parts.remove(part);
    }

    // Serialization methods
    /**
     * Calls the required data writing function depending on the serialization type.
     */
    @Override
    public synchronized void write(String filepath, SerializationType type) {
        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        lock();
        switch (type) {
            case ZIP:
                try {
                    ZipHandler.writeToZip(this, filepath);
                } catch (IOException e) {
                    e.printStackTrace();
                    unlock();
                }
                break;
            case XML:
                XMLHandler.writeToXML(this, filepath);
                break;
            default:
                JSONHandler.writeToJSON(this, filepath);
                break;
        }
        unlock();
        notifyAll();
    }

    /**
     * Calls the required data loading function depending on the serialization type.
     */
    @Override
    public synchronized void load(String filepath, SerializationType type) {
        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        lock();
        Data tmp;
        switch (type) {
            case ZIP:
                try {
                    tmp = ZipHandler.readFromZip(filepath);
                    this.setEmployees(tmp.getEmployees());
                    this.setClients(tmp.getClients());
                    this.setCars(tmp.getCars());
                    this.setRepairs(tmp.getRepairs());
                    this.setParts(tmp.getParts());
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    unlock();
                }
                break;
            case XML:
                tmp = XMLHandler.readFromXML(filepath);
                this.setEmployees(tmp.getEmployees());
                this.setClients(tmp.getClients());
                this.setCars(tmp.getCars());
                this.setRepairs(tmp.getRepairs());
                this.setParts(tmp.getParts());
                break;
            default:
                tmp = JSONHandler.readFromJSON(filepath);
                this.setEmployees(tmp.getEmployees());
                this.setClients(tmp.getClients());
                this.setCars(tmp.getCars());
                this.setRepairs(tmp.getRepairs());
                this.setParts(tmp.getParts());
                break;
        }
        unlock();
        notifyAll();
    }
}
