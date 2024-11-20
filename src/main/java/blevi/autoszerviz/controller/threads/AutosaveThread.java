package blevi.autoszerviz.controller.threads;

public class AutosaveThread extends Thread {
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
