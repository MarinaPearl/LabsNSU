package ru.nsu.Demchuk.lab2.Calculator;


import java.util.EmptyStackException;
import java.util.Vector;

public class PlusInCalculator implements OperationsInCalculator{
    @Override
    public void doOperation(Context calculatorState, Vector<String> arguments) {
        try {
            Double value1 = calculatorState.getStack().peek();
            calculatorState.popInStack();
            Double value2 = calculatorState.getStack().peek();
            calculatorState.popInStack();
            calculatorState.pushInStack(value1 + value2);
        } catch (EmptyStackException error) {
            System.out.println("array out of bounds");
        }
    }
}
