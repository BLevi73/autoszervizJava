package blevi.autoszerviz;

import blevi.autoszerviz.controller.logic.Controller;
import blevi.autoszerviz.controller.threads.AutosaveThread;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        AutosaveThread autosaveThread = new AutosaveThread(controller);
        autosaveThread.start();
    }
}