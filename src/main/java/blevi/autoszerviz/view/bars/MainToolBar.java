package blevi.autoszerviz.view.bars;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class MainToolBar extends JToolBar {
    JButton addButton = new JButton(new ImageIcon("src/main/resources/icons/plus-48.png"));
    JButton removeButton = new JButton(new ImageIcon("src/main/resources/icons/minus-48.png"));
    JButton editButton = new JButton(new ImageIcon("src/main/resources/icons/pencil-2-48.png"));
    JButton dataViewButton = new JButton(new ImageIcon("src/main/resources/icons/copywriting-48.png"));

    public MainToolBar() {
        addButton = new JButton(new ImageIcon("src/main/resources/icons/plus-48.png"));
        removeButton = new JButton(new ImageIcon("src/main/resources/icons/minus-48.png"));
        editButton = new JButton(new ImageIcon("src/main/resources/icons/pencil-2-48.png"));
        dataViewButton = new JButton(new ImageIcon("src/main/resources/icons/copywriting-48.png"));
        this.add(addButton);
        this.add(removeButton);
        this.add(editButton);
        this.add(dataViewButton);
        this.setFloatable(false);
    }

    public void setAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }
}
