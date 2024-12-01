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
        
            default:
                break;
        }
    }
}
