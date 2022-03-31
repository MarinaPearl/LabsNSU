package ru.nsu.Demchuk.lab2.Calculator;

import java.util.Vector;
import java.util.logging.Logger;

import static ru.nsu.Demchuk.lab2.Calculator.Constants.*;

public class Define implements OperationsInCalculator{
    private static Logger log = Logger.getLogger(Define.class.getName());
    @Override
    public void doOperation(Context calculatorState, Vector<String> arguments) throws ExceptionArguments {
        log.info("Start Define");
        if (arguments.size() != MAX_ARGUMENT_IN_DEFINE) {
            throw new ExceptionArguments(ERROR_IN_ARGUMENTS);
        }
        calculatorState.setMap(arguments.get(START_ARGUMENT), Double.parseDouble(arguments.get(END_ARGUMENT)));
    }
}
