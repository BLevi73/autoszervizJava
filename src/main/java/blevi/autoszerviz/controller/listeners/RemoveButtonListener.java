package blevi.autoszerviz.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import blevi.autoszerviz.controller.logic.MainController;

public class RemoveButtonListener implements ActionListener {
    private MainController parent;

    public RemoveButtonListener(MainController parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (parent.getOpenedTab()) {
            case 0:
                parent.removeEmployee();
                break;
            case 1:
                parent.removeClient();
                break;
            case 2:
                parent.removeCar();
                break;
            case 3:
                parent.removeRepair();
                break;
            default:
                parent.removePart();
                break;
        }
    }
}
