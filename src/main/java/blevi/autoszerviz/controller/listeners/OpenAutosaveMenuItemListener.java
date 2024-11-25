package blevi.autoszerviz.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import blevi.autoszerviz.controller.filehandlers.SerializationType;
import blevi.autoszerviz.controller.logic.MainController;

public class OpenAutosaveMenuItemListener implements ActionListener {
    private MainController parent;
    public OpenAutosaveMenuItemListener(MainController parent) {
        this.parent = parent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        parent.loadData(System.getProperty("user.home") + "/autosave.zip", SerializationType.ZIP);
    }
    
}
