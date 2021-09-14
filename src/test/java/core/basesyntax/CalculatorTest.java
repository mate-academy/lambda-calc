package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final double DELTA = 0.000001;
    private static Calculator calculator = new Calculator();
    private double expected;
    private double actual;

    @Test
    public void positiveAddition_Ok() {
        expected = 8;
        actual = calculator.calculator(1,7,'+');
        assertEquals(expected, actual);
    }

    @Test
    public void negativeAddition_Ok() {
        expected = -8;
        actual = calculator.calculator(-1,-7,'+');
        assertEquals(expected, actual);
    }

    @Test
    public void positiveNegativeAddition_Ok() {
        expected = 6;
        actual = calculator.calculator(-1,7,'+');
        assertEquals(expected, actual);
        expected = -6;
        actual = calculator.calculator(1,-7,'+');
        assertEquals(expected, actual);
    }

    @Test
    public void differentPlacesZeroAddition_Ok() {
        expected = 1;
        actual = calculator.calculator(1,0,'+');
        assertEquals(expected, actual);
        actual = calculator.calculator(0,1,'+');
        assertEquals(expected, actual);
    }

    @Test
    public void maxMinValuesAddition_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculator(Double.MAX_VALUE, Double.MAX_VALUE,'+');
        assertEquals(expected, actual, DELTA);
        expected = 0;
        actual = calculator.calculator(Double.MIN_VALUE, Double.MIN_VALUE,'+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void positiveSubtraction_Ok() {
        expected = -6;
        actual = calculator.calculator(1,7,'-');
        assertEquals(expected, actual);
    }

    @Test
    public void negativeSubtraction_Ok() {
        expected = 6;
        actual = calculator.calculator(-1,-7,'-');
        assertEquals(expected, actual);
    }

    @Test
    public void positiveNegativeSubtraction_Ok() {
        expected = 8;
        actual = calculator.calculator(1,-7,'-');
        assertEquals(expected, actual);
        expected = -8;
        actual = calculator.calculator(-1,7,'-');
        assertEquals(expected, actual);
    }

    @Test
    public void differentPlacesZeroSubtraction_Ok() {
        expected = 1;
        actual = calculator.calculator(1,0,'-');
        assertEquals(expected, actual);
        expected = -1;
        actual = calculator.calculator(0,1,'-');
        assertEquals(expected, actual);
    }

    @Test
    public void maxMinValuesSubtraction_Ok() {
        expected = 0;
        actual = calculator.calculator(Double.MAX_VALUE, Double.MAX_VALUE,'-');
        assertEquals(expected, actual, DELTA);
        expected = 0;
        actual = calculator.calculator(Double.MIN_VALUE, Double.MIN_VALUE,'-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void positiveMultiplication_Ok() {
        expected = 7;
        actual = calculator.calculator(1,7,'*');
        assertEquals(expected, actual);
    }

    @Test
    public void negativeMultiplication_Ok() {
        expected = 7;
        actual = calculator.calculator(-1,-7,'*');
        assertEquals(expected, actual);
    }

    @Test
    public void positiveNegativeMultiplication_Ok() {
        expected = -7;
        actual = calculator.calculator(-1,7,'*');
        assertEquals(expected, actual);
        expected = -7;
        actual = calculator.calculator(1,-7,'*');
        assertEquals(expected, actual);
    }

    @Test
    public void differentPlacesZeroMultiplication_Ok() {
        expected = 0;
        actual = calculator.calculator(1,0,'*');
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculator(0,7,'*');
        assertEquals(expected, actual);
    }

    @Test
    public void maxMinValuesMultiplication_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculator(Double.MAX_VALUE, Double.MAX_VALUE,'*');
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculator(Double.MIN_VALUE, Double.MIN_VALUE,'*');
        assertEquals(expected, actual);
    }

    @Test
    public void positiveDivision_Ok() {
        expected = 2;
        actual = calculator.calculator(4,2,'/');
        assertEquals(expected, actual);
    }

    @Test
    public void negativeDivision_Ok() {
        expected = 2;
        actual = calculator.calculator(-4,-2,'/');
        assertEquals(expected, actual);
    }

    @Test
    public void positiveNegativeDivision_Ok() {
        expected = -2;
        actual = calculator.calculator(-4,2,'/');
        assertEquals(expected, actual);
        expected = -2;
        actual = calculator.calculator(4,-2,'/');
        assertEquals(expected, actual);
    }

    @Test
    public void firstPlacesZeroDivision_Ok() {
        expected = 0;
        actual = calculator.calculator(0,2,'/');
        assertEquals(expected, actual);
    }

    @Test
    public void secondPlacesZeroDivision_NotOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculator(2,0,'/'));
    }

    @Test
    public void maxMinValueDivision_Ok() {
        expected = 1;
        actual = calculator.calculator(Double.MAX_VALUE, Double.MAX_VALUE,'/');
        assertEquals(expected, actual);
        expected = 1;
        actual = calculator.calculator(Double.MIN_VALUE, Double.MIN_VALUE,'/');
        assertEquals(expected, actual);
    }

    @Test
    public void raisingPositiveToPositiveOrNegative_Ok() {
        expected = 64;
        actual = calculator.calculator(4,3,'^');
        assertEquals(expected, actual);
        expected = 0.0625;
        actual = calculator.calculator(4,-2,'^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void raisingNegativeToPositiveOrNegative_Ok() {
        expected = 16;
        actual = calculator.calculator(-4,2,'^');
        assertEquals(expected, actual);
        expected = 0.0625;
        actual = calculator.calculator(-4,-2,'^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void raisingValueToZero_Ok() {
        expected = 1;
        actual = calculator.calculator(2,0,'^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void raisingZeroToNegativePower_Ok() {
        expected = 0;
        actual = calculator.calculator(0,2,'^');
        assertEquals(expected, actual);
    }

    @Test
    public void illegalOperation_notOk() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculator(1,2,'&'));
    }
}
