package fi.jyu.prg2.starvera.personalprojectexpenseproject.controller;

import fi.jyu.prg2.starvera.personalprojectexpenseproject.model.Notification;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

import java.io.IOException;

public class ActivityController {
    @FXML
    private ListView<Notification> activityList;

    void showActivity(Notification notification) {
        Platform.runLater(() -> activityList.getItems().add(0, notification));
    }

    @FXML
    protected void onReturnButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fi/jyu/prg2/starvera/personalprojectexpenseproject/app_menu_view.fxml"));
        Scene currentScene = ((Node) event.getSource()).getScene();
        currentScene.setRoot(root);
    }


}
