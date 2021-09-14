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
    public void calculator_positiveAddition_Ok() {
        expected = 8;
        actual = calculator.calculate(1,7,'+');
        assertEquals(expected, actual);
    }

    @Test
    public void calculator_negativeAddition_Ok() {
        expected = -8;
        actual = calculator.calculate(-1,-7,'+');
        assertEquals(expected, actual);
    }

    @Test
    public void calculator_positiveNegativeAddition_Ok() {
        expected = 6;
        actual = calculator.calculate(-1,7,'+');
        assertEquals(expected, actual);
        expected = -6;
        actual = calculator.calculate(1,-7,'+');
        assertEquals(expected, actual);
    }

    @Test
    public void calculator_differentPlacesZeroAddition_Ok() {
        expected = 1;
        actual = calculator.calculate(1,0,'+');
        assertEquals(expected, actual);
        actual = calculator.calculate(0,1,'+');
        assertEquals(expected, actual);
    }

    @Test
    public void calculator_maxMinValuesAddition_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE,'+');
        assertEquals(expected, actual, DELTA);
        expected = 0;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE,'+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculator_positiveSubtraction_Ok() {
        expected = -6;
        actual = calculator.calculate(1,7,'-');
        assertEquals(expected, actual);
    }

    @Test
    public void calculator_negativeSubtraction_Ok() {
        expected = 6;
        actual = calculator.calculate(-1,-7,'-');
        assertEquals(expected, actual);
    }

    @Test
    public void calculator_positiveNegativeSubtraction_Ok() {
        expected = 8;
        actual = calculator.calculate(1,-7,'-');
        assertEquals(expected, actual);
        expected = -8;
        actual = calculator.calculate(-1,7,'-');
        assertEquals(expected, actual);
    }

    @Test
    public void calculator_differentPlacesZeroSubtraction_Ok() {
        expected = 1;
        actual = calculator.calculate(1,0,'-');
        assertEquals(expected, actual);
        expected = -1;
        actual = calculator.calculate(0,1,'-');
        assertEquals(expected, actual);
    }

    @Test
    public void calculator_maxMinValuesSubtraction_Ok() {
        expected = 0;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE,'-');
        assertEquals(expected, actual, DELTA);
        expected = 0;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE,'-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculator_positiveMultiplication_Ok() {
        expected = 7;
        actual = calculator.calculate(1,7,'*');
        assertEquals(expected, actual);
    }

    @Test
    public void calculator_negativeMultiplication_Ok() {
        expected = 7;
        actual = calculator.calculate(-1,-7,'*');
        assertEquals(expected, actual);
    }

    @Test
    public void calculator_positiveNegativeMultiplication_Ok() {
        expected = -7;
        actual = calculator.calculate(-1,7,'*');
        assertEquals(expected, actual);
        expected = -7;
        actual = calculator.calculate(1,-7,'*');
        assertEquals(expected, actual);
    }

    @Test
    public void calculator_differentPlacesZeroMultiplication_Ok() {
        expected = 0;
        actual = calculator.calculate(1,0,'*');
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculate(0,7,'*');
        assertEquals(expected, actual);
    }

    @Test
    public void calculator_maxMinValuesMultiplication_Ok() {
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE,'*');
        assertEquals(expected, actual);
        expected = 0;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE,'*');
        assertEquals(expected, actual);
    }

    @Test
    public void calculator_positiveDivision_Ok() {
        expected = 2;
        actual = calculator.calculate(4,2,'/');
        assertEquals(expected, actual);
    }

    @Test
    public void calculator_negativeDivision_Ok() {
        expected = 2;
        actual = calculator.calculate(-4,-2,'/');
        assertEquals(expected, actual);
    }

    @Test
    public void calculator_positiveNegativeDivision_Ok() {
        expected = -2;
        actual = calculator.calculate(-4,2,'/');
        assertEquals(expected, actual);
        expected = -2;
        actual = calculator.calculate(4,-2,'/');
        assertEquals(expected, actual);
    }

    @Test
    public void calculator_firstPlacesZeroDivision_Ok() {
        expected = 0;
        actual = calculator.calculate(0,2,'/');
        assertEquals(expected, actual);
    }

    @Test
    public void calculator_secondPlacesZeroDivision_NotOk() {
        assertThrows(ArithmeticException.class,
                () -> calculator.calculate(2,0,'/'));
    }

    @Test
    public void calculator_maxMinValueDivision_Ok() {
        expected = 1;
        actual = calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE,'/');
        assertEquals(expected, actual);
        expected = 1;
        actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE,'/');
        assertEquals(expected, actual);
    }

    @Test
    public void calculator_raisingPositiveToPositiveOrNegative_Ok() {
        expected = 64;
        actual = calculator.calculate(4,3,'^');
        assertEquals(expected, actual);
        expected = 0.0625;
        actual = calculator.calculate(4,-2,'^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculator_raisingNegativeToPositiveOrNegative_Ok() {
        expected = 16;
        actual = calculator.calculate(-4,2,'^');
        assertEquals(expected, actual);
        expected = 0.0625;
        actual = calculator.calculate(-4,-2,'^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculator_raisingValueToZero_Ok() {
        expected = 1;
        actual = calculator.calculate(2,0,'^');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void calculator_raisingZeroToPower_Ok() {
        expected = 0;
        actual = calculator.calculate(0,2,'^');
        assertEquals(expected, actual);
    }

    @Test
    public void calculator_illegalOperation_notOk() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(1,2,'&'));
    }
}
