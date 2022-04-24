package TestCalculator;

import org.junit.Test;
import org.testng.Assert;
import ru.nsu.Demchuk.lab2.Calculator.Context;
import ru.nsu.Demchuk.lab2.Calculator.OperationsInCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryDivision;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestDivision {
    private static Logger log = Logger.getLogger(TestDivision.class.getName());
    @Test
    public void testDevision() {
        try {
            Context context = new Context();
            context.pushInStack(2.0);
            context.pushInStack(8.0);
            FactoryCalculator creator = new FactoryDivision();
            OperationsInCalculator operation = creator.creatOperation();
            operation.doOperation(context, null);
            Double value = new Double(4.0);
            Assert.assertEquals(value, context.getStack().peek());
        } catch (Exception error) {
            log.log(Level.SEVERE, "Exception : ", error.getMessage());
        }
    }
    @Test
    public void testDevisionByZero() {
        try {
            Context context = new Context();
            context.pushInStack(0.0);
            context.pushInStack(4.0);
            FactoryCalculator creator = new FactoryDivision();
            OperationsInCalculator operation = creator.creatOperation();
            operation.doOperation(context, null);
        } catch (Exception error) {
            log.log(Level.SEVERE, "Exception : ", error);
        }
    }
}
