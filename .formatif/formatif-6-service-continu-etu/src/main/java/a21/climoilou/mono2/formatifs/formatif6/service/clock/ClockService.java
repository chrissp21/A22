package a21.climoilou.mono2.formatifs.formatif6.service.clock;


import a21.climoilou.mono2.formatifs.formatif6.service.SlowHelper;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.time.LocalDateTime;

public class ClockService extends Service<LocalDateTime> {

    @Override
    protected Task<LocalDateTime> createTask() {
        return new ClockTask();
    }

    public class ClockTask extends Task<LocalDateTime> {

        @Override
        protected LocalDateTime call() throws Exception {
            while (!isCancelled()){

                updateValue(LocalDateTime.now());
                SlowHelper.slow(1000);
            }
            return LocalDateTime.now();
        }
    }
}
