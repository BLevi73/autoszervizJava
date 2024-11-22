package blevi.autoszerviz;

import blevi.autoszerviz.controller.threads.AutosaveThread;
import blevi.autoszerviz.controller.threads.MainThread;

public class Main {
    public static void main(String[] args) {
        MainThread mainThread = new MainThread();
        mainThread.start();
        AutosaveThread autosaveThread = new AutosaveThread();
        autosaveThread.start();
    }
}