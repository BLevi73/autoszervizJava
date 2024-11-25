package blevi.autoszerviz.controller.threads;

import blevi.autoszerviz.controller.logic.Controller;

public class AutosaveThread extends Thread {
    Controller controller;
    public AutosaveThread(Controller controller) {
        this.controller = controller;
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
