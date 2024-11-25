package blevi.autoszerviz.view.menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ViewMenu extends JMenu {
    JMenuItem toolBarLock;
    public ViewMenu() {
        toolBarLock = new JMenuItem("Lock toolbar");
        this.add(toolBarLock);
        this.setText("View");
    }
    public JMenuItem getToolBarLock() {
        return toolBarLock;
    }
}
