package ru.nsu.Demchuk.lab2.Calculator;
import java.util.Vector;
import java.util.logging.Logger;

import static ru.nsu.Demchuk.lab2.Calculator.Constants.ERROR_IN_STACK;
import static ru.nsu.Demchuk.lab2.Calculator.Constants.SMALL_STACK_FOR_OPERATION;

public class PrintArgumentInStack implements OperationsInCalculator{
    private static Logger log = Logger.getLogger(PrintArgumentInStack.class.getName());
    @Override
    public void doOperation(Context calculatorState, Vector<String> arguments) throws ExceptionStack {
        log.info("Start Print");
        if (calculatorState.getStack().size() < SMALL_STACK_FOR_OPERATION) {
            throw new ExceptionStack(ERROR_IN_STACK);
        }
            Double value = calculatorState.getStack().peek();
            System.out.println(value);
    }
}
