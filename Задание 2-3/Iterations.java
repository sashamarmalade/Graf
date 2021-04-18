
package sample;

//import javafx.application.Platform;
import javafx.scene.control.ProgressBar;

public class Iterations implements Runnable {

    private final ProgressBar progressBar;

//    private int counter;

    public Iterations(final ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    public void run() {
        synchronized (progressBar) {
            for (int counter = (int) (progressBar.getProgress() * 1000); counter < 1000; counter++) {
//                Platform.runLater(() -> progressBar.setProgress(counter / 1000d));
                progressBar.setProgress(counter / 1000d);
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

}