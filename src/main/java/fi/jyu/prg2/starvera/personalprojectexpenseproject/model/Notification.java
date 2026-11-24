package fi.jyu.prg2.starvera.personalprojectexpenseproject.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Notification {
    private SimpleStringProperty notificationName;
    private SimpleStringProperty notificationDescription;
    private SimpleStringProperty notificationTime;
    public static ObservableList<String> notifications = FXCollections.observableArrayList();

    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Notification(String notificationName, String notificationDescription) {
        this.notificationName =
                new SimpleStringProperty(notificationName);
        this.notificationTime =
                new SimpleStringProperty(LocalDateTime.now().format(FORMATTER));
        this.notificationDescription =
                new SimpleStringProperty(notificationDescription);

        notifications.add(this.toString());
    }

    @Override
    public String toString() {
        return notificationName.get() + " (" + notificationTime.get() + ")" + "\n" + notificationDescription.get();
    }

    public String getNotificationName() {
        return notificationName.get();
    }

    public SimpleStringProperty notificationNameProperty() {
        return notificationName;
    }

    public String getNotificationDescription() {
        return notificationDescription.get();
    }

    public SimpleStringProperty notificationDescriptionProperty() {
        return notificationDescription;
    }

    public String getNotificationTime() {
        return notificationTime.get();
    }

    public SimpleStringProperty notificationTimeProperty() {
        return notificationTime;
    }
}
