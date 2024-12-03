package blevi.autoszerviz.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import blevi.autoszerviz.controller.logic.MainController;

public class ViewButtonListener implements ActionListener {
    MainController parent;

    public ViewButtonListener(MainController parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (parent.getOpenedTab()) {
            case 0:
                parent.viewEmployeeDetails();
                break;
            case 1:
                parent.viewClientDetails();
                break;
            case 2:
                parent.viewCarDetails();
                break;
            case 3:
                parent.viewRepairDetails();
                break;

            default:
                parent.viewPartDetails();
                break;
        }

    }
}
