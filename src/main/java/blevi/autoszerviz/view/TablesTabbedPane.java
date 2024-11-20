package blevi.autoszerviz.view;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import blevi.autoszerviz.model.wrappers.EmployeeData;

public class TablesTabbedPane extends JTabbedPane {
    public TablesTabbedPane() {
        this.addTab("Employees",new JScrollPane(new JTable(new EmployeeData())));
        this.addTab("Clients",new JTable());
        this.addTab("Cars",new JTable());
        this.addTab("Motorcycles",new JTable());
        this.addTab("Parts",new JTable());
    }
}
