package blevi.autoszerviz.view.dialogs;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

public class RepairDialog {
    private static JFormattedTextField repairIdInputField;
    private static JFormattedTextField descriptionInputField;
    private static JFormattedTextField costInputField;
    private static JFormattedTextField dateInputField;
    private static JComboBox<String> repairIdOrdering;
    private static JComboBox<String> descriptionOrdering;
    private static JComboBox<String> costOrdering;
    private static JComboBox<String> dateOrdering;
    private static final String[] ORDERING = { "Exact", "Comes before", "Comes after" };
    
    private RepairDialog() {
        throw new IllegalStateException();
    }

    public static int showAddRepairDialog() {
        repairIdInputField = new JFormattedTextField();
        descriptionInputField = new JFormattedTextField();
        costInputField = new JFormattedTextField();
        dateInputField = new JFormattedTextField();
        Object[] elements = {
            "Repair ID:", repairIdInputField,
            "Description:", descriptionInputField,
            "Cost:", costInputField,
            "Date:", dateInputField,
        };
        repairIdInputField.setEditable(true);
        descriptionInputField.setEditable(true);
        costInputField.setEditable(true);
        dateInputField.setEditable(true);
        return JOptionPane.showConfirmDialog(null, elements, "Add repair", JOptionPane.OK_CANCEL_OPTION);
    }

    public static int showModifyRepairDialog() {
        descriptionInputField = new JFormattedTextField();
        costInputField = new JFormattedTextField();
        dateInputField = new JFormattedTextField();
        Object[] elements = {
            "Description:", descriptionInputField,
            "Cost:", costInputField,
            "Date:", dateInputField,
        };
        descriptionInputField.setEditable(true);
        costInputField.setEditable(true);
        dateInputField.setEditable(true);
        return JOptionPane.showConfirmDialog(null, elements, "Modify repair", JOptionPane.OK_CANCEL_OPTION);
    }

    public static int showQueryRepairDialog() {
        repairIdInputField = new JFormattedTextField();
        descriptionInputField = new JFormattedTextField();
        costInputField = new JFormattedTextField();
        dateInputField = new JFormattedTextField();
        repairIdOrdering = new JComboBox<>(ORDERING);
        descriptionOrdering = new JComboBox<>(ORDERING);
        costOrdering = new JComboBox<>(ORDERING);
        dateOrdering = new JComboBox<>(ORDERING);
        Object[] elements = {
            "Repair ID:", repairIdInputField, repairIdOrdering,
            "Description:", descriptionInputField, descriptionOrdering,
            "Cost:", costInputField, costOrdering,
            "Date:", dateInputField, dateOrdering
        };
        repairIdInputField.setEditable(true);
        descriptionInputField.setEditable(true);
        costInputField.setEditable(true);
        dateInputField.setEditable(true);
        return JOptionPane.showConfirmDialog(null, elements, "Search repairs", JOptionPane.OK_CANCEL_OPTION);
    }

    public static JFormattedTextField getRepairIdInputField() {
        return repairIdInputField;
    }
    public static JFormattedTextField getDescriptionInputField() {
        return descriptionInputField;
    }
    public static JFormattedTextField getCostInputField() {
        return costInputField;
    }
    public static JFormattedTextField getDateInputField() {
        return dateInputField;
    }

    public static int getRepairIdOrdering() {
        return repairIdOrdering.getSelectedIndex();
    }
    public static int getDescriptionOrdering() {
        return descriptionOrdering.getSelectedIndex();
    }
    public static int getCostOrdering() {
        return costOrdering.getSelectedIndex();
    }
    public static int getDateOrdering() {
        return dateOrdering.getSelectedIndex();
    }
}
