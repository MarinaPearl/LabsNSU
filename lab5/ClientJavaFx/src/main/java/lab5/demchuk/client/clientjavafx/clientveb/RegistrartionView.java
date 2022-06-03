package lab5.demchuk.client.clientjavafx.clientveb;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lab5.demchuk.client.clientjavafx.controller.ControllerRegistration;

public class RegistrartionView {
    private static TextField textField;
    private Text text;
    private static String name;
    private Button go;
    private String str;

    public void registarted(String str) {
        this.str = str;
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Pane pane = new Pane();
        setTextField();
        setText();
        setButton();
        ControllerRegistration conntroller = new ControllerRegistration();
        go.setOnMouseClicked(event -> {
            conntroller.closeWindow(stage);
            conntroller.connectingInChat();
            //stage.close();
        });
        pane.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, null, null)));
        pane.getChildren().addAll(textField, text, go);
        Scene scene = new Scene(pane, 400, 200);
        stage.setScene(scene);
        stage.setTitle(this.str);
        stage.showAndWait();
    }

    private void setButton() {
        go = new Button("GO");
        go.setTranslateX(155);
        go.setTranslateY(150);
        go.setPrefSize(100, 30);
        go.setStyle("-fx-font: 12 arial; -fx-background-color:#339966 ; " +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 )");
    }

    private void setTextField() {
        textField = new TextField();
        textField.setLayoutX(100);
        textField.setLayoutY(100);
        textField.setPrefColumnCount(18);
        textField.setPrefHeight(35);
        textField.setOpacity(0.5);
    }

    private void setText() {
        text = new Text("Your name?");
        text.setX(110);
        text.setY(50);
        text.setFont(Font.font("Arial", FontWeight.BOLD, 32));
        text.setFill(Color.WHITE);
    }

    public static String getName() {
        name = textField.getText();
        return name;
    }

}