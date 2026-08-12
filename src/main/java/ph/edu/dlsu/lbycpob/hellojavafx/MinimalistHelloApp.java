package ph.edu.dlsu.lbycpob.hellojavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MinimalistHelloApp extends Application {
    @Override
    public void start(Stage window){
        Label label = new Label("   \t\t   Hello LBYCPOB OOP! by Tim, Ken, and Serena");
        window.setTitle("HelloApplication by Tim, Ken, and Serena");
        window.setScene(new Scene(label, 320, 240));
        window.show();
    }
    static void main() { launch(); }
}
