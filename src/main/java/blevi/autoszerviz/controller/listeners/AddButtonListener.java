package blevi.autoszerviz.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import blevi.autoszerviz.controller.logic.MainController;

public class AddButtonListener implements ActionListener {
    MainController parent;

    public AddButtonListener(MainController parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (parent.getOpenedTab()) {
            case 0:
                parent.addEmployee();
                break;
            case 1:
                parent.addClient();
                break;
            default:
                break;
        }

    }
}
