package blevi.autoszerviz.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import blevi.autoszerviz.controller.logic.Controller;




public class AddButtonListener implements ActionListener {
    Controller controller;
    public AddButtonListener(Controller controller) {
        this.controller = controller;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        controller.addElementEvent();
    }
}
