package lab5.demchuk.client.clientjavafx.controller;

import lab5.demchuk.client.clientjavafx.clientveb.ClientView;
import lab5.demchuk.client.clientjavafx.clientveb.RegistrartionView;

public class ControllerClient {
    public static void doRegistration(String str) {
        RegistrartionView view = new RegistrartionView();
        view.registarted(str);
    }
    public static void setName(String str) {
        ClientView.setName(str);
    }
}

