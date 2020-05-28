import core.basesyntax.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        double result = calculator.calculate(2, 2, '+');
        if (result != 4) {
            Assert.fail();
        }
    }

    @Test
    public void testSumNegative() {
        double result = calculator.calculate(2, -2, '+');
        if (result != 0) {
            Assert.fail();
        }
    }

    @Test
    public void testMinus() {
        double result = calculator.calculate(2, 2, '-');
        if (result != 0) {
            Assert.fail();
        }
    }

    @Test
    public void testMinusNegative() {
        double result = calculator.calculate(2, -2, '-');
        if (result != 4) {
            Assert.fail();
        }
    }

    @Test
    public void multiple() {
        double result = calculator.calculate(2, 2, '*');
        if (result != 4) {
            Assert.fail();
        }
    }

    @Test
    public void multipleByZero() {
        double result = calculator.calculate(0, 2, '*');
        if (result != 0) {
            Assert.fail();
        }
    }

    @Test
    public void testToExponent() {
        double result = calculator.calculate(2, 3, '^');
        if (result != 8) {
            Assert.fail();
        }
    }

    @Test
    public void testToNegativeExponent() {
        double result = calculator.calculate(2, -3, '^');
        if (result != 0.125) {
            Assert.fail();
        }
    }

    @Test
    public void testNegativeToExponent() {
        double result = calculator.calculate(-2, 3, '^');
        if (result != -8) {
            Assert.fail();
        }
    }

    @Test
    public void tesToZeroExponent() {
        double result = calculator.calculate(-2, 0, '^');
        if (result != 1) {
            Assert.fail();
        }
    }

    @Test
    public void testDivide() {
        double result = calculator.calculate(2, 2, '/');
        if (result != 1) {
            Assert.fail();
        }
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideWillThrowExceptionWhenDivideOnZero() {
        double result = calculator.calculate(2, 0, '/');
    }

}