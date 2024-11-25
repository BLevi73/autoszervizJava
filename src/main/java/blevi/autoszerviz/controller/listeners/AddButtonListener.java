package blevi.autoszerviz.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import blevi.autoszerviz.controller.logic.MainController;




public class AddButtonListener implements ActionListener {
    MainController controller;
    public AddButtonListener(MainController controller) {
        this.controller = controller;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        controller.addElementEvent();
    }
}
