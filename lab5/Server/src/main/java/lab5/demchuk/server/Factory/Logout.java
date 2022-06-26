package lab5.demchuk.server.Factory;

import com.google.gson.Gson;
import lab5.demchuk.server.Server;
import lab5.demchuk.server.ServerSomthing;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static lab5.demchuk.server.Factory.Constants.DATA_FORMAT;
import static lab5.demchuk.server.Factory.Constants.LOGOUT;

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
    public void runCommand() {
       //ServerSomthing.setActive(false);
        Gson gson = new Gson();
        ArrayList<String> list = new ArrayList<String>();
        for (String string : Server.listofClients) {
            list.add(string);
        }
        Server.listofClients.clear();
        for (String str : list) {
            Login login = gson.fromJson(str, Login.class);
            String string = login.getNameUser();
            if (!string.equals(getName())) {
                //System.out.println(string);
                Server.listofClients.add(str);
                //Server.listofClients.remove(str);
            }
        }
    }
}
