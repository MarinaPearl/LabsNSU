package ru.nsu.Demchuk.lab2.factory;

import ru.nsu.Demchuk.lab2.Calculator.Define;
import ru.nsu.Demchuk.lab2.Calculator.OperationsInCalculator;

public class FactoryDefine implements FactoryCalculator{

    @Override
    public OperationsInCalculator creatOperation() {
        return new Define();
    }
}
