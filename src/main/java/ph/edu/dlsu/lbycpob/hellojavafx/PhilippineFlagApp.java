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
    void drawBlueStripe(int x, int y, int width, int height) {
        graphics.setFill(Color.BLUE);
        graphics.fillRect(x, y, width, height/2);
    }
    void drawRedStripe(int x, int y, int width, int height) {
        graphics.setFill(Color.RED);
        graphics.fillRect(x, y+height/2, width, height/2);
    }

    void drawWhiteTriangle(int x, int y, int width, int height) {
        double[] xPoints = {x, x, x + width/2};
        double[] yPoints = {y, y + height, y + height/2};

        graphics.setFill(Color.WHITE);
        graphics.fillPolygon(xPoints, yPoints, 3);
    }

    void drawSun(int x, int y, int size) {
        graphics.setFill(Color.GOLD);
        graphics.fillOval(x, y, size, size);
        double centerX = x + size / 2;
        double centerY = y + size / 2;
        drawDiagonalRays(centerX, centerY, size);
    }

    void drawDiagonalRays(double centerX, double centerY, double size ) {
        double rayLength = size * 0.8;
        double verticalLength = size * 1.2;
        graphics.setStroke(Color.GOLD);
        graphics.setLineWidth(3);

        graphics.strokeLine(centerX, centerY - verticalLength, centerX, centerY + verticalLength);

        graphics.strokeLine(centerX - verticalLength, centerY, centerX + verticalLength, centerY);

        graphics.strokeLine(centerX - rayLength, centerY - rayLength, centerX + rayLength, centerY + rayLength);

        graphics.strokeLine(centerX + rayLength, centerY - rayLength, centerX - rayLength, centerY + rayLength);
    }
void drawSingleStar(double centerX, double centerY, double radius) {
    double[] xPoints = new double[10];
    double[] yPoints = new double[10];
    double startingAngle = -90;
    double innerRadius = radius * 0.4;
    double currentRadius;
    for(int i = 0; i < 10; i++) {
        double angle = Math.toRadians(startingAngle + i * 36);

        if(i%2 != 0){
            currentRadius = innerRadius;
        }
        else {
            currentRadius = radius;
        }

        xPoints[i] = centerX + currentRadius * Math.cos(angle);
        yPoints[i] = centerY + currentRadius * Math.sin(angle);
    }

    graphics.setFill(Color.GOLD);
    graphics.fillPolygon(xPoints, yPoints, 10);
}

void drawThreeStars(int x, int y, int width, int height) {
    double starRadius = width * 0.03;
    drawSingleStar(x+15, y+27, starRadius);
    drawSingleStar(x+15, y+height-28, starRadius);
    drawSingleStar(x+width/2 - 30, y+height/2, starRadius);
}
}