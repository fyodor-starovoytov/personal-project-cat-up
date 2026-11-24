package fi.jyu.prg2.starvera.personalprojectexpenseproject.controller;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class popupController {
    private static final String RESOURCES = "/fi/jyu/prg2/starvera/personalprojectexpenseproject/";
    private static final double WIDTH = 280;
    private static final double HEIGHT = 160;
    private static final double MARGIN = 24;

    @FXML
    private Label speechBubble;
    @FXML private ImageView catImage;
    private final PauseTransition speechTimer =
            new PauseTransition(Duration.seconds(3));
    private final PauseTransition entranceTimer =
            new PauseTransition(Duration.seconds(6));
    private final PauseTransition exitTimer =
            new PauseTransition(Duration.seconds(2));

    private Stage popup;
    private boolean exiting;
    public static popupController create(Stage owner) throws IOException {
        FXMLLoader loader = new FXMLLoader(resource("kissanäkymä.fxml"));
        Scene scene = new Scene(
                loader.load(), WIDTH, HEIGHT, Color.TRANSPARENT);
        popupController controller = loader.getController();

        Stage stage = new Stage(StageStyle.TRANSPARENT);
        stage.initOwner(owner);
        stage.setAlwaysOnTop(true);
        stage.setResizable(false);
        stage.setScene(scene);

        controller.popup = stage;
        stage.setOnHidden(event -> controller.reset());
        return controller;
    }
    @FXML
    private void initialize() {
        speechTimer.setOnFinished(event -> speechBubble.setVisible(false));
        entranceTimer.setOnFinished(event -> playGif("play phase.gif"));
        exitTimer.setOnFinished(event -> popup.hide());
    }

    public void showMessage(String message) {
        if (exiting) {
            return;
        }

        speechBubble.setText(message);
        speechBubble.setVisible(true);
        playGif("coming to screen phase.gif");

        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        popup.setX(bounds.getMaxX() - WIDTH - MARGIN);
        popup.setY(bounds.getMaxY() - HEIGHT - MARGIN);
        popup.show();

        speechTimer.playFromStart();
        entranceTimer.playFromStart();
    }
    @FXML
    private void dismiss() {
        if (exiting) {
            return;
        }

        exiting = true;
        speechTimer.stop();
        entranceTimer.stop();
        speechBubble.setVisible(false);
        playGif("end phase.gif");
        exitTimer.playFromStart();
    }

    private void playGif(String filename) {
        catImage.setImage(new Image(resource(filename).toExternalForm()));
    }

    private void reset() {
        speechTimer.stop();
        entranceTimer.stop();
        exitTimer.stop();
        catImage.setImage(null);
        exiting = false;
    }

    private static URL resource(String filename) {
        return Objects.requireNonNull(
                popupController.class.getResource(RESOURCES + filename),
                "Missing popup resource: " + filename);
    }


}
