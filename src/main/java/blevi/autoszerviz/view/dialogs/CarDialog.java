package blevi.autoszerviz.view.dialogs;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

public class CarDialog {
    private static JFormattedTextField licencePlateInputField;
    private static JFormattedTextField modelYearInputField;
    private static JFormattedTextField manufacturerInputField;
    private static JFormattedTextField modelInputField;
    private static JFormattedTextField chassisTypeInputField;
    private static JFormattedTextField horsepowerInputField;
    private static JComboBox<String> licencePlateOrdering;
    private static JComboBox<String> modelYearOrdering;
    private static JComboBox<String> manufacturerOrdering;
    private static JComboBox<String> modelOrdering;
    private static JComboBox<String> chassisTypeOrdering;
    private static JComboBox<String> horsepowerOrdering;
    private static final String[] ORDERING = { "Exact", "Comes before", "Comes after" };

    private CarDialog() {
        throw new IllegalStateException();
    }

    public static int showAddCarDialog() {
        licencePlateInputField = new JFormattedTextField();
        modelYearInputField = new JFormattedTextField();
        manufacturerInputField = new JFormattedTextField();
        modelInputField = new JFormattedTextField();
        chassisTypeInputField = new JFormattedTextField();
        horsepowerInputField = new JFormattedTextField();
        Object[] elements = {
            "Licence plate:", licencePlateInputField,
            "Model year:", modelYearInputField,
            "Manufacturer:", manufacturerInputField,
            "Model:", modelInputField,
            "Chassis type:", chassisTypeInputField,
            "Horsepower:", horsepowerInputField
        };
        licencePlateInputField.setEditable(true);
        modelYearInputField.setEditable(true);
        manufacturerInputField.setEditable(true);
        modelInputField.setEditable(true);
        chassisTypeInputField.setEditable(true);
        horsepowerInputField.setEditable(true);
        return JOptionPane.showConfirmDialog(null, elements, "Add car", JOptionPane.OK_CANCEL_OPTION);
    }

    public static int showModifyCarDialog() {
        modelYearInputField = new JFormattedTextField();
        manufacturerInputField = new JFormattedTextField();
        modelInputField = new JFormattedTextField();
        chassisTypeInputField = new JFormattedTextField();
        horsepowerInputField = new JFormattedTextField();
        Object[] elements = {
            "Model year:", modelYearInputField,
            "Manufacturer:", manufacturerInputField,
            "Model:", modelInputField,
            "Chassis type:", chassisTypeInputField,
            "Horsepower:", horsepowerInputField
        };
        modelYearInputField.setEditable(true);
        manufacturerInputField.setEditable(true);
        modelInputField.setEditable(true);
        chassisTypeInputField.setEditable(true);
        horsepowerInputField.setEditable(true);
        return JOptionPane.showConfirmDialog(null, elements, "Modify car", JOptionPane.OK_CANCEL_OPTION);
    }

    public static int showQueryCarDialog() {
        licencePlateInputField = new JFormattedTextField();
        modelYearInputField = new JFormattedTextField();
        manufacturerInputField = new JFormattedTextField();
        modelInputField = new JFormattedTextField();
        chassisTypeInputField = new JFormattedTextField();
        horsepowerInputField = new JFormattedTextField();
        licencePlateOrdering = new JComboBox<>(ORDERING);
        modelYearOrdering = new JComboBox<>(ORDERING);
        manufacturerOrdering = new JComboBox<>(ORDERING);
        modelOrdering = new JComboBox<>(ORDERING);
        chassisTypeOrdering = new JComboBox<>(ORDERING);
        horsepowerOrdering = new JComboBox<>(ORDERING);
        Object[] elements = {
            "Licence plate:", licencePlateInputField, licencePlateOrdering,
            "Model year:", modelYearInputField, modelYearOrdering,
            "Manufacturer:", manufacturerInputField, manufacturerOrdering,
            "Model:", modelInputField, modelOrdering,
            "Chassis type:", chassisTypeInputField, chassisTypeOrdering,
            "Horsepower:", horsepowerInputField, horsepowerOrdering
        };
        licencePlateInputField.setEditable(true);
        modelYearInputField.setEditable(true);
        manufacturerInputField.setEditable(true);
        modelInputField.setEditable(true);
        chassisTypeInputField.setEditable(true);
        horsepowerInputField.setEditable(true);
        return JOptionPane.showConfirmDialog(null, elements, "Search car", JOptionPane.OK_CANCEL_OPTION);
    }


    public static JFormattedTextField getLicencePlateInputField() {
        return licencePlateInputField;
    }
    public static JFormattedTextField getModelYearInputField() {
        return modelYearInputField;
    }
    public static JFormattedTextField getManufacturerInputField() {
        return manufacturerInputField;
    }
    public static JFormattedTextField getModelInputField() {
        return modelInputField;
    }
    public static JFormattedTextField getChassisTypeInputField() {
        return chassisTypeInputField;
    }
    public static JFormattedTextField getHorsepowerInputField() {
        return horsepowerInputField;
    }

    public static int getLicencePlateOrdering() {
        return licencePlateOrdering.getSelectedIndex();
    }
    public static int getModelYearOrdering() {
        return modelYearOrdering.getSelectedIndex();
    }
    public static int getManufacturerOrdering() {
        return manufacturerOrdering.getSelectedIndex();
    }
    public static int getModelOrdering() {
        return modelOrdering.getSelectedIndex();
    }
    public static int getChassisTypeOrdering() {
        return chassisTypeOrdering.getSelectedIndex();
    }
    public static int getHorsepowerOrdering() {
        return horsepowerOrdering.getSelectedIndex();
    }
}
