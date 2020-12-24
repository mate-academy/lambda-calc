package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void addTwoPositiveOperands() {
        double actual = calculator.calculate(10, 15, '+');
        assertEquals(25, actual);
    }

    @Test
    void addTwoNegativeOperands() {
        double actual = calculator.calculate(-10, -15, '+');
        assertEquals(-25, actual);
    }

    @Test
    void addPositiveAndNegative() {
        double actual = calculator.calculate(10, -15, '+');
        assertEquals(-5, actual);
    }

    @Test
    void addZeroAndOperand() {
        double actual = calculator.calculate(0, 15, '+');
        assertEquals(15, actual);
    }

    @Test
    void addOperandAndZero() {
        double actual = calculator.calculate(10, 0, '+');
        assertEquals(10, actual);
    }

    @Test
    void subtractTwoPositiveOperands() {
        double actual = calculator.calculate(10, 15, '-');
        assertEquals(-5, actual);
    }

    @Test
    void subtractTwoNegativeOperands() {
        double actual = calculator.calculate(-10, -15, '-');
        assertEquals(5, actual);
    }

    @Test
    void subtractPositiveAndNegative() {
        double actual = calculator.calculate(10, -15, '-');
        assertEquals(25, actual);
    }

    @Test
    void subtractZeroAndOperand() {
        double actual = calculator.calculate(0, 15, '-');
        assertEquals(-15, actual);
    }

    @Test
    void subtractOperandAndZero() {
        double actual = calculator.calculate(10, 0, '-');
        assertEquals(10, actual);
    }

    @Test
    void multiplyTwoPositiveOperands() {
        double actual = calculator.calculate(10, 15, '*');
        assertEquals(150, actual);
    }

    @Test
    void multiplyTwoNegativeOperands() {
        double actual = calculator.calculate(-10, -15, '*');
        assertEquals(150, actual);
    }

    @Test
    void multiplyPositiveAndNegative() {
        double actual = calculator.calculate(10, -15, '*');
        assertEquals(-150, actual);
    }

    @Test
    void multiplyZeroAndOperand() {
        double actual = calculator.calculate(0, 15, '*');
        assertEquals(0, actual);
    }

    @Test
    void multiplyOperandAndZero() {
        double actual = calculator.calculate(10, 0, '*');
        assertEquals(0, actual);
    }

    @Test
    void divideTwoPositiveOperands() {
        double actual = calculator.calculate(10, 15, '/');
        assertEquals(10.0 / 15.0, actual);
    }

    @Test
    void divideTwoNegativeOperands() {
        double actual = calculator.calculate(-100, -50, '/');
        assertEquals(2.0, actual);
    }

    @Test
    void dividePositiveAndNegative() {
        double actual = calculator.calculate(-100, 25, '/');
        assertEquals(-4, actual);
    }

    @Test
    void divideZeroAndOperand() {
        double actual = calculator.calculate(0, 15, '/');
        assertEquals(0, actual);
    }

    @Test
    void divisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(10, 0, '/'));
    }

    @Test
    void raisePositiveValueToPositivePow() {
        double actual = calculator.calculate(2, 3, '^');
        assertEquals(8, actual);
    }

    @Test
    void raisePositiveValueToNegativePow() {
        double actual = calculator.calculate(2, -3, '^');
        assertEquals(0.125, actual);
    }

    @Test
    void raiseNegativeValueToPositivePow() {
        double actual = calculator.calculate(-2, 3, '^');
        assertEquals(-8, actual);
    }

    @Test
    void raiseNegativeValueToNegativePow() {
        double actual = calculator.calculate(-2, -3, '^');
        assertEquals(-0.125, actual);
    }

    @Test
    void raisePositiveValueToZeroPow() {
        double actual = calculator.calculate(69, 0, '^');
        assertEquals(1, actual);
    }

    @Test
    void raiseNegativeValueToZeroPow() {
        double actual = calculator.calculate(-69, 0, '^');
        assertEquals(1, actual);
    }

    @Test
    void raiseZeroToPow() {
        double actual = calculator.calculate(0, 13, '^');
        assertEquals(0, actual);
    }

    @Test
    void illegalOperation() {
        assertThrows(RuntimeException.class, () -> calculator.calculate(10, 0, '?'));
    }

    @Test
    void doubleOverflow() {
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '*'));
    }
}
