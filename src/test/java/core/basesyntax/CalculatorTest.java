package core.basesyntax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char EXPONENT = '^';
    private static final double POSITIVE_VALUE = 8535.7937;
    private static final double NEGATIVE_VALUE = -9876.5433;
    private static final double ZERO = 0;
    private static final double DELTA = 0.0001;
    private double expected;
    private double actual;
    Calculator calculator = new Calculator();

    //START ADDITION
    @Test
    void additionWith2PositiveOperands_Ok() {
        expected = 17071.5874;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWith2NegativeOperands_Ok() {
        expected = -19753.0866;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithPositiveAndNegativeOperands_Ok() {
        expected = -1340.7495999999992;
        actual = calculator.calculate(POSITIVE_VALUE, NEGATIVE_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionWithZeroInDifferentPlaces_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, ADDITION);
        assertEquals(POSITIVE_VALUE, actual, DELTA);
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, ADDITION);
        assertEquals(POSITIVE_VALUE, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, ADDITION);
        assertEquals(NEGATIVE_VALUE, actual, DELTA);
        actual = calculator.calculate(ZERO, NEGATIVE_VALUE, ADDITION);
        assertEquals(NEGATIVE_VALUE, actual, DELTA);
    }

    @Test
    void additionForMinAndMaxDoubleValues() {
        expected = 1.7976931348623157E308;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, ADDITION);
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(POSITIVE_VALUE, Double.MIN_VALUE, ADDITION);
        assertEquals(POSITIVE_VALUE, actual, DELTA);
    }
    //END ADDITION

    //START SUBTRACTION
    @Test
    void subtractionWith2PositiveOperands_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, SUBTRACTION);
        assertEquals(ZERO, actual, DELTA);
    }

    @Test
    void subtractionWith2NegativeOperands_Ok() {
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(ZERO, actual, DELTA);
    }

    @Test
    void subtractionWithPositiveAndNegativeOperands_Ok() {
        expected = 18412.337;
        actual = calculator.calculate(NEGATIVE_VALUE, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithZeroInDifferentPlaces_Ok() {
        actual = calculator.calculate(POSITIVE_VALUE, ZERO, SUBTRACTION);
        assertEquals(POSITIVE_VALUE, actual, DELTA);
        expected = -POSITIVE_VALUE;
        actual = calculator.calculate(ZERO, POSITIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(NEGATIVE_VALUE, ZERO, SUBTRACTION);
        assertEquals(NEGATIVE_VALUE, actual, DELTA);
        expected = -NEGATIVE_VALUE;
        actual = calculator.calculate(ZERO, NEGATIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionForMinAndMaxDoubleValues_Ok() {
        expected = 1.7976931348623157E308;
        actual = calculator.calculate(Double.MAX_VALUE, POSITIVE_VALUE, SUBTRACTION);
        assertEquals(expected, actual, DELTA);

        actual = calculator.calculate(POSITIVE_VALUE, Double.MIN_VALUE, SUBTRACTION);
        assertEquals(POSITIVE_VALUE, actual, DELTA);
    }

    //END SUBTRACTION

    //START MULTIPLICATION
    @Test
    void multiplicationWith2PositiveOperands_Ok() {
        expected = 7.28597740889597E7;
        actual = calculator.calculate(POSITIVE_VALUE, POSITIVE_VALUE, MULTIPLICATION);
        assertEquals(expected, actual, DELTA);
    }

    /*
    private static final double POSITIVE_VALUE = 8535.7937;
    private static final double NEGATIVE_VALUE = -9876.5433;
     */


    /*
same for multiplication;
with 2 positive operands;
with 2 negative operands;
with positive and negative operands;
with zero in different places;
for min and max double values;




same for division (check division by 0);
raising positive/negative value to the positive power;
raising positive/negative value to the negative power;
raising positive/negative value to zero power;
raising zero to power;
illegal operation;
     */
}