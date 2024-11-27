package blevi.autoszerviz.view.frames;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PreferencesFrame extends JFrame {
    public PreferencesFrame() {
        this.setTitle("Preferences");
        this.setIconImage(new ImageIcon("src/main/resources/icons/settings-17-48.png").getImage());
        this.setSize(640,720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
