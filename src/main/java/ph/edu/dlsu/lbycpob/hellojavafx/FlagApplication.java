package ph.edu.dlsu.lbycpob.hellojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class FlagApplication extends Application {
    // Variables to store initial click position
    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("flag.fxml"));
        Scene scene = new Scene(loader.load(), 400, 208);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);

        // Make the window draggable
        scene.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        scene.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}