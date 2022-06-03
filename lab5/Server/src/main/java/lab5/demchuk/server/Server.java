package lab5.demchuk.server;

import lab4.demchuk.phone.phone.Connect;
import lab4.demchuk.phone.phone.UserName;
import lab5.demchuk.server.Factory.AnswerToClient;
import lab5.demchuk.server.Factory.FactoryServer;
import lab5.demchuk.server.Factory.FactoryUser;
import lab5.demchuk.server.Factory.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

class ServerSomthing extends Thread {

    private Connect connect;

    public ServerSomthing(Connect connect) throws IOException {
        this.connect = connect;
        Server.story.printStory(this.connect);
        start();
    }
    @Override
    public void run() {
        String word;
        try {
            word = connect.readLine();
             if (word!= null) {
                 FactoryServer serverfactory = new FactoryUser();
                 AnswerToClient answer = serverfactory.create();
                 User user = new User("SUCCESS");
                 word = answer.doActions(user);
             }
            System.out.println(word);
            try {
              connect.writeLine(word);
            } catch (IOException ignored) {}
            try {
                while (true) {
                    word = connect.readLine();
                    if(word.equals("stop")) {
                        this.downService();
                        break;
                    }
                    System.out.println("Echoing: " + word);
                    Server.story.addStoryEl(word);
                    for (ServerSomthing vr : Server.serverList) {
                        vr.send(word);
                    }
                }
            } catch (NullPointerException ignored) {}


        } catch (IOException e) {
            this.downService();
        }
    }

    private void send(String msg) {
        try {
           connect.writeLine(msg);
        } catch (IOException ignored) {}

    }

    private void downService() {
        try {
            if(!connect.getSocket().isClosed()) {
                connect.close();
                connect.getSocket().close();
                for (ServerSomthing vr : Server.serverList) {
                    if(vr.equals(this)) vr.interrupt();
                    Server.serverList.remove(this);
                }
            }
        } catch (IOException ignored) {}
    }
}



class Story {

    private LinkedList<String> story = new LinkedList<>();

    public void addStoryEl(String el) {
        if (story.size() >= 10) {
            story.removeFirst();
            story.add(el);
        } else {
            story.add(el);
        }
    }



    public void printStory(Connect connect) {
        if(story.size() > 0) {
            try {
                connect.writeLine("History messages");
                for (String vr : story) {
                    connect.writeLine(vr + "\n");
                }
                connect.writeLine("/....");
            } catch (IOException ignored) {}

        }

    }
}

public class Server {

    public static final int PORT = 8080;
    public static LinkedList<ServerSomthing> serverList = new LinkedList<>();
    public static Story story;

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(PORT);
        story = new Story();
        System.out.println("Server Started");
        try {
            while (true) {
                Socket socket = server.accept();
                Connect connect = new Connect(socket);
                try {
                    serverList.add(new ServerSomthing(connect));
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}