package fi.jyu.prg2.starvera.personalprojectexpenseproject;

import fi.jyu.prg2.starvera.personalprojectexpenseproject.model.Notification;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RunningAppListener {

    private final ScheduledExecutorService monitor =
            Executors.newSingleThreadScheduledExecutor(task -> {
                Thread thread = new Thread(task, "monitor");
                thread.setDaemon(true);
                return thread;
            });

    private Set<Integer> previousPIDs = new HashSet<>();

    public void startReadingNewProcesses(){
        monitor.scheduleWithFixedDelay(() -> {
            List<OSProcess> systemProcesses = new SystemInfo().getOperatingSystem().getProcesses();

            Set<Integer> currentPIDs = new HashSet<>();

            for (OSProcess process : systemProcesses) {
                int pid = process.getProcessID();
                currentPIDs.add(pid);

                if (previousPIDs != null && !previousPIDs.contains(pid)) {
                    String name = process.getName();
                    Notification notification = new Notification(name + " has launched",
                            "Program '" + name + "' has been just launched");
                }
        }

        previousPIDs = currentPIDs;
    }, 0, 5, TimeUnit.SECONDS);
    }
}
