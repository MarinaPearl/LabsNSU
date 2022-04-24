package ru.nsu.Demchuk.lab2.factory;

import ru.nsu.Demchuk.lab2.Calculator.MultiplicationInCalculator;
import ru.nsu.Demchuk.lab2.Calculator.OperationsInCalculator;

public class FactoryMultiplication implements FactoryCalculator{
    @Override
    public OperationsInCalculator creatOperation() {
        return new MultiplicationInCalculator();
    }
}
