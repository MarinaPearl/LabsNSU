package ru.nsu.Demchuk.lab2.Calculator;

import ru.nsu.Demchuk.lab2.Main;

import java.util.EmptyStackException;
import java.util.Vector;
import java.util.logging.Logger;

public class DivisionInCalculator implements OperationsInCalculator {
    private static Logger log = Logger.getLogger(Main.class.getName());
    @Override
    public void doOperation(Context calculatorState, Vector<String> arguments) {
        try {
            Double value1 = calculatorState.getStack().peek();
            calculatorState.popInStack();
            Double value2 = calculatorState.getStack().peek();
            System.out.println(value2);
            if (value2 == 0.0) {
                log.warning("check division");
                throw new RuntimeException("division by zero");
            }
            calculatorState.popInStack();
            calculatorState.pushInStack(value1 / value2);
        } catch (EmptyStackException error) {
            log.info("index error");
        }

    }
}
