package TestCalculator;

import org.junit.Assert;
import org.junit.Test;
import ru.nsu.Demchuk.lab2.Calculator.Context;
import ru.nsu.Demchuk.lab2.Calculator.OperationsInCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryCalculator;
import ru.nsu.Demchuk.lab2.factory.FactoryComment;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestComment {
    private static Logger log = Logger.getLogger(TestComment.class.getName());
    @Test
    public void testComment() {
        try {
            Context context = new Context();
            context.pushInStack(10.0);
            FactoryCalculator creator = new FactoryComment();
            OperationsInCalculator operation = creator.creatOperation();
            operation.doOperation(context, null);
            Double value = new Double(10.0);
            Assert.assertEquals(value, context.getStack().peek());
        } catch (Exception error) {
                 log.log(Level.SEVERE, "Exception : ", error);
        }

    }
}
