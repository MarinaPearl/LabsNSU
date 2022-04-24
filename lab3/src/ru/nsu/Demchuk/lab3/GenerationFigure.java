package ru.nsu.Demchuk.lab3;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GenerationFigure {
    Rectangle square1;
    Rectangle square2;
    Rectangle square3;
    Rectangle square4;
    Color color;
    private String name;
    public int form = 1;

    public GenerationFigure(Rectangle a, Rectangle b, Rectangle c, Rectangle d, String name) {
        this.square1 = a;
        this.square2 = b;
        this.square3 = c;
        this.square4 = d;
        this.name = name;
        switch (name) {
            case "j":
                color = Color.PINK;
                break;
            case "l":
                color = Color.GREY;
                break;
            case "o":
                color = Color.BLUE;
                break;
            case "s":
                color = Color.BISQUE;
                break;
            case "t":
                color = Color.GOLD;
                break;
            case "z":
                color = Color.CORAL;
                break;
            case "i":
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
        if (form != 4) {
            form++;
        } else {
            form = 1;
        }
    }


}
