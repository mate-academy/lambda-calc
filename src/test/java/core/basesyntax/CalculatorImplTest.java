package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.exceptions.NotAnumberException;
import core.basesyntax.exceptions.UnknownOperationException;
import core.basesyntax.exceptions.ZeroDivisionException;
import core.basesyntax.service.Calculator;
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

    private Calculator newCalculator = new CalculatorImpl();

    @Test
    public void getAddition_twoPositiveOperands_Ok() {
        char operator = '+';
        double expected = 15.557;
        double actual = newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                SECOND_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getAddition_twoNegativeOperands_Ok() {
        char operator = '+';
        double expected = -19.83;
        double actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                SECOND_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getAddition_negativeAndPositiveOperands_Ok() {
        char operator = '+';
        double expected = 5.16;
        double actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                SECOND_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getAddition_twoMaxValueOperands_Ok() {
        char operator = '+';
        double expected = Double.POSITIVE_INFINITY;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getAddition_twoMinValueOperands_Ok() {
        char operator = '+';
        double expected = 1.0E-323;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getAddition_minValueAndMaxValueOperands_Ok() {
        char operator = '+';
        double expected = 1.7976931348623157E+308;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getAddition_minValueAndPositiveOperands_Ok() {
        char operator = '+';
        double expected = 5.567;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                FIRST_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getAddition_minValueAndNegativeOperands_Ok() {
        char operator = '+';
        double expected = -4.83;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                FIRST_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getAddition_maxValueAndPositiveOperands_Ok() {
        char operator = '+';
        double expected = 1.7976931348623157E+308;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                FIRST_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getAddition_maxValueAndNegativeOperands_Ok() {
        char operator = '+';
        double expected = 1.7976931348623157E+308;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                FIRST_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_twoPositiveOperands_Ok() {
        char operator = '-';
        double expected = -4.423;
        double actual = newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                SECOND_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_twoNegativeOperands_Ok() {
        char operator = '-';
        double expected = 10.17;
        double actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                SECOND_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_negativeAndPositiveOperands_Ok() {
        char operator = '-';
        double expected = -14.82;
        double actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                SECOND_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_positiveAndNegativeOperands_Ok() {
        char operator = '-';
        double expected = 24.99;
        double actual = newCalculator.calculate(SECOND_POSITIVE_OPERAND,
                SECOND_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_twoMaxValueOperands_Ok() {
        char operator = '-';
        double expected = 0.0;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_twoMinValueOperands_Ok() {
        char operator = '-';
        double expected = 0.0;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_minValueAndMaxValueOperands_Ok() {
        char operator = '-';
        double expected = -1.7976931348623157E+308;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_maxValueAndMinValueOperands_Ok() {
        char operator = '-';
        double expected = 1.7976931348623157E+308;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_minValueAndPositiveOperands_Ok() {
        char operator = '-';
        double expected = -5.567;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                FIRST_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_minValueAndNegativeOperands_Ok() {
        char operator = '-';
        double expected = 4.83;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                FIRST_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_maxValueAndPositiveOperands_Ok() {
        char operator = '-';
        double expected = 1.7976931348623157E+308;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                FIRST_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_maxValueAndNegativeOperands_Ok() {
        char operator = '-';
        double expected = 1.7976931348623157E+308;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                FIRST_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_positiveValueAndMaxValueOperands_Ok() {
        char operator = '-';
        double expected = -1.7976931348623157E+308;
        double actual = newCalculator.calculate(SECOND_POSITIVE_OPERAND,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_negativeValueAndMaxValueOperands_Ok() {
        char operator = '-';
        double expected = -1.7976931348623157E+308;
        double actual = newCalculator.calculate(SECOND_NEGATIVE_OPERAND,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_positiveValueAndMinValueOperands_Ok() {
        char operator = '-';
        double expected = 9.99;
        double actual = newCalculator.calculate(SECOND_POSITIVE_OPERAND,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_negativeValueAndMinValueOperands_Ok() {
        char operator = '-';
        double expected = -15.0;
        double actual = newCalculator.calculate(SECOND_NEGATIVE_OPERAND,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_zeroValueAndMinValueOperands_Ok() {
        char operator = '-';
        double expected = -4.9E-324;
        double actual = newCalculator.calculate(ZERO_OPERAND,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_zeroValueAndMaxValueOperands_Ok() {
        char operator = '-';
        double expected = -1.7976931348623157E+308;
        double actual = newCalculator.calculate(ZERO_OPERAND,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_minValueAndZeroValueOperands_Ok() {
        char operator = '-';
        double expected = 4.9E-324;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                ZERO_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getSubtraction_maxValueAndZeroValueOperands_Ok() {
        char operator = '-';
        double expected = 1.7976931348623157E+308;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                ZERO_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getMultiplication_twoPositiveOperands_Ok() {
        char operator = '*';
        double expected = 55.61433;
        double actual = newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                SECOND_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getMultiplication_twoNegativeOperands_Ok() {
        char operator = '*';
        double expected = 72.45;
        double actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                SECOND_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getMultiplication_negativeAndPositiveOperands_Ok() {
        char operator = '*';
        double expected = -48.2517;
        double actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                SECOND_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getMultiplication_twoMaxValueOperands_Ok() {
        char operator = '*';
        double expected = Double.POSITIVE_INFINITY;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getMultiplication_twoMinValueOperands_Ok() {
        char operator = '*';
        double expected = 0.0;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getMultiplication_minValueAndMaxValueOperands_Ok() {
        char operator = '*';
        double expected = 8.881784197001251E-16;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getMultiplication_minValueAndPositiveOperands_Ok() {
        char operator = '*';
        double expected = 3.0E-323;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                FIRST_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getMultiplication_minValueAndNegativeOperands_Ok() {
        char operator = '*';
        double expected = -2.5E-323;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                FIRST_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getMultiplication_maxValueAndPositiveOperands_Ok() {
        char operator = '*';
        double expected = Double.POSITIVE_INFINITY;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                FIRST_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getMultiplication_maxValueAndNegativeOperands_Ok() {
        char operator = '*';
        double expected = Double.NEGATIVE_INFINITY;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                FIRST_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getDivision_twoPositiveOperands_Ok() {
        char operator = '/';
        double expected = 0.55726;
        double actual = newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                SECOND_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getDivision_twoNegativeOperands_Ok() {
        char operator = '/';
        double expected = 0.322;
        double actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                SECOND_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getDivision_negativeAndPositiveOperands_Ok() {
        char operator = '/';
        double expected = -0.48348;
        double actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                SECOND_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getDivision_twoMaxValueOperands_Ok() {
        char operator = '/';
        double expected = 1.0;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getDivision_twoMinValueOperands_Ok() {
        char operator = '/';
        double expected = 1.0;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getDivision_minValueAndMaxValueOperands_Ok() {
        char operator = '/';
        double expected = 0.0;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getDivision_minValueAndPositiveOperands_Ok() {
        char operator = '/';
        double expected = 0.0;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                FIRST_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getDivision_minValueAndNegativeOperands_Ok() {
        char operator = '/';
        double expected = 0.0;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                FIRST_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getDivision_maxValueAndPositiveOperands_Ok() {
        char operator = '/';
        double expected = 3.2291955000221225E307;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                FIRST_POSITIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getDivision_maxValueAndNegativeOperands_Ok() {
        char operator = '/';
        double expected = -3.7219319562366786E307;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                FIRST_NEGATIVE_OPERAND, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getDivision_zeroValueAndMaxOperands_Ok() {
        char operator = '/';
        double expected = 0.0;
        double actual = newCalculator.calculate(ZERO_OPERAND,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getDivision_zeroValueAndMinOperands_Ok() {
        char operator = '/';
        double expected = 0.0;
        double actual = newCalculator.calculate(ZERO_OPERAND,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getDivision_byZero_NotOK() {
        char operator = '/';
        assertThrows(ZeroDivisionException.class, () -> {
            newCalculator.calculate(FIRST_POSITIVE_OPERAND, ZERO_OPERAND, operator);
        });
    }

    @Test
    public void getPowerOf_positiveValueAndPositiveDecimalPower_Ok() {
        char operator = '^';
        double expected = 27.8382;
        double actual = newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                POSITIVE_DECIMAL_POWER, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_positiveValueAndPositiveIntegerPower_Ok() {
        char operator = '^';
        double expected = 172.52962;
        double actual = newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                POSITIVE_INTEGER_POWER, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_positiveValueAndNegativeDecimalPower_Ok() {
        char operator = '^';
        double expected = 0.0009;
        double actual = newCalculator.calculate(SECOND_POSITIVE_OPERAND,
                NEGATIVE_DECIMAL_POWER, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_positiveValueAndNegativeIntegerPower_Ok() {
        char operator = '^';
        double expected = 0.00001;
        double actual = newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                NEGATIVE_INTEGER_POWER, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_negativeValueAndPositiveIntegerPower_Ok() {
        char operator = '^';
        double expected = -112.67859;
        double actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                POSITIVE_INTEGER_POWER, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_negativeValueAndPositiveDecimalPower_NotOk() {
        char operator = '^';
        assertThrows(NotAnumberException.class, () -> {
            newCalculator.calculate(FIRST_NEGATIVE_OPERAND, POSITIVE_DECIMAL_POWER, operator);
        });
    }

    @Test
    public void getPowerOf_negativeValueAndNegativeIntegerPower_Ok() {
        char operator = '^';
        double expected = -0.00002;
        double actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                NEGATIVE_INTEGER_POWER, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_negativeValueAndNegativeDecimalPower_NotOk() {
        char operator = '^';
        assertThrows(NotAnumberException.class, () -> {
            newCalculator.calculate(FIRST_NEGATIVE_OPERAND, NEGATIVE_DECIMAL_POWER, operator);
        });
    }

    @Test
    public void getPowerOf_maxValueAndMaxValuePower_Ok() {
        char operator = '^';
        double expected = Double.POSITIVE_INFINITY;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_minValueAndMinValuePower_Ok() {
        char operator = '^';
        double expected = 1.0;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_minValueAndMaxValuePower_Ok() {
        char operator = '^';
        double expected = 0.0;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_maxValueAndMinValuePower_Ok() {
        char operator = '^';
        double expected = 1.0;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_minValueAndPositiveIntegerPower_Ok() {
        char operator = '^';
        double expected = 0.0;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                POSITIVE_INTEGER_POWER, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_minValueAndPositiveDecimalPower_Ok() {
        char operator = '^';
        double expected = 0.0;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                POSITIVE_DECIMAL_POWER, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_minValueAndNegativeIntegerPower_Ok() {
        char operator = '^';
        double expected = Double.POSITIVE_INFINITY;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                NEGATIVE_INTEGER_POWER, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_minValueAndNegativeDecimalPower_Ok() {
        char operator = '^';
        double expected = Double.POSITIVE_INFINITY;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                NEGATIVE_DECIMAL_POWER, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_maxValueAndPositiveIntegerPower_Ok() {
        char operator = '^';
        double expected = Double.POSITIVE_INFINITY;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                POSITIVE_INTEGER_POWER, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_maxValueAndPositiveDecimalPower_Ok() {
        char operator = '^';
        double expected = Double.POSITIVE_INFINITY;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                POSITIVE_DECIMAL_POWER, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_maxValueAndNegativeIntegerPower_Ok() {
        char operator = '^';
        double expected = 0.0;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                NEGATIVE_INTEGER_POWER, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_maxValueAndNegativeDecimalPower_Ok() {
        char operator = '^';
        double expected = 0.0;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                NEGATIVE_DECIMAL_POWER, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_minValueAndZeroPower_Ok() {
        char operator = '^';
        double expected = 1.0;
        double actual = newCalculator.calculate(Double.MIN_VALUE,
                ZERO_POWER, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_maxValueAndZeroPower_Ok() {
        char operator = '^';
        double expected = 1.0;
        double actual = newCalculator.calculate(Double.MAX_VALUE,
                ZERO_POWER, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_positiveValueAndMaxValuePower_Ok() {
        char operator = '^';
        double expected = Double.POSITIVE_INFINITY;
        double actual = newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_positiveValueAndMinValuePower_Ok() {
        char operator = '^';
        double expected = 1.0;
        double actual = newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                Double.MIN_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_negativeValueAndMaxValuePower_Ok() {
        char operator = '^';
        double expected = Double.POSITIVE_INFINITY;
        double actual = newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                Double.MAX_VALUE, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getPowerOf_negativeValueAndMinValuePower_NotOk() {
        char operator = '^';
        assertThrows(NotAnumberException.class, () -> {
            newCalculator.calculate(FIRST_NEGATIVE_OPERAND,
                    Double.MIN_VALUE, operator);
        });
    }

    @Test
    public void getPowerOf_zeroAndZeroPower_Ok() {
        char operator = '^';
        double expected = 1.0;
        double actual = newCalculator.calculate(ZERO_OPERAND,
                ZERO_POWER, operator);
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    public void getModulus_unknownOperator_NotOk() {
        char operator = '%';
        assertThrows(UnknownOperationException.class, () -> {
            newCalculator.calculate(FIRST_POSITIVE_OPERAND,
                    SECOND_POSITIVE_OPERAND, operator);
        });
    }
}
