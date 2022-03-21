package ru.nsu.Demchuk.lab2.factory;

import java.util.Vector;

public class PrintArgumentInStack implements OperationsInCalculator{
    @Override
    public void doOperation(Context calculatorState, Vector<String> arguments) {

        Double value = calculatorState.getStack().peek();
        System.out.println(value);
    }
}
