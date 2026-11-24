package fi.jyu.prg2.starvera.personalprojectexpenseproject.controller;

import fi.jyu.prg2.starvera.personalprojectexpenseproject.model.Notification;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ActivityController implements Initializable {
    @FXML
    private ListView<String> activityList;

//    void showActivity(Notification notification) {
//        Platform.runLater(() -> activityList.getItems().add(0, notification));
//    }

    @FXML
    protected void onReturnButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fi/jyu/prg2/starvera/personalprojectexpenseproject/app_menu_view.fxml"));
        Scene currentScene = ((Node) event.getSource()).getScene();
        currentScene.setRoot(root);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        activityList.setItems(Notification.notifications);
    }
}
