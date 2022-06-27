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
    private static TextArea textField;
    private TextArea port;
    private TextArea ipAdres;
    private Text text;
    private static String name;
    private Button go;
    private String str;
    private Button goObject;
    public void registarted(String str, ControllerClient controllerClient) {
        this.str = str;
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Pane pane = new Pane();
        setTextField();
        setText();
        setButton();
        setIpAdres();
        setPort();
        setButtonObject();
        ControllerRegistration conntroller = new ControllerRegistration();
        go.setOnMouseClicked(event -> {
            conntroller.closeWindow(stage);
            conntroller.connectingInChat(controllerClient,true, port.getText(), ipAdres.getText());
            //stage.close();
        });
        goObject.setOnMouseClicked(event -> {
            conntroller.closeWindow(stage);
            conntroller.connectingInChat(controllerClient,false, port.getText(), ipAdres.getText());
        });
        pane.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, null, null)));
        pane.getChildren().addAll(textField, text, go, port, ipAdres, goObject);
        Scene scene = new Scene(pane, SCENE_X, SCENE_Y);
        stage.setScene(scene);
        stage.setTitle(this.str);
        stage.showAndWait();
    }
    private void setButtonObject() {
        goObject = new Button(NAME_BUTTON_GO);
        goObject.setTranslateX(GO_X);
        goObject.setTranslateY(GO_Y);
        goObject.setPrefSize(BUTTON_HEIGHT_GO, BUTTON_WEIGHT);
        goObject.setStyle(STYLE_BACK_BUTTON + STYLE_FRONT_BUTTON);
    }
    private void setButton() {
        go = new Button(NAME_BUTTON_GO_GSON);
        go.setTranslateX(GO_X);
        go.setTranslateY(BUTTON_Y_TRANSLATE);
        go.setPrefSize(BUTTON_HEIGHT_GO, BUTTON_WEIGHT);
        go.setStyle(STYLE_BACK_BUTTON + STYLE_FRONT_BUTTON);
    }

    private void setTextField() {
        textField = new TextArea();
        textField.setLayoutX(TEXT_FIELD_X);
        textField.setLayoutY(TEXT_FIELD_Y);
        textField.setPrefColumnCount(TEXT_FIELD_PREF);
        textField.setPrefHeight(TEXT_FIELD_HEIGHT);
    }
    private void setPort() {
        port = new TextArea();
        port.setTranslateX(TEXT_FIELD_X);
        port.setTranslateY(PORT);
        port.setPrefColumnCount(TEXT_FIELD_PREF);
        port.setPrefHeight(TEXT_FIELD_HEIGHT);
        port.setPromptText(PORT_NAME);
    }
    private void setIpAdres() {
        ipAdres = new TextArea();
        ipAdres.setTranslateX(TEXT_FIELD_X);
        ipAdres.setTranslateY(IP);
        ipAdres.setPrefColumnCount(TEXT_FIELD_PREF);
        ipAdres.setPrefHeight(TEXT_FIELD_HEIGHT);
        ipAdres.setPromptText(IP_NAME);
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