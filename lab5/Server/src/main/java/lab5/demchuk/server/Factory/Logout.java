package lab5.demchuk.server.Factory;

import com.google.gson.Gson;
import lab5.demchuk.server.Server;

import java.util.ArrayList;

import static lab5.demchuk.server.Factory.Constants.LOGOUT;

public class Logout extends Reader{
    private String name;
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
        Gson gson = new Gson();
        ArrayList<String> list = new ArrayList<String>();
        list = Server.listofClients;
        Server.listofClients.clear();
        for (String str : list) {
            System.out.println("11");
            Login login = gson.fromJson(str, Login.class);
            System.out.println("22");
            String string = login.getNameUser();
            System.out.println("33");
            if (!string.equals(getName())) {
                System.out.println(string);
                Server.listofClients.add(str);
                //Server.listofClients.remove(str);
                System.out.println("44");
            }
        }
    }
}
