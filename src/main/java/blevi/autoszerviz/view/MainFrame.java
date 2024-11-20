package blevi.autoszerviz.view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    public MainFrame() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new MainToolBar(), BorderLayout.NORTH);
        mainPanel.add(new TablesTabbedPane());
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(new MainMenuBar(), BorderLayout.NORTH);
        this.setTitle("Car Mechanic");
        this.setIconImage(new ImageIcon("src/main/resources/icons/car-4-48.png").getImage());
        this.setSize(1280,720);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }
}
