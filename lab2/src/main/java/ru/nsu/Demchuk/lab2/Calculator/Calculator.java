package ru.nsu.Demchuk.lab2.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;

public class Calculator {
    private InputStream input;
    private Properties prop;
    private ArrayList<String[]> str;
    public Calculator (ArrayList<String[]> str) throws IOException {
        input = new FileInputStream("D:/labs/lab2/src/com/company/lab2/factory/file.properties");
        this.str = str;
    }
    public void doOperations() throws IOException{
        prop = new Properties();
        prop.load(input);
        Context calculatorState = new Context();
        try {
            for (String[] array : str) {
                FactoryCalculator classOfFactory = (FactoryCalculator) Class.forName(prop.getProperty(array[0])).newInstance();
                Vector<String> arguments = new Vector<String>();
                for (String string : array) {
                    System.out.print(string + " ");
                    arguments.add(string);
                }
                System.out.println();
                OperationsInCalculator operation = classOfFactory.creatOperation();
                operation.doOperation(calculatorState, arguments);
            }
        } catch (ClassNotFoundException |InstantiationException | IllegalAccessException error) {
            //System.out.println(error.getMessage());
        }

    }

}
