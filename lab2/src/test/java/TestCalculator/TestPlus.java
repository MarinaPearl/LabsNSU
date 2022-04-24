package TestCalculator;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.nsu.Demchuk.lab2.Calculator.Context;
import ru.nsu.Demchuk.lab2.Calculator.OperationsInCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryPlus;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestPlus {
    private static Logger log = Logger.getLogger(TestPlus.class.getName());
    @Test
    public void testPlus() {
        try {
            Context context = new Context();
            context.pushInStack(5.5);
            context.pushInStack(10.1);
            FactoryCalculator creator = new FactoryPlus();
            OperationsInCalculator opearion = creator.creatOperation();
            opearion.doOperation(context, null);
            Double value = new Double(15.6);
            Assert.assertEquals(value, context.getStack().peek());
            context.pushInStack(8.6);
            opearion.doOperation(context, null);
            value = 24.2;
            Assert.assertEquals(value, context.getStack().peek());
        } catch (Exception error) {
            log.log(Level.SEVERE, "Exception : ", error);
        }
    }

}
