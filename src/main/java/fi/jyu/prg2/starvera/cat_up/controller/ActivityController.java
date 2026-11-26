package fi.jyu.prg2.starvera.cat_up.controller;

import fi.jyu.prg2.starvera.cat_up.model.Notification;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ActivityController implements Initializable {
    @FXML
    private ListView<Notification> activityList;

//    void showActivity(Notification notification) {
//        Platform.runLater(() -> activityList.getItems().add(0, notification));
//    }

    @FXML
    protected void onReturnButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fi/jyu/prg2/starvera/cat_up/app_menu_view.fxml"));
        Scene currentScene = ((Node) event.getSource()).getScene();
        currentScene.setRoot(root);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        activityList.setItems(Notification.notifications);
    }
}
