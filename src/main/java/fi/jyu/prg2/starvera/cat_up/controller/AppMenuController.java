package fi.jyu.prg2.starvera.cat_up.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;

public class AppMenuController {

    @FXML
    private void onCustomizeButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fi/jyu/prg2/starvera/cat_up/customization_view.fxml"));
        Scene currentScene = ((Node) event.getSource()).getScene();
        currentScene.setRoot(root);
    }

    @FXML
    private void onChooseButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fi/jyu/prg2/starvera/cat_up/cat_up_view.fxml"));
        Scene currentScene = ((Node) event.getSource()).getScene();
        currentScene.setRoot(root);
    }

    @FXML
    private void onActivityButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fi/jyu/prg2/starvera/cat_up/activity_view.fxml"));
        Scene currentScene = ((Node) event.getSource()).getScene();
        currentScene.setRoot(root);
    }
}
