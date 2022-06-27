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

    //public static String ipAddr = "192.168.56.1";
    //public static int port = 8080;


    public  void newClient(ControllerClient controllerClient, boolean serialization, String port, String ip) {

        try {
            Socket socket = new Socket(ip, Integer.parseInt(port));
            Connect connect = new Connect(socket);
            new ClientSomthing(connect, controllerClient, serialization);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}