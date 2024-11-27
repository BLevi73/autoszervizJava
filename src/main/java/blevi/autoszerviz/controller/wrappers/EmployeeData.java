package blevi.autoszerviz.controller.wrappers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import blevi.autoszerviz.model.datatypes.Employee;
import blevi.autoszerviz.view.dialogs.EmployeeQueryDialog;

public class EmployeeData extends AbstractTableModel implements Filterable<Employee> {
    private List<Employee> employees;

    public EmployeeData(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return employees.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 1:
                return "Identification number";
            case 2:
                return "Name";
            case 3:
                return "Phone number";
            case 4:
                return "E-mail address";
            case 5:
                return "Position";
            default:
                return "Index";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 1:
                return employees.get(rowIndex).getIdNumber();
            case 2:
                return employees.get(rowIndex).getName();
            case 3:
                return employees.get(rowIndex).getPhoneNumber();
            case 4:
                return employees.get(rowIndex).getEmail();
            case 5:
                return employees.get(rowIndex).getPosition();
            default:
                return rowIndex + 1;
        }
    }

    public void addEmployeeData(Employee employee) {
        employees.add(employee);
        fireTableDataChanged();
    }

    public List<Employee> getFilteredData(Employee filter) {
        List<Employee> filteredData = new ArrayList<>();
        boolean idNumberFilterFlag;
        boolean nameFilterFlag;
        boolean phoneNumberFilterFlag;
        boolean emailFilterFlag;
        boolean positionFilterFlag;
        for (Employee employeeElement : employees) {
            idNumberFilterFlag = evaluateIdNumberFilter(employeeElement, filter);
            nameFilterFlag = evaluateNameFilter(employeeElement, filter);
            phoneNumberFilterFlag = evaluatePhoneNumberFilter(employeeElement, filter);
            emailFilterFlag = evaluateEmailFilter(employeeElement, filter);
            positionFilterFlag = evaluatePositionFilter(employeeElement, filter);
            if (idNumberFilterFlag && nameFilterFlag && phoneNumberFilterFlag && emailFilterFlag && positionFilterFlag) {
                filteredData.add(employeeElement);
            }
        }
        return filteredData;
    }

    private boolean evaluateIdNumberFilter(Employee element, Employee filter) {
        if (filter.getIdNumber().isBlank()) {
            return true;
        } else {
            switch (EmployeeQueryDialog.getIdNumberOrdering()) {
                case 1:
                    return element.getIdNumber().compareTo(filter.getIdNumber()) < 0;
                case 2:
                    return element.getIdNumber().compareTo(filter.getIdNumber()) > 0;
                default:
                    return element.getIdNumber().compareTo(filter.getIdNumber()) == 0;
            }
        }
    }
    private boolean evaluateNameFilter(Employee element, Employee filter) {
        if (filter.getName().isBlank()) {
            return true;
        } else {
            switch (EmployeeQueryDialog.getNameOrdering()) {
                case 1:
                    return element.getName().compareTo(filter.getName()) < 0;
                case 2:
                    return element.getName().compareTo(filter.getName()) > 0;
                default:
                    return element.getName().compareTo(filter.getName()) == 0;
            }
        }
    }
    private boolean evaluatePhoneNumberFilter(Employee element, Employee filter) {
        if (filter.getPhoneNumber().isBlank()) {
            return true;
        } else {
            switch (EmployeeQueryDialog.getPhoneNumberOrdering()) {
                case 1:
                    return element.getPhoneNumber().compareTo(filter.getPhoneNumber()) < 0;
                case 2:
                    return element.getPhoneNumber().compareTo(filter.getPhoneNumber()) > 0;
                default:
                    return element.getPhoneNumber().compareTo(filter.getPhoneNumber()) == 0;
            }
        }
    }
    private boolean evaluateEmailFilter(Employee element, Employee filter) {
        if (filter.getEmail().isBlank()) {
            return true;
        } else {
            switch (EmployeeQueryDialog.getEmailOrdering()) {
                case 1:
                    return element.getEmail().compareTo(filter.getEmail()) < 0;
                case 2:
                    return element.getEmail().compareTo(filter.getEmail()) > 0;
                default:
                    return element.getEmail().compareTo(filter.getEmail()) == 0;
            }
        }
    }
    private boolean evaluatePositionFilter(Employee element, Employee filter) {
        if (filter.getPosition().isBlank()) {
            return true;
        } else {
            switch (EmployeeQueryDialog.getPositionOrdering()) {
                case 1:
                    return element.getPosition().compareTo(filter.getPosition()) < 0;
                case 2:
                    return element.getPosition().compareTo(filter.getPosition()) > 0;
                default:
                    return element.getPosition().compareTo(filter.getPosition()) == 0;
            }
        }
    }
}
