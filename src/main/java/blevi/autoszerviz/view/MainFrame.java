package blevi.autoszerviz.view;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    public MainFrame() {
        JPanel mainPanel = new JPanel();
        TablesTabbedPane tablesTabbedPane = new TablesTabbedPane();
        MainToolBar mainToolBar = new MainToolBar(tablesTabbedPane);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(mainToolBar, BorderLayout.NORTH);
        mainPanel.add(tablesTabbedPane);
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(new MainMenuBar(), BorderLayout.NORTH);
        this.setTitle("Car Mechanic");
        this.setIconImage(new ImageIcon("src/main/resources/icons/appicon-48.png").getImage());
        this.setSize(1280,720);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }
}
