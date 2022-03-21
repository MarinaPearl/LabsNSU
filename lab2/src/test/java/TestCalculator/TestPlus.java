package TestCalculator;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.nsu.Demchuk.lab2.Calculator.Context;
import ru.nsu.Demchuk.lab2.Calculator.OperationsInCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryPlus;

public class TestPlus {
    @Test
    public void testPlus() {
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
    }

}
