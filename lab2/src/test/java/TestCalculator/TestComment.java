package TestCalculator;

import org.junit.Assert;
import org.junit.Test;
import ru.nsu.Demchuk.lab2.Calculator.Context;
import ru.nsu.Demchuk.lab2.Calculator.OperationsInCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryComment;

public class TestComment {
    @Test
    public void testComment() {
        Context context = new Context();
        context.pushInStack(10.0);
        FactoryCalculator creator = new FactoryComment();
        OperationsInCalculator operation = creator.creatOperation();
        operation.doOperation(context, null);
        Double value = new Double(10.0);
        Assert.assertEquals(value, context.getStack().peek());

    }
}
