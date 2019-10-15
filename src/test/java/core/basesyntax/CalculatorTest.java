package core.basesyntax;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private static final double DELTA = 0.0001;
    private static Calculator calculator;
    private double expectedResult;
    private double actualResult;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        expectedResult = 0;
        actualResult = 0;
    }

    @Test
    public void methodCalculateShouldReturnCorrectResultOfAdditionalWhenInputDataIsPositive() {
        expectedResult = 4.0;
        actualResult = calculator.calculate(2, 2, '+');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 52489.0;
        actualResult = calculator.calculate(15648, 36841, '+');
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectResultOfAdditionalWhenInputDataIsNegative() {
        expectedResult = -450.0;
        actualResult = calculator.calculate(-100, -350, '+');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = -174628.0;
        actualResult = calculator.calculate(-109341, -65287, '+');
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectResultOfSubtractionWhenInputDataIsPositive() {
        expectedResult = 2.0;
        actualResult = calculator.calculate(4, 2, '-');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 22143.0;
        actualResult = calculator.calculate(54632, 32489, '-');
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectResultOfSubtractionWhenInputDataIsNegative() {
        expectedResult = 2.0;
        actualResult = calculator.calculate(-2, -4, '-');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = -1495.0;
        actualResult = calculator.calculate(-5147, -3652, '-');
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectResultOfMultiplicationWhenInputDataIsPositive() {
        expectedResult = 4.0;
        actualResult = calculator.calculate(2, 2, '*');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 1926672.0;
        actualResult = calculator.calculate(5412, 356, '*');
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectResultOfMultiplicationWhenInputDataIsNegative() {
        expectedResult = 108.0;
        actualResult = calculator.calculate(-54, -2, '*');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 10491852.0;
        actualResult = calculator.calculate(-4234, -2478, '*');
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectResultOfDivisionWhenInputDataIsPositive() {
        expectedResult = 10.0;
        actualResult = calculator.calculate(100, 10, '/');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 796.0;
        actualResult = calculator.calculate(54128, 68, '/');
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectResultOfDivisionWhenInputDataIsNegative() {
        expectedResult = 10.0;
        actualResult = calculator.calculate(-100, -10, '/');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 796.0;
        actualResult = calculator.calculate(-54128, -68, '/');
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectResultOfDivisionWhenDividendEqualsZero() {
        expectedResult = 0.0;
        actualResult = calculator.calculate(0, -123, '/');
        assertEquals(expectedResult, actualResult, DELTA);

        actualResult = calculator.calculate(0, 234, '/');
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void methodCalculateShouldThrowArithmeticExceptionWhenDividerEqualsZero() {
        calculator.calculate(123, 0, '/');
    }

    @Test
    public void methodCalculateShouldReturnCorrectExponentiationWhenInputDataIsPositive() {
        expectedResult = 16.0;
        actualResult = calculator.calculate(2, 4, '^');
        assertEquals(expectedResult, actualResult, DELTA);

        expectedResult = 512.0;
        actualResult = calculator.calculate(2, 9, '^');
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectExponentiationWhenPowerEqualsZero() {
        expectedResult = 1;
        actualResult = calculator.calculate(2, 0, '^');
        assertEquals(expectedResult, actualResult, DELTA);

        actualResult = calculator.calculate(234, 0, '^');
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectExponentiationWhenInputDataEqualsZero() {
        expectedResult = 1;
        actualResult = calculator.calculate(0, 0, '^');
        assertEquals(expectedResult, actualResult, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void methodCalculateShouldThrowIllegalArgumentExceptionWhenOperationUnsupported() {
        calculator.calculate(1, 1, '!');
    }
}
