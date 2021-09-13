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

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionWithTwoPositiveOperands_Ok() {
        double expected = 657.487;
        double actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                SECOND_VALUE_POSITIVE, OPERATION_ADDITION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
    }

    @Test
    void calculate_additionWithTwoNegativeOperands_Ok() {
        double expected = -657.487;
        double actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                SECOND_VALUE_NEGATIVE, OPERATION_ADDITION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperand_Ok() {
        double expected = 421.789;
        double actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                SECOND_VALUE_NEGATIVE, OPERATION_ADDITION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
        expected = -421.789;
        actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                SECOND_VALUE_POSITIVE, OPERATION_ADDITION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
    }

    @Test
    void calculate_additionWithZeroOperandInDifferentPlace_Ok() {
        double expected = 539.638;
        double actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
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
    void calculate_additionWithMinDoubleValues_Ok() {
        double expected = 0;
        double actual = calculator.lambdaCalculator(Double.MIN_VALUE,
                Double.MIN_VALUE, OPERATION_ADDITION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
    }

    @Test
    void calculate_additionWithMaxDoubleValues_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.lambdaCalculator(Double.MAX_VALUE,
                Double.MAX_VALUE, OPERATION_ADDITION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
    }

    @Test
    void calculate_subtractionWithTwoPositiveOperands_Ok() {
        double expected = 421.789;
        double actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                SECOND_VALUE_POSITIVE, OPERATION_SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Operation subtraction work not correct!");
    }

    @Test
    void calculate_subtractionWithTwoNegativeOperands_Ok() {
        double expected = -421.789;
        double actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                SECOND_VALUE_NEGATIVE, OPERATION_SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Operation subtraction work not correct!");
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeOperand_Ok() {
        double expected = 657.487;
        double actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                SECOND_VALUE_NEGATIVE, OPERATION_SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Operation subtraction work not correct!");
        expected = -657.487;
        actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                SECOND_VALUE_POSITIVE, OPERATION_SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Operation subtraction work not correct!");
    }

    @Test
    void calculate_subtractionWithZeroOperandInDifferentPlace_Ok() {
        double expected = 539.638;
        double actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
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
    void calculate_subtractionWithMinDoubleValues_Ok() {
        double expected = 0;
        double actual = calculator.lambdaCalculator(Double.MIN_VALUE,
                Double.MIN_VALUE, OPERATION_SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
    }

    @Test
    void calculate_subtractionWithMaxDoubleValues_Ok() {
        double expected = 0;
        double actual = calculator.lambdaCalculator(Double.MAX_VALUE,
                Double.MAX_VALUE, OPERATION_SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
        expected = Double.MAX_VALUE;
        actual = calculator.lambdaCalculator(Double.MAX_VALUE,
                Double.MIN_VALUE, OPERATION_SUBTRACTION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
    }

    @Test
    void calculate_multiplicationWithTwoPositiveOperands_Ok() {
        double expected = 63_595.798_66;
        double actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                SECOND_VALUE_POSITIVE, OPERATION_MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Operation multiplication work not correct!");
    }

    @Test
    void calculate_multiplicationWithTwoNegativeOperands_Ok() {
        double expected = 63_595.798_66;
        double actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                SECOND_VALUE_NEGATIVE, OPERATION_MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Operation multiplication work not correct!");
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeOperand_Ok() {
        double expected = -63_595.798_66;
        double actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                SECOND_VALUE_NEGATIVE, OPERATION_MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Operation multiplication work not correct!");
        expected = -63_595.798_66;
        actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                SECOND_VALUE_POSITIVE, OPERATION_MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Operation multiplication work not correct!");
    }

    @Test
    void calculate_multiplicationWithZeroOperandInDifferentPlace_Ok() {
        double expected = 0;
        double actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
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
    void calculate_multiplicationWithMinDoubleValues_Ok() {
        double expected = 0;
        double actual = calculator.lambdaCalculator(Double.MIN_VALUE,
                Double.MIN_VALUE, OPERATION_MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
    }

    @Test
    void calculate_multiplicationWithMaxDoubleValues_Ok() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = calculator.lambdaCalculator(Double.MAX_VALUE,
                Double.MAX_VALUE, OPERATION_MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
        expected = 0;
        actual = calculator.lambdaCalculator(Double.MAX_VALUE,
                Double.MIN_VALUE, OPERATION_MULTIPLICATION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
    }

    @Test
    void calculate_divisionWithTwoPositiveOperands_Ok() {
        double expected = 4.57906;
        double actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                SECOND_VALUE_POSITIVE, OPERATION_DIVISION);
        assertEquals(expected, actual, DELTA, "Operation division work not correct!");
    }

    @Test
    void calculate_divisionWithTwoNegativeOperands_Ok() {
        double expected = 4.57906;
        double actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                SECOND_VALUE_NEGATIVE, OPERATION_DIVISION);
        assertEquals(expected, actual, DELTA, "Operation division work not correct!");
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperand_Ok() {
        double expected = -4.57906;
        double actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                SECOND_VALUE_NEGATIVE, OPERATION_DIVISION);
        assertEquals(expected, actual, DELTA, "Operation division work not correct!");
        expected = -4.57906;
        actual = calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                SECOND_VALUE_POSITIVE, OPERATION_DIVISION);
        assertEquals(expected, actual, DELTA, "Operation division work not correct!");
    }

    @Test
    void calculate_divisionWithZeroAsFirstValue_Ok() {
        double expected = 0;
        double actual = calculator.lambdaCalculator(VALUE_ZERO,
                SECOND_VALUE_POSITIVE, OPERATION_DIVISION);
        assertEquals(expected, actual, "Operation division work not correct!");
        expected = 0;
        actual = calculator.lambdaCalculator(VALUE_ZERO,
                SECOND_VALUE_NEGATIVE, OPERATION_DIVISION);
        assertEquals(expected, actual, DELTA, "Operation division work not correct!");
    }

    @Test
    void calculate_divisionWithZeroAsSecondValue_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                    VALUE_ZERO, OPERATION_DIVISION);
            calculator.lambdaCalculator(FIRST_VALUE_NEGATIVE,
                    VALUE_ZERO, OPERATION_DIVISION);
        });
    }

    @Test
    void calculate_divisionWithMinDoubleValues_Ok() {
        double expected = 1;
        double actual = calculator.lambdaCalculator(Double.MIN_VALUE,
                Double.MIN_VALUE, OPERATION_DIVISION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
    }

    @Test
    void calculate_divisionWithMaxDoubleValues_Ok() {
        double expected = 1;
        double actual = calculator.lambdaCalculator(Double.MAX_VALUE,
                Double.MAX_VALUE, OPERATION_DIVISION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.lambdaCalculator(Double.MAX_VALUE,
                Double.MIN_VALUE, OPERATION_DIVISION);
        assertEquals(expected, actual, DELTA, "Operation addition work not correct!");
    }

    @Test
    void calculate_raisingToPositivePowerWithPositiveAndNegativeOperand_Ok() {
        double expected = Math.pow(FIRST_VALUE_POSITIVE, POWER_COEFFICIENT_POSITIVE);
        double actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                POWER_COEFFICIENT_POSITIVE, OPERATION_RAISING_TO_POWER);
        assertEquals(expected, actual, DELTA, "Operation raising to power work not correct!");
        expected = -Math.pow(FIRST_VALUE_NEGATIVE, POWER_COEFFICIENT_POSITIVE);
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                POWER_COEFFICIENT_POSITIVE, OPERATION_RAISING_TO_POWER);
        assertEquals(expected, actual, DELTA, "Operation raising to power work not correct!");
    }

    @Test
    void calculate_raisingToNegativePowerWithPositiveAndNegativeOperand_Ok() {
        double expected = Math.pow(FIRST_VALUE_POSITIVE, POWER_COEFFICIENT_NEGATIVE);
        double actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                POWER_COEFFICIENT_NEGATIVE, OPERATION_RAISING_TO_POWER);
        assertEquals(expected, actual, DELTA, "Operation raising to power work not correct!");
        expected = Math.pow(FIRST_VALUE_NEGATIVE, POWER_COEFFICIENT_NEGATIVE);
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                POWER_COEFFICIENT_NEGATIVE, OPERATION_RAISING_TO_POWER);
        assertEquals(expected, actual, DELTA, "Operation raising to power work not correct!");
    }

    @Test
    void calculate_raisingToZeroPowerWithPositiveAndNegativeOperand_Ok() {
        double expected = 1;
        double actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                VALUE_ZERO, OPERATION_RAISING_TO_POWER);
        assertEquals(expected, actual, DELTA, "Operation raising to power work not correct!");
        expected = 1;
        actual = calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                VALUE_ZERO, OPERATION_RAISING_TO_POWER);
        assertEquals(expected, actual, DELTA, "Operation raising to power work not correct!");
    }

    @Test
    void calculate_raisingZeroToPositiveAndNegativePower_Ok() {
        double expected = 0;
        double actual = calculator.lambdaCalculator(VALUE_ZERO,
                POWER_COEFFICIENT_POSITIVE, OPERATION_RAISING_TO_POWER);
        assertEquals(expected, actual, DELTA, "Operation raising to power n work not correct!");
        expected = Double.POSITIVE_INFINITY;
        actual = calculator.lambdaCalculator(VALUE_ZERO,
                POWER_COEFFICIENT_NEGATIVE, OPERATION_RAISING_TO_POWER);
        assertEquals(expected, actual, DELTA, "Operation raising to power work not correct!");
    }

    @Test
    void calculate_illegalOperator_notOk() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.lambdaCalculator(FIRST_VALUE_POSITIVE,
                    SECOND_VALUE_POSITIVE, OPERATION_ILLEGAL);
        });
    }
}
