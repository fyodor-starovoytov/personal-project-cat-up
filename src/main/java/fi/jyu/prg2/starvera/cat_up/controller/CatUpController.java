package fi.jyu.prg2.starvera.cat_up.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class CatUpController {

    @FXML
    protected void onReturnButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fi/jyu/prg2/starvera/cat_up/app_menu_view.fxml"));
        Scene currentScene = ((Node) event.getSource()).getScene();
        currentScene.setRoot(root);
    }
}
