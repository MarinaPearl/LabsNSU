package lab5.demchuk.client.clientjavafx.model.Factory;

import lab5.demchuk.client.clientjavafx.controller.ControllerClient;
import lab5.demchuk.client.clientjavafx.model.ClientSomthing;

import java.text.SimpleDateFormat;
import java.util.Date;

import static lab5.demchuk.client.clientjavafx.clientveb.ConstantsView.DATA_FORMAT;
import static lab5.demchuk.client.clientjavafx.model.Factory.Constannts.MESSAGE;

public class Message extends Reader{
    private String telegram;
    private String nickUser;
    private String time;
    public void setTime()  {
        Date time = new Date();
        SimpleDateFormat dt1 = new SimpleDateFormat(DATA_FORMAT);
        this.time = dt1.format(time); // время
    }
    public String getTime() {
        return time;
    }
    public void setNickUser(String name) {
        this.nickUser = name;
    }
    public String getNickUser() {
        return this.nickUser;
    }
    public Message() {
        setCommand(MESSAGE);
    }
    public void setMessage(String str) {
        this.telegram = str;
    }
    public String getTelegram() {
        return telegram;
    }
    @Override
    public void outInWindow(ControllerClient controllerClient) {
       // System.out.println("USser in Massage " + getNickUser());
        controllerClient.setMessageOnView(telegram, getNickUser(), getTime());
    }
}
