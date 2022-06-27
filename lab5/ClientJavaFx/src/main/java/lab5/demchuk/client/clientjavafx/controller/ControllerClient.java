package lab5.demchuk.client.clientjavafx.controller;

import lab5.demchuk.client.clientjavafx.clientveb.ClientView;
import lab5.demchuk.client.clientjavafx.clientveb.RegistrartionView;
import lab5.demchuk.client.clientjavafx.model.ClientSomthing;

import java.util.ArrayList;

public class ControllerClient {
    private ClientView view;
    private ClientSomthing clientSomthing;
    public void setClientSomthing(ClientSomthing clientSomthing) {
        this.clientSomthing = clientSomthing;
    }
    public ClientSomthing getClientSomthing() {
        return this.clientSomthing;
    }
    public void setView(ClientView value) {
        this.view = value;
    }

    public void doRegistration(String str, ControllerClient controllerClient) {
        RegistrartionView view = new RegistrartionView();
        view.registarted(str, controllerClient);
    }

    public  void setName(String str, String time) {
        view.setText(str, time);
    }

    public  void setMessage(String str) {
        //clientSomthing.sendMessage(str);
        if (clientSomthing.getSerialization()) {
            clientSomthing.sendMessage(str);
        } else {
            clientSomthing.sendObject(str);
        }
        //String str = ClientView.getTextArea();
        //return str;
    }

    public void setMessageOnView(String str, String name, String time) {
        view.setMessage(str, name, time);
        //ClientView.setText(str);
    }

    public  void sendList() {
        clientSomthing.sendList();
    }

    public  void setList(ArrayList<String> str) {
        view.setList(str);
    }

    public  void downClient() {
        //clientSomthing.logout();
        if (clientSomthing.getSerialization() == true) {
            clientSomthing.logout();
        } else {
            clientSomthing.logoutObject();
        }
        //ClientSomthing.downService();
    }

    public void deleted(String str, String time) {

        view.showDeletedClient(str, time);
    }
}

