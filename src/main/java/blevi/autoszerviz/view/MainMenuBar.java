package blevi.autoszerviz.view;

import javax.swing.JMenuBar;

public class MainMenuBar extends JMenuBar {
    public MainMenuBar() {
        this.add(new FileMenu());
        this.add(new ViewMenu());
    }
}
