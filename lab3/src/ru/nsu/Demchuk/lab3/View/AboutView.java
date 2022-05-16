package ru.nsu.Demchuk.lab3.View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ru.nsu.Demchuk.lab3.Controller.AboutController;

import static ru.nsu.Demchuk.lab3.View.Constants.*;

public class AboutView {
    private Stage stage;
    private  Pane pane;
    private Button back;
    private static final String NAME_BUTTON = "BACK";
    private static final String EMAIL = "m.demchuk@g.nsu.ru";
    private static final int POSSITION_BUTTON_X = 205;
    private static final int POSSITION_BUTTON_Y = 410;
    private static final int SIZE_BUTTON_X = 200;
    private static final int SIZE_BUTTON_Y = 50;
    private static final int POSSITION_TEXT_X = 135;
    private static final int POSSITION_TEXT_Y = 250;
    private static final double OPACITY_BUTTON = 0.5;
    private static final int FONT_SIZE = 33;
    private static final String STYLE_BUTTON = "-fx-font: 24 arial; -fx-background-color:#000080";
    private static final String FONT = "Arial";
    public AboutView(Stage stage) {
        back = new Button(NAME_BUTTON);
        pane = new Pane();
        this.stage = stage;
    }
    public  void showAbout() {
        Image image = new Image(PATH_IN_TO_IMAGE_MENU);
        ImageView img = new ImageView(image);
        img.setFitWidth(FIELD_WIDTH);
        img.setFitHeight(FIELD_HEIGHT);
        pane.getChildren().add(img);
        Scene scene = new Scene(pane, FIELD_WIDTH, FIELD_HEIGHT);
        back.setTranslateX(POSSITION_BUTTON_X);
        back.setTranslateY(POSSITION_BUTTON_Y);
        back.setPrefSize(SIZE_BUTTON_X, SIZE_BUTTON_Y);
        back.setTextFill(Color.WHITE);
        Text text = new Text(EMAIL);
        text.setX(POSSITION_TEXT_X);
        text.setY(POSSITION_TEXT_Y);
        text.setFill(Color.WHITE);
        text.setFont(Font.font(FONT, FontWeight.BOLD,FONT_SIZE));
        back.setStyle(STYLE_BUTTON);
        back.setOpacity(OPACITY_BUTTON);
        back.setOnMouseClicked(event -> {
            AboutController.doBack(stage);
        });
        pane.getChildren().addAll(back);
        pane.getChildren().addAll(text);
        stage.setScene(scene);
        stage.show();
    }
}
