package ru.nsu.Demchuk.lab2.Calculator;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import ru.nsu.Demchuk.lab2.Main;
import ru.nsu.Demchuk.lab2.factory.FactoryCalculator;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import static ru.nsu.Demchuk.lab2.Calculator.Constants.LOADING_CLASS;

public class Calculator  {
    private InputStream input;
    private Properties prop;
    private ArrayList<String[]> str;
    private String pathToProperty = "/file.properties";
    private static Logger log = Logger.getLogger(Calculator.class.getName());
    public Calculator (ArrayList<String[]> str) throws IOException {
        input = Class.class.getResourceAsStream(pathToProperty);
        this.str = str;
    }
    public void doOperations() throws IOException{
        prop = new Properties();
        prop.load(input);
        input.close();
        Context calculatorState = new Context();
        try {
            for (String[] array : str) {
                FactoryCalculator classOfFactory = (FactoryCalculator) Class.forName(
                        prop.getProperty(array[LOADING_CLASS])).newInstance();
                Vector<String> arguments = new Vector<String>();
                for (String string : array) {
                    arguments.add(string);
                }
                OperationsInCalculator operation = classOfFactory.creatOperation();
                operation.doOperation(calculatorState, arguments);
            }
        } catch (Exception error) {
            log.log(Level.SEVERE, "Exception : ", error);
        }

    }
}
