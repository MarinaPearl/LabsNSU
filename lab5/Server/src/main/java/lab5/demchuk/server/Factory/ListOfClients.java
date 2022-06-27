package lab5.demchuk.server.Factory;

import lab5.demchuk.server.Server;
import lab5.demchuk.server.ServerSomthing;

import java.util.ArrayList;

import static lab5.demchuk.server.Factory.Constants.CHAT_CLIENT_N;

public class ListOfClients extends Reader{
    private ArrayList<String> stringArrayList;
    public ListOfClients() {
        setCommand(CHAT_CLIENT_N);
    }
    @Override
    public void runCommand() {
        stringArrayList = ServerSomthing.getList();
    }
}
