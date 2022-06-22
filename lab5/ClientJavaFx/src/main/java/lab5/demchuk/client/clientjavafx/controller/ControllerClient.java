package lab5.demchuk.client.clientjavafx.controller;

import lab5.demchuk.client.clientjavafx.clientveb.ClientView;
import lab5.demchuk.client.clientjavafx.clientveb.RegistrartionView;
import lab5.demchuk.client.clientjavafx.model.ClientSomthing;

import java.util.ArrayList;

public class ControllerClient {
    private static String string;
    public static void doRegistration(String str) {
        RegistrartionView view = new RegistrartionView();
        view.registarted(str);
    }
    public static void setName(String str) {
        ClientView.setText(str);
    }
    public static void setMessage(String str) {
        string = str;
        ClientSomthing.sendMessage(str);
        //String str = ClientView.getTextArea();
        //return str;
    }
    public static  void setMessageOnView(String str) {
           ClientView.setText(str);
    }
    public static void sendList() {
           ClientSomthing.sendList();
    }
    public static void setList(ArrayList<String> str) {
            ClientView.setList(str);
    }
    public static void downClient() {
        ClientSomthing.logout();
        //ClientSomthing.downService();
    }
    public static void deleted(String str) {
          ClientView.showDeletedClient(str);
    }
}

