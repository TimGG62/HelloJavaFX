package ph.edu.dlsu.lbycpob.hellojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
// Note: This file has same code as the original HelloApplication.java
public class FlagAppWithSceneBuilder extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FlagAppWithSceneBuilder.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello! We are Cruz, Rasing, and Smith!");
        stage.setScene(scene);
        stage.show(); } }