package ru.nsu.Demchuk.lab3;
import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

import static ru.nsu.Demchuk.lab3.Constants.PATH_TO_IMAGE_MENU;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Image image = new Image(PATH_TO_IMAGE_MENU);
        ImageView img = new ImageView(image);
        img.setFitHeight(600);
        img.setFitWidth(900);
        root.getChildren().add(img);

        MenuItem newGame = new MenuItem("PLAY");
        MenuItem statistic = new MenuItem("STATISTIC");
        MenuItem exitGame = new MenuItem("EXIT");
        SubMenu mainMenu = new SubMenu(
                newGame,statistic,exitGame
        );

        MenuItem back = new MenuItem("BACK");
        SubMenu optionsMenu = new SubMenu(back
        );
        MenuBox menuBox = new MenuBox(mainMenu);

        newGame.setOnMouseClicked(event-> {
            Tetris game = new Tetris(primaryStage);
            try {
                game.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        statistic.setOnMouseClicked(event->menuBox.setSubMenu(optionsMenu));
        exitGame.setOnMouseClicked(event-> System.exit(0));
        back.setOnMouseClicked(event ->menuBox.setSubMenu(mainMenu));

        root.getChildren().addAll(menuBox);

        Scene scene = new Scene(root,900,600);
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
        primaryStage.setTitle("Pause");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private static class MenuItem extends StackPane{
        public  MenuItem(String name){
            Rectangle bg = new Rectangle(200,20,Color.WHITE);
            bg.setOpacity(0.5);

            Text text = new Text(name);
            text.setFill(Color.WHITE);
            text.setFont(Font.font("Arial",FontWeight.BOLD,14));

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
    private static class MenuBox extends Pane{
        static SubMenu subMenu;
        public MenuBox(SubMenu subMenu){
            MenuBox.subMenu = subMenu;

            setVisible(false);
            Rectangle bg = new Rectangle(900,600,Color.LIGHTBLUE);
            bg.setOpacity(0.4);
            getChildren().addAll(bg, subMenu);
        }
        public void setSubMenu(SubMenu subMenu){
            getChildren().remove(MenuBox.subMenu);
            MenuBox.subMenu = subMenu;
            getChildren().add(MenuBox.subMenu);
        }
    }

    private static class SubMenu extends VBox{
        public SubMenu(MenuItem...items){
            setSpacing(15);
            setTranslateY(250);
            setTranslateX(350);
            for(MenuItem item : items){
                getChildren().addAll(item);
            }
        }
    }
}