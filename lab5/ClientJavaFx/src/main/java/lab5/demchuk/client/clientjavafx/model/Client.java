package lab5.demchuk.client.clientjavafx.model;

import com.google.gson.Gson;
import lab4.demchuk.phone.phone.Connect;
import lab5.demchuk.client.clientjavafx.controller.ControllerClient;
import lab5.demchuk.client.clientjavafx.controller.ControllerRegistration;
import lab5.demchuk.client.clientjavafx.model.Factory.*;

import java.io.*;
import java.io.Reader;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static lab5.demchuk.client.clientjavafx.model.Factory.Constannts.CHAT_CLIENT_NAME;


public class Client {

    public static String ipAddr = "localhost";
    public static int port = 8080;


    public static void newClient() {

        try {
            Socket socket = new Socket(ipAddr, port);
            Connect connect = new Connect(socket);
            new ClientSomthing(connect);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}