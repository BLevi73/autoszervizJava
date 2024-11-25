package blevi.autoszerviz.view.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import blevi.autoszerviz.view.bars.MainToolBar;

public class MainPanel extends JPanel {
    private MainToolBar mainToolBar;
    private TablesTabbedPane tablesTabbedPane;

    public MainPanel() {
        this.mainToolBar = new MainToolBar();
        this.tablesTabbedPane = new TablesTabbedPane();
        this.setLayout(new BorderLayout());
        this.add(mainToolBar, BorderLayout.NORTH);
        this.add(tablesTabbedPane, BorderLayout.CENTER);
    }

    public MainToolBar getMainToolBar() {
        return mainToolBar;
    }

    public TablesTabbedPane getTablesTabbedPane() {
        return tablesTabbedPane;
    }
}
