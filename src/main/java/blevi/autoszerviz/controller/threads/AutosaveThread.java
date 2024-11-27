package blevi.autoszerviz.controller.threads;

import blevi.autoszerviz.controller.logic.MainController;

public class AutosaveThread extends Thread {
    MainController parent;
    public AutosaveThread(MainController parent) {
        this.parent = parent;
    }
    @Override
    public void run() {
        
    }
}
