package blevi.autoszerviz.controller.filehandlers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import blevi.autoszerviz.model.datasources.Data;
import blevi.autoszerviz.model.datatypes.Employee;

public class ZipHandlerTest {
    @Test
    public void readWriteTest() {
        Data data = new Data();
        data.addEmployee(new Employee("001","John Doe", "555-123456","john@example.com","Leader"));
        data.write("src/test/resources/ziptest.zip", SerializationType.ZIP);
        data = new Data();
        data.load("src/test/resources/ziptest.zip", SerializationType.ZIP);
        Data expected = new Data();
        expected.addEmployee(new Employee("001","John Doe", "555-123456","john@example.com","Leader"));
        assertEquals(expected.getEmployees(), data.getEmployees());
    }
}
