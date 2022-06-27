package Demchuck.lab5.ru;

import static Demchuck.lab5.ru.Constants.CHAT_CLIENT_N_JAVA;

public class ListOfClients extends JavaObject{
    private static final long serialVersionUID = 1529685098267757690L;
    public ListOfClients() {
        setCommand(CHAT_CLIENT_N_JAVA);
    }
}
