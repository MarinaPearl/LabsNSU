package ru.nsu.Demchuk.lab2.factory;

import ru.nsu.Demchuk.lab2.Calculator.OperationsInCalculator;
import ru.nsu.Demchuk.lab2.Calculator.SquareNumberInCalculator;

public class FactorySquareNumber implements FactoryCalculator {
    @Override
    public OperationsInCalculator creatOperation() {
        return new SquareNumberInCalculator();
    }
}
