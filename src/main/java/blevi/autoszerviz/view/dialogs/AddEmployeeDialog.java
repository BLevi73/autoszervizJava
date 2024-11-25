package blevi.autoszerviz.view.dialogs;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class AddEmployeeDialog extends JDialog {
    private JTextField idNumberInputField;
    private JTextField nameInputField;
    private JTextField phoneNumberInputField;
    private JTextField emailInputField;
    private JTextField positionInputField;
    public AddEmployeeDialog() {
        this.setLocationRelativeTo(null);
        this.setSize(480, 640);
        this.setVisible(true);
    }
}
