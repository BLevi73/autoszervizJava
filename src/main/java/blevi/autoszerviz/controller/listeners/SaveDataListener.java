package blevi.autoszerviz.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import blevi.autoszerviz.controller.filehandlers.SerializationType;
import blevi.autoszerviz.controller.logic.MainController;

public class SaveDataListener implements ActionListener {
    MainController parent;
    public SaveDataListener(MainController parent) {
        this.parent = parent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("ZIP Archive", "zip"));
        int returnVal = fileChooser.showSaveDialog(fileChooser);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            parent.saveData(fileChooser.getSelectedFile().getAbsolutePath(), SerializationType.ZIP);
        }
    }
}
