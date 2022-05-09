package ru.nsu.Demchuk.lab3.View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GenerationFigure {
    public Rectangle square1;
    public Rectangle square2;
    public Rectangle square3;
    public Rectangle square4;
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
                color = Color.DEEPSKYBLUE;
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
