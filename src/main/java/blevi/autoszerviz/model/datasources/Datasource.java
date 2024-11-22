package blevi.autoszerviz.model.datasources;

import java.io.File;
import java.util.List;

import blevi.autoszerviz.model.datatypes.Car;
import blevi.autoszerviz.model.datatypes.Client;
import blevi.autoszerviz.model.datatypes.Employee;
import blevi.autoszerviz.model.datatypes.Part;
import blevi.autoszerviz.model.datatypes.Repair;

public interface Datasource {

    public List<Employee> getEmployees();
    
    public List<Client> getClients();
    
    public List<Car> getCars();
    
    public List<Repair> getRepairs();
    
    public List<Part> getParts();
    
    public void addEmployee(Employee employee);

    public void addClient(Client client);

    public void addCar(Car car);

    public void addRepair(Repair repair);

    public void addPart(Part part);

    public void write();

    public void load(String filepath);
}
