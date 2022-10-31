package a21.climoilou.mono2.formatifs.formatif6.service.flasher;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

import java.sql.Time;

public class FlasherAnimationService extends ScheduledService<Boolean>{
    private boolean b = false;

    @Override
    protected Task<Boolean> createTask() {
        return new FlasherAnimationTask();
    }
    public class FlasherAnimationTask extends Task<Boolean>{

        @Override
        protected Boolean call() throws Exception {
            b = !b;
            return b;
        }
    }
}

