package blevi.autoszerviz.view.bars;

import javax.swing.JMenuBar;

import blevi.autoszerviz.view.menus.FileMenu;
import blevi.autoszerviz.view.menus.ViewMenu;

public class MainMenuBar extends JMenuBar {
    FileMenu fileMenu;
    ViewMenu viewMenu;
    
    public MainMenuBar() {
        fileMenu = new FileMenu();
        viewMenu = new ViewMenu();
        this.add(fileMenu);
        this.add(viewMenu);
    }

    public FileMenu getFileMenu() {
        return fileMenu;
    }
    
    public ViewMenu getViewMenu() {
        return viewMenu;
    }
}
