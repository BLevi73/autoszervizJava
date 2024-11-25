package blevi.autoszerviz.controller.logic;

import blevi.autoszerviz.controller.filehandlers.SerializationType;
import blevi.autoszerviz.controller.listeners.AddButtonListener;
import blevi.autoszerviz.controller.listeners.NewMenuItemListener;
import blevi.autoszerviz.controller.listeners.OpenAutosaveMenuItemListener;
import blevi.autoszerviz.controller.listeners.OpenMenuItemListener;
import blevi.autoszerviz.controller.listeners.SaveMenuItemListener;
import blevi.autoszerviz.controller.wrappers.ClientData;
import blevi.autoszerviz.controller.wrappers.EmployeeData;
import blevi.autoszerviz.model.datasources.Data;
import blevi.autoszerviz.view.dialogs.AddEmployeeDialog;
import blevi.autoszerviz.view.frames.MainFrame;

public class MainController {
    private Data data;
    private MainFrame mainFrame;
    private EmployeeData employeeData;
    private ClientData clientData;
    
    public MainController() {
        this.data = new Data();
        this.mainFrame = new MainFrame();
    }

    private void setupListeners() {
        mainFrame.getMainMenuBar().getFileMenu().getNewMenuItem().addActionListener(new NewMenuItemListener(this));
        mainFrame.getMainMenuBar().getFileMenu().getSaveMenuItem().addActionListener(new SaveMenuItemListener(this));
        mainFrame.getMainMenuBar().getFileMenu().getOpenMenuItem().addActionListener(new OpenMenuItemListener(this));
        mainFrame.getMainMenuBar().getFileMenu().getOpenAutosaveMenuItem().addActionListener(new OpenAutosaveMenuItemListener(this));
        mainFrame.getMainPanel().getMainToolBar().getAddButton().addActionListener(new AddButtonListener(this));
    }
    private void setupTables() {
        mainFrame.getMainPanel().getTablesTabbedPane().getEmployeesTable().setModel(employeeData);
        mainFrame.getMainPanel().getTablesTabbedPane().getClientsTable().setModel(clientData);
    }

    private void setupTableModels() {
        this.employeeData = new EmployeeData(data.getEmployees());
        this.clientData = new ClientData(data.getClients());
    }

    public void init() {
        this.setupListeners();
        this.setupTableModels();
        this.setupTables();
    }

    public void newData() {
        data = new Data();
        this.setupTableModels();
        this.setupTables();
    }
    public void saveData(String filepath, SerializationType type) {
        synchronized(data) {
            data.write(filepath, type);
        }
    }
    public void loadData(String filepath, SerializationType type) {
        synchronized(data) {
            data.load(filepath, type);
        }
        mainFrame.getMainPanel().getMainInfoBar().getCurrentFileLabel().setText(filepath);
        this.setupTableModels();
        this.setupTables();
    }

    public void addElementEvent() {
        int openedTabIndex = mainFrame.getMainPanel().getTablesTabbedPane().getSelectedIndex();
        switch (openedTabIndex) {
            case 0:
                AddEmployeeDialog addEmployeeDialog = new AddEmployeeDialog();
                break;
        
            default:
                break;
        }
    }
}