package ru.nsu.Demchuk.lab2.Calculator;
import java.util.Vector;
import java.util.logging.Logger;

import static ru.nsu.Demchuk.lab2.Calculator.Constants.*;

public class DivisionInCalculator implements OperationsInCalculator {
    private static Logger log = Logger.getLogger(DivisionInCalculator.class.getName());
    @Override
    public void doOperation(Context calculatorState, Vector<String> arguments) throws ExceptionStack,
            ExceptionDivision {
            log.info("Start DivisionInCalculator");
            if (calculatorState.getStack().size() < SMALL_STACK ) {
                throw new ExceptionStack(ERROR_IN_STACK);
            }
            Double value1 = calculatorState.getStack().peek();
            calculatorState.popInStack();
            Double value2 = calculatorState.getStack().peek();
            System.out.println(value2);
            if (value2 == CHECK_ZERO) {
               throw new ExceptionDivision(ERROR_IN_DIVISION);
            }
            calculatorState.popInStack();
            calculatorState.pushInStack(value1 / value2);

    }
}
