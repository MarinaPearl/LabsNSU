package ru.nsu.Demchuk.lab2;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import ru.nsu.Demchuk.lab2.Calculator.FileToString;
import ru.nsu.Demchuk.lab2.Calculator.Calculator;

public class Main {
    private static Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws IOException {
        try {
            FileToString file;
            log.info("Start main");
            if (args.length == 1) {
                //FileToString file = new FileToString("/input.txt");
                file = new FileToString(args[0]);
            } else {
                file = new FileToString();
            }
            file.readFileInToStack();
            Calculator calculator = new Calculator(file.getCommmands());
            calculator.doOperations();
        } catch (RuntimeException error) {
            log.info(error.getMessage());

        }
    }
}