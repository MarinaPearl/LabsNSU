package lab5.demchuk.client.clientjavafx.model.Factory;

import lab5.demchuk.client.clientjavafx.controller.ControllerClient;

import static lab5.demchuk.client.clientjavafx.model.Factory.Constannts.LOGOUT;

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
    public void outInWindow() {
        ControllerClient.deleted(getName());
    }
}
