package Demchuck.lab5.ru;

import java.text.SimpleDateFormat;
import java.util.Date;

import static Demchuck.lab5.ru.Constants.CHAT_CLIENT_NAME_JAVA;
import static lab5.demchuk.client.clientjavafx.clientveb.ConstantsView.DATA_FORMAT;

public class Login extends JavaObject{
    private static final long serialVersionUID = 2529685098267757690L;
    private String userName;
    private String time;
    public void setTime()  {
        Date time = new Date();
        SimpleDateFormat dt1 = new SimpleDateFormat(DATA_FORMAT);
        this.time = dt1.format(time); // время
    }
    public String getTime() {
        return this.time;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }
    public Login() {
        setCommand(CHAT_CLIENT_NAME_JAVA);
    }
}
