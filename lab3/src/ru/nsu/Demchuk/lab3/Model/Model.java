package ru.nsu.Demchuk.lab3.Model;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import ru.nsu.Demchuk.lab3.Controller.Controller;
import ru.nsu.Demchuk.lab3.View.GenerationFigure;

import java.util.ArrayList;
import java.util.Arrays;

import static ru.nsu.Demchuk.lab3.View.Constants.*;

public class Model {
    public static int[][] MESH = new int[XMAX / SIZE][YMAX / SIZE];
    private static int linesNo = 0;
    public  static GenerationFigure makeRect() {
        int block = (int) (Math.random() * 100);
        String name;
        Rectangle a = new Rectangle(SIZE - 1, SIZE - 1),
                b = new Rectangle(SIZE - 1, SIZE - 1),
                c = new Rectangle(SIZE - 1, SIZE - 1),
                d = new Rectangle(SIZE - 1, SIZE - 1);
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
    public static void moveRight( GenerationFigure form) {
        try {
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
        }catch (ArrayIndexOutOfBoundsException error) {}
    }
    public static void moveLeft(GenerationFigure form) {
        try {
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
        } catch (ArrayIndexOutOfBoundsException error) {}
    }
    public static void moveDown(GenerationFigure form, Pane group) {
        try {
            if (form.square1.getY() == YMAX - SIZE || form.square2.getY() == YMAX - SIZE ||
                    form.square3.getY() == YMAX - SIZE || form.square4.getY() == YMAX - SIZE || moveA(form) || moveB(form)
                    || moveC(form) || moveD(form)) {
                MESH[((int) form.square1.getX()) / SIZE][((int) form.square1.getY()) / SIZE] = 1;
                MESH[((int) form.square2.getX()) / SIZE][((int) form.square2.getY()) / SIZE] = 1;
                MESH[((int) form.square3.getX()) / SIZE][((int) form.square3.getY()) / SIZE] = 1;
                MESH[((int) form.square4.getX()) / SIZE][((int) form.square4.getY()) / SIZE] = 1;
                removeRows(group);
                Controller.generationNewRect();
            }
            if (form.square1.getY() + MOVE < YMAX && form.square2.getY() + MOVE < YMAX && form.square3.getY() + MOVE < YMAX
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
        }catch (ArrayIndexOutOfBoundsException error) {}

    }
    private static boolean moveA(GenerationFigure form) {
        return (MESH[(int) form.square1.getX() / SIZE][((int) form.square1.getY() / SIZE) + 1] == 1);
    }

    private static boolean moveB(GenerationFigure form) {
        return (MESH[(int) form.square2.getX() / SIZE][((int) form.square2.getY() / SIZE) + 1] == 1);
    }

    private static boolean moveC(GenerationFigure form) {
        return (MESH[(int) form.square3.getX() / SIZE][((int) form.square3.getY() / SIZE) + 1] == 1);
    }

    private static boolean moveD(GenerationFigure form) {
        return (MESH[(int) form.square4.getX() / SIZE][((int) form.square4.getY() / SIZE) + 1] == 1);
    }
    private static void removeRows(Pane pane) {
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
        while (lines.size() > 0) {
                for (Node node : pane.getChildren()) {
                    if (node instanceof Rectangle)
                        rects.add(node);
                }
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
            }
    }
    public static int getLine() {
        return linesNo;
    }
    public static boolean cB(Rectangle rect, int x, int y) {
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
    public static int getLinesNo() {
        return linesNo;
    }
}
