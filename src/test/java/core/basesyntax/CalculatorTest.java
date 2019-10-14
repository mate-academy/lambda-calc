package core.basesyntax;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CalculatorTest {
    private Calculator calculator = new Calculator();
    private double expectedResult;
    private double actualResult;
    private final double DELTA = 0.0001;

    @Test
    public void testCalculateMethodExpressionShouldReturnResultOfAddition() {
        expectedResult = 9.1;
        actualResult = calculator.calculate(5.2, 3.9, '+');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = -2;
        actualResult = calculator.calculate(-1, -1, '+');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = -14.21;
        actualResult = calculator.calculate(0, -14.21, '+');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 1.2696;
        actualResult = calculator.calculate(-0.0214, 1.291, '+');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 0;
        actualResult = calculator.calculate(-0.25, 0.25, '+');
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @Test
    public void testCalculateMethodExpressionShouldReturnResultOfSubtraction() {
        expectedResult = 3.1;
        actualResult = calculator.calculate(5.2, 2.1, '-');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = -2.2;
        actualResult = calculator.calculate(-1.1, 1.1, '-');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 0;
        actualResult = calculator.calculate(0, 0, '-');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 0;
        actualResult = calculator.calculate(0.15, 0.15, '-');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 0;
        actualResult = calculator.calculate(0.15, 0.15, '-');
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @Test
    public void testCalculateMethodExpressionShouldReturnResultOfMultiplication() {
        expectedResult = 45.32931;
        actualResult = calculator.calculate(6.201, 7.31, '*');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 7.26;
        actualResult = calculator.calculate(-2.2, -3.3, '*');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 0;
        actualResult = calculator.calculate(0, 0, '*');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 0;
        actualResult = calculator.calculate(0, -0.15, '*');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = -0.8925;
        actualResult = calculator.calculate(-0.15, 5.95, '*');
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @Test
    public void testCalculateMethodExpressionShouldReturnResultOfDivision() {
        expectedResult = 4.3;
        actualResult = calculator.calculate(4.3, 1, '/');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 2;
        actualResult = calculator.calculate(-2.2, -1.1, '/');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 0;
        actualResult = calculator.calculate(0, -5.3, '/');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = -3;
        actualResult = calculator.calculate(12.3, -4.1, '/');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = -0.01;
        actualResult = calculator.calculate(-0.1, 10, '/');
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @Test(expected = java.lang.AssertionError.class)
    public void testCalculateMethodExpressionShouldReturnAssertionErrorWhenDivisionByZero() {
        calculator.calculate(4.3, 0, '/');

        calculator.calculate(0, 0.0, '/');
    }

    @Test
    public void testCalculateMethodExpressionShouldReturnResultOfRaisePower() {
        expectedResult = 8;
        actualResult = calculator.calculate(2, 3, '^');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 1;
        actualResult = calculator.calculate(-2.2, 0, '^');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 1;
        actualResult = calculator.calculate(0, 0, '^');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 59049;
        actualResult = calculator.calculate(-3, 10, '^');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = Double.POSITIVE_INFINITY;
        actualResult = calculator.calculate(0, -1, '^');
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateMethodExpressionShouldReturnIllegalArgumentException() {
        calculator.calculate(3, 4, '@');

        calculator.calculate(3, 4, '=');

        calculator.calculate(3, 4, 'z');
    }
}
