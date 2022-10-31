package a22.climoilou.sim203.formatif.formatif5.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.io.BufferedReader;
import java.io.FileReader;

public class FichierLectureService extends Service<String> {
    @Override
    protected Task<String> createTask() {
        return new FichierReaderStringTask();
    }

    private class FichierReaderStringTask extends Task<String> {

        @Override
        protected String call() throws Exception {
            gaspilleTemps();
            BufferedReader br = new BufferedReader(new FileReader("text.txt"));
            SlowHelper.slow(1000);
            String text = br.readLine();
            updateMessage(text);
            updateProgress(0, 0);
            return text;
        }

        public void gaspilleTemps() {
            for (int i = 0; i < 10 && !isCancelled(); i++) {
                SlowHelper.slowRandom(100, 1000);
            }
            if(isCancelled()){
                updateMessage("service anullé");

                updateProgress(1, 1);
            }
        }
    }
}
