package blevi.autoszerviz.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import blevi.autoszerviz.controller.logic.MainController;

public class EditButtonListener implements ActionListener {
    MainController parent;

    public EditButtonListener(MainController parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (parent.getOpenedTab()) {
            case 0:
                parent.modifyEmployee();
                break;
            case 1:
                parent.modifyClient();
                break;
            case 2:
                parent.modifyCar();
                break;
            case 3:
                parent.modifyRepair();
                break;
            default:
                parent.modifyPart();
                break;
        }

    }
}
