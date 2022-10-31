package a22.climoilou.sim203.formatif.formatif5.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FichierEcritureService extends Service<Void> {

    private String message;

    @Override
    protected Task<Void> createTask() {
        return new FichierWriterVoidTask();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private class FichierWriterVoidTask extends Task<Void> {

        @Override
        protected Void call() throws Exception {
            gaspilleTemps();
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter("text.txt"));
                bw.write(message);
            } finally {
                if (bw != null) {
                    bw.close();
                }
            }
            return null;
        }

        public void gaspilleTemps() {
            for (int i = 0; i < 10 && !isCancelled(); i++) {
                SlowHelper.slowRandom(100, 1000);

                updateProgress(i, 9);
                updateMessage("étape " + i);
            }
            if(isCancelled()){
                updateMessage("service anullé");

                updateProgress(1, 1);
            }
        }
    }

}
