package fi.jyu.prg2.starvera.personalprojectexpenseproject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CatUpController {

    @FXML
    protected void onReturnButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fi/jyu/prg2/starvera/personalprojectexpenseproject/app_menu_view.fxml"));
        Scene currentScene = ((Node) event.getSource()).getScene();
        currentScene.setRoot(root);
    }
}
