package ru.nsu.Demchuk.lab3.View;

import javafx.animation.FillTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import ru.nsu.Demchuk.lab3.Controller.RegistrartionController;


import static ru.nsu.Demchuk.lab3.View.Constants.*;

public class RegistrationView {
    Image image;
    Stage stage;
    Pane pane;
    private Button goToGame;
    private Button back;
    private static String name;
    private Text text;
    private TextField textField;
    private static final int TEXT_X = 135;
    private static final int TEXT_Y = 200;
    private static final int FONT_SIZE = 33;
    private static final int TEXT_FIELD_X = 195;
    private static final int TEXT_FIELD_Y = 240;
    private static final int TEXT_FIELD_SIZE = 18;
    private static final int TEXT_FIELD_HEIGHT = 35;
    private static final String FONT = "Arial";
    private static final String NAME_BUTTON_GAME = "Go to game";
    private static final String NAME_BUTTON_BACK = "BACK";
    private static final String NAME_MENU = "R E G I S T R A T I O N";
    private static final int BUTTON_X = 205;
    private static final double BUTTON_OPACITY = 0.5;
    private static final int BUTTON_W = 200;
    private static final int BUTTON_H = 50;
    private static final int GAME_Y = 350;
    private static final int BACK_Y = 410;
    private static final int EXIT = 0;
    private static String  BUTTON_STYLE = "-fx-font: 24 arial; -fx-background-color:#000080";
    public RegistrationView(Stage stage) {
        pane = new Pane();
        image = new Image(PATH_IN_TO_IMAGE_MENU);
        this.stage = stage;
    }

    public void makeRegistration() {
        ImageView img;
        img = new ImageView(image);
        img.setFitWidth(FIELD_WIDTH);
        img.setFitHeight(FIELD_HEIGHT);
        pane.getChildren().add(img);
        Scene scene = new Scene(pane, FIELD_WIDTH, FIELD_HEIGHT);
        setButtonGame();
        setButtonBack();
        setText();
        setTextField();
        pane.getChildren().addAll(textField, text, goToGame, back);
        RegistrartionController controller = new RegistrartionController();
        goToGame.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                name = textField.getText();
                if (name.hashCode() != EXIT)
               controller.doGame(stage);
            }

            ;
        });
        back.setOnMouseClicked(event-> {
            controller.doBack(stage);
        });
        stage.setScene(scene);
        stage.show();
    }
    public static String getName() {
        return name;
    }
    private void setButtonGame()
    {
        goToGame = new Button(NAME_BUTTON_GAME);
        goToGame.setTranslateX(BUTTON_X);
        goToGame.setTranslateY(GAME_Y);
        goToGame.setPrefSize(BUTTON_W, BUTTON_H);
        goToGame.setTextFill(Color.WHITE);
        goToGame.setStyle(BUTTON_STYLE);
        goToGame.setOpacity(BUTTON_OPACITY);

    }
    private void setButtonBack() {
        back = new Button(NAME_BUTTON_BACK);
        back.setTranslateX(BUTTON_X);
        back.setTranslateY(BACK_Y);
        back.setPrefSize(BUTTON_W, BUTTON_H);
        back.setTextFill(Color.WHITE);
        back.setStyle(BUTTON_STYLE);
        back.setOpacity(BUTTON_OPACITY);

    }
    private void setText() {
        text = new Text(NAME_MENU);
        text.setX(TEXT_X);
        text.setY(TEXT_Y);
        text.setFill(Color.WHITE);
        text.setFont(Font.font(FONT, FontWeight.BOLD,FONT_SIZE));
    }
    private void setTextField() {
        textField = new TextField();
        textField.setPrefColumnCount(TEXT_FIELD_SIZE);
        textField.setLayoutX(TEXT_FIELD_X);
        textField.setLayoutY(TEXT_FIELD_Y);
        textField.setPrefHeight(TEXT_FIELD_HEIGHT);

    }
}
