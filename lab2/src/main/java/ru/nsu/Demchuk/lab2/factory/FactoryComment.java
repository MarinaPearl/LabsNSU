package ru.nsu.Demchuk.lab2.factory;

import ru.nsu.Demchuk.lab2.Calculator.Comment;
import ru.nsu.Demchuk.lab2.Calculator.OperationsInCalculator;

public class FactoryComment implements FactoryCalculator{
    @Override
    public OperationsInCalculator creatOperation() {
        return new Comment();
    }
}
