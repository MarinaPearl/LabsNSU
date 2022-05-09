package ru.nsu.Demchuk.lab3.View;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ru.nsu.Demchuk.lab3.Controller.Controller;
import ru.nsu.Demchuk.lab3.Model.Model;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import static ru.nsu.Demchuk.lab3.View.Constants.*;

public class TetrisView {
    private static Pane group = new Pane();
    private static GenerationFigure object;
    private static Scene scene = new Scene(group, XMAX + 150, YMAX, Color.BLACK);
    private static int lines;
    private boolean game;
    private static GenerationFigure nextObj = Controller.createFigure();
    private Stage stage;
    private int top;
    public TetrisView(Stage stage) {
        Controller.nullingArray();
        top = 0;
        group.getChildren().clear();
        this.stage = stage;
        this.game = true;
        this.lines = 0;

    }
    public void start() throws Exception {
        Image image = new Image(PATH_IN_TO_IMAGE_MENU);
        ImageView img = new ImageView(image);
        img.setFitWidth(FIELD_WIDTH);
        img.setFitHeight(FIELD_HEIGHT);
        group.getChildren().add(img);
        Line line = new Line(XMAX, 0, XMAX, YMAX);
        line.setStroke(Color.WHITE);
        Text level = new Text("Lines: ");
        level.setStyle("-fx-font: 20 arial;");
        level.setY(100);
        level.setX(XMAX + 5);
        level.setFill(Color.PINK);
        group.getChildren().addAll(line, level);

        GenerationFigure a = nextObj;
        group.getChildren().addAll(a.square1, a.square2, a.square3, a.square4);
        Controller.moveOnKeyPress(a, scene, group);
        object = a;
        nextObj = Controller.createFigure();
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.setTitle("T E T R I S");
        stage.show();
        Timer time = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (object.square1.getY() == 0 || object.square2.getY() == 0 ||
                                object.square3.getY() == 0 || object.square4.getY() == 0) {
                            ++top;
                        } else top = 0;
                        if (top == 2) {
                            Text gameOver = new Text("GAME OVER");
                            gameOver.setFill(Color.RED);
                            gameOver.setX(10);
                            gameOver.setY(250);
                            gameOver.setStyle("-fx-font: 70 arial;");
                            group.getChildren().add(gameOver);
                            game = false;
                        }
                        if (top == 5) {
                            Main retur = new Main();
                            try {
                                retur.start(stage);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (game) {
                            Controller.doDown(object, group);
                            lines = Model.getLine();
                            level.setText("Lines: " + Integer.toString(lines));
                        } else {

                        }
                    }
                });
            }
        };
        time.schedule(task, 0, 300);
    }
    public static void makeNewRect(){
        GenerationFigure a = nextObj;
        nextObj = Controller.createFigure();
        object = a;
        group.getChildren().addAll(a.square1, a.square2, a.square3, a.square4);
        Controller.moveOnKeyPress(a, scene, group);
    }
}
