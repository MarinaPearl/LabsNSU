package ru.nsu.Demchuk.lab2.factory;

import ru.nsu.Demchuk.lab2.Calculator.DivisionInCalculator;
import ru.nsu.Demchuk.lab2.Calculator.OperationsInCalculator;

public class FactoryDivision implements FactoryCalculator{

    @Override
    public OperationsInCalculator creatOperation() {
        return new DivisionInCalculator();
    }
}
