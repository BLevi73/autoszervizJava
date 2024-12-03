package blevi.autoszerviz.view.frames;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ViewDetailsFrame extends JFrame {
    private JTextArea textArea;

    public ViewDetailsFrame() {
        textArea = new JTextArea();
        textArea.setEditable(false);
        this.setIconImage(new ImageIcon("src/main/resources/icons/appicon-48.png").getImage());
        this.add(new JScrollPane(textArea));
        this.setSize(480, 480);
        this.setLocationRelativeTo(null);
        this.setTitle("Details");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
