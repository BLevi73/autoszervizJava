package blevi.autoszerviz.view.bars;

import javax.swing.JMenuBar;

import blevi.autoszerviz.view.menus.FileMenu;
import blevi.autoszerviz.view.menus.ViewMenu;

public class MainMenuBar extends JMenuBar {
    public MainMenuBar() {
        this.add(new FileMenu());
        this.add(new ViewMenu());
    }
}
