package lab5.demchuk.client.clientjavafx.model.Factory;

import lab5.demchuk.client.clientjavafx.controller.ControllerClient;

import static lab5.demchuk.client.clientjavafx.model.Factory.Constannts.MESSAGE;

public class Message extends Reader{
    private String telegram;
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
    public void outInWindow() {
        ControllerClient.setMessageOnView(telegram);
    }
}
