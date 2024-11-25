package blevi.autoszerviz.controller.wrappers;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import blevi.autoszerviz.model.datatypes.Employee;

public class EmployeeData extends AbstractTableModel {
    private List<Employee> employees;
    public EmployeeData(List<Employee> employees) {
        this.employees = employees;
    }
    @Override
    public int getColumnCount() {
        return 5;
    }
    @Override
    public int getRowCount() {
        return employees.size();
    }
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 1 :
                return "Name";
            case 2 :
                return "Phone number";
            case 3 :
                return "E-mail address";
            case 4 :
                return "Position";
            default :
                return "Index";
        }
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 1 :
                return employees.get(rowIndex).getName();
            case 2 :
                return employees.get(rowIndex).getNumber();
            case 3 :
                return employees.get(rowIndex).getEmail();
            case 4 :
                return employees.get(rowIndex).getPosition();
            default :
                return rowIndex + 1;
        }
    }

    public void addEmployeeData(Employee employee) {
        employees.add(employee);
    }
}
