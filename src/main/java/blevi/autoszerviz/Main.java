package blevi.autoszerviz;

import blevi.autoszerviz.controller.LogicAccessInterface;
import blevi.autoszerviz.controller.DataAccessInterface;
import blevi.autoszerviz.controller.threads.AutosaveThread;
import blevi.autoszerviz.controller.threads.MainThread;
import blevi.autoszerviz.model.Database;

public class Main {
    public static void main(String[] args) {
        DataAccessInterface.setDatabase(new Database("Untitled"));
        LogicAccessInterface.setTables();
        MainThread mainThread = new MainThread();
        mainThread.start();
        AutosaveThread autosaveThread = new AutosaveThread();
        autosaveThread.start();
    }
}