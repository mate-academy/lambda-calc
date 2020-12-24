package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final double DELTA = 1e-15;
    private static Calculator calculator;

    @BeforeAll
    public static void creatingInstance() {
        calculator = new Calculator();
    }

    @Test
    public void integerMaxValueResults_Correct() {
        double maxIntegerAddition =
                calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '+');
        assertEquals(4.294967294E9, maxIntegerAddition);
        double maxIntegerSubtraction =
                calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '-');
        assertEquals(0, maxIntegerSubtraction);
        double maxIntegerMultiplication =
                calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '*');
        assertEquals(4.6116860141324206E18, maxIntegerMultiplication);
        double maxIntegerDivision =
                calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '/');
        assertEquals(1, maxIntegerDivision);
        double maxIntegerPower =
                calculator.calculate(Integer.MAX_VALUE, Integer.MAX_VALUE, '^');
        assertEquals(Double.POSITIVE_INFINITY, maxIntegerPower);
    }

    @Test
    public void integerMinValueResults_Correct() {
        double maxIntegerAddition =
                calculator.calculate(Integer.MIN_VALUE, Integer.MIN_VALUE, '+');
        assertEquals(-4.294967296E9, maxIntegerAddition);
        double maxIntegerSubtraction =
                calculator.calculate(Integer.MIN_VALUE, Integer.MIN_VALUE, '-');
        assertEquals(0, maxIntegerSubtraction);
        double maxIntegerMultiplication =
                calculator.calculate(Integer.MIN_VALUE, Integer.MIN_VALUE, '*');
        assertEquals(4.6116860184273879E18, maxIntegerMultiplication);
        double maxIntegerDivision =
                calculator.calculate(Integer.MIN_VALUE, Integer.MIN_VALUE, '/');
        assertEquals(1, maxIntegerDivision);
        double maxIntegerPower =
                calculator.calculate(Integer.MIN_VALUE, Integer.MIN_VALUE, '^');
        assertEquals(0, maxIntegerPower);
    }

    @Test
    public void integerMaxAndMinValueResults_Correct() {
        double maxIntegerAddition =
                calculator.calculate(Integer.MAX_VALUE, Integer.MIN_VALUE, '+');
        assertEquals(-1, maxIntegerAddition);
        double maxIntegerSubtraction =
                calculator.calculate(Integer.MAX_VALUE, Integer.MIN_VALUE, '-');
        assertEquals(4.294967295E9, maxIntegerSubtraction);
        double maxIntegerMultiplication =
                calculator.calculate(Integer.MAX_VALUE, Integer.MIN_VALUE, '*');
        assertEquals(-4.6116860162799043E18, maxIntegerMultiplication);
        double maxIntegerDivision =
                calculator.calculate(Integer.MAX_VALUE, Integer.MIN_VALUE, '/');
        assertEquals(-0.9999999995343387, maxIntegerDivision);
        double maxIntegerPower =
                calculator.calculate(Integer.MAX_VALUE, Integer.MIN_VALUE, '^');
        assertEquals(0, maxIntegerPower);
    }

    @Test
    public void calculatorImplementsInterface_True() {
        assertTrue(calculator instanceof Calculable,
                "Must inherit interface behavior");
    }

    @Test
    public void additionTest_Correct() {
        double sum1and0 = calculator.calculate(1, 0, '+');
        assertEquals(1, sum1and0);
        double sum0and1 = calculator.calculate(0, 1, '+');
        assertEquals(1, sum0and1);
        double sum2and2 = calculator.calculate(2, 2, '+');
        assertEquals(4, sum2and2);
        double sum2andNegative2 = calculator.calculate(2, -2, '+');
        assertEquals(0, sum2andNegative2);
        double negative2andNegative2 = calculator.calculate(-2, -2, '+');
        assertEquals(-4, negative2andNegative2);
    }

    @Test
    public void subtractionTest_Correct() {
        double sub1and0 = calculator.calculate(1, 0, '-');
        assertEquals(1, sub1and0);
        double sub0and1 = calculator.calculate(0, 1, '-');
        assertEquals(-1, sub0and1);
        double sub2and2 = calculator.calculate(2, 2, '-');
        assertEquals(0, sub2and2);
        double sum2andNegative2 = calculator.calculate(2, -2, '-');
        assertEquals(4, sum2andNegative2);
        double negative2andNegative2 = calculator.calculate(-2, -2, '-');
        assertEquals(0, negative2andNegative2);
    }

    @Test
    public void divisionByZeroTest_ThrowsException() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, 0, '/'));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(21, 0, '/'));
        assertThrows(ArithmeticException.class, () -> calculator.calculate(-21, 0, '/'));
    }

    @Test
    public void divisionTest_Correct() {
        double div4and2 = calculator.calculate(4, 2, '/');
        assertEquals(2, div4and2);
        double div2and2 = calculator.calculate(2, 2, '/');
        assertEquals(1, div2and2);
        double div0and1 = calculator.calculate(0, 1, '/');
        assertEquals(0, div0and1);
        double sum2andNegative2 = calculator.calculate(2, -2, '/');
        assertEquals(-1, sum2andNegative2);
        double negative2andNegative2 = calculator.calculate(-2, -2, '/');
        assertEquals(1, negative2andNegative2);
    }

    @Test
    public void divisionFloatPointResultTest_Correct() {
        double negative2andNegative2 = calculator.calculate(-2, -2, '/');
        assertEquals(1, negative2andNegative2);
        double div13and3 = calculator.calculate(13, 3, '/');
        assertEquals(4.333333333333333, div13and3, DELTA);
    }

    @Test
    public void multiplicationTest_Correct() {
        double multi4and1 = calculator.calculate(4, 1, '*');
        assertEquals(4, multi4and1);
        double multi2and2 = calculator.calculate(2, 2, '*');
        assertEquals(4, multi2and2);
        double multi21and0 = calculator.calculate(21, 0, '*');
        assertEquals(0, multi21and0);
        double sum2andNegative2 = calculator.calculate(2, -2, '*');
        assertEquals(-4, sum2andNegative2);
        double negative2andNegative2 = calculator.calculate(-2, -2, '*');
        assertEquals(4, negative2andNegative2);
    }

    @Test
    public void raisingToPowerTest_Correct() {
        double power0to21 = calculator.calculate(0, 21, '^');
        assertEquals(0, power0to21);
        double power0to0 = calculator.calculate(0, 0, '^');
        assertEquals(1, power0to0);
        double power21to0 = calculator.calculate(21, 0, '^');
        assertEquals(1, power21to0);
        double power1to21 = calculator.calculate(1, 21, '^');
        assertEquals(1, power1to21);
        double power5to5 = calculator.calculate(5, 5, '^');
        assertEquals(3125, power5to5);
        double sum2toNegative2 = calculator.calculate(2, -2, '^');
        assertEquals(0.25d, sum2toNegative2);
        double negative2toNegative2 = calculator.calculate(-2, -2, '^');
        assertEquals(0.25d, negative2toNegative2);
    }

    @Test
    public void invalidOperatorTest_ThrowsException() {
        assertThrows(RuntimeException.class, () -> calculator.calculate(1, 0, 'a'));
        assertThrows(RuntimeException.class, () -> calculator.calculate(0, 1, '\\'));
        assertThrows(RuntimeException.class, () -> calculator.calculate(2, 2, '.'));
        assertThrows(RuntimeException.class, () -> calculator.calculate(2, 2, Character.MIN_VALUE));
    }
}
