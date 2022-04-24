package TestCalculator;

import org.junit.Assert;
import org.junit.Test;
import ru.nsu.Demchuk.lab2.Calculator.Context;
import ru.nsu.Demchuk.lab2.Calculator.OperationsInCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryPrint;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestPrint {
    private static Logger log = Logger.getLogger(TestPrint.class.getName());
    @Test
    public void testPrint() {
        try {
            Context context = new Context();
            context.pushInStack(new Double(5.0));
            FactoryCalculator creator = new FactoryPrint();
            OperationsInCalculator operations = creator.creatOperation();
            operations.doOperation(context, null);
            Double value = new Double(5.0);
            Assert.assertEquals(value, context.getStack().peek());
            context.pushInStack(new Double(10.0));
            context.pushInStack(new Double(15.0));
            context.popInStack();
            operations.doOperation(context, null);
            value = 10.0;
            Assert.assertEquals(value, context.getStack().peek());
        } catch (Exception error) {
            log.log(Level.SEVERE, "Exception : ", error);
        }

    }
}
