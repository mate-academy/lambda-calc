package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.exceptions.UnknownOperationException;
import core.basesyntax.exceptions.ZeroDivisionException;
import core.basesyntax.service.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private static final double FIRST_POSITIVE_OPERAND = 5.567;
    private static final double SECOND_POSITIVE_OPERAND = 9.99;
    private static final double FIRST_NEGATIVE_OPERAND = -4.83;
    private static final double SECOND_NEGATIVE_OPERAND = -15;
    private static final double POSITIVE_DECIMAL_POWER = 1.9375;
    private static final double POSITIVE_INTEGER_POWER = 3;
    private static final double NEGATIVE_DECIMAL_POWER = -3.0464;
    private static final double NEGATIVE_INTEGER_POWER = -7;
    private static final double ZERO_POWER = 0;
    private static final double ZERO_OPERAND = 0;
    private static final double ZERO_DOUBLE_OPERAND = 0.0d;
    private static final double DELTA = 0.00001;
    private static Calculator newCalculator;
    private char operator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        newCalculator = new CalculatorImpl();
    }

    @Test
    public void getAddition_twoPositiveOperands_Ok() {
        operator = '+';
        expected = 15.557;
        actual = newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                SECOND_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getAddition_twoNegativeOperands_Ok() {
        operator = '+';
        expected = -19.83;
        actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                SECOND_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getAddition_negativeAndPositiveOperands_Ok() {
        operator = '+';
        expected = 5.16;
        actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                SECOND_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getAddition_twoMaxValueOperands_Ok() {
        operator = '+';
        expected = Double.POSITIVE_INFINITY;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getAddition_twoMinValueOperands_Ok() {
        operator = '+';
        expected = 1.0E-323;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getAddition_minValueAndMaxValueOperands_Ok() {
        operator = '+';
        expected = 1.7976931348623157E+308;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getAddition_minValueAndPositiveOperands_Ok() {
        operator = '+';
        expected = 5.567;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                FIRST_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getAddition_minValueAndNegativeOperands_Ok() {
        operator = '+';
        expected = -4.83;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                FIRST_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getAddition_maxValueAndPositiveOperands_Ok() {
        operator = '+';
        expected = 1.7976931348623157E+308;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                FIRST_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getAddition_maxValueAndNegativeOperands_Ok() {
        operator = '+';
        expected = 1.7976931348623157E+308;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                FIRST_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getSubtraction_twoPositiveOperands_Ok() {
        operator = '-';
        expected = -4.423;
        actual = newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                SECOND_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getSubtraction_twoNegativeOperands_Ok() {
        operator = '-';
        expected = 10.17;
        actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                SECOND_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getSubtraction_negativeAndPositiveOperands_Ok() {
        operator = '-';
        expected = -14.82;
        actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                SECOND_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getSubtraction_positiveAndNegativeOperands_Ok() {
        operator = '-';
        expected = 24.99;
        actual = newCalculator.calculate(SECOND_POSITIVE_OPERAND,
                SECOND_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getSubtraction_twoMaxValueOperands_Ok() {
        operator = '-';
        expected = 0.0;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getSubtraction_twoMinValueOperands_Ok() {
        operator = '-';
        expected = 0.0;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getSubtraction_minValueAndMaxValueOperands_Ok() {
        operator = '-';
        expected = -1.7976931348623157E+308;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getSubtraction_maxValueAndMinValueOperands_Ok() {
        operator = '-';
        expected = 1.7976931348623157E+308;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getSubtraction_minValueAndPositiveOperands_Ok() {
        operator = '-';
        expected = -5.567;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                FIRST_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getSubtraction_minValueAndNegativeOperands_Ok() {
        operator = '-';
        expected = 4.83;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                FIRST_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getSubtraction_maxValueAndPositiveOperands_Ok() {
        operator = '-';
        expected = 1.7976931348623157E+308;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                FIRST_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getSubtraction_maxValueAndNegativeOperands_Ok() {
        operator = '-';
        expected = 1.7976931348623157E+308;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                FIRST_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getSubtraction_positiveValueAndMaxValueOperands_Ok() {
        operator = '-';
        expected = -1.7976931348623157E+308;
        actual = newCalculator.calculate(SECOND_POSITIVE_OPERAND,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getSubtraction_negativeValueAndMaxValueOperands_Ok() {
        operator = '-';
        expected = -1.7976931348623157E+308;
        actual = newCalculator.calculate(SECOND_NEGATIVE_OPERAND,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getSubtraction_positiveValueAndMinValueOperands_Ok() {
        operator = '-';
        expected = 9.99;
        actual = newCalculator.calculate(SECOND_POSITIVE_OPERAND,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getSubtraction_negativeValueAndMinValueOperands_Ok() {
        operator = '-';
        expected = -15.0;
        actual = newCalculator.calculate(SECOND_NEGATIVE_OPERAND,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getSubtraction_zeroValueAndMinValueOperands_Ok() {
        operator = '-';
        expected = -4.9E-324;
        actual = newCalculator.calculate(ZERO_OPERAND,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getSubtraction_zeroValueAndMaxValueOperands_Ok() {
        operator = '-';
        expected = -1.7976931348623157E+308;
        actual = newCalculator.calculate(ZERO_OPERAND,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getSubtraction_minValueAndZeroValueOperands_Ok() {
        operator = '-';
        expected = 4.9E-324;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                ZERO_OPERAND, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getSubtraction_maxValueAndZeroValueOperands_Ok() {
        operator = '-';
        expected = 1.7976931348623157E+308;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                ZERO_OPERAND, operator);
        assertEquals(expected, actual);
    }

    @Test
    public void getMultiplication_twoPositiveOperands_Ok() {
        operator = '*';
        expected = 55.61433;
        actual = newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                SECOND_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getMultiplication_twoNegativeOperands_Ok() {
        operator = '*';
        expected = 72.45;
        actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                SECOND_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getMultiplication_negativeAndPositiveOperands_Ok() {
        operator = '*';
        expected = -48.2517;
        actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                SECOND_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getMultiplication_twoMaxValueOperands_Ok() {
        operator = '*';
        expected = Double.POSITIVE_INFINITY;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getMultiplication_twoMinValueOperands_Ok() {
        operator = '*';
        expected = 0.0;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getMultiplication_minValueAndMaxValueOperands_Ok() {
        operator = '*';
        expected = 8.881784197001251E-16;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getMultiplication_minValueAndPositiveOperands_Ok() {
        operator = '*';
        expected = 3.0E-323;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                FIRST_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getMultiplication_minValueAndNegativeOperands_Ok() {
        operator = '*';
        expected = -2.5E-323;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                FIRST_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getMultiplication_maxValueAndPositiveOperands_Ok() {
        operator = '*';
        expected = Double.POSITIVE_INFINITY;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                FIRST_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getMultiplication_maxValueAndNegativeOperands_Ok() {
        operator = '*';
        expected = Double.NEGATIVE_INFINITY;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                FIRST_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getDivision_twoPositiveOperands_Ok() {
        operator = '/';
        expected = 0.55726;
        actual = newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                SECOND_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getDivision_twoNegativeOperands_Ok() {
        operator = '/';
        expected = 0.322;
        actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                SECOND_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getDivision_negativeAndPositiveOperands_Ok() {
        operator = '/';
        expected = -0.48348;
        actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                SECOND_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getDivision_twoMaxValueOperands_Ok() {
        operator = '/';
        expected = 1.0;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getDivision_twoMinValueOperands_Ok() {
        operator = '/';
        expected = 1.0;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getDivision_minValueAndMaxValueOperands_Ok() {
        operator = '/';
        expected = 0.0;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getDivision_minValueAndPositiveOperands_Ok() {
        operator = '/';
        expected = 0.0;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                FIRST_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getDivision_minValueAndNegativeOperands_Ok() {
        operator = '/';
        expected = 0.0;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                FIRST_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getDivision_maxValueAndPositiveOperands_Ok() {
        operator = '/';
        expected = 3.2291955000221225E307;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                FIRST_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getDivision_maxValueAndNegativeOperands_Ok() {
        operator = '/';
        expected = -3.7219319562366786E307;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                FIRST_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getDivision_zeroValueAndMaxOperands_Ok() {
        operator = '/';
        expected = 0.0;
        actual = newCalculator.calculate(ZERO_OPERAND,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getDivision_zeroValueAndMinOperands_Ok() {
        operator = '/';
        expected = 0.0;
        actual = newCalculator.calculate(ZERO_OPERAND,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getDivision_byZero_NotOK() {
        operator = '/';
        assertThrows(ZeroDivisionException.class, () -> {
            newCalculator.calculate(FIRST_POSITIVE_OPERAND, ZERO_OPERAND, operator);
        });
    }

    @Test
    public void getDivision_doubleZeroByZero_OK() {
        operator = '/';
        expected = Double.NaN;
        actual = newCalculator.calculate(ZERO_DOUBLE_OPERAND,
                ZERO_OPERAND, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_positiveValueAndPositiveDecimalPower_Ok() {
        operator = '^';
        expected = 27.8382;
        actual = newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                POSITIVE_DECIMAL_POWER, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_positiveValueAndPositiveIntegerPower_Ok() {
        operator = '^';
        expected = 172.52962;
        actual = newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                POSITIVE_INTEGER_POWER, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_positiveValueAndNegativeDecimalPower_Ok() {
        operator = '^';
        expected = 0.0009;
        actual = newCalculator.calculate(SECOND_POSITIVE_OPERAND,
                NEGATIVE_DECIMAL_POWER, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_positiveValueAndNegativeIntegerPower_Ok() {
        operator = '^';
        expected = DELTA;
        actual = newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                NEGATIVE_INTEGER_POWER, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_negativeValueAndPositiveIntegerPower_Ok() {
        operator = '^';
        expected = -112.67859;
        actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                POSITIVE_INTEGER_POWER, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_negativeValueAndPositiveDecimalPower_Ok() {
        operator = '^';
        expected = Double.NaN;
        actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                POSITIVE_DECIMAL_POWER, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_negativeValueAndNegativeIntegerPower_Ok() {
        operator = '^';
        expected = -0.00002;
        actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                NEGATIVE_INTEGER_POWER, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_negativeValueAndNegativeDecimalPower_Ok() {
        operator = '^';
        expected = Double.NaN;
        actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                NEGATIVE_DECIMAL_POWER, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_maxValueAndMaxValuePower_Ok() {
        operator = '^';
        expected = Double.POSITIVE_INFINITY;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_minValueAndMinValuePower_Ok() {
        operator = '^';
        expected = 1.0;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_minValueAndMaxValuePower_Ok() {
        operator = '^';
        expected = 0.0;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_maxValueAndMinValuePower_Ok() {
        operator = '^';
        expected = 1.0;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_minValueAndPositiveIntegerPower_Ok() {
        operator = '^';
        expected = 0.0;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                POSITIVE_INTEGER_POWER, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_minValueAndPositiveDecimalPower_Ok() {
        operator = '^';
        expected = 0.0;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                POSITIVE_DECIMAL_POWER, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_minValueAndNegativeIntegerPower_Ok() {
        operator = '^';
        expected = Double.POSITIVE_INFINITY;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                NEGATIVE_INTEGER_POWER, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_minValueAndNegativeDecimalPower_Ok() {
        operator = '^';
        expected = Double.POSITIVE_INFINITY;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                NEGATIVE_DECIMAL_POWER, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_maxValueAndPositiveIntegerPower_Ok() {
        operator = '^';
        expected = Double.POSITIVE_INFINITY;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                POSITIVE_INTEGER_POWER, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_maxValueAndPositiveDecimalPower_Ok() {
        operator = '^';
        expected = Double.POSITIVE_INFINITY;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                POSITIVE_DECIMAL_POWER, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_maxValueAndNegativeIntegerPower_Ok() {
        operator = '^';
        expected = 0.0;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                NEGATIVE_INTEGER_POWER, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_maxValueAndNegativeDecimalPower_Ok() {
        operator = '^';
        expected = 0.0;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                NEGATIVE_DECIMAL_POWER, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_minValueAndZeroPower_Ok() {
        operator = '^';
        expected = 1.0;
        actual = newCalculator.calculate(Double.MIN_VALUE,
                ZERO_POWER, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_maxValueAndZeroPower_Ok() {
        operator = '^';
        expected = 1.0;
        actual = newCalculator.calculate(Double.MAX_VALUE,
                ZERO_POWER, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_positiveValueAndMaxValuePower_Ok() {
        operator = '^';
        expected = Double.POSITIVE_INFINITY;
        actual = newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_positiveValueAndMinValuePower_Ok() {
        operator = '^';
        expected = 1.0;
        actual = newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_negativeValueAndMaxValuePower_Ok() {
        operator = '^';
        expected = Double.POSITIVE_INFINITY;
        actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_negativeValueAndMinValuePower_Ok() {
        operator = '^';
        expected = Double.NaN;
        actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getPowerOf_zeroAndZeroPower_Ok() {
        operator = '^';
        expected = 1.0;
        actual = newCalculator.calculate(ZERO_OPERAND,
                ZERO_POWER, operator);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getModulus_unknownOperator_NotOk() {
        operator = '%';
        assertThrows(UnknownOperationException.class, () -> {
            newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                    SECOND_POSITIVE_OPERAND, operator);
        });
    }
}
