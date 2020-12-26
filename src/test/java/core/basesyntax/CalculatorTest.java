package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    static void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void addTwoPositiveOperands() {
        double actual = calculator.calculate(10, 15, '+');
        assertEquals(25, actual);
    }

    @Test
    public void addTwoNegativeOperands() {
        double actual = calculator.calculate(-10, -15, '+');
        assertEquals(-25, actual);
    }

    @Test
    public void addPositiveAndNegative() {
        double actual = calculator.calculate(10, -15, '+');
        assertEquals(-5, actual);
    }

    @Test
    public void addZeroAndOperand() {
        double actual = calculator.calculate(0, 15, '+');
        assertEquals(15, actual);
    }

    @Test
    public void addOperandAndZero() {
        double actual = calculator.calculate(10, 0, '+');
        assertEquals(10, actual);
    }

    @Test
    public void subtractTwoPositiveOperands() {
        double actual = calculator.calculate(10, 15, '-');
        assertEquals(-5, actual);
    }

    @Test
    public void subtractTwoNegativeOperands() {
        double actual = calculator.calculate(-10, -15, '-');
        assertEquals(5, actual);
    }

    @Test
    public void subtractPositiveAndNegative() {
        double actual = calculator.calculate(10, -15, '-');
        assertEquals(25, actual);
    }

    @Test
    public void subtractZeroAndOperand() {
        double actual = calculator.calculate(0, 15, '-');
        assertEquals(-15, actual);
    }

    @Test
    public void subtractOperandAndZero() {
        double actual = calculator.calculate(10, 0, '-');
        assertEquals(10, actual);
    }

    @Test
    public void multiplyTwoPositiveOperands() {
        double actual = calculator.calculate(10, 15, '*');
        assertEquals(150, actual);
    }

    @Test
    void multiplyTwoNegativeOperands() {
        double actual = calculator.calculate(-10, -15, '*');
        assertEquals(150, actual);
    }

    @Test
    public void multiplyPositiveAndNegative() {
        double actual = calculator.calculate(10, -15, '*');
        assertEquals(-150, actual);
    }

    @Test
    public void multiplyZeroAndOperand() {
        double actual = calculator.calculate(0, 15, '*');
        assertEquals(0, actual);
    }

    @Test
    public void multiplyOperandAndZero() {
        double actual = calculator.calculate(10, 0, '*');
        assertEquals(0, actual);
    }

    @Test
    public void divideTwoPositiveOperands() {
        double actual = calculator.calculate(10, 15, '/');
        assertEquals(10.0 / 15.0, actual);
    }

    @Test
    public void divideTwoNegativeOperands() {
        double actual = calculator.calculate(-100, -50, '/');
        assertEquals(2.0, actual);
    }

    @Test
    public void dividePositiveAndNegative() {
        double actual = calculator.calculate(-100, 25, '/');
        assertEquals(-4, actual);
    }

    @Test
    public void divideZeroAndOperand() {
        double actual = calculator.calculate(0, 15, '/');
        assertEquals(0, actual);
    }

    @Test
    public void divisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(10, 0, '/'));
    }

    @Test
    public void raisePositiveValueToPositivePow() {
        double actual = calculator.calculate(2, 3, '^');
        assertEquals(8, actual);
    }

    @Test
    public void raisePositiveValueToNegativePow() {
        double actual = calculator.calculate(2, -3, '^');
        assertEquals(0.125, actual);
    }

    @Test
    public void raiseNegativeValueToPositivePow() {
        double actual = calculator.calculate(-2, 3, '^');
        assertEquals(-8, actual);
    }

    @Test
    public void raiseNegativeValueToNegativePow() {
        double actual = calculator.calculate(-2, -3, '^');
        assertEquals(-0.125, actual);
    }

    @Test
    public void raisePositiveValueToZeroPow() {
        double actual = calculator.calculate(69, 0, '^');
        assertEquals(1, actual);
    }

    @Test
    public void raiseNegativeValueToZeroPow() {
        double actual = calculator.calculate(-69, 0, '^');
        assertEquals(1, actual);
    }

    @Test
    public void raiseZeroToPow() {
        double actual = calculator.calculate(0, 13, '^');
        assertEquals(0, actual);
    }

    @Test
    public void illegalOperation() {
        assertThrows(RuntimeException.class, () -> calculator.calculate(10, 0, '?'));
    }

    @Test
    public void doubleOverflow() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '*'));
    }
}
