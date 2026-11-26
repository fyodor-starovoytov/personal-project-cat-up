package fi.jyu.prg2.starvera.cat_up.model;

import fi.jyu.prg2.starvera.cat_up.controller.PopupController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Notification {
    private final SimpleStringProperty notificationName;
    private final SimpleStringProperty notificationDescription;
    private final SimpleStringProperty notificationTime;
    private final String processName;

    public static final ObservableList<Notification> notifications = FXCollections.observableArrayList();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    /**
     * Initializes Cat Pop-Up Screen
     * */
    Stage stage = new Stage(StageStyle.TRANSPARENT);
    PopupController popupController = PopupController.create(stage);

    public Notification(String notificationName, String notificationDescription, String processName) throws IOException {
        this.notificationName = new SimpleStringProperty(notificationName);
        this.notificationTime = new SimpleStringProperty(LocalDateTime.now().format(FORMATTER));
        this.notificationDescription = new SimpleStringProperty(notificationDescription);
        this.processName = processName.toLowerCase();

        notifications.add(this);
        popupController.showMessage(notificationName);
    }

    public String getProcessName() {
        return processName;
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
