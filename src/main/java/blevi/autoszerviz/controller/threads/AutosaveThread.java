package blevi.autoszerviz.controller.threads;

import java.time.LocalDateTime;

import blevi.autoszerviz.controller.filehandlers.SerializationType;
import blevi.autoszerviz.controller.logic.ProgramConfig;
import blevi.autoszerviz.model.datasources.Data;

/**
 * Autosave thread, creates an autosave of the currently opened data.
 * The time between autosaves is loaded from the programConfig object.
 */
public class AutosaveThread extends Thread {
    private Data data;
    private ProgramConfig programConfig;
    public AutosaveThread(Data data, ProgramConfig programConfig) {
        this.data = data;
        this.programConfig = programConfig;
        this.setName("Autosave Thread");
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(programConfig.getAutosaveInterval());
                data.write(System.getProperty("user.home") + "/autosave.zip", SerializationType.ZIP);
                System.out.println("Autosave event happened at: " + LocalDateTime.now());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
