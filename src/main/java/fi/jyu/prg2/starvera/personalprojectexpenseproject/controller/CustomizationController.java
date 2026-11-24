package fi.jyu.prg2.starvera.personalprojectexpenseproject.controller;

import fi.jyu.prg2.starvera.personalprojectexpenseproject.controller.popupController;
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

        popupController catPopup = (popupController)
                owner.getProperties().get(popupController.class);

        if (catPopup == null) {
            catPopup = popupController.create(owner);
            owner.getProperties().put(popupController.class, catPopup);
        }

        catPopup.showMessage("Notes just opened!");
    }

    @FXML
    private void onReturnButtonClick(ActionEvent event) throws IOException {
        Parent menu = FXMLLoader.load(getClass().getResource(
                "/fi/jyu/prg2/starvera/personalprojectexpenseproject/app_menu_view.fxml"));
        Scene scene = ((Node) event.getSource()).getScene();
        scene.setRoot(menu);
    }
}
