package blevi.autoszerviz.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import blevi.autoszerviz.controller.logic.MainController;

public class QueryButtonListener implements ActionListener {
    private MainController parent;

    public QueryButtonListener(MainController parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (parent.getOpenedTab()) {
            case 0:
                parent.createEmployeeQuery();
                break;
            case 1:
                parent.createClientQuery();
                break;
            case 2:
                parent.createCarQuery();
                break;
            case 3:
                parent.createRepairQuery();
                break;
            default:
                parent.createPartQuery();
                break;
        }
    }
}
