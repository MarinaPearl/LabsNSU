package lab5.demchuk.client.clientjavafx.model.Factory;

public abstract class Reader implements TypeCommand {
       private String command;
       public void setCommand(String str) {
           this.command = str;
       }
       public String getCommand() {
           return command;
       }
}
