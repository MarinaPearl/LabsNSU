package lab5.demchuk.client.clientjavafx.clientveb;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import lab5.demchuk.client.clientjavafx.controller.ControllerClient;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static lab5.demchuk.client.clientjavafx.clientveb.ConstantsView.*;

public class ClientView extends Application {
    private Text text;
    private ScaleTransition scaleTransition;
    private Pane group;
    private Scene scene;
    private Button connection;
    private Button disConnection;
    private Line line;
    private ControllerClient controller;
    private  TextArea listOfClients;
    private  TextArea textArea;
    private  TextArea chat;
    private  Button list;
    @Override
    public void start(Stage stage) {
        controller = new ControllerClient();
        controller.setView(this);
        setChat();
        group = new Pane();
        scene = new Scene(group, LENGTH, WIDTH);
       group.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
        makeButton();
        addLine();
        setTextArea();
        setList();
        String str = NAME_CHAT;
        setButtonConnect(connection);
        setButtonDisConnect(disConnection);
        setButtonList(list);
        animation();
        group.getChildren().addAll(connection, disConnection, line, chat, listOfClients, text);
        connection.setOnMouseClicked(event -> {
            scaleTransition.stop();
            group.getChildren().clear();
            group.getChildren().addAll(connection, disConnection, line, chat, textArea, listOfClients);
           controller.doRegistration(str, controller);

        });
        list.setOnMouseClicked(event -> {
             controller.sendList();
        });
        disConnection.setOnMouseClicked(event -> {
               controller.downClient();
               //System.exit(0);
               stage.close();
        });
        stage.setScene(scene);
        stage.setTitle(NAME_CHAT);
        stage.show();

    }
    public void animation() {
        text = new Text();
        text.setText("WELCOME TO THE CLUB, BOY!");
        text.setX(250.0f);
        text.setY(170.0f);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
        Stop[] stops = new Stop[] {
                new Stop(0, Color.GREENYELLOW),
                new Stop(1, Color.SEAGREEN)
        };
        RadialGradient radialGradient =
                new RadialGradient(0, 0, 300, 178, 60, false, CycleMethod.NO_CYCLE, stops);
        text.setFill(radialGradient);

        scaleTransition = new ScaleTransition();
        scaleTransition.setDuration(Duration.millis(3000));
        scaleTransition.setNode(text);
        scaleTransition.setByY(1.5);
        scaleTransition.setByX(1.5);
        scaleTransition.setCycleCount(50);
        scaleTransition.setAutoReverse(false);
        scaleTransition.play();

    }
    private void setList() {
        listOfClients = new TextArea();
        listOfClients.setTranslateX(LIST_X);
        listOfClients.setTranslateY(LIST_Y);
        listOfClients.setPrefHeight(LIST_HEIGHT);
        listOfClients.setPrefWidth(LIST_WIDTH);
        listOfClients.setWrapText(true);
        listOfClients.setStyle(STYLE_TEXT);
        listOfClients.setEditable(false);
        listOfClients.setPromptText(LIST_PROMPT_TEXT);
    }
    private void setChat() {
        chat = new TextArea();
        chat.setTranslateX(CHAT_X);
        chat.setTranslateY(CHAT_Y);
        chat.setPrefHeight(CHAT_HEIGHT);
        chat.setPrefWidth(CHAT_WEIGHT);
        chat.setWrapText(true);
        chat.setStyle(STYLE_TEXT);
        chat.setEditable(false);
        chat.setPromptText(CHAT_PROMPT_TEXT);
    }
   private void setTextArea() {
        textArea = new TextArea();
        textArea.setTranslateX(TEXT_AREA_X);
        textArea.setTranslateY(TEXT_AREA_Y);
        textArea.setPrefWidth(TEXT_AREA_WEIGHT);
        textArea.setPromptText(TEXT_AREA_PROMPT_TEXT);
        textArea.setWrapText(true);
        textArea.setStyle(TEXT_AREA_STYLE);
       textArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
           @Override
           public void handle(KeyEvent keyEvent) {
               if (keyEvent.getCode() == KeyCode.ENTER)  {
                   controller.setMessage(textArea.getText());
                   textArea.clear();
               }
           }
       });
   }
   public  String getTextArea() {
        return textArea.getText();
   }
    private void makeButton() {
        connection = new Button(NAME_BUTTON_CONNECT);
        disConnection = new Button(NAME_BUTTON_DISCONNECT);
        list = new Button(NAME_BUTTON_LIST);
    }
    private void setButtonList(Button button) {
        button.setTranslateX(LIST_BUTTON_X);
        button.setTranslateY(LIST_BUTTON_Y);
        button.setPrefSize(LIST_BUTTON_HEIGHT, LIST_BUTTON_WEIGHT);
        button.setStyle(STYLE_BACK_BUTTON + STYLE_FRONT_BUTTON);
    }
    private void setButtonConnect(Button button) {
        button.setTranslateX(CONNECT_X);
        button.setTranslateY(BUTTON_Y);
        button.setPrefSize(BUTTON_HEIGHT, BUTTON_WEIGHT);
        button.setStyle(STYLE_BACK_BUTTON + STYLE_FRONT_BUTTON);

    }

    private void setButtonDisConnect(Button button) {
        button.setTranslateX(DISCONNECT_X);
        button.setTranslateY(BUTTON_Y);
        button.setPrefSize(BUTTON_HEIGHT, BUTTON_WEIGHT);
        button.setStyle(STYLE_BACK_BUTTON + STYLE_FRONT_BUTTON);

    }
    private void addLine() {
        line = new Line(LINE_X, LINE_Y, LINE_X, LINE_Y2);
        line.setStrokeWidth(LINE_WIDTH);
        line.setStroke(Color.DARKSEAGREEN);
    }

    public static void main(String[] args) {
        launch();
    }
    public  void setText(String str, String time) {
        try {
            chat.appendText(time + ": " + USER_NAME + str + "\n");
        } catch (NullPointerException error) {

        }
    }
    public  void setMessage(String telegram, String name, String time) {
        try {
            chat.appendText(time + USER_STRING + name + ": " + telegram);
        } catch (NullPointerException error) {

        }
    }
    public   void setList(ArrayList<String> str) {
        listOfClients.clear();
        for (String s : str) {
             listOfClients.appendText(USER_STRING + s + "\n");
        }
    }
    public  void showDeletedClient(String str, String time) {
        try {
            chat.appendText(time + ": " + USER_STRING + str + " " + USER_LEFT);
        } catch (NullPointerException error) {

        }
    }

}