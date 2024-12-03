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
        int returnVal = CarDialog.showAddCarDialog();
        if (returnVal == JOptionPane.YES_OPTION) {
            Car toAdd = new Car(CarDialog.getLicencePlateInputField().getText(),
                    Integer.valueOf(CarDialog.getModelYearInputField().getText()),
                    CarDialog.getManufacturerInputField().getText(),
                    CarDialog.getModelInputField().getText(),
                    CarDialog.getChassisTypeInputField().getText(),
                    Integer.valueOf(CarDialog.getHorsepowerInputField().getText()));
            boolean operationSuccessful = true;
            if (!data.addCar(toAdd)) {
                operationSuccessful = false;
            }
            if (!operationSuccessful) {
                JOptionPane.showMessageDialog(null, "This car is already in the database!", "Operation failed",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        carData.fireTableDataChanged();
        updateInfo();
    }

    /**
     * Adds a new repair to the data.
     */
    public void addRepair() {
        int returnVal = RepairDialog.showAddRepairDialog();
        if (returnVal == JOptionPane.YES_OPTION) {
            Repair toAdd = new Repair(RepairDialog.getRepairIdInputField().getText(),
                    RepairDialog.getDescriptionInputField().getText(),
                    Integer.valueOf(RepairDialog.getCostInputField().getText()),
                    RepairDialog.getDateInputField().getText());
            boolean operationSuccessful = true;
            if (!data.addRepair(toAdd)) {
                operationSuccessful = false;
            }
            if (!operationSuccessful) {
                JOptionPane.showMessageDialog(null, "This repair is already in the database!", "Operation failed",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
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
        int selectedRow = mainFrame.getMainPanel().getTablesTabbedPane().getCarsTable().getSelectedRow();
        String idNumber = (String) mainFrame.getMainPanel().getTablesTabbedPane().getCarsTable()
                .getValueAt(selectedRow, 0);
        Car finder = new Car(idNumber, null, null, null, null, null);
        Car toEdit = data.getCars().get(data.getCars().indexOf(finder));
        int returnVal = CarDialog.showModifyCarDialog();
        if (returnVal == JOptionPane.YES_OPTION) {
            if (!CarDialog.getModelYearInputField().getText().isBlank()) {
                toEdit.setModelYear(Integer.valueOf(CarDialog.getModelYearInputField().getText()));
            }
            if (!CarDialog.getManufacturerInputField().getText().isBlank()) {
                toEdit.setManufacturer(CarDialog.getManufacturerInputField().getText());
            }
            if (!CarDialog.getModelInputField().getText().isBlank()) {
                toEdit.setModel(CarDialog.getModelInputField().getText());
            }
            if (!CarDialog.getChassisTypeInputField().getText().isBlank()) {
                toEdit.setChassisType(CarDialog.getChassisTypeInputField().getText());
            }
            if (!CarDialog.getHorsepowerInputField().getText().isBlank()) {
                toEdit.setHorsepower(Integer.valueOf(CarDialog.getHorsepowerInputField().getText()));
            }
        }
        carData.fireTableDataChanged();
    }

    /**
     * Modifies a repair.
     */
    public void modifyRepair() {
        int selectedRow = mainFrame.getMainPanel().getTablesTabbedPane().getRepairsTable().getSelectedRow();
        String repairId = (String) mainFrame.getMainPanel().getTablesTabbedPane().getRepairsTable()
                .getValueAt(selectedRow, 0);
        Repair finder = new Repair(repairId, null, null, null);
        Repair toEdit = data.getRepairs().get(data.getRepairs().indexOf(finder));
        int returnVal = RepairDialog.showModifyRepairDialog();
        if (returnVal == JOptionPane.YES_OPTION) {
            if (!RepairDialog.getDescriptionInputField().getText().isBlank()) {
                toEdit.setDescription(RepairDialog.getDescriptionInputField().getText());
            }
            if (!RepairDialog.getCostInputField().getText().isBlank()) {
                toEdit.setCost(Integer.valueOf(RepairDialog.getCostInputField().getText()));
            }
            if (!RepairDialog.getDateInputField().getText().isBlank()) {
                toEdit.setDateOfRepair(RepairDialog.getDateInputField().getText());
            }
        }
        repairData.fireTableDataChanged();
    }

    /**
     * Modifies a part.
     */
    public void modifyPart() {

        partData.fireTableDataChanged();
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
            String idNumber = EmployeeDialog.getIdNumberInputField().getText();
            String name = EmployeeDialog.getNameInputField().getText();
            String phoneNumber = EmployeeDialog.getPhoneNumberInputField().getText();
            String email = EmployeeDialog.getEmailInputField().getText();
            String position = EmployeeDialog.getPositionInputField().getText();
            filter = new Employee(idNumber, name, phoneNumber, email, position);
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
            String idNumber = ClientDialog.getIdNumberInputField().getText();
            String name = ClientDialog.getNameInputField().getText();
            String phoneNumber = ClientDialog.getPhoneNumberInputField().getText();
            String email = ClientDialog.getEmailInputField().getText();
            filter = new Client(idNumber, name, phoneNumber, email);
            filteredData = clientData.getFilteredData(filter);
            QueryFrame queryFrame = new QueryFrame();
            queryFrame.getTable().setModel(filteredData);
            queryFrame.getFoundRecords().setText("Found records: " + Integer.toString(filteredData.getRowCount()));
        }
    }

    /**
     * Creates a query for the cars.
     */
    public void createCarQuery() {
        int returnVal = CarDialog.showQueryCarDialog();
        Car filter;
        CarData filteredData;
        if (returnVal == JOptionPane.YES_OPTION) {
            String licencePlate = CarDialog.getLicencePlateInputField().getText();
            Integer modelYear = null;
            if (!CarDialog.getModelYearInputField().getText().isBlank()) {
                modelYear = Integer.valueOf(CarDialog.getModelYearInputField().getText());
            }
            String manufacturer = CarDialog.getManufacturerInputField().getText();
            String model = CarDialog.getModelInputField().getText();
            String chassisType = CarDialog.getChassisTypeInputField().getText();
            Integer horsepower = null;
            if (!CarDialog.getHorsepowerInputField().getText().isBlank()) {
                horsepower = Integer.valueOf(CarDialog.getHorsepowerInputField().getText());
            }
            filter = new Car(licencePlate, modelYear, manufacturer, model, chassisType, horsepower);
            filteredData = carData.getFilteredData(filter);
            QueryFrame queryFrame = new QueryFrame();
            queryFrame.getTable().setModel(filteredData);
            queryFrame.getFoundRecords().setText("Found records: " + Integer.toString(filteredData.getRowCount()));
        }
    }

    /**
     * Creates a query for repairs.
     */
    public void createRepairQuery() {
        int returnVal = RepairDialog.showQueryRepairDialog();
        Repair filter;
        RepairData filteredData;
        if (returnVal == JOptionPane.YES_OPTION) {
            String repairId = RepairDialog.getRepairIdInputField().getText();
            String description = RepairDialog.getDescriptionInputField().getText();
            Integer cost = null;
            if (!RepairDialog.getCostInputField().getText().isBlank()) {
                cost = Integer.valueOf(RepairDialog.getCostInputField().getText());
            }
            String date = RepairDialog.getDateInputField().getText();
            filter = new Repair(repairId, description, cost, date);
            filteredData = repairData.getFilteredData(filter);
            QueryFrame queryFrame = new QueryFrame();
            queryFrame.getTable().setModel(filteredData);
        }
    }

    /**
     * Creates a query for parts.
     */
    public void createPartQuery() {

    }
}