package ru.nsu.Demchuk.lab2.Calculator;

import java.util.Vector;

public class PopInCalculator implements OperationsInCalculator{
    @Override
    public void doOperation(Context calculatorState, Vector<String> arguments) {
        calculatorState.popInStack();
    }
}
