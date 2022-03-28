package ru.nsu.Demchuk.lab2.Calculator;

import ru.nsu.Demchuk.lab2.Main;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Define implements OperationsInCalculator{
    private final String errorInfo = "wrong number of arguments in Define";
    private final Integer maxArguments = 3;
    private final Integer startArgument = 1;
    private final Integer endArgument = 1;
    private static Logger log = Logger.getLogger(OperationsInCalculator.class.getName());
    @Override
    public void doOperation(Context calculatorState, Vector<String> arguments) {
        if (arguments.size() != maxArguments) {
            log.log(Level.INFO, "", new RuntimeException(errorInfo));

        }
        calculatorState.setMap(arguments.get(startArgument), Double.parseDouble(arguments.get(endArgument)));
    }
}
