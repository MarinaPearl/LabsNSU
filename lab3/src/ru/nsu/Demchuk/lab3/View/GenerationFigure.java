package ru.nsu.Demchuk.lab3.View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static ru.nsu.Demchuk.lab3.View.Constants.*;

public class GenerationFigure {
    public Rectangle square1;
    public Rectangle square2;
    public Rectangle square3;
    public Rectangle square4;
    Color color;
    private String name;
    public int form = 1;
    private static final int LAST_FORM = 4;
    private static final int FIRST_FORM = 1;
    public GenerationFigure(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        this.square1 = a;
        this.square2 = b;
        this.square3 = c;
        this.square4 = d;
        this.name = name;
        switch (name) {
            case SHAPE_ONE:
                color = Color.PINK;
                break;
            case SHAPE_TWO:
                color = Color.GREY;
                break;
            case SHAPE_THREE:
                color = Color.BLUE;
                break;
            case SHAPE_FOUR:
                color = Color.BISQUE;
                break;
            case SHAPE_FIVE:
                color = Color.DEEPSKYBLUE;
                break;
            case SHAPE_SIX:
                color = Color.CORAL;
                break;
            case SHAPE_SEVEN:
                color = Color.LIGHTPINK;
                break;

        }
        this.square1.setFill(color);
        this.square2.setFill(color);
        this.square3.setFill(color);
        this.square4.setFill(color);
    }
    public String getName() {
        return name;
    }


    public void changeForm() {
        if (form != LAST_FORM) {
            form++;
        } else {
            form = FIRST_FORM;
        }
    }
}
