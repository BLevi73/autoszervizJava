package blevi.autoszerviz.controller.logic;

import javax.swing.JOptionPane;

import blevi.autoszerviz.controller.filehandlers.SerializationType;
import blevi.autoszerviz.controller.listeners.*;
import blevi.autoszerviz.controller.wrappers.*;
import blevi.autoszerviz.model.datasources.Data;
import blevi.autoszerviz.model.datatypes.*;
import blevi.autoszerviz.view.dialogs.*;
import blevi.autoszerviz.view.frames.*;

/**
 * The main class of the controller layer, class has all the methods that
 * handles the UI calls, and provides data for the ui.
 * The listeners of the UI call the required methods of this class, which does
 * the calculations, and then updates the data in the model, and provides the
 * updated data for the UI.
 * 
 */
public class MainController {
    // Fields

    private ProgramConfig programConfig;
    private Data data;
    private MainFrame mainFrame;
    private EmployeeData employeeData;
    private ClientData clientData;
    private CarData carData;
    private RepairData repairData;
    private PartData partData;

    // Constructor
    /**
     * Constructs a MainController object, intializes it's fields with the given
     * parameters.
     * 
     * @param data          reference to the data
     * @param programConfig reference to the configuration data
     */
    public MainController(Data data, ProgramConfig programConfig) {
        this.programConfig = programConfig;
        this.data = data;
    }

    // Getters
    /**
     * Getter of the MainFrame.
     * 
     * @return reference of the MainFrame
     */
    public MainFrame getMainFrame() {
        return mainFrame;
    }

    /**
     * Getter of the ProgramConfig.
     * 
     * @return reference of the ProgramConfig
     */
    public ProgramConfig getProgramConfig() {
        return programConfig;
    }

    // Swing setup methods

    /**
     * Sets up the listeners of the UI elements to communicate with this
     * MainController instance.
     */
    private void setupListeners() {
        // File menu
        mainFrame.getMainMenuBar().getFileMenu().getNewMenuItem().addActionListener(new NewDataListener(this));
        mainFrame.getMainMenuBar().getFileMenu().getSaveMenuItem().addActionListener(new SaveDataListener(this));
        mainFrame.getMainMenuBar().getFileMenu().getOpenMenuItem().addActionListener(new OpenDataListener(this));
        mainFrame.getMainMenuBar().getFileMenu().getOpenAutosaveMenuItem()
                .addActionListener(new OpenAutosaveListener(this));
        mainFrame.getMainMenuBar().getFileMenu().getOpenExampleItem().addActionListener(new OpenExampleListener(this));
        mainFrame.getMainMenuBar().getFileMenu().getExportToXMLMenuItem()
                .addActionListener(new XMLExportListener(this));
        mainFrame.getMainMenuBar().getFileMenu().getExportToJSONMenuItem()
                .addActionListener(new JSONExportListener(this));
        mainFrame.getMainMenuBar().getFileMenu().getImportFromXMLMenuItem()
                .addActionListener(new XMLImportListener(this));
        mainFrame.getMainMenuBar().getFileMenu().getImportFromJSONMenuItem()
                .addActionListener(new JSONImportListener(this));
        // View menu
        mainFrame.getMainMenuBar().getViewMenu().getToolBarLock().addActionListener(new LockToolbarListener(this));
        // Preferences menu
        mainFrame.getMainMenuBar().getSettingsMenu().getPreferencesItem()
                .addActionListener(new PreferencesListener(this));
        // Toolbar menu
        mainFrame.getMainPanel().getMainToolBar().getAddButton().addActionListener(new AddButtonListener(this));
        mainFrame.getMainPanel().getMainToolBar().getRemoveButton().addActionListener(new RemoveButtonListener(this));
        mainFrame.getMainPanel().getMainToolBar().getEditButton().addActionListener(new EditButtonListener(this));
        mainFrame.getMainPanel().getMainToolBar().getQueryButton().addActionListener(new QueryButtonListener(this));
    }

    /**
     * Sets up the data for the tables in the MainFrame.
     */
    private void setupTables() {
        mainFrame.getMainPanel().getTablesTabbedPane().getEmployeesTable().setModel(employeeData);
        mainFrame.getMainPanel().getTablesTabbedPane().getClientsTable().setModel(clientData);
        mainFrame.getMainPanel().getTablesTabbedPane().getCarsTable().setModel(carData);
        mainFrame.getMainPanel().getTablesTabbedPane().getRepairsTable().setModel(repairData);
        mainFrame.getMainPanel().getTablesTabbedPane().getPartsTable().setModel(partData);
    }

    /**
     * Creates wrapped data, which is used by the tables in the MainFrame.
     */
    private void setupTableModels() {
        this.employeeData = new EmployeeData(data.getEmployees());
        this.clientData = new ClientData(data.getClients());
        this.carData = new CarData(data.getCars());
        this.repairData = new RepairData(data.getRepairs());
        this.partData = new PartData(data.getParts());
    }

    /**
     * Initializes the UI, and calls the setup methods.
     */
    public void init() {
        this.mainFrame = new MainFrame();
        this.setupListeners();
        this.setupTableModels();
        this.setupTables();
    }

    /**
     * Updates the information about the data in the MainInfoBar.
     */
    private void updateInfo() {
        mainFrame.getMainPanel().getMainInfoBar().getNumberOfEmployeesLabel()
                .setText(Integer.toString(data.getEmployees().size()));
        mainFrame.getMainPanel().getMainInfoBar().getNumberOfClientsLabel()
                .setText(Integer.toString(data.getClients().size()));
        mainFrame.getMainPanel().getMainInfoBar().getNumberOfCarsLabel()
                .setText(Integer.toString(data.getCars().size()));
        mainFrame.getMainPanel().getMainInfoBar().getNumberOfRepairsLabel()
                .setText(Integer.toString(data.getRepairs().size()));
        mainFrame.getMainPanel().getMainInfoBar().getNumberOfPartsLabel()
                .setText(Integer.toString(data.getParts().size()));
    }

    // Serialization methods

    /**
     * Creates a new data to work on.
     */
    public void newData() {
        data = new Data();
        mainFrame.getMainPanel().getMainInfoBar().getCurrentFileLabel().setText("-");
        mainFrame.getMainPanel().getMainInfoBar().getNumberOfEmployeesLabel().setText("0");
        this.setupTableModels();
        this.setupTables();
    }

    /**
     * Saves the data to a file.
     * 
     * @param filepath The absolute path of the file to be written
     * @param type     Determines the type of serialization for saving the data
     */
    public void saveData(String filepath, SerializationType type) {
        data.write(filepath, type);
        mainFrame.getMainPanel().getMainInfoBar().getCurrentFileLabel().setText(filepath);
    }

    /**
     * Loads the data to a file.
     * 
     * @param filepath The absolute path of the file to be loaded
     * @param type     Determines the type of serialization for loading the data
     */
    public void loadData(String filepath, SerializationType type) {
        data.load(filepath, type);
        mainFrame.getMainPanel().getMainInfoBar().getCurrentFileLabel().setText(filepath);
        updateInfo();
        this.setupTableModels();
        this.setupTables();
    }

    // Preferences window
    /**
     * Shows the preferences window.
     */
    public void openPreferences() {
        int returnVal = PreferencesDialog.showPreferencesDialog();
        if (returnVal == JOptionPane.YES_OPTION) {
            if (PreferencesDialog.getIntervalTextField().getText().isBlank()) {
                programConfig.setAutosaveInterval(PreferencesDialog.getSelectedInterval());
            } else {
                int customInterval = Integer.parseInt(PreferencesDialog.getIntervalTextField().getText());
                if (customInterval > 0) {
                    programConfig.setAutosaveInterval(customInterval);
                } else {
                    JOptionPane.showMessageDialog(null, "Custom interval must be larger than 0!", "Wrong input",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            programConfig.write();
        }
    }

    // Adders
    /**
     * Adds a new employee to the data.
     */
    public void addEmployee() {
        int returnVal = EmployeeDialog.showAddEmployeeDialog();
        if (returnVal == JOptionPane.YES_OPTION) {
            Employee toAdd = new Employee(EmployeeDialog.getIdNumberInputField().getText(),
                    EmployeeDialog.getNameInputField().getText(),
                    EmployeeDialog.getPhoneNumberInputField().getText(),
                    EmployeeDialog.getEmailInputField().getText(),
                    EmployeeDialog.getPositionInputField().getText());
            boolean operationSuccessful = true;
            if (!data.addEmployee(toAdd)) {
                operationSuccessful = false;
            }
            if (!operationSuccessful) {
                JOptionPane.showMessageDialog(null, "This employee is already in the database!", "Operation failed",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        employeeData.fireTableDataChanged();
        updateInfo();
    }

    /**
     * Adds a new client to the data.
     */
    public void addClient() {
        int returnVal = ClientDialog.showAddClientDialog();
        if (returnVal == JOptionPane.YES_OPTION) {
            Client toAdd = new Client(ClientDialog.getIdNumberInputField().getText(),
                    ClientDialog.getNameInputField().getText(),
                    ClientDialog.getPhoneNumberInputField().getText(),
                    ClientDialog.getEmailInputField().getText());
            boolean operationSuccessful = true;
            if (!data.addClient(toAdd)) {
                operationSuccessful = false;
            }
            if (!operationSuccessful) {
                JOptionPane.showMessageDialog(null, "This client is already in the database!", "Operation failed",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        clientData.fireTableDataChanged();
        updateInfo();
    }

    /**
     * Adds a new car to the data.
     */
    public void addCar() {
        carData.fireTableDataChanged();
        updateInfo();
    }

    /**
     * Adds a new repair to the data.
     */
    public void addRepair() {
        repairData.fireTableDataChanged();
        updateInfo();
    }

    /**
     * Adds a new part to the data.
     */
    public void addPart() {
        partData.fireTableDataChanged();
        updateInfo();
    }

    // Removers
    /**
     * Removes an employee from the data.
     */
    public void removeEmployee() {
        int selectedRow = mainFrame.getMainPanel().getTablesTabbedPane().getEmployeesTable().getSelectedRow();
        String idNumber = (String) mainFrame.getMainPanel().getTablesTabbedPane().getEmployeesTable()
                .getValueAt(selectedRow, 0);
        Employee toRemove = new Employee(idNumber, null, null, null, null);
        data.removeEmployee(toRemove);
        employeeData.fireTableDataChanged();
    }

    /**
     * Removes a client from the data.
     */
    public void removeClient() {
        int selectedRow = mainFrame.getMainPanel().getTablesTabbedPane().getClientsTable().getSelectedRow();
        String idNumber = (String) mainFrame.getMainPanel().getTablesTabbedPane().getClientsTable()
                .getValueAt(selectedRow, 0);
        Client toRemove = new Client(idNumber, null, null, null);
        data.removeClient(toRemove);
        clientData.fireTableDataChanged();
    }

    /**
     * Removes a car from the data.
     */
    public void removeCar() {
        int selectedRow = mainFrame.getMainPanel().getTablesTabbedPane().getCarsTable().getSelectedRow();
        String licencePlate = (String) mainFrame.getMainPanel().getTablesTabbedPane().getCarsTable()
                .getValueAt(selectedRow, 0);
        Car toRemove = new Car(licencePlate, null, null, null, null, null);
        data.removeCar(toRemove);
        carData.fireTableDataChanged();
    }

    /**
     * Removes a repair from the data.
     */
    public void removeRepair() {
        int selectedRow = mainFrame.getMainPanel().getTablesTabbedPane().getRepairsTable().getSelectedRow();
        String repairId = (String) mainFrame.getMainPanel().getTablesTabbedPane().getRepairsTable()
                .getValueAt(selectedRow, 0);
        Repair toRemove = new Repair(repairId, null, null, null);
        data.removeRepair(toRemove);
        repairData.fireTableDataChanged();
    }

    /**
     * Removes a part from the data.
     */
    public void removePart() {
        int selectedRow = mainFrame.getMainPanel().getTablesTabbedPane().getPartsTable().getSelectedRow();
        String serialNumber = (String) mainFrame.getMainPanel().getTablesTabbedPane().getRepairsTable()
                .getValueAt(selectedRow, 0);
        Part toRemove = new Part(serialNumber, null, null, null);
        data.removePart(toRemove);
        partData.fireTableDataChanged();
    }

    // Modifiers
    /**
     * Modifies an employee.
     */
    public void modifyEmployee() {
        int selectedRow = mainFrame.getMainPanel().getTablesTabbedPane().getEmployeesTable().getSelectedRow();
        String idNumber = (String) mainFrame.getMainPanel().getTablesTabbedPane().getEmployeesTable()
                .getValueAt(selectedRow, 0);
        Employee finder = new Employee(idNumber, null, null, null, null);
        Employee toEdit = data.getEmployees().get(data.getEmployees().indexOf(finder));
        int returnVal = EmployeeDialog.showModifyEmployeeDialog();
        if (returnVal == JOptionPane.YES_OPTION) {
            if (!EmployeeDialog.getNameInputField().getText().isBlank()) {
                toEdit.setName(EmployeeDialog.getNameInputField().getText());
            }
            if (!EmployeeDialog.getPhoneNumberInputField().getText().isBlank()) {
                toEdit.setPhoneNumber(EmployeeDialog.getPhoneNumberInputField().getText());
            }
            if (!EmployeeDialog.getEmailInputField().getText().isBlank()) {
                toEdit.setEmail(EmployeeDialog.getEmailInputField().getText());
            }
            if (!EmployeeDialog.getPositionInputField().getText().isBlank()) {
                toEdit.setPosition(EmployeeDialog.getPositionInputField().getText());
            }
        }
        employeeData.fireTableDataChanged();

    }

    /**
     * Modifies a client.
     */
    public void modifyClient() {
        int selectedRow = mainFrame.getMainPanel().getTablesTabbedPane().getClientsTable().getSelectedRow();
        String idNumber = (String) mainFrame.getMainPanel().getTablesTabbedPane().getClientsTable()
                .getValueAt(selectedRow, 0);
        Client finder = new Client(idNumber, null, null, null);
        Client toEdit = data.getClients().get(data.getClients().indexOf(finder));
        int returnVal = ClientDialog.showModifyClientDialog();
        if (returnVal == JOptionPane.YES_OPTION) {
            if (!ClientDialog.getNameInputField().getText().isBlank()) {
                toEdit.setName(ClientDialog.getNameInputField().getText());
            }
            if (!ClientDialog.getPhoneNumberInputField().getText().isBlank()) {
                toEdit.setPhoneNumber(ClientDialog.getPhoneNumberInputField().getText());
            }
            if (!ClientDialog.getEmailInputField().getText().isBlank()) {
                toEdit.setEmail(ClientDialog.getEmailInputField().getText());
            }
        }
        clientData.fireTableDataChanged();
    }

    /**
     * Modifies a car.
     */
    public void modifyCar() {

        carData.fireTableDataChanged();
    }

    /**
     * Modifies a repair.
     */
    public void modifyRepair() {

        repairData.fireTableDataChanged();
    }

    /**
     * Modifies a part.
     */
    public void modifyPart() {

        partData.fireTableDataChanged();
    }

    /**
     * Gets the index of the currently visbile tab in the MainFrame.
     * 
     * @return the index of the visible tab
     */
    public int getOpenedTab() {
        return mainFrame.getMainPanel().getTablesTabbedPane().getSelectedIndex();
    }

    /**
     * Locks the toolbar's position.
     */
    public void lockToolbar() {
        mainFrame.getMainPanel().getMainToolBar()
                .setFloatable(!mainFrame.getMainPanel().getMainToolBar().isFloatable());
    }

    // Query creators
    /**
     * Creates a query for the employees.
     */
    public void createEmployeeQuery() {
        int returnVal = EmployeeDialog.showEmployeeQueryDialog();
        Employee filter;
        EmployeeData filteredData;
        if (returnVal == JOptionPane.YES_OPTION) {
            filter = new Employee(EmployeeDialog.getIdNumberInputField().getText(),
                    EmployeeDialog.getNameInputField().getText(),
                    EmployeeDialog.getPhoneNumberInputField().getText(),
                    EmployeeDialog.getEmailInputField().getText(),
                    EmployeeDialog.getPositionInputField().getText());
            filteredData = employeeData.getFilteredData(filter);
            QueryFrame queryFrame = new QueryFrame();
            queryFrame.getTable().setModel(filteredData);
            queryFrame.getFoundRecords().setText("Found records: " + Integer.toString(filteredData.getRowCount()));
        }
    }

    /**
     * Creates a query for the clients.
     */
    public void createClientQuery() {
        int returnVal = ClientDialog.showClientQueryDialog();
        Client filter;
        ClientData filteredData;
        if (returnVal == JOptionPane.YES_OPTION) {
            filter = new Client(ClientDialog.getIdNumberInputField().getText(),
                    ClientDialog.getNameInputField().getText(),
                    ClientDialog.getPhoneNumberInputField().getText(),
                    ClientDialog.getEmailInputField().getText());
            filteredData = clientData.getFilteredData(filter);
            QueryFrame queryFrame = new QueryFrame();
            queryFrame.getTable().setModel(filteredData);
            queryFrame.getFoundRecords().setText("Found records: " + Integer.toString(filteredData.getRowCount()));
        }
    }
}