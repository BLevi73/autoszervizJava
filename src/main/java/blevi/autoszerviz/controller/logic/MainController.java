package blevi.autoszerviz.controller.logic;

import javax.swing.JOptionPane;

import blevi.autoszerviz.controller.filehandlers.SerializationType;
import blevi.autoszerviz.controller.listeners.*;
import blevi.autoszerviz.controller.wrappers.*;
import blevi.autoszerviz.model.datasources.Data;
import blevi.autoszerviz.model.datatypes.*;
import blevi.autoszerviz.view.dialogs.*;
import blevi.autoszerviz.view.frames.*;

public class MainController {
    private Data data;
    private MainFrame mainFrame;
    private EmployeeData employeeData;
    private ClientData clientData;
    private CarData carData;
    private RepairData repairData;
    private PartData partData;

    public MainController() {
        this.data = new Data();
        this.mainFrame = new MainFrame();
    }

    private void setupListeners() {
        mainFrame.getMainMenuBar().getFileMenu().getNewMenuItem().addActionListener(new NewDataListener(this));
        mainFrame.getMainMenuBar().getFileMenu().getSaveMenuItem().addActionListener(new SaveDataListener(this));
        mainFrame.getMainMenuBar().getFileMenu().getOpenMenuItem().addActionListener(new OpenDataListener(this));
        mainFrame.getMainMenuBar().getFileMenu().getOpenAutosaveMenuItem()
                .addActionListener(new OpenAutosaveListener(this));
        mainFrame.getMainMenuBar().getFileMenu().getExportToXMLMenuItem()
                .addActionListener(new XMLExportListener(this));
        mainFrame.getMainMenuBar().getViewMenu().getToolBarLock().addActionListener(new LockToolbarListener(this));
        mainFrame.getMainPanel().getMainToolBar().getAddButton().addActionListener(new AddButtonListener(this));
        mainFrame.getMainPanel().getMainToolBar().getQueryButton().addActionListener(new QueryButtonListener(this));

    }

    private void setupTables() {
        mainFrame.getMainPanel().getTablesTabbedPane().getEmployeesTable().setModel(employeeData);
        mainFrame.getMainPanel().getTablesTabbedPane().getClientsTable().setModel(clientData);
        mainFrame.getMainPanel().getTablesTabbedPane().getCarsTable().setModel(carData);
        mainFrame.getMainPanel().getTablesTabbedPane().getRepairsTable().setModel(repairData);
        mainFrame.getMainPanel().getTablesTabbedPane().getPartsTable().setModel(partData);
    }

    private void setupTableModels() {
        this.employeeData = new EmployeeData(data.getEmployees());
        this.clientData = new ClientData(data.getClients());
        this.carData = new CarData(data.getCars());
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
        synchronized (data) {
            data.write(filepath, type);
        }
    }

    public void loadData(String filepath, SerializationType type) {
        synchronized (data) {
            data.load(filepath, type);
        }
        mainFrame.getMainPanel().getMainInfoBar().getCurrentFileLabel().setText(filepath);
        this.setupTableModels();
        this.setupTables();
    }

    public void addEmployee() {
        int returnVal = EmployeeDialog.showAddEmployeeDialog();
        if (returnVal == JOptionPane.YES_OPTION) {
            synchronized (data) {
                employeeData.addEmployeeData(new Employee(EmployeeDialog.getIdNumberInputField().getText(),
                        EmployeeDialog.getNameInputField().getText(),
                        EmployeeDialog.getPhoneNumberInputField().getText(),
                        EmployeeDialog.getEmailInputField().getText(),
                        EmployeeDialog.getPositionInputField().getText()));
            }
        }

    }

    public int getOpenedTab() {
        return mainFrame.getMainPanel().getTablesTabbedPane().getSelectedIndex();
    }

    public void lockToolbar() {
        mainFrame.getMainPanel().getMainToolBar()
                .setFloatable(!mainFrame.getMainPanel().getMainToolBar().isFloatable());
    }

    public void createEmployeeQuery() {
        int returnVal = EmployeeQueryDialog.showEmployeeQueryDialog();
        Employee filter;
        EmployeeData filteredData;
        if (returnVal == JOptionPane.YES_OPTION) {
            filter = new Employee(EmployeeQueryDialog.getIdNumberInputField().getText(),
                    EmployeeQueryDialog.getNameInputField().getText(),
                    EmployeeQueryDialog.getPhoneNumberInputField().getText(),
                    EmployeeQueryDialog.getEmailInputField().getText(),
                    EmployeeQueryDialog.getPositionInputField().getText());
            filteredData = new EmployeeData(employeeData.getFilteredData(filter));
            QueryFrame queryFrame = new QueryFrame();
            queryFrame.getTable().setModel(filteredData);
        }
    }

    public void createClientQuery() {
        
    }
}