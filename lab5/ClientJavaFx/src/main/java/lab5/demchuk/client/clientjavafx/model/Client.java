package lab5.demchuk.client.clientjavafx.model;

import com.google.gson.Gson;
import lab4.demchuk.phone.phone.Connect;
import lab4.demchuk.phone.phone.UserName;
import lab5.demchuk.client.clientjavafx.controller.ControllerClient;
import lab5.demchuk.client.clientjavafx.controller.ControllerRegistration;
import lab5.demchuk.client.clientjavafx.model.Factory.ActionInChat;
import lab5.demchuk.client.clientjavafx.model.Factory.CreateLogin;
import lab5.demchuk.client.clientjavafx.model.Factory.FactoryChat;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;



class ClientSomthing {



    private Connect connect;
    private String nickName; // имя клиента
    private Date time;
    private String dtime;
    private SimpleDateFormat dt1;



    public ClientSomthing(Connect connect) {

       this.connect = connect;
            this.pressNickname();
            new ReadMsg().start();
            new WriteMsg().start();


    }



    private void pressNickname() {
        try {
            nickName = ControllerRegistration.getName();
            UserName name = new UserName(nickName);
            FactoryChat chat = new CreateLogin();
            ActionInChat operations = chat.createAction();
           String str = operations.doAction(name);
           connect.writeLine(str);
           String string = connect.readLine();
            Gson gson1 = new Gson();
           AnswerFromServer answer = gson1.fromJson(string, AnswerFromServer.class);
            System.out.println(answer.getStr());
            if (answer.getStr().equals("SUCCESS")) {
                System.out.println("djhsdjh");
                Gson gson = new Gson();
                name = gson.fromJson(str, UserName.class);
                ControllerClient.setName(name.getNickName());
            }

        } catch (IOException ignored) {
        }

    }

    private void downService() {
        try {
            if (!connect.getSocket().isClosed()) {
                connect.getSocket().close();
                connect.close();
            }
        } catch (IOException ignored) {}
    }
    private class ReadMsg extends Thread {
        @Override
        public void run() {

            String str;
            try {
                while (true) {
                    str = connect.readLine();
                    if (str.equals("stop")) {
                        ClientSomthing.this.downService();
                        break;
                    }
                    System.out.println(str);
                }
            } catch (IOException e) {
                ClientSomthing.this.downService();
            }
        }
    }
    public class WriteMsg extends Thread {

        @Override
        public void run() {
            while (true) {
                String userWord;
                try {
                    time = new Date();
                    dt1 = new SimpleDateFormat("HH:mm:ss");
                    dtime = dt1.format(time); // время
                    userWord = connect.readLineSystem();
                    if (userWord.equals("stop")) {
                        connect.writeLine("stop" + "\n");
                        ClientSomthing.this.downService();
                        break;
                    } else {
                        connect.writeLine("(" + dtime + ") " + nickName + ": " + userWord + "\n");
                    }
                } catch (IOException e) {
                    ClientSomthing.this.downService();

                }

            }
        }
    }
}

public class Client {

    public static String ipAddr = "localhost";
    public static int port = 8080;


    public static void newClient() {

        try {
            Socket socket = new Socket(ipAddr, port);
            Connect connect = new Connect(socket);
            new ClientSomthing(connect);
        }catch (Exception error) {
            error.printStackTrace();
        }
    }
}