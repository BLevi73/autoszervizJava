package blevi.autoszerviz.view.menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class FileMenu extends JMenu {
    JMenuItem newMenuItem;
    JMenuItem openMenuItem;
    JMenuItem saveMenuItem;
    JMenuItem openAutosaveMenuItem;
    JMenuItem openExampleItem;
    JMenu exportMenu;
    JMenuItem exportToXMLMenuItem;
    JMenuItem exportToJSONMenuItem;
    JMenu importMenu;
    JMenuItem importFromXMLMenuItem;
    JMenuItem importFromJSONMenuItem;

    public FileMenu() {
        newMenuItem = new JMenuItem("New data...");
        openMenuItem = new JMenuItem("Open");
        saveMenuItem = new JMenuItem("Save");
        openAutosaveMenuItem = new JMenuItem("Open autosaved data");
        openExampleItem = new JMenuItem("Open example data");
        exportMenu = new JMenu("Export...");
        exportToXMLMenuItem = new JMenuItem("as XML");
        exportToJSONMenuItem = new JMenuItem("as JSON");
        importMenu = new JMenu("Import...");
        importFromXMLMenuItem = new JMenuItem("from XML");
        importFromJSONMenuItem = new JMenuItem("from JSON");
        this.add(newMenuItem);
        this.add(openMenuItem);
        this.add(saveMenuItem);
        this.add(new JSeparator());
        this.add(openAutosaveMenuItem);
        this.add(openExampleItem);
        this.add(new JSeparator());
        exportMenu.add(exportToXMLMenuItem);
        exportMenu.add(exportToJSONMenuItem);
        this.add(exportMenu);
        importMenu.add(importFromXMLMenuItem);
        importMenu.add(importFromJSONMenuItem);
        this.add(importMenu);
        this.setText("File");
    }

    public JMenuItem getNewMenuItem() {
        return newMenuItem;
    }
    public JMenuItem getOpenMenuItem() {
        return openMenuItem;
    }
    public JMenuItem getSaveMenuItem() {
        return saveMenuItem;
    }
    public JMenuItem getOpenAutosaveMenuItem() {
        return openAutosaveMenuItem;
    }
    public JMenuItem getOpenExampleItem() {
        return openExampleItem;
    }
    public JMenuItem getExportToXMLMenuItem() {
        return exportToXMLMenuItem;
    }
    public JMenuItem getExportToJSONMenuItem() {
        return exportToJSONMenuItem;
    }
    public JMenuItem getImportFromXMLMenuItem() {
        return importFromXMLMenuItem;
    }
    public JMenuItem getImportFromJSONMenuItem() {
        return importFromJSONMenuItem;
    }
}
