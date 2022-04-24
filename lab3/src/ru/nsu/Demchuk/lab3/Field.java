package ru.nsu.Demchuk.lab3;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class Field extends StackPane {
    public Field(String name) {
        Rectangle bg = new Rectangle(200, 20, Color.WHITE);
        bg.setOpacity(0.5);
        Text text = new Text(name);
        text.setFill(Color.PINK);
        text.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        setAlignment(Pos.CENTER);
        getChildren().addAll(bg, text);
        FillTransition st = new FillTransition(Duration.seconds(0.5), bg);
        setOnMouseEntered(event -> {
            st.setToValue(Color.DARKGOLDENROD);
            st.setFromValue(Color.DARKGREY);
            st.setCycleCount(Animation.INDEFINITE);
            st.setAutoReverse(true);
            st.play();
        });
        setOnMouseExited(event -> {
            st.stop();
            bg.setFill(Color.WHITE);
        });
    }
   public static class MenuBox extends Pane {
        static  SubMenu subMenu;
        public MenuBox(SubMenu subMenu) {
            MenuBox.subMenu = subMenu;
            setVisible(false);
            Rectangle bg = new Rectangle(900, 600, Color.LIGHTBLUE);
            bg.setOpacity(0.4);
            getChildren().addAll(bg, subMenu);
        }
        public void setSubMenu(SubMenu subMenu) {
            getChildren().remove(MenuBox.subMenu);
            MenuBox.subMenu = subMenu;
            getChildren().add(MenuBox.subMenu);
        }
   }
    public static class SubMenu extends VBox {
        public SubMenu(Field... items) {
            setSpacing(15);
            setTranslateY(100);
            setTranslateX(50);
            for (Field item : items) {
                getChildren().addAll(item);
            }
        }
    }
}
