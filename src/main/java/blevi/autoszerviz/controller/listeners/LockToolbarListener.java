package blevi.autoszerviz.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import blevi.autoszerviz.controller.logic.MainController;

public class LockToolbarListener implements ActionListener {
    MainController parent;
    public LockToolbarListener(MainController parent) {
        this.parent = parent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        parent.lockToolbar();
    }
}
