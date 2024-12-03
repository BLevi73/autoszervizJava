package blevi.autoszerviz.view.dialogs;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class CarDialog {
    private static JFormattedTextField licencePlateInputField;
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
}
