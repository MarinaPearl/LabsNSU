package TestCalculator;

import com.sun.javaws.IconUtil;
import org.junit.Assert;
import org.junit.Test;
import ru.nsu.Demchuk.lab2.Calculator.Context;
import ru.nsu.Demchuk.lab2.Calculator.OperationsInCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryPop;

import java.util.EmptyStackException;

public class TestPop {
    @Test
    public void testPop() {
        try {
            Context context = new Context();
            FactoryCalculator creator = new FactoryPop();
            OperationsInCalculator operations = creator.creatOperation();
            context.pushInStack(new Double(5.0));
            context.pushInStack(new Double(10.0));
            operations.doOperation(context, null);
            Double value = new Double(5.0);
            Assert.assertEquals(value, context.getStack().peek());
            context.pushInStack(new Double(15.0));
            context.pushInStack(new Double(25.0));
            operations.doOperation(context, null);
            value = 15.0;
            Assert.assertEquals(value, context.getStack().peek());
        } catch (EmptyStackException error) {
            System.out.println("array out of bounds");
        }
    }
    @Test
    public void testPopException() {
            Context context = new Context();
            context.pushInStack(new Double(5.0));
            FactoryCalculator creator = new FactoryPop();
            OperationsInCalculator operation = creator.creatOperation();
            operation.doOperation(context, null);
            operation.doOperation(context, null);
    }
}
