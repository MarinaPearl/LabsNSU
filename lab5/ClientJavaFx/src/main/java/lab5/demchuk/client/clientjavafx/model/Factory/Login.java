package lab5.demchuk.client.clientjavafx.model.Factory;

import lab5.demchuk.client.clientjavafx.controller.ControllerClient;

import static lab5.demchuk.client.clientjavafx.model.Factory.Constannts.CHAT_CLIENT_NAME;

public class Login extends Reader{
    private String nameUser;

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
    public void outInWindow() {
        ControllerClient.setName(nameUser);
    }
}
