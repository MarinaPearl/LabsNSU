package TestCalculator;

import org.junit.Assert;
import org.junit.Test;
import ru.nsu.Demchuk.lab2.Calculator.Context;
import ru.nsu.Demchuk.lab2.Calculator.OperationsInCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryMinus;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestMinus {
    private static Logger log = Logger.getLogger(TestMinus.class.getName());

    @Test
    public void testMinus() {
        try {
            Context context = new Context();
            context.pushInStack(new Double(4.0));
            context.pushInStack(new Double(5.0));
            Double value = new Double(1.0);
            FactoryCalculator creator = new FactoryMinus();
            OperationsInCalculator operation = creator.creatOperation();
            operation.doOperation(context, null);
            Assert.assertEquals(value, context.getStack().peek());
            context.pushInStack(12.0);
            context.pushInStack(12.0);
            value = 0.0;
            operation.doOperation(context, null);
            Assert.assertEquals(value, context.getStack().peek());
            context.pushInStack(9.5);
            context.pushInStack(4.5);
            value = -5.0;
            operation.doOperation(context, null);
            Assert.assertEquals(value, context.getStack().peek());
        }catch (Exception error) {
            log.log(Level.SEVERE, "Exception : ", error);
        }
    }
}
