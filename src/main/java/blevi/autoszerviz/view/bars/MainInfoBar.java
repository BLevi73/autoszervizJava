package blevi.autoszerviz.view.bars;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;

import blevi.autoszerviz.view.misc.Spacer;

public class MainInfoBar extends JToolBar {
    JLabel currentFileLabel;
    JLabel numberOfEmployeesLabel;
    public MainInfoBar() {
        currentFileLabel = new JLabel("-");
        numberOfEmployeesLabel = new JLabel("0");
        this.add(new JLabel("Currently opened file: "));
        this.add(currentFileLabel);
        this.add(new Spacer());
        this.add(new JSeparator(VERTICAL));
        this.add(new Spacer());
        this.add(new JLabel("Number of employees: "));
        this.add(numberOfEmployeesLabel);
        this.add(new Spacer());
        this.add(new JSeparator(VERTICAL));
        this.add(new Spacer());
        this.add(new JLabel("Number of clients: "));
        this.setFloatable(false);
    }

    public JLabel getCurrentFileLabel() {
        return currentFileLabel;
    }
    public JLabel getNumberOfEmployeesLabel() {
        return numberOfEmployeesLabel;
    }
}
