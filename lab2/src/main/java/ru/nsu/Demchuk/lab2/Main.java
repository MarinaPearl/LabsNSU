package ru.nsu.Demchuk.lab2;

import java.io.IOException;
import ru.nsu.Demchuk.lab2.Calculator.FileToString;
import ru.nsu.Demchuk.lab2.Calculator.Calculator;
public class Main {

    public static void main(String[] args) throws IOException {
        try {
            //FileToString file = new FileToString();
            FileToString file = new FileToString("/input.txt");
            file.readFileInToStack();
            Calculator calculator = new Calculator(file.getCommmands());
            calculator.doOperations();
        } catch (RuntimeException error) {
            System.out.println(error.getMessage());

        }

    }
}