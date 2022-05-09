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
    public StatisticView(Stage stage) {
           image = new Image(PATH_IN_TO_IMAGE_MENU);
           pane = new Pane();
           this.stage = stage;
           back = new Button("BACK");

    }
    public  void doStatistic(HashMap<String, Integer> unsortedMap){
       count = 0;
        ImageView img;
        img = new ImageView(image);
        img.setFitWidth(FIELD_WIDTH);
        img.setFitHeight(FIELD_HEIGHT);
        pane.getChildren().add(img);
        Scene scene = new Scene(pane, FIELD_WIDTH, FIELD_HEIGHT);
        Text textStatistic = new Text("S T A T I S T I C");
        textStatistic.setX(175);
        textStatistic.setY(120);
        textStatistic.setFill(Color.WHITE);
        textStatistic.setFont(Font.font("Arial", FontWeight.BOLD,33));
        back.setTranslateX(196);
        back.setTranslateY(450);
        back.setPrefSize(200, 50);
        back.setTextFill(Color.WHITE);
        back.setStyle("-fx-font: 24 arial; -fx-background-color:#000080");
        back.setOpacity(0.5);
        pane.getChildren().addAll(back, textStatistic);
        int offset = 0;
        back.setOnMouseClicked(event -> {
            StatisticController.back(stage);
        });
        for (Map.Entry<String, Integer> pair : unsortedMap.entrySet()) {
            if (count < 3) {
                if (pair.getKey() != null) {
                    Text text = new Text(pair.getKey() + " " + pair.getValue());
                    text.setFill(Color.WHITE);
                    text.setFont(Font.font("Arial", FontWeight.BOLD, 25));
                    text.setX(250);
                    text.setY(200 + offset);
                    //pane.setAlignment(Pos.CENTER);
                    pane.getChildren().addAll(text);
                }
            }
                offset+=50;
                ++count;
        }
        stage.setScene(scene);
        stage.show();

    }
}
