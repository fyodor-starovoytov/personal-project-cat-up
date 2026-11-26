package fi.jyu.prg2.starvera.cat_up;

import fi.jyu.prg2.starvera.cat_up.model.Notification;
import javafx.application.Platform;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RunningAppListener {

    private final SystemInfo systemInfo = new SystemInfo();
    private final String osFamily = systemInfo.getOperatingSystem().getFamily();

    private final ScheduledExecutorService monitor =
            Executors.newSingleThreadScheduledExecutor(task -> {
                Thread thread = new Thread(task, "monitor");
                thread.setDaemon(true);
                return thread;
            });

    private Set<String> previousProcessNames = new HashSet<>();
    private Set<Integer> previousPIDs = new HashSet<>();

    public void startReadingNewProcesses() {
        for (OSProcess process : systemInfo.getOperatingSystem().getProcesses()) {
            previousPIDs.add(process.getProcessID());
            if (process.getName() != null) {
                previousProcessNames.add(process.getName().toLowerCase());
            }
        }

        monitor.scheduleWithFixedDelay(() -> {
            List<OSProcess> systemProcesses = systemInfo.getOperatingSystem().getProcesses();
            Set<Integer> currentPIDs = new HashSet<>();
            Set<String> currentProcessNames = new HashSet<>();

            for (OSProcess process : systemProcesses) {
                int pid = process.getProcessID();
                String name = process.getName();
                if (name == null || name.isEmpty()) continue;

                String lowerName = name.toLowerCase();
                String processPath = process.getPath();

                currentPIDs.add(pid);
                currentProcessNames.add(lowerName);

                if (!previousPIDs.contains(pid) && !previousProcessNames.contains(lowerName)) {
                    boolean readSystemProcesses = false;

                    if (!readSystemProcesses && osFamily.equalsIgnoreCase("windows")) {
                        if (processPath.contains("\\Windows\\") || lowerName.equals("svchost")) {
                            continue;
                        }
                    }

                    String displayName = name.substring(0, 1).toUpperCase() + name.substring(1);
                    Platform.runLater(() -> {
                        try {
                            new Notification(
                                    displayName + " has been launched",
                                    "Program '" + name + "' has been just launched!\n" + processPath,
                                    lowerName
                            );
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

                    previousProcessNames.add(lowerName);
                }
            }

            previousPIDs = currentPIDs;
            previousProcessNames = currentProcessNames;
        }, 5, 5, TimeUnit.SECONDS);
    }
}