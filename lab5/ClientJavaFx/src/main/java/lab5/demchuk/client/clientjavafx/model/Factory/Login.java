package lab5.demchuk.client.clientjavafx.model.Factory;

import lab5.demchuk.client.clientjavafx.controller.ControllerClient;
import lab5.demchuk.client.clientjavafx.model.ClientSomthing;

import java.text.SimpleDateFormat;
import java.util.Date;

import static lab5.demchuk.client.clientjavafx.clientveb.ConstantsView.DATA_FORMAT;
import static lab5.demchuk.client.clientjavafx.model.Factory.Constannts.CHAT_CLIENT_NAME;

public class Login extends Reader{
    private String nameUser;
    private String time;
    public void setTime()  {
        Date time = new Date();
        SimpleDateFormat dt1 = new SimpleDateFormat(DATA_FORMAT);
        this.time = dt1.format(time); // время
    }
    public String getTime() {
        return time;
    }
    public Login() {
        setCommand(CHAT_CLIENT_NAME);
    }
   public void setName(String name) {
        this.nameUser = name;
   }
    public String getNameUser() {
        return nameUser;
    }
    @Override
    public void outInWindow(ControllerClient controllerClient) {

        controllerClient.setName(nameUser, getTime());
    }
}
