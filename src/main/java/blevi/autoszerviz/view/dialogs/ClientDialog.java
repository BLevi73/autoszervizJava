package blevi.autoszerviz.view.dialogs;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ClientDialog {
    private static JFormattedTextField idNumberInputField;
    private static JFormattedTextField nameInputField;
    private static JFormattedTextField phoneNumberInputField;
    private static JFormattedTextField emailInputField;

    private ClientDialog() {
        throw new IllegalStateException();
    }

    public static int showAddClientDialog() {
        idNumberInputField = new JFormattedTextField();
        nameInputField = new JFormattedTextField();
        phoneNumberInputField = new JFormattedTextField();
        emailInputField = new JFormattedTextField();
        Object[] elements = {
                "Identification number:", idNumberInputField,
                "Full name:", nameInputField,
                "Phone number:", phoneNumberInputField,
                "E-mail address:", emailInputField
        };
        idNumberInputField.setEditable(true);
        nameInputField.setEditable(true);
        phoneNumberInputField.setEditable(true);
        emailInputField.setEditable(true);
        return JOptionPane.showConfirmDialog(null, elements, "Add employee", JOptionPane.OK_CANCEL_OPTION);
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
}
