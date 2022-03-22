package TestCalculator;

import org.junit.Assert;
import org.junit.Test;
import ru.nsu.Demchuk.lab2.Calculator.Context;
import ru.nsu.Demchuk.lab2.Calculator.OperationsInCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryMultiplication;

public class TestMultiplication {
    @Test
    public void testMultiplication() {
        Context context = new Context();
        context.pushInStack(new Double(5.0));
        context.pushInStack(new Double(5.0));
        FactoryCalculator creator = new FactoryMultiplication();
        OperationsInCalculator operations = creator.creatOperation();
        Double value = new Double(25.0);
        operations.doOperation(context, null);
        Assert.assertEquals(value, context.getStack().peek());
        context.pushInStack(new Double(-5.0));
        context.pushInStack(new Double(-5.0));
        operations.doOperation(context, null);
        value = 25.0;
        Assert.assertEquals(value, context.getStack().peek());
        context.pushInStack(new Double(-4.0));
        context.pushInStack(new Double(8.0));
        operations.doOperation(context,null);
        value = -32.0;
        Assert.assertEquals(value, context.getStack().peek());
    }
}
