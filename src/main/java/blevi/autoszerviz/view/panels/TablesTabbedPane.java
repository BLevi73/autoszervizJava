package blevi.autoszerviz.view.panels;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TablesTabbedPane extends JTabbedPane {
    JTable employeesTable;
    JTable clientsTable;
    JTable carsTable;
    JTable repairsTable;
    JTable partsTable;
    public TablesTabbedPane() {
        employeesTable = new JTable();
        employeesTable.setAutoCreateRowSorter(true);
        employeesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        clientsTable = new JTable();
        clientsTable.setAutoCreateRowSorter(true);
        clientsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        carsTable = new JTable();
        carsTable.setAutoCreateRowSorter(true);
        carsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        repairsTable = new JTable();
        repairsTable.setAutoCreateRowSorter(true);
        repairsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        partsTable = new JTable();
        partsTable.setAutoCreateRowSorter(true);
        partsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.addTab("Employees",new JScrollPane(employeesTable));
        this.addTab("Clients",new JScrollPane(clientsTable));
        this.addTab("Cars",new JScrollPane(carsTable));
        this.addTab("Repairs",new JScrollPane(repairsTable));
        this.addTab("Parts in stash",new JScrollPane(partsTable));
    }

    public JTable getEmployeesTable() {
        return employeesTable;
    }
    public JTable getClientsTable() {
        return clientsTable;
    }
    public JTable getCarsTable() {
        return carsTable;
    }
    public JTable getRepairsTable() {
        return repairsTable;
    }
    public JTable getPartsTable() {
        return partsTable;
    }
}
