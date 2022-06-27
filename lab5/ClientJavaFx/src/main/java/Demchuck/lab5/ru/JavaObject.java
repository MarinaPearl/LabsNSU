package Demchuck.lab5.ru;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static Demchuck.lab5.ru.Constants.DATA_FORMAT;


public abstract class JavaObject implements Serializable {
    private String command;
    private String message;
    private String time;
    private String userName;
    private ArrayList<JavaObject> stringArrayList;
    public void setStringArrayList(ArrayList<JavaObject> str) {
        this.stringArrayList =str;
    }
    public ArrayList<JavaObject> getStringArrayList() {
        return this.stringArrayList;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setTime() {
        Date time1 = new Date();
        SimpleDateFormat dt1 = new SimpleDateFormat(DATA_FORMAT);
        this.time = dt1.format(time1); // время
    }
    public String getTime () {
        return time;
    }
    public String getCommand() {
        return command;
    }
    public void setCommand(String str) {
        this.command = str;
    }

}
