package ru.nsu.Demchuk.lab2.Calculator;

import java.util.Vector;

public class DivisionInCalculator implements OperationsInCalculator{
    @Override
    public void doOperation(Context calculatorState, Vector<String> arguments) {
        Double value1 = calculatorState.getStack().peek();
        calculatorState.popInStack();
        Double value2 = calculatorState.getStack().peek();
        System.out.println(value2);
        if (value2 == 0.0) {
            System.out.println("ddd");
            throw new RuntimeException("division by zero");
        }
        calculatorState.popInStack();
        calculatorState.pushInStack(value1 / value2);
    }
}
