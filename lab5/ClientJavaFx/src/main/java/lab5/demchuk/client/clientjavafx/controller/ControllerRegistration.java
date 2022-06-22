package lab5.demchuk.client.clientjavafx.controller;

import javafx.stage.Stage;
import lab5.demchuk.client.clientjavafx.clientveb.RegistrartionView;
import lab5.demchuk.client.clientjavafx.model.Client;

public class ControllerRegistration {
    private Stage stage;
    private static String name;
    public void closeWindow(Stage stage)
    {
       this.stage = stage;
      // this.name = name;
       this.name = RegistrartionView.getName();
       if (name.hashCode() != 0) {
           stage.close();
       }
    }
    public void connectingInChat() {
        Client.newClient();
    }
    public static String getName() {
        return name;
        //return RegistrartionView.getName();
    }
}
