package lab5.demchuk.server;

import Demchuck.lab5.ru.JavaObject;
import com.google.gson.Gson;
import lab4.demchuk.phone.phone.Connect;
import lab5.demchuk.server.Factory.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;

import static Demchuck.lab5.ru.Constants.CHAT_CLIENT_N_JAVA;
import static Demchuck.lab5.ru.Constants.LOGOUT_JAVA;
import static lab5.demchuk.server.Factory.Constants.*;

public class ServerSomthing extends Thread {

    private Connect connect;
    private int count = 0;
    private InputStream input;
    private Properties prop;
    private boolean active = true;
    private static String PATH_TO_PROPERTY = "file.properties";
    private static final int NULL_SIZE = 0;
    private static final int FLAG = 1;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private static final String JSON = "Json";
    public ServerSomthing(Connect connect) throws IOException {
        objectOutputStream = new ObjectOutputStream(connect.getSocket().getOutputStream());
        objectInputStream = new ObjectInputStream(connect.getSocket().getInputStream());
        this.input = Server.class.getClassLoader().getResourceAsStream(PATH_TO_PROPERTY);
        prop = new Properties();
        prop.load(input);
        input.close();
        this.connect = connect;
        start();
    }

    @Override
    public void run() {
        try {
            System.out.println(active);
            String serialization = connect.readLine();
            while (active) {
                if (serialization.equals(JSON)) {
                    doGson();
                } else {
                    useJavaObject();
                }
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


    public void sendObject(JavaObject javaObject) {
        try {
            objectOutputStream.writeObject(javaObject);
        } catch (IOException error) {

        }
    }

    private void useJavaObject() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        JavaObject javaObject = (JavaObject) objectInputStream.readObject();
        // objectOutputStream.writeObject(javaObject);
        if (javaObject.getCommand().equals(LOGOUT_JAVA)) {
            this.active = false;
            //  connect.writeLine(word);
            for (ServerSomthing vr : Server.serverList) {
                System.out.println(vr);
                vr.sendObject(javaObject);
            }
//            //оно было после цикла
            //  downService();

            for (ServerSomthing vr : Server.serverList) {
                Demchuck.lab5.ru.ListOfClients listOfClients = new Demchuck.lab5.ru.ListOfClients();
                listOfClients.setStringArrayList(Server.javaObjectArrayList);
                vr.sendObject(listOfClients);
            }
        } else if (javaObject.getCommand().equals(CHAT_CLIENT_N_JAVA)) {
            try {
                objectOutputStream.writeObject(javaObject);
            } catch (IOException error) {
            }
        } else {

            for (ServerSomthing vr : Server.serverList) {
                System.out.println(vr);
                vr.sendObject(javaObject);
            }
        }
        if (count == NULL_SIZE) {
            Server.javaObjectArrayList.add(javaObject);
            for (ServerSomthing vr : Server.serverList) {
                Demchuck.lab5.ru.ListOfClients listOfClients = new Demchuck.lab5.ru.ListOfClients();
                listOfClients.setStringArrayList(Server.javaObjectArrayList);
                //System.out.println(vr);
                vr.sendObject(listOfClients);
            }
            if (Server.story.storyObject.size() > NULL_SIZE) {
                for (JavaObject vr : Server.story.storyObject) {
                    sendObject(vr);

                }

            }
            count = FLAG;
        }
        //addStrory(Server.story.story, word);
        Server.story.storyObject.add(javaObject);
    }

    private void downService() {
        try {
            if (!connect.getSocket().isClosed()) {
                connect.getSocket().close();
                connect.close();
                for (int i = 0; i < Server.serverList.size(); ++i) {
                    ServerSomthing s = Server.serverList.get(i);
                    if (s.equals(this)) {
                        Server.serverList.remove(i);
                    }
                }
                for (ServerSomthing vr : Server.serverList) {
                    if (vr.equals(this)) {
                        //тут было закомментирванно
                        //vr.interrupt();
                        Server.serverList.remove(this);
                    }

                }
            }
        } catch (IOException ignored) {
        }
    }

    private void doGson() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String word;
        word = connect.readLine();
        System.out.println("Echoing: " + word);
        //Server.story.addStoryEl(word);
        Gson gson = new Gson();
        TypeCommand command = (TypeCommand) Class.forName(
                prop.getProperty(gson.fromJson(word, ReaderClass.class).getCommand())).newInstance();
        command = gson.fromJson(word, command.getClass());
        command.runCommand();
        word = gson.toJson(command);
        if (gson.fromJson(word, ReaderClass.class).getCommand().equals(LOGOUT)) {
            active = false;
            //  connect.writeLine(word);
            for (ServerSomthing vr : Server.serverList) {
                System.out.println(vr);
                vr.send(word);
            }
            //оно было после цикла
            downService();
            for (ServerSomthing vr : Server.serverList) {
                ListOfClients list = new ListOfClients();
                list.runCommand();
                String string = gson.toJson(list);
                //System.out.println(vr);
                vr.send(string);
            }

        } else if (gson.fromJson(word, ReaderClass.class).getCommand().equals(CHAT_CLIENT_N)) {
            try {
                connect.writeLine(word);
            } catch (IOException error) {
            }
        } else {

            for (ServerSomthing vr : Server.serverList) {
                System.out.println(vr);
                vr.send(word);
            }
        }
        if (count == NULL_SIZE) {
            Server.listofClients.add(word);
            for (ServerSomthing vr : Server.serverList) {
                ListOfClients list = new ListOfClients();
                list.runCommand();
                String string = gson.toJson(list);
                //System.out.println(vr);
                vr.send(string);
            }
            if (Server.story.story.size() > NULL_SIZE) {
                for (String vr : Server.story.story) {
                    send(vr);

                }

            }
            count = FLAG;
        }
        //addStrory(Server.story.story, word);
        Server.story.story.add(word);
    }


    public static ArrayList<JavaObject> getListObject() {
        return Server.javaObjectArrayList;
    }

    public static ArrayList<String> getList() {
        return Server.listofClients;
    }
}
