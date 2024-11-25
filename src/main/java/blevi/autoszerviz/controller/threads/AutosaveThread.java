package blevi.autoszerviz.controller.threads;

import blevi.autoszerviz.controller.filehandlers.SerializationType;
import blevi.autoszerviz.controller.logic.MainController;

public class AutosaveThread extends Thread {
    MainController parent;
    public AutosaveThread(MainController parent) {
        this.parent = parent;
    }
    @Override
    public void run() {
        while (true) {
            try {
                sleep(300000);
                parent.saveData(System.getProperty("user.home") + "/autosave.zip", SerializationType.ZIP);
            } catch (InterruptedException e) {
                this.interrupt();
            }
        }
    }
}
