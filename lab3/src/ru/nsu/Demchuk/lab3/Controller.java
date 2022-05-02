package ru.nsu.Demchuk.lab3;

import javafx.scene.shape.Rectangle;

public class Controller {
    // Getting the numbers and the MESH from Tetris
    public static final int MOVE = Tetris.MOVE;
    public static final int SIZE = Tetris.SIZE;
    public static int XMAX = Tetris.XMAX;
    public static int YMAX = Tetris.YMAX;
    public static int[][] MESH = Tetris.MESH;

    public static void moveRight( GenerationFigure form) {
        if (form.square1.getX() + MOVE <= XMAX - SIZE && form.square2.getX() + MOVE <= XMAX - SIZE
                && form.square3.getX() + MOVE <= XMAX - SIZE && form.square4.getX() + MOVE <= XMAX - SIZE) {
            int movea = MESH[((int) form.square1.getX() / SIZE) + 1][((int) form.square1.getY() / SIZE)];
            int moveb = MESH[((int) form.square2.getX() / SIZE) + 1][((int) form.square2.getY() / SIZE)];
            int movec = MESH[((int) form.square3.getX() / SIZE) + 1][((int) form.square3.getY() / SIZE)];
            int moved = MESH[((int) form.square4.getX() / SIZE) + 1][((int) form.square4.getY() / SIZE)];
            if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
                form.square1.setX(form.square1.getX() + MOVE);
                form.square2.setX(form.square2.getX() + MOVE);
                form.square3.setX(form.square3.getX() + MOVE);
                form.square4.setX(form.square4.getX() + MOVE);
            }
        }
    }

    public static void moveLeft(GenerationFigure form) {
        if (form.square1.getX() - MOVE >= 0 && form.square2.getX() - MOVE >= 0 &&
                form.square3.getX() - MOVE >= 0 && form.square4.getY() - MOVE >= 0) {
            int maovea = MESH[((int)form.square1.getX()) / SIZE - 1][(int)form.square1.getY() / SIZE];
            int maoveb = MESH[((int)form.square2.getX() / SIZE) - 1][(int)form.square1.getY() / SIZE];
            int maovec = MESH[((int)form.square3.getX() / SIZE) - 1][(int)form.square1.getY() / SIZE];
            int maoved = MESH[((int)form.square4.getX() / SIZE) - 1][(int)form.square1.getY() / SIZE];
            if (maovea == 0 && maoveb == 0 && maovec == 0 && maovec == 0) {
                form.square1.setX(form.square1.getX() - MOVE);
                form.square2.setX(form.square2.getX() - MOVE);
                form.square3.setX(form.square3.getX() - MOVE);
                form.square4.setX(form.square4.getX() - MOVE);
            }
        }
    }
    public static GenerationFigure makeRect() {
        int block = (int) (Math.random() * 100);
        String name;
        Rectangle a = new Rectangle(SIZE-1, SIZE-1), b = new Rectangle(SIZE-1, SIZE-1), c = new Rectangle(SIZE-1, SIZE-1),
                d = new Rectangle(SIZE-1, SIZE-1);
        if (block < 15) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
            name = "j";
        } else if (block < 30) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2 - SIZE);
            b.setY(SIZE);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            d.setY(SIZE);
            name = "l";
        } else if (block < 45) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 - SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2);
            d.setY(SIZE);
            name = "o";
        } else if (block < 60) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 - SIZE);
            d.setY(SIZE);
            name = "s";
        } else if (block < 75) {
            a.setX(XMAX / 2 - SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE);
            name = "t";
        } else if (block < 90) {
            a.setX(XMAX / 2 + SIZE);
            b.setX(XMAX / 2);
            c.setX(XMAX / 2 + SIZE);
            c.setY(SIZE);
            d.setX(XMAX / 2 + SIZE + SIZE);
            d.setY(SIZE);
            name = "z";
        } else {
            a.setX(XMAX / 2 - SIZE - SIZE);
            b.setX(XMAX / 2 - SIZE);
            c.setX(XMAX / 2);
            d.setX(XMAX / 2 + SIZE);
            name = "i";
        }
        return new GenerationFigure(a, b, c, d, name);
    }
}
