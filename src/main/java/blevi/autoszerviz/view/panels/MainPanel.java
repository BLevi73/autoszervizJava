package blevi.autoszerviz.view.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import blevi.autoszerviz.view.bars.MainInfoBar;
import blevi.autoszerviz.view.bars.MainToolBar;

public class MainPanel extends JPanel {
    private MainToolBar mainToolBar;
    private TablesTabbedPane tablesTabbedPane;
    private MainInfoBar mainInfoBar;

    public MainPanel() {
        this.mainToolBar = new MainToolBar();
        this.tablesTabbedPane = new TablesTabbedPane();
        this.mainInfoBar = new MainInfoBar();
        this.setLayout(new BorderLayout());
        this.add(mainToolBar, BorderLayout.NORTH);
        this.add(tablesTabbedPane, BorderLayout.CENTER);
        this.add(mainInfoBar, BorderLayout.SOUTH);
    }

    public MainToolBar getMainToolBar() {
        return mainToolBar;
    }

    public TablesTabbedPane getTablesTabbedPane() {
        return tablesTabbedPane;
    }

    public MainInfoBar getMainInfoBar() {
        return mainInfoBar;
    }
}
