package ph.edu.dlsu.lbycpob.hellojavafx;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class PhilippineFlagApp {
    private GraphicsContext graphics;
    private Canvas canvas;

    @Override
    public void start(Stage stage) {
        canvas = new Canvas(600, 400);
        graphics = canvas.getGraphicsContext2D();

        drawFlag(50, 50, 500);
        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Philippine Flag");
        stage.setScene(scene);
        stage.show();
    }

    private Canvas drawFlag(int x, int y, int width) {
        int height = width / 2;
        drawBlueStripe(x, y, width, height);
        drawRedStripe(x, y, width, height);
        drawWhiteTriangle(x, y, width, height);

        drawSun(x + 60, y + height/2 - 25, 50 );
        drawThreeStars(x, y, width, height);
        return canvas;
    }
}
