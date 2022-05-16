package ru.nsu.Demchuk.lab3.Controller;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import ru.nsu.Demchuk.lab3.Model.Model;
import ru.nsu.Demchuk.lab3.View.AboutView;
import ru.nsu.Demchuk.lab3.View.GenerationFigure;
import ru.nsu.Demchuk.lab3.View.Main;
import ru.nsu.Demchuk.lab3.View.TetrisView;

import java.util.Arrays;

import static ru.nsu.Demchuk.lab3.View.Constants.*;

public class Controller {
    public static final int FORM_FIRST = 1;
    public static final int FORM_SECOND = 2;
    public static final int FORM_3 = 3;
    public static final int FORM_LAST = 4;
    public static final int FORM_NULL = 0;
    public static final int FORM_NULL_1 = -1;
    public static final int FORM_NULL_2 = -2;
    public static GenerationFigure createFigure() {
        GenerationFigure form = Model.makeRect();
        return form;
    }
    public static void nullingArray() {
        for (int a[] : Model.MESH) {
            Arrays.fill(a, FORM_NULL);
        }
    }
    public static void moveOnKeyPress(GenerationFigure form, Scene scene, Pane group) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case RIGHT:
                        Model.moveRight(form);
                        break;
                    case DOWN:
                       Model.moveDown(form, group);
                        break;
                    case LEFT:
                        Model.moveLeft(form);
                        break;
                    case UP:
                       MoveTurn(form);
                        break;
                }
            }
        });
    }
    private static void MoveDown(Rectangle rect) {
        if (rect.getY() + MOVE < YMAX)
            rect.setY(rect.getY() + MOVE);

    }

    private static void MoveRight(Rectangle rect) {
        if (rect.getX() + MOVE <= XMAX - SIZE)
            rect.setX(rect.getX() + MOVE);
    }

    private static void MoveLeft(Rectangle rect) {
        if (rect.getX() - MOVE >= 0)
            rect.setX(rect.getX() - MOVE);
    }

    private static void MoveUp(Rectangle rect) {
        if (rect.getY() - MOVE > 0)
            rect.setY(rect.getY() - MOVE);
    }
    public static void generationNewRect() {
        TetrisView.makeNewRect();
    }
    public static void doDown(GenerationFigure form, Pane group) {
        Model.moveDown(form, group);
    }
    private static void MoveTurn (GenerationFigure form) {
        int f = form.form;
        Rectangle a = form.square1;
        Rectangle b = form.square2;
        Rectangle c = form.square3;
        Rectangle d = form.square4;
        switch (form.getName()) {
            case "j":
                if (f == FORM_FIRST && Model.cB(a, FORM_FIRST, FORM_NULL_1) &&
                        Model.cB(c, FORM_NULL_1, FORM_NULL_1) && Model.cB(d, FORM_NULL_2, FORM_NULL_2)) {
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
                if (f == FORM_SECOND && Model.cB(a, FORM_NULL_1, FORM_NULL_1) &&
                        Model.cB(c, FORM_NULL_1, FORM_FIRST) && Model.cB(d, FORM_NULL_2, FORM_SECOND)) {
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
                if (f == FORM_3 && Model.cB(a, FORM_NULL_1, FORM_FIRST) &&
                        Model.cB(c, FORM_FIRST, FORM_FIRST) && Model.cB(d, FORM_SECOND, FORM_SECOND)) {
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
                if (f == FORM_LAST && Model.cB(a, FORM_FIRST, FORM_FIRST) &&
                        Model.cB(c, FORM_FIRST, FORM_NULL_1) && Model.cB(d, FORM_SECOND, FORM_NULL_2)) {
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
                if (f == FORM_FIRST && Model.cB(a, FORM_FIRST, FORM_NULL_1)
                        && Model.cB(c, FORM_FIRST, FORM_FIRST) && Model.cB(b, FORM_SECOND, FORM_SECOND)) {
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
                if (f == FORM_SECOND && Model.cB(a, FORM_NULL_1, FORM_NULL_1)
                        && Model.cB(b, FORM_SECOND, FORM_NULL_2) && Model.cB(c, FORM_FIRST, FORM_NULL_1)) {
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
                if (f == FORM_3 && Model.cB(a, FORM_NULL_1, FORM_FIRST) && Model.cB(c, FORM_NULL_1, FORM_NULL_1)
                        && Model.cB(b, FORM_NULL_2, FORM_NULL_2)) {
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
                if (f == FORM_LAST && Model.cB(a, FORM_FIRST, FORM_FIRST)
                        && Model.cB(b, FORM_NULL_2, FORM_SECOND) && Model.cB(c, FORM_NULL_1, FORM_FIRST)) {
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
                if (f == FORM_FIRST && Model.cB(a, FORM_NULL_1, FORM_NULL_1)
                        && Model.cB(c, FORM_NULL_1, FORM_FIRST) && Model.cB(d, FORM_NULL, FORM_SECOND)) {
                    MoveDown(form.square1);
                    MoveLeft(form.square1);
                    MoveLeft(form.square3);
                    MoveUp(form.square3);
                    MoveUp(form.square4);
                    MoveUp(form.square4);
                    form.changeForm();
                    break;
                }
                if (f == FORM_SECOND && Model.cB(a, FORM_FIRST, FORM_FIRST) && Model.cB(c, FORM_FIRST, FORM_NULL_1)
                        && Model.cB(d, FORM_NULL, FORM_NULL_2)) {
                    MoveUp(form.square1);
                    MoveRight(form.square1);
                    MoveRight(form.square3);
                    MoveDown(form.square3);
                    MoveDown(form.square4);
                    MoveDown(form.square4);
                    form.changeForm();
                    break;
                }
                if (f == FORM_3 && Model.cB(a, FORM_NULL_1, FORM_NULL_1)
                        && Model.cB(c, FORM_NULL_1, FORM_FIRST) && Model.cB(d, FORM_NULL, FORM_SECOND)) {
                    MoveDown(form.square1);
                    MoveLeft(form.square1);
                    MoveLeft(form.square3);
                    MoveUp(form.square3);
                    MoveUp(form.square4);
                    MoveUp(form.square4);
                    form.changeForm();
                    break;
                }
                if (f == FORM_LAST && Model.cB(a, FORM_FIRST, FORM_FIRST)
                        && Model.cB(c, FORM_FIRST, FORM_NULL_1) && Model.cB(d, FORM_NULL, FORM_NULL_2)) {
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
                if (f == FORM_FIRST && Model.cB(a, FORM_FIRST, FORM_FIRST)
                        && Model.cB(d, FORM_NULL_1, FORM_NULL_1) && Model.cB(c, FORM_NULL_1, FORM_FIRST)) {
                    MoveUp(form.square1);
                    MoveRight(form.square1);
                    MoveDown(form.square4);
                    MoveLeft(form.square4);
                    MoveLeft(form.square3);
                    MoveUp(form.square3);
                    form.changeForm();
                    break;
                }
                if (f == FORM_SECOND && Model.cB(a, FORM_FIRST, FORM_NULL_1)
                        && Model.cB(d, FORM_NULL_1, FORM_FIRST) && Model.cB(c, FORM_FIRST, FORM_FIRST)) {
                    MoveRight(form.square1);
                    MoveDown(form.square1);
                    MoveLeft(form.square4);
                    MoveUp(form.square4);
                    MoveUp(form.square3);
                    MoveRight(form.square3);
                    form.changeForm();
                    break;
                }
                if (f == FORM_3 && Model.cB(a, FORM_NULL_1, FORM_NULL_1)
                        && Model.cB(d, FORM_FIRST, FORM_FIRST) && Model.cB(c, FORM_FIRST, FORM_NULL_1)) {
                    MoveDown(form.square1);
                    MoveLeft(form.square1);
                    MoveUp(form.square4);
                    MoveRight(form.square4);
                    MoveRight(form.square3);
                    MoveDown(form.square3);
                    form.changeForm();
                    break;
                }
                if (f == FORM_LAST && Model.cB(a, FORM_NULL_1, FORM_FIRST)
                        && Model.cB(d, FORM_FIRST, FORM_NULL_1) && Model.cB(c, FORM_NULL_1, FORM_NULL_1)) {
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
                if (f == FORM_FIRST && Model.cB(b, FORM_FIRST, FORM_FIRST)
                        && Model.cB(c, FORM_NULL_1, FORM_FIRST) && Model.cB(d, FORM_NULL_2, FORM_NULL)) {
                    MoveUp(form.square2);
                    MoveRight(form.square2);
                    MoveLeft(form.square3);
                    MoveUp(form.square3);
                    MoveLeft(form.square4);
                    MoveLeft(form.square4);
                    form.changeForm();
                    break;
                }
                if (f == FORM_SECOND && Model.cB(b, FORM_NULL_1, FORM_NULL_1)
                        && Model.cB(c, FORM_FIRST, FORM_NULL_1) && Model.cB(d, FORM_SECOND, FORM_NULL)) {
                    MoveDown(form.square2);
                    MoveLeft(form.square2);
                    MoveRight(form.square3);
                    MoveDown(form.square3);
                    MoveRight(form.square4);
                    MoveRight(form.square4);
                    form.changeForm();
                    break;
                }
                if (f == FORM_3 && Model.cB(b, FORM_FIRST, FORM_FIRST)
                        && Model.cB(c, FORM_NULL_1, FORM_FIRST) && Model.cB(d, FORM_NULL_2, FORM_NULL)) {
                    MoveUp(form.square2);
                    MoveRight(form.square2);
                    MoveLeft(form.square3);
                    MoveUp(form.square3);
                    MoveLeft(form.square4);
                    MoveLeft(form.square4);
                    form.changeForm();
                    break;
                }
                if (f == FORM_LAST && Model.cB(b, FORM_NULL_1, FORM_NULL_1)
                        && Model.cB(c, FORM_FIRST, FORM_NULL_1) && Model.cB(d, FORM_SECOND, FORM_NULL)) {
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
                if (f == FORM_FIRST && Model.cB(a, FORM_SECOND, FORM_SECOND)
                        && Model.cB(b, FORM_FIRST, FORM_FIRST) && Model.cB(d, FORM_NULL_1, FORM_NULL_1)) {
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
                if (f == FORM_SECOND && Model.cB(a, FORM_NULL_2, FORM_NULL_2)
                        && Model.cB(b, FORM_NULL_1, FORM_NULL_1) && Model.cB(d, FORM_FIRST, FORM_FIRST)) {
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
                if (f == FORM_3 && Model.cB(a, FORM_SECOND, FORM_SECOND)
                        && Model.cB(b, FORM_FIRST, FORM_FIRST) && Model.cB(d, FORM_NULL_1, FORM_NULL_1)) {
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
                if (f == FORM_LAST && Model.cB(a, FORM_NULL_2, FORM_NULL_2) &&
                        Model.cB(b, FORM_NULL_1, FORM_NULL_1) && Model.cB(d, FORM_FIRST, FORM_FIRST)) {
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
    public static void returnMenu(Stage stage) {
        Main retur = new Main();
        try {
            retur.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
