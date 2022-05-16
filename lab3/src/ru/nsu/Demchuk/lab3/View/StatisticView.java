package ru.nsu.Demchuk.lab3.View;

import javafx.animation.Animation;
import javafx.animation.FillTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javafx.util.Pair;
import ru.nsu.Demchuk.lab3.Controller.StatisticController;

import java.util.*;
import java.util.stream.Collectors;

import static ru.nsu.Demchuk.lab3.View.Constants.*;


public class StatisticView {
    private Pane pane;
    private Stage stage;
    Image image;
    int count = 0;
    private Button back;
    private static final String BUTTON_NAME_BACK = "BACK";
    private static final String MENU_NAME = "S T A T I S T I C";
    private static final String FONT = "Arial";
    private static final int FONT_SIZE = 33;
    private static final int FONT_SIZE_2 = 25;
    private static String  BUTTON_STYLE = "-fx-font: 24 arial; -fx-background-color:#000080";
    private static final int BUTTON_W = 200;
    private static final int BUTTON_H = 50;
    private static final double BUTTON_OPACITY = 0.5;
    private static final int TEXT_X = 175;
    private static final int TEXT_X_2 = 250;
    private static final int TEXT_Y_2 = 200;
    private static final int TEXT_Y = 120;
    private static final int BACK_X = 196;
    private static final int BACK_Y = 196;
    private static final int OFFSET = 50;
    private static final int COUNT_PEOUPLE = 6;
    public StatisticView(Stage stage) {
           image = new Image(PATH_IN_TO_IMAGE_MENU);
           pane = new Pane();
           this.stage = stage;
           back = new Button(BUTTON_NAME_BACK);

    }
    public  void doStatistic(HashMap<String, Integer> unsortedMap){
       count = 0;
        ImageView img;
        img = new ImageView(image);
        img.setFitWidth(FIELD_WIDTH);
        img.setFitHeight(FIELD_HEIGHT);
        pane.getChildren().add(img);
        Scene scene = new Scene(pane, FIELD_WIDTH, FIELD_HEIGHT);
        Text textStatistic = new Text(MENU_NAME);
        textStatistic.setX(TEXT_X);
        textStatistic.setY(TEXT_Y);
        textStatistic.setFill(Color.WHITE);
        textStatistic.setFont(Font.font(FONT, FontWeight.BOLD,FONT_SIZE));
        back.setTranslateX(BACK_X);
        back.setTranslateY(BACK_Y);
        back.setPrefSize(BUTTON_W, BUTTON_H);
        back.setTextFill(Color.WHITE);
        back.setStyle(BUTTON_STYLE);
        back.setOpacity(BUTTON_OPACITY);
        pane.getChildren().addAll(back, textStatistic);
        int offset = 0;
        back.setOnMouseClicked(event -> {
            StatisticController.back(stage);
        });
        for (Map.Entry<String, Integer> pair : unsortedMap.entrySet()) {
            if (count < COUNT_PEOUPLE) {
                if (pair.getKey() != null) {
                    Text text = new Text(pair.getKey() + " " + pair.getValue());
                    text.setFill(Color.WHITE);
                    text.setFont(Font.font(FONT, FontWeight.BOLD, FONT_SIZE_2));
                    text.setX(TEXT_X_2);
                    text.setY(TEXT_Y_2 + offset);
                    //pane.setAlignment(Pos.CENTER);
                    pane.getChildren().addAll(text);
                }
            }
                offset+=OFFSET;
                ++count;
        }
        stage.setScene(scene);
        stage.show();

    }
}
