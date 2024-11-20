package blevi.autoszerviz.controller.listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

/**
 * WindowAdapter for the main window, controls the events of the main window
 * @see WindowAdapter
 */
public class MainWindowAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        int exit = JOptionPane.showConfirmDialog(null , "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}