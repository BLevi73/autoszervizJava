package blevi.autoszerviz.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import blevi.autoszerviz.controller.filehandlers.SerializationType;
import blevi.autoszerviz.controller.logic.MainController;

public class OpenExampleListener implements ActionListener {
    private MainController parent;
    public OpenExampleListener(MainController parent) {
        this.parent = parent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        parent.loadData("src/main/resources/example-data/example.zip", SerializationType.ZIP);
    }
}
