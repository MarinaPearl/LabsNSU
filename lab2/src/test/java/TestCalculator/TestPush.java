package TestCalculator;

import org.junit.Assert;
import org.junit.Test;
import ru.nsu.Demchuk.lab2.Calculator.Context;
import ru.nsu.Demchuk.lab2.Calculator.OperationsInCalculator;
import ru.nsu.Demchuk.lab2.Calculator.PushInCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryPush;

import java.util.Vector;

public class TestPush {
    @Test
    public void testPush() {
        Context context = new Context();
        FactoryCalculator creator = new FactoryPush();
        OperationsInCalculator operations = creator.creatOperation();
        context.setMap("a", new Double (5.0));
        context.setMap("b", new Double(6.0));
        context.setMap("c", new Double(7.0));
        Vector<String> arguments = new Vector<String>();
        arguments.add("PUSH");
        arguments.add("a");
        Double value = new Double(5.0);
        operations.doOperation(context, arguments);
        Assert.assertEquals(context.getStack().peek(), value);
        arguments.clear();
        arguments.add("PUSH");
        arguments.add("b");
        operations.doOperation(context, arguments);
        value = 6.0;
        Assert.assertEquals(context.getStack().peek(), value);
        arguments.clear();
        arguments.add("PUSH");
        arguments.add("c");
        operations.doOperation(context, arguments);
        value = 7.0;
        Assert.assertEquals(context.getStack().peek(), value);
    }
}
