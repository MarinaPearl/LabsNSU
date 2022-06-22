package lab5.demchuk.client.clientjavafx.model;

import com.google.gson.Gson;
import lab4.demchuk.phone.phone.Connect;
import lab5.demchuk.client.clientjavafx.controller.ControllerRegistration;
import lab5.demchuk.client.clientjavafx.model.Factory.*;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ClientSomthing {


    private static Connect connect;
    private static String nickName; // имя клиента
    private Date time;
    private String dtime;
    private SimpleDateFormat dt1;
    private InputStream input;
    private Properties prop;
    private static String PATH_TO_PROPERTY = "file.properties";


    public ClientSomthing(Connect connect) throws IOException {
        this.input = Client.class.getClassLoader().getResourceAsStream(PATH_TO_PROPERTY);
        prop = new Properties();
        prop.load(input);
        input.close();
        this.connect = connect;
        this.pressNickname();
        new ReadMsg().start();
        //new WriteMsg().start();


    }


    private void pressNickname() throws IOException {
        // System.out.println("NAME" + " " + Login.class.getName());
        nickName = ControllerRegistration.getName();
        Login login = new Login();
        login.setName(nickName);
        //login.setCommand(CHAT_CLIENT_NAME);
        String gson = ObjectWrapper.getGson(login);
        connect.writeLine(gson);
        System.out.println("Name " + login.getNameUser());

    }

    public static void downService() {
        try {
            if (!connect.getSocket().isClosed()) {
                connect.getSocket().close();
                connect.close();
            }
        } catch (IOException ignored) {
        }
    }
    public static void logout() {
        Logout logout = new Logout();
        logout.setName(nickName);
        String str = ObjectWrapper.getGson(logout);
        try {
            connect.writeLine(str);
        } catch (IOException error) {}
    }
    public static void sendMessage(String str) {
        //userWord = ControllerClient.getMessage();
        Message message = new Message();
        message.setMessage(str);
        String gson = ObjectWrapper.getGson(message);
        try {
            connect.writeLine(gson);
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    private class ReadMsg extends Thread {
        @Override
        public void run() {

            String str;
            try {
                while (true) {
                    str = connect.readLine();
                    System.out.println("str" + str);
                    if (str.equals("stop")) {
                        ClientSomthing.this.downService();
                        break;
                    }
                    Gson gson = new Gson();
                    if (str == null)
                        System.out.println("Message is NULL");
                    if (str != null) {
                        TypeCommand command = (TypeCommand) Class.forName(
                                prop.getProperty(gson.fromJson(str, RederClass.class).getCommand())).newInstance();
                        command = gson.fromJson(str, command.getClass());
                        command.outInWindow();
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                ClientSomthing.this.downService();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    public static void sendList() {
        ListOfClients list = new ListOfClients();
        String gson = ObjectWrapper.getGson(list);
        try {
            connect.writeLine(gson);
        }catch (IOException error) {

        }
    }

//    public class WriteMsg extends Thread {
//
//        @Override
//        public void run() {
//                String userWord;
//                try {
//                    time = new Date();
//                    dt1 = new SimpleDateFormat("HH:mm:ss");
//                    dtime = dt1.format(time); // время
//                    userWord = ControllerClient.getMessage();
//                    Message message = new Message();
//                    message.setMessage(userWord);
//                    String gson = ObjectWrapper.getGson(message);
//                   // userWord = connect.readLineSystem();
//                    if (userWord.equals("stop")) {
//                        connect.writeLine("stop" + "\n");
//                        ClientSomthing.this.downService();
//                    } else {
//                        connect.writeLine(gson);
//                        //connect.writeLine("(" + dtime + ") " + nickName + ": " + userWord + "\n");
//                    }
//                } catch (IOException e) {
//                    ClientSomthing.this.downService();
//
//                }
//
//        }
//    }
}
