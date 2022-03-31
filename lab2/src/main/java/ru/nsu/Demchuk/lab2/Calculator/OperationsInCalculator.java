package ru.nsu.Demchuk.lab2.Calculator;

import java.util.Vector;

public interface OperationsInCalculator {
    void doOperation(Context calculatorState, Vector<String> arguments) throws ExceptionArguments, ExceptionStack, ExceptionDivision, ExceptionWrongNumber;
}
