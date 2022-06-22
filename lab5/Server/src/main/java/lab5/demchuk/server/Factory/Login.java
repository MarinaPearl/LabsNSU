package lab5.demchuk.server.Factory;

import static lab5.demchuk.server.Factory.Constants.CHAT_CLIENT_NAME;

public class Login extends Reader {
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
    public void runCommand() {
    }
}
