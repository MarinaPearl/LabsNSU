package ru.nsu.Demchuk.lab2.Calculator;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

public class Context {
    private HashMap<String, Double> initializationArguments;
    private Stack<Double> stackNumbers;
    public Context() {
        initializationArguments = new HashMap<String, Double>();
        stackNumbers = new Stack<Double>();
    }
    public HashMap<String, Double> getMap () {
        return initializationArguments;
    }
    public Stack<Double> getStack () {
        return stackNumbers;
    }
    public void pushInSatckNewValue(String value) {
        Double value1 = initializationArguments.get(value);
        stackNumbers.push(new Double(value1));
    }
    public void pushInStack(Double value) {
        stackNumbers.push(new Double(value));
    }
    public void popInStack() {
        try {
            stackNumbers.pop();
        } catch (EmptyStackException error) {
            System.out.println("array out of bounds");
        }
    }
    public void setMap(String str, Double value) {
        initializationArguments.put(str, value);
    }
}
