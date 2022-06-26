package lab5.demchuk.server.Factory;

import java.text.SimpleDateFormat;
import java.util.Date;

import static lab5.demchuk.server.Factory.Constants.CHAT_CLIENT_NAME;
import static lab5.demchuk.server.Factory.Constants.DATA_FORMAT;

public class Login extends Reader {
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
    public void runCommand() {
    }
}
