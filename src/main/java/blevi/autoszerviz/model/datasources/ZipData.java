package blevi.autoszerviz.model.datasources;

import java.util.ArrayList;

import blevi.autoszerviz.model.datatypes.Car;
import blevi.autoszerviz.model.datatypes.Client;
import blevi.autoszerviz.model.datatypes.Employee;
import blevi.autoszerviz.model.datatypes.Part;
import blevi.autoszerviz.model.datatypes.Repair;

public class ZipData implements Datasource {
    private ArrayList<Employee> employees;
    private ArrayList<Client> clients;
    private ArrayList<Car> cars;
    private ArrayList<Repair> repairs;
    private ArrayList<Part> parts;
}
