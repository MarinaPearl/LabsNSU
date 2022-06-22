package lab5.demchuk.client.clientjavafx.clientveb;

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
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import lab5.demchuk.client.clientjavafx.controller.ControllerClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static lab5.demchuk.client.clientjavafx.clientveb.ConstantsView.*;

public class ClientView extends Application {
    private Pane group;
    private Scene scene;
    private Button connection;
    private Button disConnection;
    private Line line;
    private static TextArea listOfClients;
    private static TextArea textArea;
    private static TextArea chat;
    private static Button list;
    @Override
    public void start(Stage stage) {
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
        group.getChildren().addAll(connection, disConnection, line, textArea, chat, listOfClients, list);
        connection.setOnMouseClicked(event -> {
           ControllerClient.doRegistration(str);
        });
        list.setOnMouseClicked(event -> {
             ControllerClient.sendList();
        });
        disConnection.setOnMouseClicked(event -> {
               ControllerClient.downClient();
               stage.close();
        });
        stage.setScene(scene);
        stage.setTitle(NAME_CHAT);
        stage.show();

    }
    private void setList() {
        listOfClients = new TextArea();
        listOfClients.setTranslateX(LIST_X);
        listOfClients.setTranslateY(LIST_Y);
        listOfClients.setPrefHeight(LIST_HEIGHT);
        listOfClients.setPrefWidth(LIST_WIDTH);
        listOfClients.setWrapText(true);
        listOfClients.setOpacity(OPACITY);
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
        chat.setOpacity(OPACITY);
        chat.setStyle(STYLE_TEXT);
        chat.setEditable(false);
        chat.setPromptText(CHAT_PROMPT_TEXT);
    }
   private void setTextArea() {
        textArea = new TextArea();
        textArea.setTranslateX(TEXT_AREA_X);
        textArea.setTranslateY(TEXT_AREA_Y);
        textArea.setPrefHeight(TEXT_AREA_HEIGHT);
        textArea.setPrefWidth(TEXT_AREA_WEIGHT);
        textArea.setPromptText(TEXT_AREA_PROMPT_TEXT);
        textArea.setWrapText(true);
        textArea.setOpacity(TEXT_AREA_OPACITY);
        textArea.setStyle(TEXT_AREA_STYLE);
       textArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
           @Override
           public void handle(KeyEvent keyEvent) {
               if (keyEvent.getCode() == KeyCode.ENTER)  {
                   ControllerClient.setMessage(textArea.getText());
                   textArea.clear();
               }
           }
       });
   }
   public static String getTextArea() {
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
    public static void setText(String str) {
        Date time = new Date();
        SimpleDateFormat dt1 = new SimpleDateFormat(DATA_FORMAT);
       String dtime = dt1.format(time); // время
        System.out.println(str);
           chat.appendText(dtime + ": " + USER_NAME + str + "\n");
    }
    public static  void setList(ArrayList<String> str) {
        listOfClients.clear();
        for (String s : str) {
             listOfClients.appendText(USER_STRING + s + "\n");
        }
    }
    public static void showDeletedClient(String str) {
        Date time = new Date();
        SimpleDateFormat dt1 = new SimpleDateFormat(DATA_FORMAT);
        String dtime = dt1.format(time); // время
        chat.appendText(USER_STRING + str + " " + USER_LEFT);
    }

}