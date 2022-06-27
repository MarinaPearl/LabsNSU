package lab5.demchuk.server.Factory;

import java.text.SimpleDateFormat;
import java.util.Date;

import static lab5.demchuk.server.Factory.Constants.DATA_FORMAT;
import static lab5.demchuk.server.Factory.Constants.MESSAGE;

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
    public void runCommand() {
    }
}
