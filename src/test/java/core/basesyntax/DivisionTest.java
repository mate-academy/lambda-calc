package core.basesyntax;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivisionTest {
    private static final double DELTA = 0.01D;
    private Calculator calculator;
    private double result;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void normalDivision() {
        result = calculator.calculate(7.5, 2, '/');
        Assert.assertEquals(3.75, result, DELTA);
    }


}