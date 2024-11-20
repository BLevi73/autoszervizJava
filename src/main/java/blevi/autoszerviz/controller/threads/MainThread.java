package blevi.autoszerviz.controller.threads;

import blevi.autoszerviz.controller.listeners.MainWindowAdapter;
import blevi.autoszerviz.view.MainFrame;

public class MainThread extends Thread {
    @Override
    public void run() {
        MainFrame mainFrame = new MainFrame();
        mainFrame.addWindowListener(new MainWindowAdapter());
    }
}
