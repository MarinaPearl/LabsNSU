package lab5.demchuk.server;

import com.google.gson.Gson;
import lab4.demchuk.phone.phone.Connect;
import lab5.demchuk.server.Factory.ReaderClass;
import lab5.demchuk.server.Factory.TypeCommand;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class ServerSomthing extends Thread {

    private Connect connect;
    private int count = 0;
    private InputStream input;
    private Properties prop;
    private static String PATH_TO_PROPERTY = "file.properties";

    public ServerSomthing(Connect connect) throws IOException {
        this.input = Server.class.getClassLoader().getResourceAsStream(PATH_TO_PROPERTY);
        prop = new Properties();
        prop.load(input);
        input.close();
        this.connect = connect;
        //  Server.story.printStory(this.connect);
        start();
    }

    @Override
    public void run() {
        String word;
        try {
            while (true) {
                word = connect.readLine();
                if (word.equals("stop")) {
                    this.downService();
                    break;
                }
                System.out.println("Echoing: " + word);
                // Server.story.addStoryEl(word);
                Gson gson = new Gson();
                TypeCommand command = (TypeCommand) Class.forName(
                        prop.getProperty(gson.fromJson(word, ReaderClass.class).getCommand())).newInstance();
                command = gson.fromJson(word, command.getClass());
                command.runCommand();
                System.out.println("after runCommand");
                word = gson.toJson(command);
                System.out.println("after gson");
                for (ServerSomthing vr : Server.serverList) {
                    vr.send(word);
                }
                System.out.println("1");
                if (count == 0) {
                    Server.listofClients.add(word);
                    if (Server.story.story.size() > 0) {
                        //connect.writeLine("History messages");
                        for (String vr : Server.story.story) {
                            send(vr);
                            //connect.writeLine(vr + "\n");
                        }
                        //connect.writeLine("/....");

                    }
                    //Server.story.printStory(this.connect);
                    count = 1;
                }
                System.out.println("2");
                Server.story.story.add(word);
                // Server.story.addStoryEl(word);
                System.out.println("3");

            }
        } catch (NullPointerException | IOException ignored) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    private void send(String msg) {
        try {
            connect.writeLine(msg);
        } catch (IOException ignored) {
        }

    }

    private void downService() {
        try {
            if (!connect.getSocket().isClosed()) {
                connect.close();
                connect.getSocket().close();
                for (ServerSomthing vr : Server.serverList) {
                    if (vr.equals(this)) vr.interrupt();
                    Server.serverList.remove(this);
                }
            }
        } catch (IOException ignored) {
        }
    }

    public static ArrayList<String> getList() {
        return Server.listofClients;
    }
}
