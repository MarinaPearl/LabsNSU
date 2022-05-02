package ru.nsu.Demchuk.lab3;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;


public class Tetris{
    public static final int MOVE = 25;
    public static final int SIZE = 25;
    public static int XMAX = SIZE * 12;
    public static int YMAX = SIZE * 24;
    public static int[][] MESH = new int[XMAX / SIZE][YMAX / SIZE];
    private static Pane group = new Pane();
    private static GenerationFigure object;
    private static Scene scene = new Scene(group, XMAX + 150 , YMAX, Color.BLACK);
    public static int score;
    private static int top;
    private static boolean game = true;
    private static GenerationFigure nextObj = Controller.makeRect();
    private static int linesNo = 0;
    private Stage stage;

    public Tetris(Stage stage) {
        group.getChildren().clear();
        this.stage = stage;
        this.game = true;
        this.score = 0;
        this.top = 0;
        this.linesNo = 0;

    }
    public void start() throws Exception {
        for (int[] a : MESH) {
            Arrays.fill(a, 0);
        }
        Line line = new Line(XMAX, 0, XMAX, YMAX);
        line.setStroke(Color.WHITE);
        Text scoretext = new Text("Score: ");
        scoretext.setStyle("-fx-font: 20 arial;");
        scoretext.setY(50);
        scoretext.setX(XMAX + 5);
        Text level = new Text("Lines: ");
        level.setStyle("-fx-font: 20 arial;");
        level.setY(100);
        level.setX(XMAX + 5);
        level.setFill(Color.PINK);
        scoretext.setFill(Color.PINK);
        group.getChildren().addAll(scoretext, line, level);

        GenerationFigure a = nextObj;
        group.getChildren().addAll(a.square1, a.square2, a.square3, a.square4);
        moveOnKeyPress(a);
        object = a;
        nextObj = Controller.makeRect();
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
                            retur.start(stage);
                        }
                        if (game) {
                            MoveDown(object);
                            scoretext.setText("Score: " + Integer.toString(score));
                            level.setText("Lines: " + Integer.toString(linesNo));
                        } else {

                        }
                    }
                });
            }
        };
       time.schedule(task, 0, 300);
   }

    private void moveOnKeyPress(GenerationFigure form) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case RIGHT:
                        Controller.moveRight(form);
                        break;
                    case DOWN:
                        MoveDown(form);
                        score++;
                        break;
                    case LEFT:
                        Controller.moveLeft(form);
                        break;
                    case UP:
                        MoveTurn(form);
                        break;
                }
            }
        });
    }

    private void MoveTurn(GenerationFigure form) {
        int f = form.form;
        Rectangle a = form.square1;
        Rectangle b = form.square2;
        Rectangle c = form.square3;
        Rectangle d = form.square4;
        switch (form.getName()) {
            case "j":
                if (f == 1 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
                    MoveRight(form.square1);
                    MoveDown(form.square1);
                    MoveDown(form.square3);
                    MoveLeft(form.square3);
                    MoveDown(form.square4);
                    MoveDown(form.square4);
                    MoveLeft(form.square4);
                    MoveLeft(form.square4);
                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, -2, 2)) {
                    MoveDown(form.square1);
                    MoveLeft(form.square1);
                    MoveLeft(form.square3);
                    MoveUp(form.square3);
                    MoveLeft(form.square4);
                    MoveLeft(form.square4);
                    MoveUp(form.square4);
                    MoveUp(form.square4);
                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, 1) && cB(c, 1, 1) && cB(d, 2, 2)) {
                    MoveLeft(form.square1);
                    MoveUp(form.square1);
                    MoveUp(form.square3);
                    MoveRight(form.square3);
                    MoveUp(form.square4);
                    MoveUp(form.square4);
                    MoveRight(form.square4);
                    MoveRight(form.square4);
                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 2, -2)) {
                    MoveUp(form.square1);
                    MoveRight(form.square1);
                    MoveRight(form.square3);
                    MoveDown(form.square3);
                    MoveRight(form.square4);
                    MoveRight(form.square4);
                    MoveDown(form.square4);
                    MoveDown(form.square4);
                    form.changeForm();
                    break;
                }
                break;
            case "l":
                if (f == 1 && cB(a, 1, -1) && cB(c, 1, 1) && cB(b, 2, 2)) {
                    MoveRight(form.square1);
                    MoveDown(form.square1);
                    MoveUp(form.square3);
                    MoveRight(form.square3);
                    MoveUp(form.square2);
                    MoveUp(form.square2);
                    MoveRight(form.square2);
                    MoveRight(form.square2);
                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(a, -1, -1) && cB(b, 2, -2) && cB(c, 1, -1)) {
                    MoveDown(form.square1);
                    MoveLeft(form.square1);
                    MoveRight(form.square2);
                    MoveRight(form.square2);
                    MoveDown(form.square2);
                    MoveDown(form.square2);
                    MoveRight(form.square3);
                    MoveDown(form.square3);
                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, 1) && cB(c, -1, -1) && cB(b, -2, -2)) {
                    MoveLeft(form.square1);
                    MoveUp(form.square1);
                    MoveDown(form.square3);
                    MoveLeft(form.square3);
                    MoveDown(form.square2);
                    MoveDown(form.square2);
                    MoveLeft(form.square2);
                    MoveLeft(form.square2);
                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(a, 1, 1) && cB(b, -2, 2) && cB(c, -1, 1)) {
                    MoveUp(form.square1);
                    MoveRight(form.square1);
                    MoveLeft(form.square2);
                    MoveLeft(form.square2);
                    MoveUp(form.square2);
                    MoveUp(form.square2);
                    MoveLeft(form.square3);
                    MoveUp(form.square3);
                    form.changeForm();
                    break;
                }
                break;
            case "o":
                break;
            case "s":
                if (f == 1 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)) {
                    MoveDown(form.square1);
                    MoveLeft(form.square1);
                    MoveLeft(form.square3);
                    MoveUp(form.square3);
                    MoveUp(form.square4);
                    MoveUp(form.square4);
                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)) {
                    MoveUp(form.square1);
                    MoveRight(form.square1);
                    MoveRight(form.square3);
                    MoveDown(form.square3);
                    MoveDown(form.square4);
                    MoveDown(form.square4);
                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)) {
                    MoveDown(form.square1);
                    MoveLeft(form.square1);
                    MoveLeft(form.square3);
                    MoveUp(form.square3);
                    MoveUp(form.square4);
                    MoveUp(form.square4);
                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)) {
                    MoveUp(form.square1);
                    MoveRight(form.square1);
                    MoveRight(form.square3);
                    MoveDown(form.square3);
                    MoveDown(form.square4);
                    MoveDown(form.square4);
                    form.changeForm();
                    break;
                }
                break;
            case "t":
                if (f == 1 && cB(a, 1, 1) && cB(d, -1, -1) && cB(c, -1, 1)) {
                    MoveUp(form.square1);
                    MoveRight(form.square1);
                    MoveDown(form.square4);
                    MoveLeft(form.square4);
                    MoveLeft(form.square3);
                    MoveUp(form.square3);
                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(a, 1, -1) && cB(d, -1, 1) && cB(c, 1, 1)) {
                    MoveRight(form.square1);
                    MoveDown(form.square1);
                    MoveLeft(form.square4);
                    MoveUp(form.square4);
                    MoveUp(form.square3);
                    MoveRight(form.square3);
                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(a, -1, -1) && cB(d, 1, 1) && cB(c, 1, -1)) {
                    MoveDown(form.square1);
                    MoveLeft(form.square1);
                    MoveUp(form.square4);
                    MoveRight(form.square4);
                    MoveRight(form.square3);
                    MoveDown(form.square3);
                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(a, -1, 1) && cB(d, 1, -1) && cB(c, -1, -1)) {
                    MoveLeft(form.square1);
                    MoveUp(form.square1);
                    MoveRight(form.square4);
                    MoveDown(form.square4);
                    MoveDown(form.square3);
                    MoveLeft(form.square3);
                    form.changeForm();
                    break;
                }
                break;
            case "z":
                if (f == 1 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)) {
                    MoveUp(form.square2);
                    MoveRight(form.square2);
                    MoveLeft(form.square3);
                    MoveUp(form.square3);
                    MoveLeft(form.square4);
                    MoveLeft(form.square4);
                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)) {
                    MoveDown(form.square2);
                    MoveLeft(form.square2);
                    MoveRight(form.square3);
                    MoveDown(form.square3);
                    MoveRight(form.square4);
                    MoveRight(form.square4);
                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)) {
                    MoveUp(form.square2);
                    MoveRight(form.square2);
                    MoveLeft(form.square3);
                    MoveUp(form.square3);
                    MoveLeft(form.square4);
                    MoveLeft(form.square4);
                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)) {
                    MoveDown(form.square2);
                    MoveLeft(form.square2);
                    MoveRight(form.square3);
                    MoveDown(form.square3);
                    MoveRight(form.square4);
                    MoveRight(form.square4);
                    form.changeForm();
                    break;
                }
                break;
            case "i":
                if (f == 1 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)) {
                    MoveUp(form.square1);
                    MoveUp(form.square1);
                    MoveRight(form.square1);
                    MoveRight(form.square1);
                    MoveUp(form.square2);
                    MoveRight(form.square2);
                    MoveDown(form.square4);
                    MoveLeft(form.square4);
                    form.changeForm();
                    break;
                }
                if (f == 2 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)) {
                    MoveDown(form.square1);
                    MoveDown(form.square1);
                    MoveLeft(form.square1);
                    MoveLeft(form.square1);
                    MoveDown(form.square2);
                    MoveLeft(form.square2);
                    MoveUp(form.square4);
                    MoveRight(form.square4);
                    form.changeForm();
                    break;
                }
                if (f == 3 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)) {
                    MoveUp(form.square1);
                    MoveUp(form.square1);
                    MoveRight(form.square1);
                    MoveRight(form.square1);
                    MoveUp(form.square2);
                    MoveRight(form.square2);
                    MoveDown(form.square4);
                    MoveLeft(form.square4);
                    form.changeForm();
                    break;
                }
                if (f == 4 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)) {
                    MoveDown(form.square1);
                    MoveDown(form.square1);
                    MoveLeft(form.square1);
                    MoveLeft(form.square1);
                    MoveDown(form.square2);
                    MoveLeft(form.square2);
                    MoveUp(form.square4);
                    MoveRight(form.square4);
                    form.changeForm();
                    break;
                }
                break;
        }
    }

    private void RemoveRows(Pane pane) {
        ArrayList<Node> rects = new ArrayList<Node>();
        ArrayList<Integer> lines = new ArrayList<Integer>();
        ArrayList<Node> newrects = new ArrayList<Node>();
        int full = 0;
        for (int i = 0; i < MESH[0].length; i++) {
            for (int j = 0; j < MESH.length; j++) {
                if (MESH[j][i] == 1)
                    full++;
            }
            if (full == MESH.length)
                lines.add(i);
            full = 0;
        }
        if (lines.size() > 0)
            do {
                for (Node node : pane.getChildren()) {
                    if (node instanceof Rectangle)
                        rects.add(node);
                }
                score += 50;
                linesNo++;

                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() == lines.get(0) * SIZE) {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        pane.getChildren().remove(node);
                    } else
                        newrects.add(node);
                }

                for (Node node : newrects) {
                    Rectangle a = (Rectangle) node;
                    if (a.getY() < lines.get(0) * SIZE) {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
                        a.setY(a.getY() + SIZE);
                    }
                }
                lines.remove(0);
                rects.clear();
                newrects.clear();
                for (Node node : pane.getChildren()) {
                    if (node instanceof Rectangle)
                        rects.add(node);
                }
                for (Node node : rects) {
                    Rectangle a = (Rectangle) node;
                    try {
                        MESH[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                rects.clear();
            } while (lines.size() > 0);
    }

    private void MoveDown(Rectangle rect) {
        if (rect.getY() + MOVE < YMAX)
            rect.setY(rect.getY() + MOVE);

    }

    private void MoveRight(Rectangle rect) {
        if (rect.getX() + MOVE <= XMAX - SIZE)
            rect.setX(rect.getX() + MOVE);
    }

    private void MoveLeft(Rectangle rect) {
        if (rect.getX() - MOVE >= 0)
            rect.setX(rect.getX() - MOVE);
    }

    private void MoveUp(Rectangle rect) {
        if (rect.getY() - MOVE > 0)
            rect.setY(rect.getY() - MOVE);
    }

    private void MoveDown(GenerationFigure form) {
        if (form.square1.getY() == YMAX - SIZE || form.square2.getY() == YMAX - SIZE || form.square3.getY() == YMAX - SIZE
                || form.square4.getY() == YMAX - SIZE || moveA(form) || moveB(form) || moveC(form) || moveD(form)) {
            MESH[(int) form.square1.getX() / SIZE][(int) form.square1.getY() / SIZE] = 1;
            MESH[(int) form.square2.getX() / SIZE][(int) form.square2.getY() / SIZE] = 1;
            MESH[(int) form.square3.getX() / SIZE][(int) form.square3.getY() / SIZE] = 1;
            MESH[(int) form.square4.getX() / SIZE][(int) form.square4.getY() / SIZE] = 1;
            RemoveRows(group);

            GenerationFigure a = nextObj;
            nextObj = Controller.makeRect();
            object = a;
            group.getChildren().addAll(a.square1, a.square2, a.square3, a.square4);
            moveOnKeyPress(a);
        }

        if (form.square1.getY() + MOVE < YMAX && form.square2.getY() + MOVE < YMAX && form.square4.getY() + MOVE < YMAX
                && form.square4.getY() + MOVE < YMAX) {
            int movea = MESH[(int) form.square1.getX() / SIZE][((int) form.square1.getY() / SIZE) + 1];
            int moveb = MESH[(int) form.square2.getX() / SIZE][((int) form.square2.getY() / SIZE) + 1];
            int movec = MESH[(int) form.square3.getX() / SIZE][((int) form.square3.getY() / SIZE) + 1];
            int moved = MESH[(int) form.square4.getX() / SIZE][((int) form.square4.getY() / SIZE) + 1];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.square1.setY(form.square1.getY() + MOVE);
                form.square2.setY(form.square2.getY() + MOVE);
                form.square3.setY(form.square3.getY() + MOVE);
                form.square4.setY(form.square4.getY() + MOVE);
            }
        }
    }

    private boolean moveA(GenerationFigure form) {
        return (MESH[(int) form.square1.getX() / SIZE][((int) form.square1.getY() / SIZE) + 1] == 1);
    }

    private boolean moveB(GenerationFigure form) {
        return (MESH[(int) form.square2.getX() / SIZE][((int) form.square2.getY() / SIZE) + 1] == 1);
    }

    private boolean moveC(GenerationFigure form) {
        return (MESH[(int) form.square3.getX() / SIZE][((int) form.square3.getY() / SIZE) + 1] == 1);
    }

    private boolean moveD(GenerationFigure form) {
        return (MESH[(int) form.square4.getX() / SIZE][((int) form.square4.getY() / SIZE) + 1] == 1);
    }

    private boolean cB(Rectangle rect, int x, int y) {
        boolean xb = false;
        boolean yb = false;
        if (x >= 0)
            xb = rect.getX() + x * MOVE <= XMAX - SIZE;
        if (x < 0)
            xb = rect.getX() + x * MOVE >= 0;
        if (y >= 0)
            yb = rect.getY() - y * MOVE > 0;
        if (y < 0)
            yb = rect.getY() + y * MOVE < YMAX;
        return xb && yb && MESH[((int) rect.getX() / SIZE) + x][((int) rect.getY() / SIZE) - y] == 0;
    }

}
