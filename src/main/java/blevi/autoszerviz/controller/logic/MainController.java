package blevi.autoszerviz.controller.logic;

import blevi.autoszerviz.controller.filehandlers.SerializationType;
import blevi.autoszerviz.controller.listeners.OpenMenuItemListener;
import blevi.autoszerviz.controller.listeners.SaveMenuItemListener;
import blevi.autoszerviz.controller.wrappers.ClientData;
import blevi.autoszerviz.controller.wrappers.EmployeeData;
import blevi.autoszerviz.model.datasources.Data;
import blevi.autoszerviz.model.datatypes.Employee;
import blevi.autoszerviz.view.frames.MainFrame;

public class MainController {
    private Data data;
    private MainFrame mainFrame;
    
    public MainController() {
        this.data = new Data();
        this.mainFrame = new MainFrame();
        data.addEmployee(new Employee("id", "name", "number", "null", "position"));
    }

    public void setupListeners() {
        mainFrame.getMainMenuBar().getFileMenu().getSaveMenuItem().addActionListener(new SaveMenuItemListener(this));
        mainFrame.getMainMenuBar().getFileMenu().getOpenMenuItem().addActionListener(new OpenMenuItemListener(this));
    }
    public void setupTables() {
        mainFrame.getMainPanel().getTablesTabbedPane().getEmployeesTable().setModel(new EmployeeData(data.getEmployees()));
        mainFrame.getMainPanel().getTablesTabbedPane().getEmployeesTable().setModel(new ClientData(data.getClients()));
    }

    public void newData() {
        this.data = new Data();
    }
    public void saveData(String filepath, SerializationType type) {
        data.write(filepath, type);
    }
    public void loadData(String filepath, SerializationType type) {
        data.load(filepath, type);
        mainFrame.getMainPanel().getMainInfoBar().getCurrentFileLabel().setText(filepath);
    }

    public void addElementEvent() {
        
    }
}