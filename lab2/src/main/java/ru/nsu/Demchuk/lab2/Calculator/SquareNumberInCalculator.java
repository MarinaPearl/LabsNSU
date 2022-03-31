package ru.nsu.Demchuk.lab2.Calculator;
import java.util.Vector;
import java.util.logging.Logger;

import static ru.nsu.Demchuk.lab2.Calculator.Constants.*;

public class SquareNumberInCalculator implements OperationsInCalculator{
    private static Logger log = Logger.getLogger(SquareNumberInCalculator.class.getName());
    @Override
    public void doOperation(Context calculatorState, Vector<String> arguments) throws ExceptionStack, ExceptionWrongNumber {
        log.info("Start SQRT");
        if (calculatorState.getStack().size() < SMALL_STACK_FOR_OPERATION) {
            throw new ExceptionStack(ERROR_IN_STACK);
        }
            Double value = calculatorState.getStack().peek();
            calculatorState.popInStack();
            if (value < NEGATIV_NUMBER) {
                throw new ExceptionWrongNumber(ERROR_IN_SQRT);
            }
            calculatorState.pushInStack(Math.sqrt(value));
    }
}
