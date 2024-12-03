package blevi.autoszerviz.view.bars;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class MainToolBar extends JToolBar {
    JButton addButton;
    JButton removeButton;
    JButton editButton;
    JButton dataViewButton;
    JButton queryButton;

    public MainToolBar() {
        addButton = new JButton("Add", new ImageIcon("src/main/resources/icons/plus-48.png"));
        removeButton = new JButton("Remove", new ImageIcon("src/main/resources/icons/minus-48.png"));
        editButton = new JButton("Edit", new ImageIcon("src/main/resources/icons/pencil-2-48.png"));
        dataViewButton = new JButton("View details", new ImageIcon("src/main/resources/icons/copywriting-48.png"));
        queryButton = new JButton("Search", new ImageIcon("src/main/resources/icons/search-13-48.png"));
        this.add(addButton);
        this.add(removeButton);
        this.add(editButton);
        this.add(dataViewButton);
        this.add(queryButton);
        this.setFloatable(true);
    }
    public JButton getAddButton() {
        return addButton;
    }
    public JButton getRemoveButton() {
        return removeButton;
    }
    public JButton getEditButton() {
        return editButton;
    }
    public JButton getDataViewButton() {
        return dataViewButton;
    }
    public JButton getQueryButton() {
        return queryButton;
    }
}
