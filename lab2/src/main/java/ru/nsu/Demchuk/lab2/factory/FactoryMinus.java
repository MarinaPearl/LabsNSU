package ru.nsu.Demchuk.lab2.factory;

import ru.nsu.Demchuk.lab2.Calculator.MinusInCalculator;
import ru.nsu.Demchuk.lab2.Calculator.OperationsInCalculator;

public class FactoryMinus implements FactoryCalculator{
    @Override
    public OperationsInCalculator creatOperation() {
        return new MinusInCalculator();
    }
}
