package blevi.autoszerviz.view.menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ViewMenu extends JMenu {
    public ViewMenu() {
        JMenuItem toolBarLock = new JMenuItem("Lock toolbar");
        this.add(toolBarLock);
        this.setText("View");
    }
}
