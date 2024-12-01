package blevi.autoszerviz.view.dialogs;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PreferencesDialog {
    private static final Integer[] INTERVALS = {10, 20, 30, 40, 50, 60};
    private static JComboBox<Integer> intervalComboBox;
    private static JTextField intervalTextField;
    private PreferencesDialog() {
        throw new IllegalStateException();
    }
    
    public static int showPreferencesDialog() {
        intervalComboBox = new JComboBox<>(INTERVALS);
        intervalTextField = new JTextField();
        Object[] elements = {
            "Time between autosaves (in minutes):", intervalComboBox,
            "Custom interval (in minutes:)", intervalTextField
        };
        intervalTextField.setEditable(true);
        return JOptionPane.showConfirmDialog(null, elements, "Preferences", JOptionPane.OK_CANCEL_OPTION);
    }
    public static int getSelectedInterval() {
        return 10 * 60000 * (intervalComboBox.getSelectedIndex() +1);
    }
    public static JTextField getIntervalTextField() {
        return intervalTextField;
    }
}
