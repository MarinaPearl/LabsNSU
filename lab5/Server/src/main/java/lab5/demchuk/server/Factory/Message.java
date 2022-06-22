package lab5.demchuk.server.Factory;

import static lab5.demchuk.server.Factory.Constants.MESSAGE;

public class Message extends Reader{
    private String telegram;
    public Message() {
        setCommand(MESSAGE);
    }
    public void setMessage(String str) {
        this.telegram = str;
    }
    public String getTelegram() {
        return telegram;
    }
    @Override
    public void runCommand() {
    }
}
