package core.basesyntax;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private static Calculator calculator;
    private static final double DELTA = 0.0001;

    @BeforeClass
    public static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void methodCalculateShouldReturnCorrectResultOfAdditionalWhenInputDataIsPositive() {
        assertEquals(4.0, calculator.calculate(2, 2, '+'), DELTA);
        assertEquals(52489.0, calculator.calculate(15648, 36841, '+'), DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectResultOfAdditionalWhenInputDataIsNegative() {
        assertEquals(-450.0, calculator.calculate(-100, -350, '+'), DELTA);
        assertEquals(-174628.0, calculator.calculate(-109341, -65287, '+'), DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectResultOfSubtractionWhenInputDataIsPositive() {
        assertEquals(2.0, calculator.calculate(4, 2, '-'), DELTA);
        assertEquals(22143.0, calculator.calculate(54632, 32489, '-'), DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectResultOfSubtractionWhenInputDataIsNegative() {
        assertEquals(2.0, calculator.calculate(-2, -4, '-'), DELTA);
        assertEquals(-1495.0, calculator.calculate(-5147, -3652, '-'), DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectResultOfMultiplicationWhenInputDataIsPositive() {
        assertEquals(4.0, calculator.calculate(2, 2, '*'), DELTA);
        assertEquals(1926672.0, calculator.calculate(5412, 356, '*'), DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectResultOfMultiplicationWhenInputDataIsNegative() {
        assertEquals(108.0, calculator.calculate(-54, -2, '*'), DELTA);
        assertEquals(10491852.0, calculator.calculate(-4234, -2478, '*'), DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectResultOfDivisionWhenInputDataIsPositive() {
        assertEquals(10.0, calculator.calculate(100, 10, '/'), DELTA);
        assertEquals(796.0, calculator.calculate(54128, 68, '/'), DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectResultOfDivisionWhenInputDataIsNegative() {
        assertEquals(10.0, calculator.calculate(-100, -10, '/'), DELTA);
        assertEquals(796.0, calculator.calculate(-54128, -68, '/'), DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectResultOfDivisionWhenDividendEqualsZero() {
        assertEquals(0.0, calculator.calculate(0, -123, '/'), DELTA);
        assertEquals(0.0, calculator.calculate(0, 234, '/'), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void methodCalculateShouldThrowArithmeticExceptionWhenDividerEqualsZero() {
        calculator.calculate(123, 0, '/');
    }

    @Test
    public void methodCalculateShouldReturnCorrectExponentiationWhenInputDataIsPositive() {
        assertEquals(16.0, calculator.calculate(2, 4, '^'), DELTA);
        assertEquals(512.0, calculator.calculate(2, 9, '^'), DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectExponentiationWhenPowerEqualsZero() {
        assertEquals(1, calculator.calculate(2, 0, '^'), DELTA);
        assertEquals(1, calculator.calculate(234, 0, '^'), DELTA);
    }

    @Test
    public void methodCalculateShouldReturnCorrectExponentiationWhenInputDataEqualsZero() {
        assertEquals(1, calculator.calculate(0, 0, '^'), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void methodCalculateShouldThrowIllegalArgumentExceptionWhenOperationUnsupported() {
        calculator.calculate(1, 1, '!');
    }
}
