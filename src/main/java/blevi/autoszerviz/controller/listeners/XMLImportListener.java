package blevi.autoszerviz.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import blevi.autoszerviz.controller.filehandlers.SerializationType;
import blevi.autoszerviz.controller.logic.MainController;

public class XMLImportListener implements ActionListener {
    private MainController parent;
    public XMLImportListener(MainController parent) {
        this.parent = parent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("eXtensible Markup Language format (.xml)", "xml"));
        fileChooser.setAcceptAllFileFilterUsed(false);
        int returnVal = fileChooser.showOpenDialog(parent.getMainFrame());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            parent.loadData(fileChooser.getSelectedFile().getAbsolutePath(), SerializationType.XML);
        }
    }
}
