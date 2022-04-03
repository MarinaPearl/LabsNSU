package ru.nsu.Demchuk.lab2.Calculator;

import ru.nsu.Demchuk.lab2.Main;
import ru.nsu.Demchuk.lab2.factory.*;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class FileToString {
    private BufferedReader input;
    private ArrayList<String[]> commandsInCalculator;
    private final String separator = "\\s";
    public FileToString(String path) throws FileNotFoundException {
       input  = new BufferedReader(new InputStreamReader(Class.class.getResourceAsStream(path)));
    }
    public FileToString() {
        input = new BufferedReader(new InputStreamReader(System.in));
    }
    public void readFileInToStack() throws IOException {
        commandsInCalculator = new ArrayList<String[]>();
        Pattern pattern = Pattern.compile(separator);
        String str = null;
        while ((str = input.readLine()) != null) {
            String[] str1 = pattern.split(str);
            commandsInCalculator.add(str1);
        }
       input.close();
    }
    public ArrayList<String[]> getCommmands() {
        return commandsInCalculator;
    }
}