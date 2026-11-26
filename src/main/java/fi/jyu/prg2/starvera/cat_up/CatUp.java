package fi.jyu.prg2.starvera.cat_up;

import fi.jyu.prg2.starvera.cat_up.listener.RunningAppListener;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CatUp extends Application {
    RunningAppListener listener = new RunningAppListener();

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(CatUp.class.getResource("app_menu_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        listener.startReadingNewProcesses();
    }
}
