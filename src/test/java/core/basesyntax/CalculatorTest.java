package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double FIRST_VALUE_POSITIVE = 539.638;
    private static final double SECOND_VALUE_POSITIVE = 117.849;
    private static final double FIRST_VALUE_NEGATIVE = -539.638;
    private static final double SECOND_VALUE_NEGATIVE = -117.849;
    private static final double POWER_COEFFICIENT_POSITIVE = 109;
    private static final double POWER_COEFFICIENT_NEGATIVE = -109;
    private static final double VALUE_ZERO = 0;
    private static final double DELTA = 0.0001;
    private static final char OPERATION_ADDITION = '+';
    private static final char OPERATION_SUBTRACTION = '-';
    private static final char OPERATION_MULTIPLICATION = '*';
    private static final char OPERATION_DIVISION = '/';
    private static final char OPERATION_RAISING_TO_POWER = '^';
    private static final char OPERATION_ILLEGAL = '$';
    private static LambdaCalculate calculator;
    private double expected;
    private double actual;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void additionWithTwoPositiveOperands_Equals_Ok() {
        expected = 657.487;
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                SECOND_VALUE_POSITIVE, OPERATION_ADDITION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
    }

    @Test
    void additionWithTwoNegativeOperands_Equals_Ok() {
        expected = -657.487;
        actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                SECOND_VALUE_NEGATIVE, OPERATION_ADDITION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
    }

    @Test
    void additionWithPositiveAndNegativeOperand_Equals_Ok() {
        expected = 421.789;
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                SECOND_VALUE_NEGATIVE, OPERATION_ADDITION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
        expected = -421.789;
        actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                SECOND_VALUE_POSITIVE, OPERATION_ADDITION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
    }

    @Test
    void additionWithZeroOperandInDifferentPlace_Equals_Ok() {
        expected = 539.638;
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                VALUE_ZERO, OPERATION_ADDITION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
        expected = 117.849;
        actual = calculator.lambdaCalculator(VALUE_ZERO,
                SECOND_VALUE_POSITIVE, OPERATION_ADDITION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
        expected = -539.638;
        actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                VALUE_ZERO, OPERATION_ADDITION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
        expected = -117.849;
        actual = calculator.lambdaCalculator(VALUE_ZERO,
                SECOND_VALUE_NEGATIVE, OPERATION_ADDITION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
    }

    @Test
    void additionWithMinAndMaxDoubleValuesOperandInDifferentPlace_Equals_Ok() {
        expected = Double.MAX_VALUE + Double.MIN_VALUE;
        actual = calculator.lambdaCalculator(Double.MAX_VALUE,
                Double.MIN_VALUE, OPERATION_ADDITION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
        expected = Double.MIN_VALUE + Double.MAX_VALUE;
        actual = calculator.lambdaCalculator(Double.MIN_VALUE,
                Double.MAX_VALUE, OPERATION_ADDITION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
        expected = Double.MIN_VALUE + Double.MIN_VALUE;
        actual = calculator.lambdaCalculator(Double.MIN_VALUE,
                Double.MIN_VALUE, OPERATION_ADDITION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
        expected = Double.MAX_VALUE + Double.MAX_VALUE;
        actual = calculator.lambdaCalculator(Double.MAX_VALUE,
                Double.MAX_VALUE, OPERATION_ADDITION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
    }

    @Test
    void subtractionWithTwoPositiveOperands_Equals_Ok() {
        expected = 421.789;
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                SECOND_VALUE_POSITIVE, OPERATION_SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Operation subtraction work not correct!");
    }

    @Test
    void subtractionWithTwoNegativeOperands_Equals_Ok() {
        expected = -421.789;
        actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                SECOND_VALUE_NEGATIVE, OPERATION_SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Operation subtraction work not correct!");
    }

    @Test
    void subtractionWithPositiveAndNegativeOperand_Equals_Ok() {
        expected = 657.487;
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                SECOND_VALUE_NEGATIVE, OPERATION_SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Operation subtraction work not correct!");
        expected = -657.487;
        actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                SECOND_VALUE_POSITIVE, OPERATION_SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Operation subtraction work not correct!");
    }

    @Test
    void subtractionWithZeroOperandInDifferentPlace_Equals_Ok() {
        expected = 539.638;
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                VALUE_ZERO, OPERATION_SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Operation subtraction work not correct!");
        expected = -117.849;
        actual = calculator.lambdaCalculator(VALUE_ZERO,
                SECOND_VALUE_POSITIVE, OPERATION_SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Operation subtraction work not correct!");
        expected = -539.638;
        actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                VALUE_ZERO, OPERATION_SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Operation subtraction work not correct!");
        expected = 117.849;
        actual = calculator.lambdaCalculator(VALUE_ZERO,
                SECOND_VALUE_NEGATIVE, OPERATION_SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Operation subtraction work not correct!");
    }

    @Test
    void subtractionWithMinAndMaxDoubleValuesOperandInDifferentPlace_Equals_Ok() {
        expected = Double.MAX_VALUE - Double.MIN_VALUE;
        actual = calculator.lambdaCalculator(Double.MAX_VALUE,
                Double.MIN_VALUE, OPERATION_SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Operation subtraction work not correct!");
        expected = Double.MIN_VALUE - Double.MAX_VALUE;
        actual = calculator.lambdaCalculator(Double.MIN_VALUE,
                Double.MAX_VALUE, OPERATION_SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Operation subtraction work not correct!");
        expected = Double.MIN_VALUE - Double.MIN_VALUE;
        actual = calculator.lambdaCalculator(Double.MIN_VALUE,
                Double.MIN_VALUE, OPERATION_SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Operation subtraction work not correct!");
        expected = Double.MAX_VALUE - Double.MAX_VALUE;
        actual = calculator.lambdaCalculator(Double.MAX_VALUE,
                Double.MAX_VALUE, OPERATION_SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Operation subtraction work not correct!");
    }

    @Test
    void multiplicationWithTwoPositiveOperands_Equals_Ok() {
        expected = 63_595.798_66;
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                SECOND_VALUE_POSITIVE, OPERATION_MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Operation multiplication work not correct!");
    }

    @Test
    void multiplicationWithTwoNegativeOperands_Equals_Ok() {
        expected = 63_595.798_66;
        actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                SECOND_VALUE_NEGATIVE, OPERATION_MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Operation multiplication work not correct!");
    }

    @Test
    void multiplicationWithPositiveAndNegativeOperand_Equals_Ok() {
        expected = -63_595.798_66;
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                SECOND_VALUE_NEGATIVE, OPERATION_MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Operation multiplication work not correct!");
        expected = -63_595.798_66;
        actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                SECOND_VALUE_POSITIVE, OPERATION_MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Operation multiplication work not correct!");
    }

    @Test
    void multiplicationWithZeroOperandInDifferentPlace_Equals_Ok() {
        expected = 0;
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                VALUE_ZERO, OPERATION_MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Operation multiplication work not correct!");
        expected = 0;
        actual = calculator.lambdaCalculator(VALUE_ZERO,
                SECOND_VALUE_POSITIVE, OPERATION_MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Operation multiplication work not correct!");
        expected = 0;
        actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                VALUE_ZERO, OPERATION_MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Operation multiplication work not correct!");
        expected = 0;
        actual = calculator.lambdaCalculator(VALUE_ZERO,
                SECOND_VALUE_NEGATIVE, OPERATION_MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Operation multiplication work not correct!");
    }

    @Test
    void multiplicationWithMinAndMaxDoubleValuesOperandInDifferentPlace_Equals_Ok() {
        expected = Double.MAX_VALUE * Double.MIN_VALUE;
        actual = calculator.lambdaCalculator(Double.MAX_VALUE,
                Double.MIN_VALUE, OPERATION_MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Operation multiplication work not correct!");
        expected = Double.MIN_VALUE * Double.MAX_VALUE;
        actual = calculator.lambdaCalculator(Double.MIN_VALUE,
                Double.MAX_VALUE, OPERATION_MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Operation multiplication work not correct!");
        expected = Double.MIN_VALUE * Double.MIN_VALUE;
        actual = calculator.lambdaCalculator(Double.MIN_VALUE,
                Double.MIN_VALUE, OPERATION_MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Operation multiplication work not correct!");
        expected = Double.MAX_VALUE * Double.MAX_VALUE;
        actual = calculator.lambdaCalculator(Double.MAX_VALUE,
                Double.MAX_VALUE, OPERATION_MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Operation multiplication work not correct!");
    }

    @Test
    void divisionWithTwoPositiveOperands_Equals_Ok() {
        expected = 4.57906;
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                SECOND_VALUE_POSITIVE, OPERATION_DIVISION);
        assertEquals(expected, actual, DELTA, "Operation division work not correct!");
    }

    @Test
    void divisionWithTwoNegativeOperands_Equals_Ok() {
        expected = 4.57906;
        actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                SECOND_VALUE_NEGATIVE, OPERATION_DIVISION);
        assertEquals(expected, actual, DELTA, "Operation division work not correct!");
    }

    @Test
    void divisionWithPositiveAndNegativeOperand_Equals_Ok() {
        expected = -4.57906;
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                SECOND_VALUE_NEGATIVE, OPERATION_DIVISION);
        assertEquals(expected, actual, DELTA, "Operation division work not correct!");
        expected = -4.57906;
        actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                SECOND_VALUE_POSITIVE, OPERATION_DIVISION);
        assertEquals(expected, actual, DELTA, "Operation division work not correct!");
    }

    @Test
    void divisionWithZeroOperandInDifferentPlace_Equals_Ok() {
        assertThrows(IllegalArgumentException.class, () -> {
            actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                    VALUE_ZERO, OPERATION_DIVISION);
        });
        expected = 0;
        actual = calculator.lambdaCalculator(VALUE_ZERO,
                SECOND_VALUE_POSITIVE, OPERATION_DIVISION);
        assertEquals(expected, actual, DELTA, "Operation division work not correct!");
        assertThrows(IllegalArgumentException.class, () -> {
            actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                    VALUE_ZERO, OPERATION_DIVISION);
        });
        expected = 0;
        actual = calculator.lambdaCalculator(VALUE_ZERO,
                SECOND_VALUE_NEGATIVE, OPERATION_DIVISION);
        assertEquals(expected, actual, DELTA, "Operation division work not correct!");
    }

    @Test
    void divisionWithMinAndMaxDoubleValuesOperandInDifferentPlace_Equals_Ok() {
        expected = Double.MAX_VALUE / Double.MIN_VALUE;
        actual = calculator.lambdaCalculator(Double.MAX_VALUE,
                Double.MIN_VALUE, OPERATION_DIVISION);
        assertEquals(expected, actual, DELTA, "Operation division work not correct!");
        expected = Double.MIN_VALUE / Double.MAX_VALUE;
        actual = calculator.lambdaCalculator(Double.MIN_VALUE,
                Double.MAX_VALUE, OPERATION_DIVISION);
        assertEquals(expected, actual, DELTA, "Operation division work not correct!");
        expected = Double.MIN_VALUE / Double.MIN_VALUE;
        actual = calculator.lambdaCalculator(Double.MIN_VALUE,
                Double.MIN_VALUE, OPERATION_DIVISION);
        assertEquals(expected, actual, DELTA, "Operation division work not correct!");
        expected = Double.MAX_VALUE / Double.MAX_VALUE;
        actual = calculator.lambdaCalculator(Double.MAX_VALUE,
                Double.MAX_VALUE, OPERATION_DIVISION);
        assertEquals(expected, actual, DELTA, "Operation division work not correct!");
    }

    @Test
    void raisingToPositivePowerWithPositiveAndNegativeOperand_Equals_Ok() {
        expected = Math.pow(FIRST_VALUE_POSITIVE, POWER_COEFFICIENT_POSITIVE);
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                POWER_COEFFICIENT_POSITIVE, OPERATION_RAISING_TO_POWER);
        assertEquals(expected, actual, DELTA, "Operation raising to power work not correct!");
        expected = -Math.pow(FIRST_VALUE_NEGATIVE, POWER_COEFFICIENT_POSITIVE);
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                POWER_COEFFICIENT_POSITIVE, OPERATION_RAISING_TO_POWER);
        assertEquals(expected, actual, DELTA, "Operation raising to power work not correct!");
    }

    @Test
    void raisingToNegativePowerWithPositiveAndNegativeOperand_Equals_Ok() {
        expected = Math.pow(FIRST_VALUE_POSITIVE, POWER_COEFFICIENT_NEGATIVE);
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                POWER_COEFFICIENT_NEGATIVE, OPERATION_RAISING_TO_POWER);
        assertEquals(expected, actual, DELTA, "Operation raising to power work not correct!");
        expected = Math.pow(FIRST_VALUE_NEGATIVE, POWER_COEFFICIENT_NEGATIVE);
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                POWER_COEFFICIENT_NEGATIVE, OPERATION_RAISING_TO_POWER);
        assertEquals(expected, actual, DELTA, "Operation raising to power work not correct!");
    }

    @Test
    void raisingToZeroPowerWithPositiveAndNegativeOperand_Equals_Ok() {
        expected = 1;
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                VALUE_ZERO, OPERATION_RAISING_TO_POWER);
        assertEquals(expected, actual, DELTA, "Operation raising to power work not correct!");
        expected = 1;
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                VALUE_ZERO, OPERATION_RAISING_TO_POWER);
        assertEquals(expected, actual, DELTA, "Operation raising to power work not correct!");
    }

    @Test
    void raisingZeroToPositiveAndNegativePower_Equals_Ok() {
        expected = 0;
        actual = calculator.lambdaCalculator(VALUE_ZERO,
                POWER_COEFFICIENT_POSITIVE, OPERATION_RAISING_TO_POWER);
        assertEquals(expected, actual, DELTA, "Operation raising to power n work not correct!");
        expected = 0;
        actual = calculator.lambdaCalculator(VALUE_ZERO,
                POWER_COEFFICIENT_NEGATIVE, OPERATION_RAISING_TO_POWER);
        assertEquals(expected, actual, DELTA, "Operation raising to power work not correct!");
    }

    @Test
    void illegalOperator_ThrowException_Ok() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                    SECOND_VALUE_POSITIVE, OPERATION_ILLEGAL);
        });
    }
}
