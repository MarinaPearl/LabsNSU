package ru.nsu.Demchuk.lab2;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import ru.nsu.Demchuk.lab2.Calculator.FileToString;
import ru.nsu.Demchuk.lab2.Calculator.Calculator;

import static ru.nsu.Demchuk.lab2.Calculator.Constants.FILEAVA_ILABLE;

public class Main {
    private static Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws IOException {
        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileToString file;
            file = new FileToString("/input.txt");
//            if (args.length == FILEAVA_ILABLE ) {
//                //FileToString file = new FileToString("/input.txt");
//                file = new FileToString("./input.txt");
//            } else {
//                file = new FileToString();
//            }
            file.readFileInToStack();
            Calculator calculator = new Calculator(file.getCommmands());
            calculator.doOperations();
        } catch (Exception error) {
            log.info(error.getMessage());

        }
    }
}