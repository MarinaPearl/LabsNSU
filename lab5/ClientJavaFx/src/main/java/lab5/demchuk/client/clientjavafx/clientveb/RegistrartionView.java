package lab5.demchuk.client.clientjavafx.clientveb;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lab5.demchuk.client.clientjavafx.controller.ControllerClient;
import lab5.demchuk.client.clientjavafx.controller.ControllerRegistration;

import static lab5.demchuk.client.clientjavafx.clientveb.ConstantsView.*;

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
        Scene scene = new Scene(pane, SCENE_X, SCENE_Y);
        stage.setScene(scene);
        stage.setTitle(this.str);
        stage.showAndWait();
    }

    private void setButton() {
        go = new Button(NAME_BUTTON_GO);
        go.setTranslateX(GO_X);
        go.setTranslateY(GO_Y);
        go.setPrefSize(BUTTON_HEIGHT, BUTTON_WEIGHT);
        go.setStyle(STYLE_BACK_BUTTON + STYLE_FRONT_BUTTON);
    }

    private void setTextField() {
        textField = new TextField();
        textField.setLayoutX(TEXT_FIELD_X);
        textField.setLayoutY(TEXT_FIELD_Y);
        textField.setPrefColumnCount(TEXT_FIELD_PREF);
        textField.setPrefHeight(TEXT_FIELD_HEIGHT);
        textField.setOpacity(TEXT_FIELD_OPACITY);
    }

    private void setText() {
        text = new Text(QUESTION);
        text.setX(TEXT_WINDOW_X);
        text.setY(TEXT_WINDOW_Y);
        text.setFont(Font.font(FONT, FontWeight.BOLD, TEXT_SIZE_FONT));
        text.setFill(Color.WHITE);
    }

    public static String getName() {

       //System.out.println("Name1 " + textField.getText());
        return textField.getText();
    }

}