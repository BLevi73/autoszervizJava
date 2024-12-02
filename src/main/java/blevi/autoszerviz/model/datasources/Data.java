package blevi.autoszerviz.model.datasources;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import blevi.autoszerviz.controller.filehandlers.JSONHandler;
import blevi.autoszerviz.controller.filehandlers.SerializationType;
import blevi.autoszerviz.controller.filehandlers.XMLHandler;
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

    private static void lock() {
        isLocked = true;
    }

    private static void unlock() {
        isLocked = false;
    }

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

    @Override
    public synchronized void addClient(Client client) {
        clients.add(client);
    }

    @Override
    public synchronized void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public synchronized void addRepair(Repair repair) {
        repairs.add(repair);
    }

    @Override
    public synchronized void addPart(Part part) {
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
                try {
                    XMLHandler.writeToXML(this, filepath);
                } catch (Exception e) {
                    e.printStackTrace();
                    unlock();
                }
                break;
            default:
                try {
                    JSONHandler.writeToJSON(this, filepath);
                } catch (Exception e) {
                    e.printStackTrace();
                    unlock();
                }
                break;
        }
        unlock();
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
        lock();
        switch (type) {
            case ZIP:
                try {
                    Data tmp = ZipHandler.readFromZip(filepath);
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
                break;
            default:
                Data tmp = JSONHandler.readFromJSON(filepath);
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
