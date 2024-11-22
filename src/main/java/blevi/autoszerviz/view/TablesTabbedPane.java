package blevi.autoszerviz.view;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class TablesTabbedPane extends JTabbedPane {
    public TablesTabbedPane() {
        this.addTab("Employees",new JScrollPane(new JTable()));
        this.addTab("Clients",new JScrollPane(new JTable()));
        this.addTab("Cars",new JScrollPane(new JTable()));
        this.addTab("Parts",new JScrollPane(new JTable()));
        this.addTab("Repairs",new JScrollPane(new JTable()));
    }
}
