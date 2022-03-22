package ru.nsu.Demchuk.lab2.Calculator;

import java.util.EmptyStackException;
import java.util.Vector;

public class PrintArgumentInStack implements OperationsInCalculator{
    @Override
    public void doOperation(Context calculatorState, Vector<String> arguments) {
        try {
            Double value = calculatorState.getStack().peek();
            System.out.println(value);
        } catch (EmptyStackException error) {
            System.out.println("array out of bounds");
        }
    }
}
