package blevi.autoszerviz.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import blevi.autoszerviz.controller.listeners.AddButtonListener;

public class MainToolBar extends JToolBar {
    TablesTabbedPane tablesTabbedPane;
    public MainToolBar(TablesTabbedPane tablesTabbedPane) {
        this.tablesTabbedPane = tablesTabbedPane;
        JButton addButton = new JButton(new ImageIcon("src/main/resources/icons/plus-48.png"));
        addButton.addActionListener(new AddButtonListener(tablesTabbedPane));
        JButton removeButton = new JButton(new ImageIcon("src/main/resources/icons/minus-48.png"));
        JButton editButton = new JButton(new ImageIcon("src/main/resources/icons/pencil-2-48.png"));
        JButton dataViewButton = new JButton(new ImageIcon("src/main/resources/icons/copywriting-48.png"));
        this.add(addButton);
        this.add(removeButton);
        this.add(editButton);
        this.add(dataViewButton);
        this.setFloatable(false);
    }
}
