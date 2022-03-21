package ru.nsu.Demchuk.lab2.factory;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class FileToString {
    private Reader input;
    private String[] arrayStrings;
    private ArrayList<String[]> commandsInCalculator;
    public FileToString(String path) throws FileNotFoundException {
        input = new InputStreamReader(new FileInputStream(path));
    }
    public void readFileInToStack() throws IOException {
        BufferedReader buffer = new BufferedReader(input);
        StringBuilder varRead = new StringBuilder();
        commandsInCalculator = new ArrayList<String[]>();
        Pattern pattern = Pattern.compile("\\s");
        String str = null;
        while ((str = buffer.readLine()) != null) {
            String[] str1 = pattern.split(str);
            commandsInCalculator.add(str1);
        }
    }
    public ArrayList<String[]> getCommmands() {
        return commandsInCalculator;
    }
    public void  CLoseFile() throws IOException {
        input.close();
    }
}
