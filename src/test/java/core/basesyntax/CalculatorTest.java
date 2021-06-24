package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.0001;
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionWithPositiveOperands_Ok() {
        double valueFirstPositive = 10.3;
        double valueSecondPositive = 15.5;
        double valueZero = 0;
        assertEquals(valueFirstPositive + valueSecondPositive,
                calculator.calculate(valueFirstPositive, valueSecondPositive, '+'));
        assertEquals(valueFirstPositive + valueZero,
                calculator.calculate(valueFirstPositive, valueZero, '+'));
        assertEquals(valueZero + valueSecondPositive,
                calculator.calculate(valueZero, valueSecondPositive, '+'));
    }

    @Test
    void calculate_additionWithNegativeOperands_Ok() {
        double valueFirstNegative = -10.3;
        double valueSecondNegative = -15.5;
        double valueZero = 0;
        assertEquals(valueFirstNegative + valueSecondNegative,
                calculator.calculate(valueFirstNegative, valueSecondNegative, '+'));
        assertEquals(valueFirstNegative + valueZero,
                calculator.calculate(valueFirstNegative, valueZero, '+'));
        assertEquals(valueZero + valueSecondNegative,
                calculator.calculate(valueZero, valueSecondNegative, '+'));
    }

    @Test
    void calculate_additionWithZeroOperands_Ok() {
        double valueZero = 0;
        assertEquals(valueZero + valueZero,
                calculator.calculate(valueZero, valueZero, '+'));
    }

    @Test
    void calculate_additionWithPositiveAndNegativeOperands_Ok() {
        double valueFirstPositive = 10.3;
        double valueSecondNegative = -15.5;
        assertEquals(valueFirstPositive + valueSecondNegative,
                calculator.calculate(valueFirstPositive, valueSecondNegative, '+'));
        assertEquals(valueSecondNegative + valueFirstPositive,
                calculator.calculate(valueSecondNegative, valueFirstPositive, '+'));
    }

    @Test
    void calculate_additionWithMinAndMaxOperands_Ok() {
        double valueFirstPositive = 10.3;
        assertEquals(Double.MAX_VALUE + Double.MIN_VALUE,
                calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+'));
        assertEquals(Double.MAX_VALUE + valueFirstPositive,
                calculator.calculate(Double.MAX_VALUE, valueFirstPositive, '+'));
        assertEquals(Double.MIN_VALUE + valueFirstPositive,
                calculator.calculate(Double.MIN_VALUE, valueFirstPositive, '+'));
    }

    @Test
    void calculate_subtractionWithPositiveOperands_Ok() {
        double valueFirstPositive = 10.3;
        double valueSecondPositive = 15.5;
        double valueZero = 0;
        assertEquals(valueFirstPositive - valueSecondPositive,
                calculator.calculate(valueFirstPositive, valueSecondPositive, '-'));
        assertEquals(valueFirstPositive - valueZero,
                calculator.calculate(valueFirstPositive, valueZero, '-'));
        assertEquals(valueZero - valueSecondPositive,
                calculator.calculate(valueZero, valueSecondPositive, '-'));
    }

    @Test
    void calculate_subtractionWithNegativeOperands_Ok() {
        double valueFirstNegative = -10.3;
        double valueSecondNegative = -15.5;
        double valueZero = 0;
        assertEquals(valueFirstNegative - valueSecondNegative,
                calculator.calculate(valueFirstNegative, valueSecondNegative, '-'));
        assertEquals(valueFirstNegative - valueZero,
                calculator.calculate(valueFirstNegative, valueZero, '-'));
        assertEquals(valueZero - valueSecondNegative,
                calculator.calculate(valueZero, valueSecondNegative, '-'));
    }

    @Test
    void calculate_subtractionWithZeroOperands_Ok() {
        double valuePositive = 10.3;
        double valueZero = 0;
        assertEquals(valuePositive - valueZero,
                calculator.calculate(valuePositive, valueZero, '-'));
    }

    @Test
    void calculate_subtractionWithPositiveAndNegativeOperands_Ok() {
        double valueFirstPositive = 10.3;
        double valueSecondNegative = -15.5;
        assertEquals(valueFirstPositive - valueSecondNegative,
                calculator.calculate(valueFirstPositive, valueSecondNegative, '-'));
        assertEquals(valueSecondNegative - valueFirstPositive,
                calculator.calculate(valueSecondNegative, valueFirstPositive, '-'));
    }

    @Test
    void calculate_subtractionWithMinAndMaxOperands_Ok() {
        double valueFirstPositive = 10.3;
        double valueSecondNegative = -15.5;
        assertEquals(Double.MAX_VALUE - Double.MIN_VALUE,
                calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-'));
        assertEquals(Double.MAX_VALUE - valueFirstPositive,
                calculator.calculate(Double.MAX_VALUE, valueFirstPositive, '-'));
        assertEquals(Double.MIN_VALUE - valueSecondNegative,
                calculator.calculate(Double.MIN_VALUE, valueSecondNegative, '-'));
    }

    @Test
    void calculate_divisionWithPositiveOperands_Ok() {
        double valueFirstPositive = 10.3;
        double valueSecondPositive = 15.5;
        assertEquals(valueFirstPositive / valueSecondPositive,
                calculator.calculate(valueFirstPositive, valueSecondPositive, '/'), DELTA);
        assertEquals(valueSecondPositive / valueFirstPositive,
                calculator.calculate(valueSecondPositive, valueFirstPositive, '/'), DELTA);
    }

    @Test
    void calculate_divisionWithNegativeOperands_Ok() {
        double valueFirstNegative = -10.3;
        double valueSecondNegative = -15.5;
        assertEquals(valueFirstNegative / valueSecondNegative,
                calculator.calculate(valueFirstNegative, valueSecondNegative, '/'), DELTA);
    }

    @Test
    void calculate_divisionWithZeroOperands_Ok() {
        double valueFirstPositive = 10.3;
        double valueZero = 0;
        assertEquals(valueZero / valueFirstPositive,
                calculator.calculate(valueZero, valueFirstPositive, '/'), DELTA);
    }

    @Test
    void calculate_divisionWithZeroOperands_notOk() {
        double valueFirstPositive = 10.3;
        double valueZero = 0;
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(valueFirstPositive, valueZero, '/'));
    }

    @Test
    void calculate_divisionWithPositiveAndNegativeOperands_Ok() {
        double valueFirstPositive = 10.3;
        double valueSecondNegative = -15.5;
        assertEquals(valueFirstPositive / valueSecondNegative,
                calculator.calculate(valueFirstPositive, valueSecondNegative, '/'), DELTA);
        assertEquals(valueSecondNegative / valueFirstPositive,
                calculator.calculate(valueSecondNegative, valueFirstPositive, '/'), DELTA);
    }

    @Test
    void calculate_divisionWithMinAndMaxOperands_Ok() {
        double valueFirstPositive = 10.3;
        double valueSecondNegative = -15.5;
        assertEquals(Double.MIN_VALUE / Double.MAX_VALUE,
                calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '/'), DELTA);
        assertEquals(Double.MAX_VALUE / valueFirstPositive,
                calculator.calculate(Double.MAX_VALUE, valueFirstPositive, '/'), DELTA);
        assertEquals(Double.MIN_VALUE / valueSecondNegative,
                calculator.calculate(Double.MIN_VALUE, valueSecondNegative, '/'), DELTA);
    }

    @Test
    void calculate_multiplicationWithPositiveOperands_Ok() {
        double valueFirstPositive = 10.3;
        double valueSecondPositive = 15.5;
        double valueZero = 0;
        assertEquals(valueFirstPositive * valueSecondPositive,
                calculator.calculate(valueFirstPositive, valueSecondPositive, '*'), DELTA);
        assertEquals(valueFirstPositive * valueZero,
                calculator.calculate(valueFirstPositive, valueZero, '*'), DELTA);
        assertEquals(valueZero * valueSecondPositive,
                calculator.calculate(valueZero, valueSecondPositive, '*'), DELTA);
    }

    @Test
    void calculate_multiplicationWithNegativeOperands_Ok() {
        double valueFirstNegative = -10.3;
        double valueSecondNegative = -15.5;
        double valueZero = 0;
        assertEquals(valueFirstNegative * valueSecondNegative,
                calculator.calculate(valueFirstNegative, valueSecondNegative, '*'), DELTA);
        assertEquals(valueFirstNegative * valueZero,
                calculator.calculate(valueFirstNegative, valueZero, '*'), DELTA);
        assertEquals(valueZero * valueSecondNegative,
                calculator.calculate(valueZero, valueSecondNegative, '*'), DELTA);
    }

    @Test
    void calculate_multiplicationWithZeroOperands_Ok() {
        double valueZero = 0;
        assertEquals(valueZero * valueZero,
                calculator.calculate(valueZero, valueZero, '*'));
    }

    @Test
    void calculate_multiplicationWithPositiveAndNegativeOperands_Ok() {
        double valueFirstPositive = 10.3;
        double valueSecondNegative = -15.5;
        assertEquals(valueFirstPositive * valueSecondNegative,
                calculator.calculate(valueFirstPositive, valueSecondNegative, '*'), DELTA);
        assertEquals(valueSecondNegative * valueFirstPositive,
                calculator.calculate(valueSecondNegative, valueFirstPositive, '*'), DELTA);
    }

    @Test
    void calculate_multiplicationWithMinAndMaxOperands_Ok() {
        double valueFirstPositive = 10.3;
        double valueSecondNegative = -15.5;
        assertEquals(Double.MAX_VALUE * Double.MIN_VALUE,
                calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*'), DELTA);
        assertEquals(Double.MAX_VALUE * valueFirstPositive,
                calculator.calculate(Double.MAX_VALUE, valueFirstPositive, '*'), DELTA);
        assertEquals(Double.MIN_VALUE * valueSecondNegative,
                calculator.calculate(Double.MIN_VALUE, valueSecondNegative, '*'), DELTA);
    }

    @Test
    void calculate_raisingToPowerWithPositiveOperands_Ok() {
        double valueFirstPositive = 10.3;
        double valueSecondPositive = 15.5;
        assertEquals(Math.pow(valueFirstPositive, valueSecondPositive),
                calculator.calculate(valueFirstPositive, valueSecondPositive, '^'));
    }

    @Test
    void calculate_raisingToPowerWithNegativeOperands_Ok() {
        double valueFirstNegative = -10.3;
        double valueSecondNegative = -15.5;
        assertEquals(Math.pow(valueFirstNegative, valueSecondNegative),
                calculator.calculate(valueFirstNegative, valueSecondNegative, '^'));
    }

    @Test
    void calculate_raisingToPowerWithZeroOperands_Ok() {
        double valueFirstNegative = -10.3;
        double valueSecondPositive = 15.5;
        double valueZero = 0;
        assertEquals(Math.pow(valueFirstNegative, valueZero),
                calculator.calculate(valueFirstNegative, valueZero, '^'));
        assertEquals(Math.pow(valueSecondPositive, valueZero),
                calculator.calculate(valueSecondPositive, valueZero, '^'));
        assertEquals(Math.pow(valueZero, valueSecondPositive),
                calculator.calculate(valueZero, valueSecondPositive, '^'));
    }

    @Test
    void calculate_raisingToPowerWithZeroOperands_notOk() {
        double valueNegative = -10.3;
        double valueZero = 0;
        assertThrows(ArithmeticException.class, () ->
                calculator.calculate(valueZero, valueNegative, '^'));
    }

    @Test
    void calculate_raisingToPowerWithPositiveAndNegativeOperands_Ok() {
        double valueFirstPositive = 10.3;
        double valueSecondNegative = -15.5;
        assertEquals(Math.pow(valueFirstPositive, valueSecondNegative),
                calculator.calculate(valueFirstPositive, valueSecondNegative, '^'));
        assertEquals(Math.pow(valueSecondNegative, valueFirstPositive),
                calculator.calculate(valueSecondNegative, valueFirstPositive, '^'));
    }

    @Test
    void calculate_raisingToPowerWithMinAndMaxOperands_Ok() {
        assertEquals(Math.pow(Double.MAX_VALUE, Double.MIN_VALUE),
                calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '^'));
    }

    @Test
    void calculate_incorrectOperation_notOk() {
        double valueFirstPositive = 10.3;
        double valueSecondNegative = -15.5;
        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculate(valueFirstPositive, valueSecondNegative, '='));
    }
}
