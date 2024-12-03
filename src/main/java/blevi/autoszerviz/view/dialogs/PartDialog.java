package blevi.autoszerviz.view.dialogs;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

public class PartDialog {
    private static JFormattedTextField serialNumberInputField;
    private static JFormattedTextField manufacturerInputField;
    private static JFormattedTextField nameInputField;
    private static JFormattedTextField typeInputField;
    private static JComboBox<String> serialNumberOrdering;
    private static JComboBox<String> manufactuerOrdering;
    private static JComboBox<String> nameOrdering;
    private static JComboBox<String> typeOrdering;
    private static final String[] ORDERING = { "Exact", "Comes before", "Comes after" };

    private PartDialog() {
        throw new IllegalStateException();
    }
    public static int showAddPartDialog() {
        serialNumberInputField = new JFormattedTextField();
        manufacturerInputField = new JFormattedTextField();
        nameInputField = new JFormattedTextField();
        typeInputField = new JFormattedTextField();
        Object[] elements = {
            "Serial number:", serialNumberInputField,
            "Manufacturer:", manufacturerInputField,
            "Name:", nameInputField,
            "Type:", typeInputField,
        };
        serialNumberInputField.setEditable(true);
        manufacturerInputField.setEditable(true);
        nameInputField.setEditable(true);
        typeInputField.setEditable(true);
        return JOptionPane.showConfirmDialog(null, elements, "Add part", JOptionPane.OK_CANCEL_OPTION);
    }
    public static int showModifyPartDialog() {
        manufacturerInputField = new JFormattedTextField();
        nameInputField = new JFormattedTextField();
        typeInputField = new JFormattedTextField();
        Object[] elements = {
            "Manufacturer:", manufacturerInputField,
            "Name:", nameInputField,
            "Type:", typeInputField,
        };
        manufacturerInputField.setEditable(true);
        nameInputField.setEditable(true);
        typeInputField.setEditable(true);
        return JOptionPane.showConfirmDialog(null, elements, "Modify part", JOptionPane.OK_CANCEL_OPTION);
    }
    public static int showQueryPartDialog() {
        serialNumberInputField = new JFormattedTextField();
        manufacturerInputField = new JFormattedTextField();
        nameInputField = new JFormattedTextField();
        typeInputField = new JFormattedTextField();
        serialNumberOrdering = new JComboBox<>(ORDERING);
        manufactuerOrdering = new JComboBox<>(ORDERING);
        nameOrdering = new JComboBox<>(ORDERING);
        typeOrdering = new JComboBox<>(ORDERING);
        Object[] elements = {
            "Serial number:", serialNumberInputField, serialNumberOrdering,
            "Manufacturer:", manufacturerInputField, manufactuerOrdering,
            "Name:", nameInputField, nameOrdering,
            "Type:", typeInputField, typeOrdering
        };
        serialNumberInputField.setEditable(true);
        manufacturerInputField.setEditable(true);
        nameInputField.setEditable(true);
        typeInputField.setEditable(true);
        return JOptionPane.showConfirmDialog(null, elements, "Add part", JOptionPane.OK_CANCEL_OPTION);
    }

    public static JFormattedTextField getSerialNumberInputField() {
        return serialNumberInputField;
    }
    public static JFormattedTextField getManufacturerInputField() {
        return manufacturerInputField;
    }
    public static JFormattedTextField getNameInputField() {
        return nameInputField;
    }
    public static JFormattedTextField getTypeInputField() {
        return typeInputField;
    }

    public static int getSerialNumberOrdering() {
        return serialNumberOrdering.getSelectedIndex();
    }
    public static int getManufactuerOrdering() {
        return manufactuerOrdering.getSelectedIndex();
    }
    public static int getNameOrdering() {
        return nameOrdering.getSelectedIndex();
    }
    public static int getTypeOrdering() {
        return typeOrdering.getSelectedIndex();
    }
}
