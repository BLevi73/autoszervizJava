package blevi.autoszerviz.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import blevi.autoszerviz.controller.logic.MainController;
import blevi.autoszerviz.model.datatypes.Employee;
import blevi.autoszerviz.view.dialogs.AddEmployeeDialog;

public class AddButtonListener implements ActionListener {
    MainController parent;

    public AddButtonListener(MainController parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (parent.getOpenedTab()) {
            case 0:
                int returnVal = AddEmployeeDialog.showAddEmployeeDialog();
                if (returnVal == JOptionPane.YES_OPTION) {
                    parent.addEmployee(new Employee(AddEmployeeDialog.getIdNumberInputField().getText(),
                            AddEmployeeDialog.getNameInputField().getText(),
                            AddEmployeeDialog.getPhoneNumberInputField().getText(),
                            AddEmployeeDialog.getEmailInputField().getText(),
                            AddEmployeeDialog.getPositionInputField().getText()));
                }
                break;
            default:
                break;
        }

    }
}
