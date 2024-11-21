package blevi.autoszerviz.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import blevi.autoszerviz.view.TablesTabbedPane;



public class AddButtonListener implements ActionListener {
    TablesTabbedPane tablesTabbedPane;
    public AddButtonListener(TablesTabbedPane tablesTabbedPane) {
        this.tablesTabbedPane = tablesTabbedPane;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(tablesTabbedPane.getSelectedIndex()) {
            case 1 :
                JOptionPane.showInputDialog(tablesTabbedPane, "Add client");
                break;
            case 2 :
                JOptionPane.showInputDialog(tablesTabbedPane, "Add car");
                break;
            case 3 :
                JOptionPane.showInputDialog(tablesTabbedPane, "Add motorcycle");
                break;
            case 4 :
                JOptionPane.showInputDialog(tablesTabbedPane, "Add part");
                break;
            default :
                JOptionPane.showInputDialog(tablesTabbedPane, "Add empolyee");
                break;
        }
    }
}
