package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void testUnacceptableOperation() {
        Calculator calculator = new Calculator();
        try {
            calculator.calculate(6, 1, 'g');
        } catch (RuntimeException e) {
            return;
        }
        Assert.fail("Unexpected character exception expected");
    }
}
