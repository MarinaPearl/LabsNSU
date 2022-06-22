package lab5.demchuk.server.Factory;

public abstract class Reader implements TypeCommand {
    private String command;
    public void setCommand(String str) {
        this.command = str;
    }
    public String getCommand() {
        return command;
    }
}
