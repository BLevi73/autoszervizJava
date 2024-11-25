package blevi.autoszerviz;

import blevi.autoszerviz.controller.logic.MainController;
import blevi.autoszerviz.controller.threads.AutosaveThread;

public class Main {
    public static void main(String[] args) {
        MainController controller = new MainController();
        controller.init();
        AutosaveThread autosaveThread = new AutosaveThread(controller);
        autosaveThread.start();
    }
}