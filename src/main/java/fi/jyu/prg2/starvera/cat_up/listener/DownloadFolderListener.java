package fi.jyu.prg2.starvera.cat_up.listener;

import oshi.SystemInfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DownloadFolderListener {

    private final String HOME = System.getProperty("user.home");
    private final Path PATH_DOWNLOADS = Paths.get(HOME, "Downloads");

    private Set<Path> downloads;

    public void readDownloads() {
        try (Stream<Path> stream = Files.list(PATH_DOWNLOADS)) {
            downloads = stream.collect(Collectors.toSet());
        } catch (IOException e) {
            System.out.println("Error: Couldn't find 'Downloads' folder");
            throw new RuntimeException(e);
        }
    }

    private void startReadingDownloads(){
        ScheduledExecutor.timer.scheduleWithFixedDelay(() -> {

        }, 5, 5, TimeUnit.SECONDS);
    }
}
