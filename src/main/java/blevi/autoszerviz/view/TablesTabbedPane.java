package blevi.autoszerviz.view;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import blevi.autoszerviz.controller.LogicAccessInterface;

public class TablesTabbedPane extends JTabbedPane {
    public TablesTabbedPane() {
        this.addTab("Employees",new JScrollPane(new JTable(LogicAccessInterface.getEmployeesData())));
        this.addTab("Clients",new JScrollPane(new JTable(LogicAccessInterface.getClientsData())));
        this.addTab("Cars",new JTable());
        this.addTab("Parts",new JTable());
        this.addTab("Repairs",new JTable());
    }
}
