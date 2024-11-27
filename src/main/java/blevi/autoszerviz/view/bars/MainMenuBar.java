package blevi.autoszerviz.view.bars;

import javax.swing.JMenuBar;

import blevi.autoszerviz.view.menus.FileMenu;
import blevi.autoszerviz.view.menus.SettingsMenu;
import blevi.autoszerviz.view.menus.ViewMenu;

public class MainMenuBar extends JMenuBar {
    FileMenu fileMenu;
    ViewMenu viewMenu;
    SettingsMenu settingsMenu;
    
    public MainMenuBar() {
        fileMenu = new FileMenu();
        viewMenu = new ViewMenu();
        settingsMenu = new SettingsMenu();
        this.add(fileMenu);
        this.add(viewMenu);
        this.add(settingsMenu);
    }

    public FileMenu getFileMenu() {
        return fileMenu;
    }
    
    public ViewMenu getViewMenu() {
        return viewMenu;
    }
    public SettingsMenu getSettingsMenu() {
        return settingsMenu;
    }
}
