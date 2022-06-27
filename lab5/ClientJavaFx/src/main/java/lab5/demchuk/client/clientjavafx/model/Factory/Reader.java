package lab5.demchuk.client.clientjavafx.model.Factory;

import java.io.Serializable;

public abstract class Reader implements TypeCommand, Serializable {
       private String command;
       public void setCommand(String str) {
           this.command = str;
       }
       public String getCommand() {
           return command;
       }
}
