package fi.jyu.prg2.starvera.personalprojectexpenseproject.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CatUpController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
