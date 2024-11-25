package blevi.autoszerviz.controller.threads;

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
                sleep(600000);
            } catch (InterruptedException e) {
                this.interrupt();
            }
        }
    }
}
