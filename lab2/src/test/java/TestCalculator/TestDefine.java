package TestCalculator;

import org.junit.Assert;
import org.junit.Test;
import ru.nsu.Demchuk.lab2.Calculator.Context;
import ru.nsu.Demchuk.lab2.Calculator.OperationsInCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryDefine;

import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestDefine {
    private static Logger log = Logger.getLogger(TestDefine.class.getName());
    @Test
    public void testDefine() {
        try {
            Context context = new Context();
            HashMap<String, Double> testMap = new HashMap<String, Double>();
            testMap.put("a", 4.0);
            testMap.put("b", 5.0);
            testMap.put("c", 6.0);
            FactoryCalculator creator = new FactoryDefine();
            Vector<String> arguments = new Vector<String>();
            arguments.add("DEFINE");
            arguments.add("a");
            arguments.add("4.0");
            OperationsInCalculator operation = creator.creatOperation();
            operation.doOperation(context, arguments);
            arguments.clear();
            arguments.add("DEFINE");
            arguments.add("b");
            arguments.add("5.0");
            operation.doOperation(context, arguments);
            arguments.clear();
            arguments.add("DEFINE");
            arguments.add("c");
            arguments.add("6.0");
            operation.doOperation(context, arguments);
            Assert.assertEquals(testMap, context.getMap());
        } catch (Exception error) {
            log.log(Level.SEVERE, "Exception : ", error.getMessage());
        }
    }
    @Test
    public void testDefineException() {
        try {
            Vector<String> arguments = new Vector<String>();
            Context context = new Context();
            FactoryCalculator creator = new FactoryDefine();
            OperationsInCalculator opearion = creator.creatOperation();
            arguments.add("DEFINE");
            arguments.add("4.0");
            opearion.doOperation(context, arguments);
        } catch (Exception error) {
            log.log(Level.SEVERE, "Exception : ", error);
        }
    }
}
