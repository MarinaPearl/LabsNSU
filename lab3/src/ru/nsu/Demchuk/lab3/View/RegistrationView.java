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
    public RegistrationView(Stage stage) {
        pane = new Pane();
        image = new Image(PATH_IN_TO_IMAGE_MENU);
        this.stage = stage;
        goToGame = new Button("Go To Game");
        back = new Button("BACK");
    }

    public void makeRegistration() {
        ImageView img;
        img = new ImageView(image);
        img.setFitWidth(FIELD_WIDTH);
        img.setFitHeight(FIELD_HEIGHT);
        pane.getChildren().add(img);
        Scene scene = new Scene(pane, FIELD_WIDTH, FIELD_HEIGHT);
        TextField textField = new TextField();
        Text text = new Text("R E G I S T R A T I O N");
        text.setX(135);
        text.setY(200);
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Arial", FontWeight.BOLD,33));
        textField.setPrefColumnCount(18);
        textField.setLayoutX(195);
        textField.setLayoutY(240);
        textField.setPrefHeight(35);
        goToGame.setTranslateX(205);
        goToGame.setTranslateY(350);
        goToGame.setPrefSize(200, 50);
        goToGame.setTextFill(Color.WHITE);
        goToGame.setStyle("-fx-font: 24 arial; -fx-background-color:#000080");
        back.setTranslateX(205);
        back.setTranslateY(410);
        back.setPrefSize(200, 50);
        back.setTextFill(Color.WHITE);
        back.setStyle("-fx-font: 24 arial; -fx-background-color:#000080");
        back.setOpacity(0.5);
        goToGame.setOpacity(0.5);
        pane.getChildren().addAll(textField, text, goToGame, back);
        RegistrartionController controller = new RegistrartionController();
        goToGame.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                name = textField.getText();
                if (name.hashCode() != 0)
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
}
