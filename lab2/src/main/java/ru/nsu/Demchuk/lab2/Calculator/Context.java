package ru.nsu.Demchuk.lab2.Calculator;
import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Context {
    private static Logger log = Logger.getLogger(Context.class.getName());
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
        } catch (Exception error) {
            log.log(Level.SEVERE, "Exception : ", error);
        }
    }
    public void setMap(String str, Double value) {
        initializationArguments.put(str, value);
    }
}
