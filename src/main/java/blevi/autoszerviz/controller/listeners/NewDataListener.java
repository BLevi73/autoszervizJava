package blevi.autoszerviz.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import blevi.autoszerviz.controller.logic.MainController;

public class NewDataListener implements ActionListener {
    MainController parent;
    public NewDataListener(MainController parent) {
        this.parent = parent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        parent.newData();
    }
}
