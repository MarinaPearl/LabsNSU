package ru.nsu.Demchuk.lab2.Calculator;

import ru.nsu.Demchuk.lab2.Main;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;
import java.util.logging.Logger;

public class SquareNumberInCalculator implements OperationsInCalculator{
    private String errorInfo = "value less then zero";
    private String errorLog = "array out of bounds";
    private static Logger log = Logger.getLogger(SquareNumberInCalculator.class.getName());
    @Override
    public void doOperation(Context calculatorState, Vector<String> arguments) {
        try {
            Double value = calculatorState.getStack().peek();
            calculatorState.popInStack();
            if (value < 0) {
                throw new RuntimeException(errorInfo);
            }
            calculatorState.pushInStack(Math.sqrt(value));
        } catch (EmptyStackException error) {
            log.info(errorLog);
        }
    }
}
