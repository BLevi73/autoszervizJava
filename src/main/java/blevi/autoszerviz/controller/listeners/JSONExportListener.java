package blevi.autoszerviz.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import blevi.autoszerviz.controller.filehandlers.SerializationType;
import blevi.autoszerviz.controller.logic.MainController;

public class JSONExportListener implements ActionListener {
    private MainController parent;
    public JSONExportListener(MainController parent) {
        this.parent = parent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("JavaScript Object Notation format (.json)", "json"));
        fileChooser.setAcceptAllFileFilterUsed(false);
        int returnVal = fileChooser.showSaveDialog(parent.getMainFrame());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            parent.saveData(fileChooser.getSelectedFile().getAbsolutePath(), SerializationType.JSON);
        }
    }
}
