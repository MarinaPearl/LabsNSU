package TestCalculator;

import org.junit.Test;
import org.testng.Assert;
import ru.nsu.Demchuk.lab2.Calculator.Context;
import ru.nsu.Demchuk.lab2.Calculator.OperationsInCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryDivision;

public class TestDivision {
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
        } catch (RuntimeException error) {
            error.getMessage();
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
        } catch (RuntimeException error) {
            System.out.println(error.getMessage());
        }
    }
}
