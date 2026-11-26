package fi.jyu.prg2.starvera.cat_up.listener;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ScheduledExecutor {
    /**
     * Initializes timer for new process checks
     * */
    public static final ScheduledExecutorService timer =
            Executors.newSingleThreadScheduledExecutor(task -> {
                Thread thread = new Thread(task, "cat_up_monitor");
                thread.setDaemon(true);
                return thread;
            });
}
