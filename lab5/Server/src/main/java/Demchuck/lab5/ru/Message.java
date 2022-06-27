package Demchuck.lab5.ru;

import static Demchuck.lab5.ru.Constants.MESSAGE_JAVA;

public class Message extends JavaObject{
    private static final long serialVersionUID = 4529685098267757690L;
    public Message() {
        setCommand(MESSAGE_JAVA);
    }
}
