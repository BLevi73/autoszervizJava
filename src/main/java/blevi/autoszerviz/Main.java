package blevi.autoszerviz;

import blevi.autoszerviz.controller.threads.MainThread;

public class Main {
    public static void main(String[] args) {
        MainThread graphicsThread = new MainThread();
        graphicsThread.start();
    }
}