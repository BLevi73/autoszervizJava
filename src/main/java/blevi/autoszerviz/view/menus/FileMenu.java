package blevi.autoszerviz.view.menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class FileMenu extends JMenu {
    public FileMenu() {
        JMenuItem newDatabase = new JMenuItem("New database...");
        JMenuItem openDatabase = new JMenuItem("Open");
        JMenuItem saveDatabase = new JMenuItem("Save");
        JMenu exportDatabase = new JMenu("Export...");
        JMenuItem exportToXML = new JMenuItem("as XML");
        JMenuItem exportToJSON = new JMenuItem("as JSON");
        JMenu importDatabase = new JMenu("Import...");
        JMenuItem importFromXML = new JMenuItem("from XML");
        JMenuItem importFromJSON = new JMenuItem("from JSON");
        this.add(newDatabase);
        this.add(openDatabase);
        this.add(saveDatabase);
        this.add(new JSeparator());
        exportDatabase.add(exportToXML);
        exportDatabase.add(exportToJSON);
        this.add(exportDatabase);
        importDatabase.add(importFromXML);
        importDatabase.add(importFromJSON);
        this.add(importDatabase);
        this.setText("File");
    }
}
