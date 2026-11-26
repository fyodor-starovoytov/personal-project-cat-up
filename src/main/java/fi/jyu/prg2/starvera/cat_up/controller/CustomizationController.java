package fi.jyu.prg2.starvera.cat_up.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomizationController {
    @FXML
    private void onPreviewCatClick(ActionEvent event) throws IOException {
        Stage owner = (Stage) ((Node) event.getSource()).getScene().getWindow();

        PopupController catPopup = (PopupController)
                owner.getProperties().get(PopupController.class);

        if (catPopup == null) {
            catPopup = PopupController.create(owner);
            owner.getProperties().put(PopupController.class, catPopup);
        }

        catPopup.showMessage("Notes just opened!");
    }

    @FXML
    private void onReturnButtonClick(ActionEvent event) throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource(
                "/fi/jyu/prg2/starvera/cat_up/app_menu_view.fxml"));
        Scene scene = ((Node) event.getSource()).getScene();
        scene.setRoot(menu);
    }
}
