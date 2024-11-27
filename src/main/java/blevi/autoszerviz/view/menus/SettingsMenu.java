package blevi.autoszerviz.view.menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class SettingsMenu extends JMenu {
    private JMenuItem preferencesItem;
    public SettingsMenu() {
        preferencesItem = new JMenuItem("Preferences");
        this.add(preferencesItem);
        this.setText("Settings");
    }
    public JMenuItem getPreferencesItem() {
        return preferencesItem;
    }
}
