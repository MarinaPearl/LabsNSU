package ru.nsu.Demchuk.lab2.Calculator;
import java.util.Vector;
import java.util.logging.Logger;

import static ru.nsu.Demchuk.lab2.Calculator.Constants.ERROR_IN_STACK;
import static ru.nsu.Demchuk.lab2.Calculator.Constants.SMALL_STACK;

public class PlusInCalculator implements OperationsInCalculator{
    private static Logger log = Logger.getLogger(PlusInCalculator.class.getName());
    @Override
    public void doOperation(Context calculatorState, Vector<String> arguments) throws ExceptionStack {
        log.info("Satrt Plus");
        if (calculatorState.getStack().size() < SMALL_STACK ) {
            throw new ExceptionStack(ERROR_IN_STACK);
        }
            Double value1 = calculatorState.getStack().peek();
            calculatorState.popInStack();
            Double value2 = calculatorState.getStack().peek();
            calculatorState.popInStack();
            calculatorState.pushInStack(value1 + value2);
    }
}
