package lab5.demchuk.client.clientjavafx.model.Factory;

import com.google.gson.Gson;
import lab5.demchuk.client.clientjavafx.controller.ControllerClient;

import java.util.ArrayList;

import static lab5.demchuk.client.clientjavafx.model.Factory.Constannts.CHAT_CLIENT_N;

public class ListOfClients extends Reader {
    private ArrayList<String> stringArrayList;
    public ListOfClients() {
        setCommand(CHAT_CLIENT_N);
    }
    public void setArrayList(ArrayList<String> str) {
        stringArrayList = str;
    }
    public ArrayList<String> getStringArrayList() {
        return stringArrayList;
    }
    @Override
    public void outInWindow() {
        Gson gson = new Gson();
       // Login login = new Login();
        ArrayList<String> str = new ArrayList<String>();
        for (String string : stringArrayList) {
            Login login = gson.fromJson(string, Login.class);
            str.add(login.getNameUser());
        }
        //ControllerClient.setList(stringArrayList);
        ControllerClient.setList(str);
    }
}
