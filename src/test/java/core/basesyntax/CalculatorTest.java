package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void calculatorImplementsInterface_True() {
        assertTrue(calculator instanceof Calculable,
                "Must inherit interface behavior");
    }

    @Test
    void integerOverflow_ThrowsException() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '*'));
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(Integer.MIN_VALUE, 1, '-'));
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(Integer.MAX_VALUE, 1, '+'));
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '^'));
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(Integer.MAX_VALUE, 2, '^'));
    }

    @Test
    void additionTest_Correct() {
        int sum1and0 = calculator.calculate(1, 0, '+');
        assertEquals(1, sum1and0);
        int sum0and1 = calculator.calculate(0, 1, '+');
        assertEquals(1, sum0and1);
        int sum2and2 = calculator.calculate(2, 2, '+');
        assertEquals(4,sum2and2);
        int sum2andNegative2 = calculator.calculate(2, -2, '+');
        assertEquals(0, sum2andNegative2);
        int negative2andNegative2 = calculator.calculate(-2, -2, '+');
        assertEquals(-4, negative2andNegative2);
    }

    @Test
    void subtractionTest_Correct() {
        int sub1and0 = calculator.calculate(1, 0, '-');
        assertEquals(1, sub1and0);
        int sub0and1 = calculator.calculate(0, 1, '-');
        assertEquals(-1, sub0and1);
        int sub2and2 = calculator.calculate(2, 2, '-');
        assertEquals(0,sub2and2);
        int sum2andNegative2 = calculator.calculate(2, -2, '-');
        assertEquals(4, sum2andNegative2);
        int negative2andNegative2 = calculator.calculate(-2, -2, '-');
        assertEquals(0, negative2andNegative2);
    }

    @Test
    void divisionByZeroTest_ThrowsException() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, 0, '/'));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(21, 0, '/'));
    }

    @Test
    void divisionTest_Correct() {
        int div4and2 = calculator.calculate(4, 2, '/');
        assertEquals(2,div4and2);
        int div2and2 = calculator.calculate(2, 2, '/');
        assertEquals(1, div2and2);
        int div21and1 = calculator.calculate(21, 1, '/');
        assertEquals(21, div21and1);
        int sum2andNegative2 = calculator.calculate(2, -2, '/');
        assertEquals(-1, sum2andNegative2);
        int negative2andNegative2 = calculator.calculate(-2, -2, '/');
        assertEquals(1, negative2andNegative2);
    }

    @Test
    void multiplicationTest_Correct() {
        int multi4and1 = calculator.calculate(4, 1, '*');
        assertEquals(4,multi4and1);
        int multi2and2 = calculator.calculate(2, 2, '*');
        assertEquals(4, multi2and2);
        int multi21and0 = calculator.calculate(21, 0, '*');
        assertEquals(0, multi21and0);
        int sum2andNegative2 = calculator.calculate(2, -2, '*');
        assertEquals(-4, sum2andNegative2);
        int negative2andNegative2 = calculator.calculate(-2, -2, '*');
        assertEquals(4, negative2andNegative2);
    }

    @Test
    void raisingToPowerTest_Correct() {
        int power0to21 = calculator.calculate(0, 21, '^');
        assertEquals(0,power0to21);
        int power0to0 = calculator.calculate(0, 0, '^');
        assertEquals(1,power0to0);
        int power21to0 = calculator.calculate(21, 0, '^');
        assertEquals(1,power21to0);
        int power1to21 = calculator.calculate(1, 21, '^');
        assertEquals(1, power1to21);
        int power5to5 = calculator.calculate(5, 5, '^');
        assertEquals(3125, power5to5);
        int sum2toNegative2 = calculator.calculate(2, -2, '^');
        assertEquals(0, sum2toNegative2);
        int negative2toNegative2 = calculator.calculate(-2, -2, '^');
        assertEquals(0, negative2toNegative2);
    }

    @Test
    void invalidOperatorTest_ThrowsException() {
        assertThrows(RuntimeException.class, () -> calculator.calculate(1, 0, 'a'));
        assertThrows(RuntimeException.class, () -> calculator.calculate(0, 1, '\\'));
        assertThrows(RuntimeException.class, () -> calculator.calculate(2, 2, '.'));
        assertThrows(RuntimeException.class, () -> calculator.calculate(2, 2, '\0'));
    }
}
