package fi.jyu.prg2.starvera.cat_up.listener;

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

public class DownloadFolderListener {

    private final SystemInfo systemInfo = new SystemInfo();
    private final String osFamily = systemInfo.getOperatingSystem().getFamily();

    private void startReadingDownloads(){
        ScheduledExecutor.timer.scheduleWithFixedDelay(() -> {

            

        }, 5, 5, TimeUnit.SECONDS);
    }
}
