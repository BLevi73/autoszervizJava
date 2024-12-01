package blevi.autoszerviz.view.frames;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class QueryFrame extends JFrame {
    private JPanel panel;
    private JTable table;
    private JLabel foundRecords;
    public QueryFrame() {
        panel = new JPanel(new BorderLayout());
        table = new JTable();
        foundRecords = new JLabel();
        panel.add(new JScrollPane(table));
        panel.add(foundRecords, BorderLayout.SOUTH);
        this.add(panel);
        this.setTitle("Query Result");
        this.setIconImage(new ImageIcon("src/main/resources/icons/appicon-48.png").getImage());
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public JTable getTable() {
        return table;
    }
    public JLabel getFoundRecords() {
        return foundRecords;
    }
}
