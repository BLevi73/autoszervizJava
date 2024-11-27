package blevi.autoszerviz.controller.threads;

import blevi.autoszerviz.controller.logic.MainController;
import blevi.autoszerviz.controller.logic.ProgramConfig;
import blevi.autoszerviz.model.datasources.Data;

public class MainThread extends Thread {
    private Data data;
    private ProgramConfig programConfig;
    public MainThread(Data data, ProgramConfig programConfig) {
        this.data = data;
        this.programConfig = programConfig;
        this.setName("Main Thread");
    }
    @Override
    public void run() {
        MainController controller = new MainController(data);
        controller.init();
    }
}
