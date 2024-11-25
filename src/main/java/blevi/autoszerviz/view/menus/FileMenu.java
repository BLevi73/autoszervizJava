package blevi.autoszerviz.view.menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class FileMenu extends JMenu {
    JMenuItem newMenuItem;
    JMenuItem openMenuItem;
    JMenuItem saveMenuItem;
    JMenu exportMenu;
    JMenuItem exportToXMLMenuItem;
    JMenuItem exportToJSONMenuItem;
    JMenu importMenu;
    JMenuItem importFromXMLMenuItem;
    JMenuItem importFromJSONMenuItem;

    public FileMenu() {
        newMenuItem = new JMenuItem("New database...");
        openMenuItem = new JMenuItem("Open");
        saveMenuItem = new JMenuItem("Save");
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
}
