package lab5.demchuk.client.clientjavafx.model;

import Demchuck.lab5.ru.FactoryPerformance;
import Demchuck.lab5.ru.JavaObject;
import com.google.gson.Gson;
import lab4.demchuk.phone.phone.Connect;
import lab5.demchuk.client.clientjavafx.controller.ControllerClient;
import lab5.demchuk.client.clientjavafx.controller.ControllerRegistration;
import lab5.demchuk.client.clientjavafx.model.Factory.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static Demchuck.lab5.ru.Constants.LOGOUT_JAVA;
import static lab5.demchuk.client.clientjavafx.model.Factory.Constannts.CHAT_CLIENT_NAME;
import static lab5.demchuk.client.clientjavafx.model.Factory.Constannts.LOGOUT;

public class ClientSomthing {


    private static Connect connect;
    private static String nickName; // имя клиента
    private ControllerClient controllerClient;
    private Date time;
    private String dtime;
    private SimpleDateFormat dt1;
    private InputStream input;
    private Properties prop;
    private static String PATH_TO_PROPERTY = "file.properties";
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private boolean serializable = true;
    private boolean active = true;
    private boolean serialization;
    public ClientSomthing(Connect connect, ControllerClient controllerClient, boolean serialization) throws IOException {
        this.serialization = serialization;
        objectInputStream = new ObjectInputStream(connect.getSocket().getInputStream());
        objectOutputStream = new ObjectOutputStream(connect.getSocket().getOutputStream());
        this.controllerClient = controllerClient;
        controllerClient.setClientSomthing(this);
        this.input = Client.class.getClassLoader().getResourceAsStream(PATH_TO_PROPERTY);
        prop = new Properties();
        prop.load(input);
        input.close();
        this.connect = connect;
        if (serialization) {
            connect.writeLine("Json");
            this.pressNickNameGson();
        } else {
            connect.writeLine("Object");
            this.pressNickname();
        }
        new ReadMsg().start();
        //new WriteMsg().start();
    }
    public boolean getSerialization() {
        return this.serialization;
    }
    public String getNickname() {
        return nickName;
    }

    //   public static void setActive(boolean value) {
//          active = value;
//   }
    private void pressNickname() throws IOException {
        // System.out.println("NAME" + " " + Login.class.getName());
        nickName = ControllerRegistration.getName();
        Demchuck.lab5.ru.Login login = new Demchuck.lab5.ru.Login();
        login.setTime();
        login.setUserName(nickName);
        //login.setTime();
        //login.setCommand(CHAT_CLIENT_NAME);
        //String gson = ObjectWrapper.getGson(login);
        //connect.writeLine(gson);
        objectOutputStream.writeObject(login);
        //System.out.println("Name " + login.getNameUser());

    }
    private void pressNickNameGson() {
        nickName = ControllerRegistration.getName();
        Login login = new Login();
        login.setTime();
        login.setName(nickName);
        String gson = ObjectWrapper.getGson(login);
        try {
            connect.writeLine(gson);
        } catch (IOException ignore) {

        }
    }
    public void downService() {
        try {
            if (!connect.getSocket().isClosed()) {
                connect.getSocket().close();
                connect.close();

            }
        } catch (IOException ignored) {
        }
    }

    public void logout() {
        Logout logout = new Logout();
        logout.setName(nickName);
        logout.setTime();
        String str = ObjectWrapper.getGson(logout);
        try {
            connect.writeLine(str);
        } catch (IOException error) {
        }
    }

    public void logoutObject() {
        Demchuck.lab5.ru.Logout logout = new Demchuck.lab5.ru.Logout();
        logout.setTime();
        logout.setUserName(nickName);
        try {
            objectOutputStream.writeObject(logout);
        } catch (IOException error) {

        }
    }

    public void sendMessage(String str) {
        //userWord = ControllerClient.getMessage();
        Message message = new Message();
        message.setMessage(str);
        //System.out.println("User Name1 " + nickName + " " + str);
        message.setNickUser(nickName);
        message.setTime();
        String gson = ObjectWrapper.getGson(message);
        try {
            System.out.println("before send");
            connect.writeLine(gson);
            System.out.println("after send");
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    public void sendObject(String str) {
        Demchuck.lab5.ru.Message message = new Demchuck.lab5.ru.Message();
        message.setMessage(str);
        message.setTime();
        message.setUserName(nickName);
        try {
            objectOutputStream.writeObject(message);
        } catch (IOException error) {

        }
    }

    private class ReadMsg extends Thread {
        @Override
        public void run() {
            try {
                while (active) {
                    if (serialization == true) {
                        doGson();
                    } else {
                        doJavaObject();
                    }
                }
//                    str = connect.readLine();
//                    System.out.println("str" + str);
//                    if (str.equals("stop")) {
//                        ClientSomthing.this.downService();
//                        break;
//                    }
//                    Gson gson = new Gson();
//                    if (str == null)
//                        System.out.println("Message is NULL");
//                    if (str != null) {
//                        if (gson.fromJson(str, RederClass.class).getCommand().equals(LOGOUT)) {
//                            Logout logout = gson.fromJson(str, Logout.class);
//                            if (logout.getName().equals(nickName))
//                            active = false;
//                        }
//                        TypeCommand command = (TypeCommand) Class.forName(
//                                prop.getProperty(gson.fromJson(str, RederClass.class).getCommand())).newInstance();
//                        command = gson.fromJson(str, command.getClass());
//                        command.outInWindow(controllerClient);
//                    }
//                }
            } catch (IOException | ClassNotFoundException e) {
                ClientSomthing.this.downService();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendList() {
        ListOfClients list = new ListOfClients();
        String gson = ObjectWrapper.getGson(list);
        try {
            connect.writeLine(gson);
        } catch (IOException error) {

        }
    }

    private void doJavaObject() throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
        JavaObject javaObject = (JavaObject) objectInputStream.readObject();
        System.out.println("hello in client");
        if (javaObject.getCommand().equals(LOGOUT_JAVA)) {
            if (javaObject.getUserName().equals(nickName)) {
                this.active = false;
            }
        }
        FactoryPerformance factoryPerformance = (FactoryPerformance) Class.forName(
                prop.getProperty(javaObject.getCommand())).newInstance();
        factoryPerformance.runOnWindow(controllerClient, javaObject);
    }

    private void doGson() throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
        String str;
        str = connect.readLine();
        System.out.println("str" + str);
        Gson gson = new Gson();
        if (str == null)
            System.out.println("Message is NULL");
        if (str != null) {
            if (gson.fromJson(str, RederClass.class).getCommand().equals(LOGOUT)) {
                Logout logout = gson.fromJson(str, Logout.class);
                if (logout.getName().equals(nickName))
                    active = false;
            }
            TypeCommand command = (TypeCommand) Class.forName(
                    prop.getProperty(gson.fromJson(str, RederClass.class).getCommand())).newInstance();
            command = gson.fromJson(str, command.getClass());
            command.outInWindow(controllerClient);
        }
    }
}

