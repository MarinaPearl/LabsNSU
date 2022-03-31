package ru.nsu.Demchuk.lab2.Calculator;

import java.util.Vector;
import java.util.logging.Logger;

import static ru.nsu.Demchuk.lab2.Calculator.Constants.ERROR_IN_ARGUMENTS;
import static ru.nsu.Demchuk.lab2.Calculator.Constants.MAX_ARGUMENT;

public class PushInCalculator implements OperationsInCalculator{
    private static Logger log = Logger.getLogger(PushInCalculator.class.getName());
    @Override
    public void doOperation(Context calculatorState, Vector<String> arguments) throws ExceptionArguments {
        log.info("Start Push");
        if (arguments.size() != MAX_ARGUMENT) {
            throw new ExceptionArguments(ERROR_IN_ARGUMENTS);
        }
        calculatorState.pushInSatckNewValue(arguments.get(1));

    }
}
