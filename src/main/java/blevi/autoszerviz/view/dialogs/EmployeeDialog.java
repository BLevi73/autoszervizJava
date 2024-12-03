package blevi.autoszerviz.view.dialogs;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EmployeeDialog {
    private static JFormattedTextField idNumberInputField;
    private static JFormattedTextField nameInputField;
    private static JFormattedTextField phoneNumberInputField;
    private static JFormattedTextField emailInputField;
    private static JFormattedTextField positionInputField;
    private static JComboBox<String> idNumberOrdering;
    private static JComboBox<String> nameOrdering;
    private static JComboBox<String> phoneNumberOrdering;
    private static JComboBox<String> emailOrdering;
    private static JComboBox<String> positionOrdering;
    private static final String[] ORDERING = { "Exact", "Comes before", "Comes after" };

    private EmployeeDialog() {
        throw new IllegalStateException();
    }

    public static int showAddEmployeeDialog() {
        idNumberInputField = new JFormattedTextField();
        nameInputField = new JFormattedTextField();
        phoneNumberInputField = new JFormattedTextField();
        emailInputField = new JFormattedTextField();
        positionInputField = new JFormattedTextField();
        Object[] elements = {
                "Identification number:", idNumberInputField,
                "Full name:", nameInputField,
                "Phone number:", phoneNumberInputField,
                "E-mail address:", emailInputField,
                "Position:", positionInputField
        };
        idNumberInputField.setEditable(true);
        nameInputField.setEditable(true);
        phoneNumberInputField.setEditable(true);
        emailInputField.setEditable(true);
        positionInputField.setEditable(true);
        return JOptionPane.showConfirmDialog(null, elements, "Add employee", JOptionPane.OK_CANCEL_OPTION);
    }

    public static int showModifyEmployeeDialog() {
        nameInputField = new JFormattedTextField();
        phoneNumberInputField = new JFormattedTextField();
        emailInputField = new JFormattedTextField();
        positionInputField = new JFormattedTextField();
        Object[] elements = {
                "Full name:", nameInputField,
                "Phone number:", phoneNumberInputField,
                "E-mail address:", emailInputField,
                "Position:", positionInputField
        };
        nameInputField.setEditable(true);
        phoneNumberInputField.setEditable(true);
        emailInputField.setEditable(true);
        positionInputField.setEditable(true);
        return JOptionPane.showConfirmDialog(null, elements, "Modify employee", JOptionPane.OK_CANCEL_OPTION);
    }

    public static int showEmployeeQueryDialog() {
        idNumberInputField = new JFormattedTextField();
        nameInputField = new JFormattedTextField();
        phoneNumberInputField = new JFormattedTextField();
        emailInputField = new JFormattedTextField();
        positionInputField = new JFormattedTextField();
        idNumberOrdering = new JComboBox<>(ORDERING);
        nameOrdering = new JComboBox<>(ORDERING);
        phoneNumberOrdering = new JComboBox<>(ORDERING);
        emailOrdering = new JComboBox<>(ORDERING);
        positionOrdering = new JComboBox<>(ORDERING);
        Object[] elements = {
                "Identification number:", idNumberInputField, idNumberOrdering,
                "Full name:", nameInputField, nameOrdering,
                "Phone number:", phoneNumberInputField, phoneNumberOrdering,
                "E-mail address:", emailInputField, emailOrdering,
                "Position:", positionInputField, positionOrdering
        };
        idNumberInputField.setEditable(true);
        nameInputField.setEditable(true);
        phoneNumberInputField.setEditable(true);
        emailInputField.setEditable(true);
        positionInputField.setEditable(true);
        return JOptionPane.showConfirmDialog(null, elements, "Search employees", JOptionPane.OK_CANCEL_OPTION);
    }

    public static JTextField getIdNumberInputField() {
        return idNumberInputField;
    }

    public static JTextField getNameInputField() {
        return nameInputField;
    }

    public static JTextField getPhoneNumberInputField() {
        return phoneNumberInputField;
    }

    public static JTextField getEmailInputField() {
        return emailInputField;
    }

    public static JTextField getPositionInputField() {
        return positionInputField;
    }

    public static int getIdNumberOrdering() {
        return idNumberOrdering.getSelectedIndex();
    }
    public static int getNameOrdering() {
        return nameOrdering.getSelectedIndex();
    }
    public static int getPhoneNumberOrdering() {
        return phoneNumberOrdering.getSelectedIndex();
    }
    public static int getEmailOrdering() {
        return emailOrdering.getSelectedIndex();
    }
    public static int getPositionOrdering() {
        return positionOrdering.getSelectedIndex();
    }
}
