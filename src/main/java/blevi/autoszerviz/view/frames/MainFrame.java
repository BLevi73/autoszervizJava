package blevi.autoszerviz.view.frames;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import blevi.autoszerviz.controller.listeners.MainWindowAdapter;
import blevi.autoszerviz.view.bars.MainMenuBar;
import blevi.autoszerviz.view.panels.MainPanel;

public class MainFrame extends JFrame {
    private JPanel mainPanel;

    public MainFrame() {
        mainPanel = new MainPanel();
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(new MainMenuBar(), BorderLayout.NORTH);
        this.addWindowListener(new MainWindowAdapter());
        this.setTitle("Car Mechanic");
        this.setIconImage(new ImageIcon("src/main/resources/icons/appicon-48.png").getImage());
        this.setSize(1280,720);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
    
}
