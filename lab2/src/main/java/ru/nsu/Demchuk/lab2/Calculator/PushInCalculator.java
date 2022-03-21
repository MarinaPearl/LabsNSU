package ru.nsu.Demchuk.lab2.Calculator;

import java.util.Vector;

public class PushInCalculator implements OperationsInCalculator{
    @Override
    public void doOperation(Context calculatorState, Vector<String> arguments) {
        if (arguments.size() != 2) {
            throw new RuntimeException("wrong number of arguments in Push");
        }
        calculatorState.pushInSatckNewValue(arguments.get(1));

    }
}
