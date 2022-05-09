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

import static ru.nsu.Demchuk.lab3.View.Constants.*;

public class Main extends Application {
    private  Pane root;
    private Image image;
    private ImageView img;
   public static void main(String[] args) {
       launch(args);
    }
    public Main() {
       root = new Pane();
       try {
           image = new Image(PATH_IN_TO_IMAGE_MENU);
           if (image == null)
               throw new Exception("menu image do not open");
       }catch (Exception error) {
           System.out.println(error.getMessage());
           System.exit(0);
       }

     }
    @Override
    public void start(Stage stage) throws Exception {
       img = new ImageView(image);
       img.setFitWidth(FIELD_WIDTH);
       img.setFitHeight(FIELD_HEIGHT);
       root.getChildren().add(img);
       Scene scene = new Scene(root, FIELD_WIDTH, FIELD_HEIGHT);
        MenuItem newGame = new MenuItem("PLAY");
        MenuItem statistic = new MenuItem("STATISTIC");
        MenuItem exitGame = new MenuItem("EXIT");
        SubMenu mainMenu = new SubMenu(
                newGame,statistic,exitGame
        );
        MenuBox menuBox = new MenuBox(mainMenu);
        newGame.setOnMouseClicked(event -> {
            MenuController.play(stage);
        });
        exitGame.setOnMouseClicked(event -> {
            MenuController.exit();
        });
        statistic.setOnMouseClicked(event -> {
            MenuController.showStatistic(stage);
        });
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                FadeTransition ft = new FadeTransition(Duration.seconds(1),menuBox);
                if (!menuBox.isVisible()) {
                    ft.setFromValue(0);
                    ft.setToValue(1);
                    ft.play();
                    menuBox.setVisible(true);
                }
                else{
                    ft.setFromValue(1);
                    ft.setToValue(0);
                    ft.setOnFinished(evt ->   menuBox.setVisible(false));
                    ft.play();

                }
            }
        });
        root.getChildren().addAll(menuBox);
       stage.setScene(scene);
       stage.setTitle("TETRIS");
       stage.show();
   }
    private  class MenuItem extends StackPane {
        public  MenuItem(String name){
            Rectangle bg = new Rectangle(200,40, Color.WHITE);
            bg.setOpacity(0.5);

            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Arial", FontWeight.BOLD,14));

            setAlignment(Pos.CENTER);
            getChildren().addAll(bg,text);
            FillTransition st = new FillTransition(Duration.seconds(0.5),bg);
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
            bg.setOpacity(0.4);
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
            setSpacing(15);
            setTranslateY(200);
            setTranslateX(195);
            for(MenuItem item : items){
                getChildren().addAll(item);
            }
        }
    }

}
