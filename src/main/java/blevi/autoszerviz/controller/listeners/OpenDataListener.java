package blevi.autoszerviz.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import blevi.autoszerviz.controller.filehandlers.SerializationType;
import blevi.autoszerviz.controller.logic.MainController;

public class OpenDataListener implements ActionListener {
    MainController parent;
    public OpenDataListener(MainController parent) {
        this.parent = parent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("ZIP Archive", "zip"));
        fileChooser.setAcceptAllFileFilterUsed(false);
        int returnVal = fileChooser.showOpenDialog(parent.getMainFrame());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            parent.loadData(fileChooser.getSelectedFile().getAbsolutePath(), SerializationType.ZIP);
        }
    }
}
