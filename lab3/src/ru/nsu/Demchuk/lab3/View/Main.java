package ru.nsu.Demchuk.lab3.View;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import ru.nsu.Demchuk.lab3.Controller.MenuController;
import ru.nsu.Demchuk.lab3.Controller.RegistrartionController;

import java.io.IOException;

import static ru.nsu.Demchuk.lab3.View.Constants.*;

public class Main extends Application {
    private  Pane root;
    private Image image;
    private ImageView img;
    private static final String EXCEPTION = "menu image do not open";
    private static final int EXIT  = 0;
    private static final String NAME_GAME_BUTTON = "PLAY";
    private static final String NAME_STATISTIC_BUTTON = "STATISTIC";
    private static final String NAME_ABOUT_BUTTON = "ABOUT";
    private static final String NAME_EXIT_BUTTON = "EXIT";
    private static final int ANIMATION_ON = 0;
    private static final int ANIMATION_OF = 1;
    private static final String GAME_NAME = "TETRIS";
    private static final int MENU_BUTTON_X = 200;
    private static final int MENU_BUTTON_Y = 40;
    private static final double MENU_BUTTON_OPACTY = 0.5;
    private static final String FONT = "Arial";
    private static final int FONT_SIZE = 14;
    private static final double SECONDS = 0.5;
    private static final double MENU_BUTTON_OPACTY_2 = 0.4;
    private static final int SPACE = 14;
    private static final int TEXT_X = 195;
    private static final int TEXT_Y = 200;
   public static void main(String[] args) {
       launch(args);
    }
    public Main() {
       root = new Pane();
       try {
           image = new Image(PATH_IN_TO_IMAGE_MENU);
           if (image == null)
               throw new Exception(EXCEPTION);
       }catch (Exception error) {
           System.out.println(error.getMessage());
           System.exit(EXIT);
       }

     }
    @Override
    public void start(Stage stage) throws Exception {
       img = new ImageView(image);
       img.setFitWidth(FIELD_WIDTH);
       img.setFitHeight(FIELD_HEIGHT);
       root.getChildren().add(img);
       Scene scene = new Scene(root, FIELD_WIDTH, FIELD_HEIGHT);
        MenuItem newGame = new MenuItem(NAME_GAME_BUTTON);
        MenuItem statistic = new MenuItem(NAME_STATISTIC_BUTTON);
        MenuItem exitGame = new MenuItem(NAME_EXIT_BUTTON);
        MenuItem about = new MenuItem(NAME_ABOUT_BUTTON);
        SubMenu mainMenu = new SubMenu(
                newGame,statistic,about, exitGame
        );
        MenuBox menuBox = new MenuBox(mainMenu);
        newGame.setOnMouseClicked(event -> {
            MenuController.play(stage);
        });
        exitGame.setOnMouseClicked(event -> {
            MenuController.exit();
        });
        statistic.setOnMouseClicked(event -> {
            try {
                MenuController.showStatistic(stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        about.setOnMouseClicked(event -> {
            MenuController.showAboutView(stage);
        });
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                FadeTransition ft = new FadeTransition(Duration.seconds(1),menuBox);
                if (!menuBox.isVisible()) {
                    ft.setFromValue(ANIMATION_ON);
                    ft.setToValue(ANIMATION_OF);
                    ft.play();
                    menuBox.setVisible(true);
                }
                else{
                    ft.setFromValue(ANIMATION_OF);
                    ft.setToValue(ANIMATION_ON);
                    ft.setOnFinished(evt ->   menuBox.setVisible(false));
                    ft.play();

                }
            }
        });
        root.getChildren().addAll(menuBox);
       stage.setScene(scene);
       stage.setTitle(GAME_NAME);
       stage.show();
   }
    private  class MenuItem extends StackPane {
        public  MenuItem(String name){
            Rectangle bg = new Rectangle(MENU_BUTTON_X,MENU_BUTTON_Y, Color.WHITE);
            bg.setOpacity(MENU_BUTTON_OPACTY);

            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font(FONT, FontWeight.BOLD,FONT_SIZE));

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg,text);
            FillTransition st = new FillTransition(Duration.seconds(SECONDS),bg);
            setOnMouseEntered(event -> {
                st.setFromValue(Color.DARKGRAY);
                st.setToValue(Color.DARKGOLDENROD);
                st.setCycleCount(Animation.INDEFINITE);
                st.setAutoReverse(true);
                st.play();
            });
            setOnMouseExited(event -> {
                st.stop();
                bg.setFill(Color.WHITE);
            });
        }
    }
    private class MenuBox extends Pane{
        static SubMenu subMenu;
        public MenuBox(SubMenu subMenu){
            MenuBox.subMenu = subMenu;

            setVisible(false);
            Rectangle bg = new Rectangle(FIELD_WIDTH,FIELD_HEIGHT,Color.LIGHTBLUE);
            bg.setOpacity(MENU_BUTTON_OPACTY_2);
            getChildren().addAll(bg, subMenu);
        }
        public void setSubMenu(SubMenu subMenu){
            getChildren().remove(MenuBox.subMenu);
            MenuBox.subMenu = subMenu;
            getChildren().add(MenuBox.subMenu);
        }
    }

    private class SubMenu extends VBox {
        public SubMenu(MenuItem...items){
            setSpacing(SPACE);
            setTranslateY(TEXT_Y);
            setTranslateX(TEXT_X);
            for(MenuItem item : items){
                getChildren().addAll(item);
            }
        }
    }

}
