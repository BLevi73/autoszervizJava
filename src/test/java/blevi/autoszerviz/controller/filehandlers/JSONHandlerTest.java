package blevi.autoszerviz.controller.filehandlers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import blevi.autoszerviz.model.datasources.Data;
import blevi.autoszerviz.model.datatypes.Employee;

public class JSONHandlerTest {
    
    @Test
    public void readWriteTest() {
        Data data = new Data();
        data.addEmployee(new Employee("001","John Doe", "555-123456","john@example.com","Leader"));
        data.write("src/test/resources/jsontest.json", SerializationType.JSON);
        data = new Data();
        data.load("src/test/resources/jsontest.json", SerializationType.JSON);
        Data expected = new Data();
        expected.addEmployee(new Employee("001","John Doe", "555-123456","john@example.com","Leader"));
        assertEquals(expected.getEmployees(), data.getEmployees());
    }
}
