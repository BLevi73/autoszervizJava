package blevi.autoszerviz.model.datasources;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import blevi.autoszerviz.model.datatypes.Car;
import blevi.autoszerviz.model.datatypes.Client;
import blevi.autoszerviz.model.datatypes.Employee;
import blevi.autoszerviz.model.datatypes.Part;
import blevi.autoszerviz.model.datatypes.Repair;

public class DataTest {
    @Test
    public void addEmployeeTest() {
        Data data = new Data();
        data.addEmployee(new Employee("1","Peter","1234567","peter@example.com","Mechanic"));
        List<Employee> expected = new ArrayList<>();
        expected.add(new Employee("1","Peter","1234567","peter@example.com","Mechanic"));
        assertEquals(expected, data.getEmployees());
    }
    @Test
    public void addClientTest() {
        Data data = new Data();
        data.addClient(new Client("1","Peter","1234567","peter@example.com"));
        List<Client> expected = new ArrayList<>();
        expected.add(new Client("1","Peter","1234567","peter@example.com"));
        assertEquals(expected, data.getClients());
    }
    @Test
    public void addCarTest() {
        Data data = new Data();
        data.addCar(new Car("ABC123", 2000, "Toyota", "Corolla", "Hatchback", 150));
        List<Car> expected = new ArrayList<>();
        expected.add(new Car("ABC123", 2000, "Toyota", "Corolla", "Hatchback", 150));
        assertEquals(expected, data.getCars());
    }
    @Test
    public void addRepairTest() {
        Data data = new Data();
        data.addRepair(new Repair("1", "Engine swap", 2000, "2000-01-01"));
        List<Repair> expected = new ArrayList<>();
        expected.add(new Repair("1", "Engine swap", 2000, "2000-01-01"));
        assertEquals(expected, data.getRepairs());
    }
    @Test
    public void addPartTest() {
        Data data = new Data();
        data.addPart(new Part("1", "Garrett", "T4", "Turbocharger"));
        List<Part> expected = new ArrayList<>();
        expected.add(new Part("1", "Garrett", "T4", "Turbocharger"));
        assertEquals(expected, data.getParts());
    }
    @Test
    public void removeEmployeeTest() {
        Data data = new Data();
        data.addEmployee(new Employee("1","Peter","1234567","peter@example.com","Mechanic"));
        data.removeEmployee(new Employee("1", null, null, null, null));
        List<Employee> expected = new ArrayList<>();
        assertEquals(expected, data.getEmployees());
    }
    @Test
    public void removeClientTest() {
        Data data = new Data();
        data.addClient(new Client("1","Peter","1234567","peter@example.com"));
        data.removeClient(new Client("1", null, null, null));
        List<Client> expected = new ArrayList<>();
        assertEquals(expected, data.getClients());
    }
    @Test
    public void removeCarTest() {
        Data data = new Data();
        data.addCar(new Car("ABC123", 2000, "Toyota", "Corolla", "Hatchback", 150));
        data.removeCar(new Car("ABC123", null, null, null, null, null));
        List<Car> expected = new ArrayList<>();
        assertEquals(expected, data.getCars());
    }
    @Test
    public void removeRepairTest() {
        Data data = new Data();
        data.addRepair(new Repair("1", "Engine swap", 2000, "2000-01-01"));
        data.removeRepair(new Repair("1", null, null, null));
        List<Repair> expected = new ArrayList<>();
        assertEquals(expected, data.getRepairs());
    }
    @Test
    public void removePartTest() {
        Data data = new Data();
        data.addPart(new Part("1", "Garrett", "T4", "Turbocharger"));
        data.removePart(new Part("1", null, null, null));
        List<Part> expected = new ArrayList<>();
        assertEquals(expected, data.getParts());
    }
}
