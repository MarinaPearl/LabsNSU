package ru.nsu.Demchuk.lab2.factory;

import java.util.Vector;

public interface OperationsInCalculator {
    void doOperation(Context calculatorState, Vector<String> arguments);
}
