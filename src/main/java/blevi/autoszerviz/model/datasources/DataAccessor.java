package blevi.autoszerviz.model.datasources;

import java.util.List;

import blevi.autoszerviz.controller.filehandlers.SerializationType;
import blevi.autoszerviz.model.datatypes.Car;
import blevi.autoszerviz.model.datatypes.Client;
import blevi.autoszerviz.model.datatypes.Employee;
import blevi.autoszerviz.model.datatypes.Part;
import blevi.autoszerviz.model.datatypes.Repair;

public interface DataAccessor {

    public List<Employee> getEmployees();
    public List<Client> getClients();
    public List<Car> getCars();
    public List<Repair> getRepairs();
    public List<Part> getParts();

    public boolean addEmployee(Employee employee);
    public boolean addClient(Client client);
    public boolean addCar(Car car);
    public boolean addRepair(Repair repair);
    public boolean addPart(Part part);

    public void removeEmployee(Employee employee);
    public void removeClient(Client client);
    public void removeCar(Car car);
    public void removeRepair(Repair repair);
    public void removePart(Part part);

    public void write(String filepath, SerializationType type);
    public void load(String filepath, SerializationType type);
}
