package blevi.autoszerviz.view.bars;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;

import blevi.autoszerviz.view.misc.Spacer;

public class MainInfoBar extends JToolBar {
    JLabel currentFileLabel;
    JLabel numberOfEmployeesLabel;
    JLabel numberOfClientsLabel;
    JLabel numberOfCarsLabel;
    JLabel numberOfRepairsLabel;
    JLabel numberOfPartsLabel;
    public MainInfoBar() {
        currentFileLabel = new JLabel("-");
        numberOfEmployeesLabel = new JLabel("0");
        numberOfClientsLabel = new JLabel("0");
        numberOfCarsLabel = new JLabel("0");
        numberOfRepairsLabel = new JLabel("0");
        numberOfPartsLabel = new JLabel("0");
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
        this.add(numberOfClientsLabel);
        this.add(new Spacer());
        this.add(new JSeparator(VERTICAL));
        this.add(new Spacer());
        this.add(new JLabel("Number of cars: "));
        this.add(numberOfCarsLabel);
        this.add(new Spacer());
        this.add(new JSeparator(VERTICAL));
        this.add(new Spacer());
        this.add(new JLabel("Number of repairs: "));
        this.add(numberOfRepairsLabel);
        this.add(new Spacer());
        this.add(new JSeparator(VERTICAL));
        this.add(new Spacer());
        this.add(new JLabel("Number of parts in stash: "));
        this.add(numberOfPartsLabel);
        this.setFloatable(false);
    }

    public JLabel getCurrentFileLabel() {
        return currentFileLabel;
    }
    public JLabel getNumberOfEmployeesLabel() {
        return numberOfEmployeesLabel;
    }
    public JLabel getNumberOfClientsLabel() {
        return numberOfClientsLabel;
    }
    public JLabel getNumberOfCarsLabel() {
        return numberOfCarsLabel;
    }
    public JLabel getNumberOfRepairsLabel() {
        return numberOfRepairsLabel;
    }
    public JLabel getNumberOfPartsLabel() {
        return numberOfPartsLabel;
    }
}
