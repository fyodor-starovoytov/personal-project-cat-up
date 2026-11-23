package fi.jyu.prg2.starvera.personalprojectexpenseproject.model;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Notification {
    private SimpleStringProperty notificationName;
    private SimpleStringProperty notificationDescription;
    private SimpleStringProperty notificationTime;

    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Notification(String notificationName, String notificationDescription) {
        this.notificationName = new SimpleStringProperty(notificationName) ;
        this.notificationDescription = new SimpleStringProperty(notificationDescription);
        this.notificationTime = new SimpleStringProperty(LocalDateTime.now().format(FORMATTER));
    }
}
