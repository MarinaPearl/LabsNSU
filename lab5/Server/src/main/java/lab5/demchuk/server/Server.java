package lab5.demchuk.server;

import lab4.demchuk.phone.phone.Connect;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;


class Story {

    public LinkedList<String> story = new LinkedList<>();
    private static final int NULL_SIZE = 0;
    public void addStoryEl(String el) {
        if (story.size() >= 10) {
            story.removeFirst();
            story.add(el);
        } else {
            story.add(el);
        }
    }


    public void printStory(Connect connect) {
        if (story.size() > NULL_SIZE) {
            try {
                //connect.writeLine("History messages");
                for (String vr : story) {
                    connect.writeLine(vr + "\n");
                }
                //connect.writeLine("/....");
            } catch (IOException ignored) {
            }

        }

    }
}

public class Server {

    public static final int PORT = 8080;
    public static LinkedList<ServerSomthing> serverList = new LinkedList<>();
    public static ArrayList<String> listofClients = new ArrayList<String>();
    public static Story story;

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(PORT);
        story = new Story();
       // System.out.println("Server Started");
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