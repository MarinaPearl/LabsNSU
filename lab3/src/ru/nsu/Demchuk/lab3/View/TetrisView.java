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

public class TetrisView implements View {
    private Line line;
    private Text level;
    private static Pane group = new Pane();
    private static GenerationFigure object;
    private static Scene scene = new Scene(group, XMAX + 150, YMAX, Color.BLACK);
    private static final int NULL_SET = 0;
    private static final int LEVEL_X = 5;
    private static final int LEVEL_Y = 100;
    private static final String NAME_GAME = "T E T R I S";
    private static final String EXIT = "GAME OVER";
    private static final int SECONDS = 300;
    private static final int TOP_IF = 2;
    private static final int TOP_EXIT = 5;
    private static final int GAME_X = 10;
    private static final int GAME_Y = 250;
    private static final String GAME_OVER = "-fx-font: 70 arial;";
    private static final String STYLE_LINE = "-fx-font: 20 arial;";
    private static final String LINE = "Lines: ";
    private static int lines;
    private boolean game;
    private static GenerationFigure nextObj = Controller.createFigure();
    private Stage stage;
    private int top;
    public TetrisView(Stage stage) {
        Controller.nullingArray();
        top = NULL_SET;
        group.getChildren().clear();
        this.stage = stage;
        this.game = true;
        this.lines = NULL_SET;

    }
    public void start() throws Exception {
        Image image = new Image(PATH_IN_TO_IMAGE_MENU);
        ImageView img = new ImageView(image);
        img.setFitWidth(FIELD_WIDTH);
        img.setFitHeight(FIELD_HEIGHT);
        setLine();
        setLevel();
        group.getChildren().add(img);
        group.getChildren().addAll(line, level);
        GenerationFigure a = nextObj;
        group.getChildren().addAll(a.square1, a.square2, a.square3, a.square4);
        Controller.moveOnKeyPress(a, scene, group);
        object = a;
        nextObj = Controller.createFigure();
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.setTitle(NAME_GAME);
        stage.show();
        Timer time = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (object.square1.getY() == NULL_SET || object.square2.getY() == NULL_SET||
                                object.square3.getY() == NULL_SET || object.square4.getY() == NULL_SET) {
                            ++top;
                        } else top = NULL_SET;
                        if (top == TOP_IF) {
                            Text gameOver = new Text(EXIT);
                            gameOver.setFill(Color.RED);
                            gameOver.setX(GAME_X);
                            gameOver.setY(GAME_Y);
                            gameOver.setStyle(GAME_OVER);
                            group.getChildren().add(gameOver);
                            game = false;
                        }
                        if (top == TOP_EXIT) {
                            Controller.returnMenu(stage);
                        }
                        if (game) {
                            Controller.doDown(object, group);
                            lines = Model.getLine();
                            level.setText(LINE + Integer.toString(lines));
                        } else {

                        }
                    }
                });
            }
        };
        time.schedule(task, NULL_SET, 300);
    }
    public static void makeNewRect(){
        GenerationFigure a = nextObj;
        nextObj = Controller.createFigure();
        object = a;
        group.getChildren().addAll(a.square1, a.square2, a.square3, a.square4);
        Controller.moveOnKeyPress(a, scene, group);
    }
    private void setLine() {
        line = new Line(XMAX, NULL_SET, XMAX, YMAX);
        line.setStroke(Color.WHITE);
    }
    private void setLevel() {
        level = new Text(LINE);
        level.setStyle(STYLE_LINE);
        level.setY(LEVEL_Y);
        level.setX(XMAX + LEVEL_X);
        level.setFill(Color.PINK);

    }
}
