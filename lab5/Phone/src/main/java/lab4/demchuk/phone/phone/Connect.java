package lab4.demchuk.phone.phone;

import java.io.*;
import java.net.Socket;

public class Connect {
    private BufferedWriter writer;
    private BufferedReader reader;
    private BufferedReader readerInSystem;
    private Socket socket;
    private static final String error = "reader is not true";
    public Connect(Socket socket) throws IOException {
        this.socket = socket;
        this.reader = createReader();
        this.writer = createWriter();
        this.readerInSystem = createrReaderSystem();
    }
    public Socket getSocket() {
        return socket;
    }
    private BufferedReader createReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    }
    private BufferedWriter createWriter() throws IOException {
        return new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
    }
    private BufferedReader createrReaderSystem() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
    public void close() throws IOException {
        reader.close();
        writer.close();
        readerInSystem.close();
    }
    public void writeLine (String message) throws IOException {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException error) {
            close();
           //error.printStackTrace();
        }
    }

    public String readLine() throws IOException {
        String str = null;
        try {
            str =  reader.readLine();
        } catch (IOException error) {
            close();
            //error.printStackTrace();
        }
        if (str != null) {
            return str;
        } else {
            throw new RuntimeException(error);
        }
    }
//    public String readLineSystem() {
//        String str = null;
//        try {
//            str =  readerInSystem.readLine();
//        } catch (IOException error) {
//            try {
//                close();
//            }catch (IOException e) {
//
//            }
//            //error.printStackTrace();
//        }
//        if (str != null) {
//            return str;
//        } else {
//            //throw new RuntimeException("rederSystem is not true");
//        }
//        return null;
//    }


}
