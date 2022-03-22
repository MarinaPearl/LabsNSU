package ru.nsu.Demchuk.lab2.Calculator;

import java.util.Vector;

public class Define implements OperationsInCalculator{
    @Override
    public void doOperation(Context calculatorState, Vector<String> arguments) {
        if (arguments.size() != 3) {
            throw new RuntimeException("wrong number of arguments in Define");
        }
        calculatorState.setMap(arguments.get(1), Double.parseDouble(arguments.get(2)));
    }
}
