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
        scene = new Scene(group, 800, 600);
       group.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
        makeButton();
        addLine();
        setTextArea();
        setList();
        String str = "Telegram";
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
        stage.setTitle("Telegram");
        stage.show();

    }
    private void setList() {
        listOfClients = new TextArea();
        listOfClients.setTranslateX(570);
        listOfClients.setTranslateY(8);
        listOfClients.setPrefHeight(470);
        listOfClients.setPrefWidth(227);
        listOfClients.setWrapText(true);
        listOfClients.setOpacity(0.7);
        listOfClients.setStyle("-fx-font: 17 arial");
        listOfClients.setEditable(false);
        listOfClients.setPromptText("List of Clients");
    }
    private void setChat() {
        chat = new TextArea();
        chat.setTranslateX(0);
        chat.setTranslateY(10);
        chat.setPrefHeight(540);
        chat.setPrefWidth(560);
        chat.setWrapText(true);
        chat.setOpacity(0.7);
        chat.setStyle("-fx-font: 17 arial");
        chat.setEditable(false);
        chat.setPromptText("TELEGRAM");
    }
   private void setTextArea() {
        textArea = new TextArea();
        textArea.setTranslateX(0);
        textArea.setTranslateY(561);
        textArea.setPrefHeight(400);
        textArea.setPrefWidth(560);
        textArea.setPromptText("Message");
        textArea.setWrapText(true);
        textArea.setOpacity(0.8);
        textArea.setStyle("-fx-font: 20 arial");
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
        connection = new Button("CONNECT");
        disConnection = new Button("DISCONNECT");
        list = new Button("LIST");
    }
    private void setButtonList(Button button) {
        button.setTranslateX(690);
        button.setTranslateY(500);
        button.setPrefSize(100, 30);
        button.setStyle("-fx-font: 12 arial; -fx-background-color:#339966;" +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 )");
    }
    private void setButtonConnect(Button button) {
        button.setTranslateX(570);
        button.setTranslateY(550);
        button.setPrefSize(100, 30);
        button.setStyle("-fx-font: 12 arial; -fx-background-color:#339966 ; " +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 )");

    }

    private void setButtonDisConnect(Button button) {
        button.setTranslateX(690);
        button.setTranslateY(550);
        button.setPrefSize(100, 30);
        button.setStyle("-fx-font: 12 arial; -fx-background-color:#339966;" +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 )");

    }
    private void addLine() {
        line = new Line(565, 0, 565, 600);
        line.setStrokeWidth(5);
        line.setStroke(Color.DARKSEAGREEN);
    }

    public static void main(String[] args) {
        launch();
    }
    public static void setText(String str) {
        Date time = new Date();
        SimpleDateFormat dt1 = new SimpleDateFormat("HH:mm:ss");
       String dtime = dt1.format(time); // время
        System.out.println(str);
           chat.appendText(dtime + ": " + "New User: " + str + "\n");
    }
    public static  void setList(ArrayList<String> str) {
        listOfClients.clear();
        for (String s : str) {
             listOfClients.appendText("User: " + s + "\n");
        }
    }
    public static void showDeletedClient(String str) {
        Date time = new Date();
        SimpleDateFormat dt1 = new SimpleDateFormat("HH:mm:ss");
        String dtime = dt1.format(time); // время
        chat.appendText("User " + str + " " + "has left this chat\n" );
    }

}