package blevi.autoszerviz.controller.logic;

import blevi.autoszerviz.controller.filehandlers.SerializationType;
import blevi.autoszerviz.controller.listeners.AddButtonListener;
import blevi.autoszerviz.model.datasources.Data;
import blevi.autoszerviz.view.frames.MainFrame;

public class Controller {
    private Data data;
    private MainFrame mainFrame;
    
    private AddButtonListener addButtonListener;
    
    public Controller() {
        this.data = new Data();
        this.mainFrame = new MainFrame();
    }

    public Data getData() {
        return data;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void saveData(String filepath, SerializationType type) {
        
    }

    public void addElementEvent() {

    }
}