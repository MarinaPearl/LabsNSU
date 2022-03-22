package ru.nsu.Demchuk.lab2.Calculator;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;

public class SquareNumberInCalculator implements OperationsInCalculator{

    @Override
    public void doOperation(Context calculatorState, Vector<String> arguments) {
        try {
            Double value = calculatorState.getStack().peek();
            calculatorState.popInStack();
            calculatorState.pushInStack(Math.sqrt(value));
        } catch (EmptyStackException error) {
            System.out.println("array out of bounds");
        }
    }
}
