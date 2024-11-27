package blevi.autoszerviz;

import blevi.autoszerviz.controller.logic.ProgramConfig;
import blevi.autoszerviz.controller.threads.AutosaveThread;
import blevi.autoszerviz.controller.threads.MainThread;
import blevi.autoszerviz.model.datasources.Data;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        ProgramConfig programConfig = new ProgramConfig();
        try {
            programConfig.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainThread mainThread = new MainThread(data, programConfig);
        mainThread.start();
        AutosaveThread autosaveThread = new AutosaveThread(data, programConfig);
        autosaveThread.start();
    }
}