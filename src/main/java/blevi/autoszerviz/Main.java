package blevi.autoszerviz;

import blevi.autoszerviz.controller.DataHandler;
import blevi.autoszerviz.controller.threads.AutosaveThread;
import blevi.autoszerviz.controller.threads.MainThread;
import blevi.autoszerviz.model.Database;

public class Main {
    public static void main(String[] args) {
        DataHandler.setDatabase(new Database("Untitled"));
        MainThread mainThread = new MainThread();
        mainThread.start();
        AutosaveThread autosaveThread = new AutosaveThread();
        autosaveThread.start();
    }
}