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
    private static final int FORM_FIRST = 1;
    private static final int FORM_SECOND = 2;
    private static final int FORM_3 = 3;
    private static final int FORM_LAST = 4;
    private static final int FORM_NULL = 0;
    private static final int FORM_NULL_1 = -1;
    private static final int FORM_NULL_2 = -2;
    private static final int NULL_SET = 0;

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
        if (rect.getX() - MOVE >= NULL_SET)
            rect.setX(rect.getX() - MOVE);
    }

    private static void MoveUp(Rectangle rect) {
        if (rect.getY() - MOVE > NULL_SET)
            rect.setY(rect.getY() - MOVE);
    }

    public static void generationNewRect() {
        TetrisView.makeNewRect();
    }

    public static void doDown(GenerationFigure form, Pane group) {
        Model.moveDown(form, group);
    }

    private static void MoveTurn(GenerationFigure form) {
        int f = form.form;
        Rectangle a = form.square1;
        Rectangle b = form.square2;
        Rectangle c = form.square3;
        Rectangle d = form.square4;
        switch (form.getName()) {
            case SHAPE_ONE:
                turnFormOne(f, form, a, b, c, d);
                break;
            case SHAPE_TWO:
                turnFormTwo(f, form, a, b, c, d);
                break;
            case SHAPE_THREE:
                break;
            case SHAPE_FOUR:
                turnFormFour(f, form, a, b, c, d);
                break;
            case SHAPE_FIVE:
                turnFormFive(f, form, a, b, c, d);
                break;
            case SHAPE_SIX:
                turnFormSix(f, form, a, b, c, d);
                break;
            case SHAPE_SEVEN:
                turnFormSeven(f, form, a, b, c, d);
                break;
        }
    }
   private static void turnFormOne(int f, GenerationFigure form, Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
       if (f == FORM_FIRST &&  getForm(a, b,c ,d, FORM_FIRST, FORM_NULL_1, FORM_NULL_1, FORM_NULL_1,FORM_NULL_2, FORM_NULL_2)) {
           turningShapeOneFormOne(form);
       }
       if (f == FORM_SECOND &&
               getForm(a, b,c ,d, FORM_NULL_1, FORM_NULL_1 ,FORM_NULL_1, FORM_FIRST,FORM_NULL_2, FORM_SECOND))
       {
           turningShapeOneFormTwo(form);
       }
       if (f == FORM_3 &&
               getForm(a, b,c ,d, FORM_NULL_1, FORM_FIRST ,FORM_FIRST, FORM_FIRST,FORM_SECOND, FORM_SECOND))
       {
           turningShapeOneFormThree(form);
       }
       if (f == FORM_LAST &&
               getForm(a, b,c ,d, FORM_FIRST, FORM_FIRST ,FORM_FIRST, FORM_NULL_1,FORM_SECOND, FORM_NULL_2)) {
           turningShapeOneFormFour(form);
       }

   }
    private static void turnFormTwo(int f, GenerationFigure form, Rectangle a, Rectangle b, Rectangle c, Rectangle d)
    {
        if (f == FORM_FIRST &&
                getForm(a, b,c ,d, FORM_FIRST, FORM_NULL_1 ,FORM_FIRST, FORM_FIRST,FORM_SECOND, FORM_SECOND)) {
            turningShapeTwoFormOne(form);
        }
        if (f == FORM_SECOND &&
                getForm(a, b,c ,d, FORM_NULL_1, FORM_NULL_1 ,FORM_SECOND, FORM_NULL_2,FORM_FIRST, FORM_NULL_1)) {
            turningShapeTwoFormTwo(form);
        }
        if (f == FORM_3 &&
                getForm(a, b,c ,d, FORM_NULL_1, FORM_FIRST ,FORM_NULL_1, FORM_NULL_1,FORM_NULL_2, FORM_NULL_2)) {
            turningShapeTwoFormThree(form);
        }
        if (f == FORM_LAST &&
                getForm(a, b,c ,d, FORM_FIRST, FORM_FIRST ,FORM_NULL_2, FORM_SECOND,FORM_NULL_1, FORM_FIRST)) {
            turningShapeTwoFormFour(form);
        }

    }
    private static void turnFormFour(int f, GenerationFigure form, Rectangle a, Rectangle b, Rectangle c, Rectangle d)
    {
        if (f == FORM_FIRST &&
                getForm(a, b,c ,d, FORM_NULL_1, FORM_NULL_1 ,FORM_NULL_1, FORM_FIRST,FORM_NULL, FORM_SECOND)) {
            turningShapeFourFormOne(form);
        }
        if (f == FORM_SECOND &&
                getForm(a, b,c ,d, FORM_FIRST, FORM_FIRST ,FORM_FIRST, FORM_NULL_1,FORM_NULL, FORM_NULL_2)) {
            turningShapeFourFormTwo(form);
        }
        if (f == FORM_3 &&
                getForm(a, b,c ,d, FORM_NULL_1, FORM_NULL_1 ,FORM_NULL_1, FORM_FIRST,FORM_NULL, FORM_SECOND)) {
            turningShapeFourFormThree(form);
        }
        if (f == FORM_LAST &&
                getForm(a, b,c ,d, FORM_FIRST, FORM_FIRST ,FORM_FIRST, FORM_NULL_1,FORM_NULL, FORM_NULL_2)) {
            turningShapeFourFormFour(form);
        }
    }
    private static void turnFormFive(int f, GenerationFigure form, Rectangle a, Rectangle b, Rectangle c, Rectangle d) {
        if (f == FORM_FIRST &&
                getForm(a, b,c ,d, FORM_FIRST, FORM_FIRST ,FORM_NULL_1, FORM_NULL_1,FORM_NULL_1, FORM_FIRST))
        {
            turningShapeFiveFormOne(form);
        }
        if (f == FORM_SECOND &&
                getForm(a, b,c ,d, FORM_FIRST, FORM_NULL_1 ,FORM_NULL_1, FORM_FIRST,FORM_FIRST, FORM_FIRST)) {
            turningShapeFiveFormTwo(form);
        }
        if (f == FORM_3 &&
                getForm(a, b,c ,d, FORM_NULL_1, FORM_NULL_1 ,FORM_FIRST, FORM_FIRST,FORM_FIRST, FORM_NULL_1)) {
            turningShapeFiveFormThree(form);
        }
        if (f == FORM_LAST &&
                getForm(a, b,c ,d, FORM_NULL_1, FORM_FIRST ,FORM_FIRST, FORM_NULL_1,FORM_NULL_1, FORM_NULL_1))
        {
            turningShapeFiveFormFour(form);
        }

    }
    private static void turnFormSix(int f, GenerationFigure form, Rectangle a, Rectangle b, Rectangle c, Rectangle d)
    {
        if (f == FORM_FIRST &&
                getForm(a, b,c ,d, FORM_FIRST, FORM_FIRST ,FORM_NULL_1, FORM_FIRST,FORM_NULL_2, FORM_NULL))
        {
            turningShapeSixFormOne(form);
        }
        if (f == FORM_SECOND &&
                getForm(a, b,c ,d, FORM_NULL_1, FORM_NULL_1 ,FORM_FIRST, FORM_NULL_1,FORM_SECOND, FORM_NULL))
        {
            turningShapeSixFormTwo(form);
        }
        if (f == FORM_3 &&
                getForm(a, b,c ,d, FORM_FIRST, FORM_FIRST ,FORM_NULL_1, FORM_FIRST,FORM_NULL_2, FORM_NULL))
        {
            turningShapeSixFormThree(form);
        }
        if (f == FORM_LAST &&
                getForm(a, b,c ,d, FORM_NULL_1, FORM_NULL_1 ,FORM_FIRST, FORM_NULL_1,FORM_SECOND, FORM_NULL))
        {
            turningShapeSixFormFour(form);
        }
    }
    private static void turnFormSeven(int f, GenerationFigure form, Rectangle a, Rectangle b, Rectangle c, Rectangle d)
    {
        if (f == FORM_FIRST &&
                getForm(a, b,c ,d, FORM_SECOND, FORM_SECOND, FORM_FIRST, FORM_FIRST,FORM_NULL_1, FORM_NULL_1))
        {
            turningShapeSevenFormOne(form);
        }
        if (f == FORM_SECOND &&
                getForm(a, b,c ,d, FORM_NULL_2, FORM_NULL_2, FORM_NULL_1, FORM_NULL_1,FORM_FIRST, FORM_FIRST))
        {
            turningShapeSevenFormTwo(form);
        }
        if (f == FORM_3 &&
                getForm(a, b,c ,d, FORM_SECOND, FORM_SECOND, FORM_FIRST, FORM_FIRST,FORM_NULL_1, FORM_NULL_1))
        {
            turningShapeSevenFormThree(form);
        }
        if (f == FORM_LAST &&
                getForm(a, b,c ,d, FORM_NULL_2, FORM_NULL_2, FORM_NULL_1, FORM_NULL_1,FORM_FIRST, FORM_FIRST))
        {
            turningShapeSevenFormFour(form);
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
    private static boolean getForm( Rectangle a, Rectangle b, Rectangle c, Rectangle d,
                                    int value1, int value2, int value3, int value4,
                                    int value5, int value6)
    {
        return (Model.controllingTurn(a, value1, value2) &&
                Model.controllingTurn(c, value3, value4)
                && Model.controllingTurn(d, value5, value6));

    }
    private static void turningShapeOneFormOne(GenerationFigure form) {
        MoveRight(form.square1);
        MoveDown(form.square1);
        MoveDown(form.square3);
        MoveLeft(form.square3);
        MoveDown(form.square4);
        MoveDown(form.square4);
        MoveLeft(form.square4);
        MoveLeft(form.square4);
        form.changeForm();

    }
    private static void turningShapeOneFormTwo(GenerationFigure form) {
        MoveDown(form.square1);
        MoveLeft(form.square1);
        MoveLeft(form.square3);
        MoveUp(form.square3);
        MoveLeft(form.square4);
        MoveLeft(form.square4);
        MoveUp(form.square4);
        MoveUp(form.square4);
        form.changeForm();

    }
    private static void turningShapeOneFormThree(GenerationFigure form) {
        MoveLeft(form.square1);
        MoveUp(form.square1);
        MoveUp(form.square3);
        MoveRight(form.square3);
        MoveUp(form.square4);
        MoveUp(form.square4);
        MoveRight(form.square4);
        MoveRight(form.square4);
        form.changeForm();
    }
    private  static void turningShapeOneFormFour(GenerationFigure form) {
        MoveUp(form.square1);
        MoveRight(form.square1);
        MoveRight(form.square3);
        MoveDown(form.square3);
        MoveRight(form.square4);
        MoveRight(form.square4);
        MoveDown(form.square4);
        MoveDown(form.square4);
        form.changeForm();

    }

    private static void turningShapeTwoFormOne(GenerationFigure form) {
        MoveRight(form.square1);
        MoveDown(form.square1);
        MoveUp(form.square3);
        MoveRight(form.square3);
        MoveUp(form.square2);
        MoveUp(form.square2);
        MoveRight(form.square2);
        MoveRight(form.square2);
        form.changeForm();
    }
    private static void turningShapeTwoFormTwo(GenerationFigure form) {
        MoveDown(form.square1);
        MoveLeft(form.square1);
        MoveRight(form.square2);
        MoveRight(form.square2);
        MoveDown(form.square2);
        MoveDown(form.square2);
        MoveRight(form.square3);
        MoveDown(form.square3);
        form.changeForm();

    }
    private static void turningShapeTwoFormThree(GenerationFigure form) {
        MoveLeft(form.square1);
        MoveUp(form.square1);
        MoveDown(form.square3);
        MoveLeft(form.square3);
        MoveDown(form.square2);
        MoveDown(form.square2);
        MoveLeft(form.square2);
        MoveLeft(form.square2);
        form.changeForm();

    }
    private static void turningShapeTwoFormFour(GenerationFigure form) {
        MoveUp(form.square1);
        MoveRight(form.square1);
        MoveLeft(form.square2);
        MoveLeft(form.square2);
        MoveUp(form.square2);
        MoveUp(form.square2);
        MoveLeft(form.square3);
        MoveUp(form.square3);
        form.changeForm();

    }

    private static void turningShapeFourFormOne(GenerationFigure form) {
        MoveDown(form.square1);
        MoveLeft(form.square1);
        MoveLeft(form.square3);
        MoveUp(form.square3);
        MoveUp(form.square4);
        MoveUp(form.square4);
        form.changeForm();
    }
    private static void turningShapeFourFormTwo(GenerationFigure form) {
        MoveUp(form.square1);
        MoveRight(form.square1);
        MoveRight(form.square3);
        MoveDown(form.square3);
        MoveDown(form.square4);
        MoveDown(form.square4);
        form.changeForm();

    }
    private static void turningShapeFourFormThree(GenerationFigure form) {
        MoveDown(form.square1);
        MoveLeft(form.square1);
        MoveLeft(form.square3);
        MoveUp(form.square3);
        MoveUp(form.square4);
        MoveUp(form.square4);
        form.changeForm();

    }
    private static void turningShapeFourFormFour(GenerationFigure form) {
        MoveUp(form.square1);
        MoveRight(form.square1);
        MoveRight(form.square3);
        MoveDown(form.square3);
        MoveDown(form.square4);
        MoveDown(form.square4);
        form.changeForm();
    }

    private static void turningShapeFiveFormOne(GenerationFigure form) {
        MoveUp(form.square1);
        MoveRight(form.square1);
        MoveDown(form.square4);
        MoveLeft(form.square4);
        MoveLeft(form.square3);
        MoveUp(form.square3);
        form.changeForm();

    }
    private static void turningShapeFiveFormTwo(GenerationFigure form) {
        MoveRight(form.square1);
        MoveDown(form.square1);
        MoveLeft(form.square4);
        MoveUp(form.square4);
        MoveUp(form.square3);
        MoveRight(form.square3);
        form.changeForm();

    }
    private static void turningShapeFiveFormThree(GenerationFigure form) {
        MoveDown(form.square1);
        MoveLeft(form.square1);
        MoveUp(form.square4);
        MoveRight(form.square4);
        MoveRight(form.square3);
        MoveDown(form.square3);
        form.changeForm();
    }
    private static void turningShapeFiveFormFour(GenerationFigure form) {
        MoveLeft(form.square1);
        MoveUp(form.square1);
        MoveRight(form.square4);
        MoveDown(form.square4);
        MoveDown(form.square3);
        MoveLeft(form.square3);
        form.changeForm();

    }

    private static void turningShapeSixFormOne(GenerationFigure form) {
        MoveUp(form.square2);
        MoveRight(form.square2);
        MoveLeft(form.square3);
        MoveUp(form.square3);
        MoveLeft(form.square4);
        MoveLeft(form.square4);
        form.changeForm();
    }
    private static void turningShapeSixFormTwo(GenerationFigure form) {
        MoveDown(form.square2);
        MoveLeft(form.square2);
        MoveRight(form.square3);
        MoveDown(form.square3);
        MoveRight(form.square4);
        MoveRight(form.square4);
        form.changeForm();

    }
   private static void turningShapeSixFormThree(GenerationFigure form) {
       MoveUp(form.square2);
       MoveRight(form.square2);
       MoveLeft(form.square3);
       MoveUp(form.square3);
       MoveLeft(form.square4);
       MoveLeft(form.square4);
       form.changeForm();

    }
    private static void turningShapeSixFormFour(GenerationFigure form) {
        MoveDown(form.square2);
        MoveLeft(form.square2);
        MoveRight(form.square3);
        MoveDown(form.square3);
        MoveRight(form.square4);
        MoveRight(form.square4);
        form.changeForm();

    }

    private static void turningShapeSevenFormOne(GenerationFigure form) {
        MoveUp(form.square1);
        MoveUp(form.square1);
        MoveRight(form.square1);
        MoveRight(form.square1);
        MoveUp(form.square2);
        MoveRight(form.square2);
        MoveDown(form.square4);
        MoveLeft(form.square4);
        form.changeForm();

    }
    private static void turningShapeSevenFormTwo(GenerationFigure form) {
        MoveDown(form.square1);
        MoveDown(form.square1);
        MoveLeft(form.square1);
        MoveLeft(form.square1);
        MoveDown(form.square2);
        MoveLeft(form.square2);
        MoveUp(form.square4);
        MoveRight(form.square4);
        form.changeForm();

    }
    private static void turningShapeSevenFormThree(GenerationFigure form) {
        MoveUp(form.square1);
        MoveUp(form.square1);
        MoveRight(form.square1);
        MoveRight(form.square1);
        MoveUp(form.square2);
        MoveRight(form.square2);
        MoveDown(form.square4);
        MoveLeft(form.square4);
        form.changeForm();

    }
    private static void turningShapeSevenFormFour(GenerationFigure form) {
        MoveDown(form.square1);
        MoveDown(form.square1);
        MoveLeft(form.square1);
        MoveLeft(form.square1);
        MoveDown(form.square2);
        MoveLeft(form.square2);
        MoveUp(form.square4);
        MoveRight(form.square4);
        form.changeForm();
    }

}
