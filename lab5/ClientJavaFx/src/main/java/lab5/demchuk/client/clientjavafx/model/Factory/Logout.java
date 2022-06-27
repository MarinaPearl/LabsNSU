package lab5.demchuk.client.clientjavafx.model.Factory;

import lab5.demchuk.client.clientjavafx.controller.ControllerClient;
import lab5.demchuk.client.clientjavafx.model.ClientSomthing;

import java.text.SimpleDateFormat;
import java.util.Date;

import static lab5.demchuk.client.clientjavafx.clientveb.ConstantsView.DATA_FORMAT;
import static lab5.demchuk.client.clientjavafx.model.Factory.Constannts.LOGOUT;

public class Logout extends Reader{
    private String name;
    private String time;
    public void setTime()  {
        Date time = new Date();
        SimpleDateFormat dt1 = new SimpleDateFormat(DATA_FORMAT);
        this.time = dt1.format(time); // время
    }
    public String getTime() {
        return time;
    }
    public Logout() {
        setCommand(LOGOUT);
    }
    public void setName(String str) {
        name = str;
    }
    public String getName() {
        return name;
    }
    @Override
    public void outInWindow(ControllerClient controllerClient) {
        System.out.println("logout");
       // ClientSomthing.setActive(false);
        if (getName().equals(controllerClient.getClientSomthing().getNickname())) {
            controllerClient.getClientSomthing().downService();
        }
        controllerClient.deleted(getName(), getTime());
    }
}
