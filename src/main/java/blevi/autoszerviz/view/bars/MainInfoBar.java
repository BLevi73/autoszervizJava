package blevi.autoszerviz.view.bars;

import javax.swing.JLabel;
import javax.swing.JToolBar;

public class MainInfoBar extends JToolBar {
    JLabel currentFileLabel;
    public MainInfoBar() {
        currentFileLabel = new JLabel("-");
        this.add(new JLabel("Currently opened file: "));
        this.add(currentFileLabel);
        this.setFloatable(false);
    }

    public JLabel getCurrentFileLabel() {
        return currentFileLabel;
    }
}
