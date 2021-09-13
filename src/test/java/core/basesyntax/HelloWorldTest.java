package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {
    private static HelloWorld helloWorld;
    private static final double SUM_OF_TWO_POSITIVE = 12;
    private static final double SUM_OF_TWO_NEGATIVE = -15;
    private static final double SUM_OF_NEGATIVE_AND_POSITIVE = 2;
    private static final double SUM_OF_MAX_AND_MIN = Double.MAX_VALUE + Double.MIN_VALUE;
    private static final double SUBTRACTION_OF_TWO_POSITIVE = -2;
    private static final double SUBTRACTION_OF_TWO_NEGATIVE = -9;
    private static final double SUBTRACTION_OF_NEGATIVE_AND_POSITIVE = -17;
    private static final double SUBTRACTION_OF_MAX_AND_MIN = Double.MAX_VALUE - Double.MIN_VALUE;
    private static final double MULTIPLICATION_OF_TWO_POSITIVE = 35;
    private static final double MULTIPLICATION_OF_TWO_NEGATIVE = 36;
    private static final double MULTIPLICATION_OF_NEGATIVE_AND_POSITIVE = -60;
    private static final double MULTIPLICATION_OF_MAX_AND_MIN = Double.MAX_VALUE * Double.MIN_VALUE;
    private static final double DIVISION_OF_TWO_POSITIVE = 0.7142857142857143;
    private static final double DIVISION_OF_TWO_NEGATIVE = 4;
    private static final double DIVISION_OF_NEGATIVE_AND_POSITIVE = -0.4166666666666667;
    private static final double DIVISION_OF_MAX_AND_MIN = Double.MAX_VALUE / Double.MIN_VALUE;
    private static final double RAISE_POSITIVE_TO_POSITIVE = 3125;
    private static final double RAISE_NEGATIVE_TO_POSITIVE = -243;
    private static final double RAISE_POSITIVE_TO_NEGATIVE = 0.008;
    private static final double RAISE_NEGATIVE_TO_NEGATIVE = -0.037037037037037;
    private static final double RAISE_TO_ZERO = 1;
    private static final double FIRST_POSITIVE_VALUE = 5;
    private static final double SECOND_POSITIVE_VALUE = 7;
    private static final double FIRST_NEGATIVE_VALUE = -12;
    private static final double SECOND_NEGATIVE_VALUE = -3;
    private static final char ILLEGAL_OPERATION = '#';
    private static final double MAX_DOUBLE = Double.MAX_VALUE;
    private static final double MIN_DOUBLE = Double.MIN_VALUE;
    private static final double ZERO = 0;
    private static final double DELTA = 0.0001;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';
    private static final char MULTIPLICATION = '*';
    private static final char POWER = '^';

    @BeforeAll
    static void beforeAll() {
        helloWorld = new HelloWorld();
    }

    @Test
    void calculate_SumOfTwoPositiveNumbers_Ok() {
        assertEquals(SUM_OF_TWO_POSITIVE, helloWorld.calculate(FIRST_POSITIVE_VALUE,
                SECOND_POSITIVE_VALUE, ADDITION), DELTA);
    }

    @Test
    void calculate_SumOfTwoNegativeNumbers_Ok() {
        assertEquals(SUM_OF_TWO_NEGATIVE, helloWorld.calculate(FIRST_NEGATIVE_VALUE,
                SECOND_NEGATIVE_VALUE, ADDITION), DELTA);
    }

    @Test
    void calculate_SumOfNegativeAndPositiveNumbers_Ok() {
        assertEquals(SUM_OF_NEGATIVE_AND_POSITIVE, helloWorld.calculate(SECOND_NEGATIVE_VALUE,
                FIRST_POSITIVE_VALUE, ADDITION), DELTA);
    }

    @Test
    void calculate_SumOfZeroInDifferentPlaces_Ok() {
        assertEquals(FIRST_POSITIVE_VALUE, helloWorld.calculate(ZERO,
                FIRST_POSITIVE_VALUE, ADDITION), DELTA);
        assertEquals(FIRST_POSITIVE_VALUE, helloWorld.calculate(FIRST_POSITIVE_VALUE,
                ZERO, ADDITION), DELTA);
    }

    @Test
    void calculate_SumWithMaxAndMinDoubleValues_Ok() {
        assertEquals(SUM_OF_MAX_AND_MIN, helloWorld.calculate(MAX_DOUBLE,
                MIN_DOUBLE, ADDITION), DELTA);
    }

    @Test
    void calculate_SubtractionOfTwoPositiveNumbers_Ok() {
        assertEquals(SUBTRACTION_OF_TWO_POSITIVE, helloWorld.calculate(FIRST_POSITIVE_VALUE,
                SECOND_POSITIVE_VALUE, SUBTRACTION), DELTA);
    }

    @Test
    void calculate_SubtractionOfTwoNegativeNumbers_Ok() {
        assertEquals(SUBTRACTION_OF_TWO_NEGATIVE, helloWorld.calculate(FIRST_NEGATIVE_VALUE,
                SECOND_NEGATIVE_VALUE, SUBTRACTION), DELTA);
    }

    @Test
    void calculate_SubtractionOfNegativeAndPositiveNumbers_Ok() {
        assertEquals(SUBTRACTION_OF_NEGATIVE_AND_POSITIVE,
                helloWorld.calculate(FIRST_NEGATIVE_VALUE,
                FIRST_POSITIVE_VALUE, SUBTRACTION), DELTA);
    }

    @Test
    void calculate_SubtractionOfZeroInDifferentPlaces_Ok() {
        assertEquals(FIRST_POSITIVE_VALUE * (-1), helloWorld.calculate(ZERO,
                FIRST_POSITIVE_VALUE, SUBTRACTION), DELTA);
        assertEquals(FIRST_POSITIVE_VALUE, helloWorld.calculate(FIRST_POSITIVE_VALUE,
                ZERO, SUBTRACTION), DELTA);
    }

    @Test
    void calculate_SubtractionWithMaxAndMinDoubleValues_Ok() {
        assertEquals(SUBTRACTION_OF_MAX_AND_MIN, helloWorld.calculate(MAX_DOUBLE,
                MIN_DOUBLE, SUBTRACTION), DELTA);
    }

    @Test
    void calculate_MultiplicationOfTwoPositiveNumbers_Ok() {
        assertEquals(MULTIPLICATION_OF_TWO_POSITIVE, helloWorld.calculate(FIRST_POSITIVE_VALUE,
                SECOND_POSITIVE_VALUE, MULTIPLICATION), DELTA);
    }

    @Test
    void calculate_MultiplicationOfTwoNegativeNumbers_Ok() {
        assertEquals(MULTIPLICATION_OF_TWO_NEGATIVE, helloWorld.calculate(FIRST_NEGATIVE_VALUE,
                SECOND_NEGATIVE_VALUE, MULTIPLICATION), DELTA);
    }

    @Test
    void calculate_MultiplicationOfNegativeAndPositiveNumbers_Ok() {
        assertEquals(MULTIPLICATION_OF_NEGATIVE_AND_POSITIVE,
                helloWorld.calculate(FIRST_POSITIVE_VALUE,
                FIRST_NEGATIVE_VALUE, MULTIPLICATION), DELTA);
    }

    @Test
    void calculate_MultiplicationOfZeroInDifferentPlaces_Ok() {
        assertEquals(ZERO, helloWorld.calculate(ZERO,
                FIRST_POSITIVE_VALUE, MULTIPLICATION), DELTA);
        assertEquals(ZERO, helloWorld.calculate(FIRST_POSITIVE_VALUE,
                ZERO, MULTIPLICATION), DELTA);
    }

    @Test
    void calculate_MultiplicationWithMaxAndMinDoubleValues_Ok() {
        assertEquals(MULTIPLICATION_OF_MAX_AND_MIN, helloWorld.calculate(MAX_DOUBLE,
                MIN_DOUBLE, MULTIPLICATION), DELTA);
    }

    @Test
    void calculate_DivisionOfTwoPositiveNumbers_Ok() {
        assertEquals(DIVISION_OF_TWO_POSITIVE, helloWorld.calculate(FIRST_POSITIVE_VALUE,
                SECOND_POSITIVE_VALUE, DIVISION), DELTA);
    }

    @Test
    void calculate_DivisionOfTwoNegativeNumbers_Ok() {
        assertEquals(DIVISION_OF_TWO_NEGATIVE, helloWorld.calculate(FIRST_NEGATIVE_VALUE,
                SECOND_NEGATIVE_VALUE, DIVISION), DELTA);
    }

    @Test
    void calculate_DivisionOfNegativeAndPositiveNumbers_Ok() {
        assertEquals(DIVISION_OF_NEGATIVE_AND_POSITIVE,
                helloWorld.calculate(FIRST_POSITIVE_VALUE,
                FIRST_NEGATIVE_VALUE, DIVISION), DELTA);
    }

    @Test
    void calculate_DivisionOfZeroInDifferentPlaces_Ok() {
        assertEquals(ZERO, helloWorld.calculate(ZERO,
                FIRST_POSITIVE_VALUE, DIVISION), DELTA);
        assertThrows(IllegalArgumentException.class, () -> {
            helloWorld.calculate(FIRST_POSITIVE_VALUE, ZERO, DIVISION);
        });
    }

    @Test
    void calculate_DivisionWithMaxAndMinDoubleValues_Ok() {
        assertEquals(DIVISION_OF_MAX_AND_MIN, helloWorld.calculate(MAX_DOUBLE,
                MIN_DOUBLE, DIVISION), DELTA);
    }

    @Test
    void calculate_RaisingPositiveAndNegativeValueToPositive_Ok() {
        assertEquals(RAISE_POSITIVE_TO_POSITIVE, helloWorld.calculate(FIRST_POSITIVE_VALUE,
                FIRST_POSITIVE_VALUE, POWER), DELTA);
        assertEquals(RAISE_NEGATIVE_TO_POSITIVE, helloWorld.calculate(SECOND_NEGATIVE_VALUE,
                FIRST_POSITIVE_VALUE, POWER), DELTA);
    }

    @Test
    void calculate_RaisingPositiveAndNegativeValueToNegative_Ok() {
        assertEquals(RAISE_POSITIVE_TO_NEGATIVE, helloWorld.calculate(FIRST_POSITIVE_VALUE,
                SECOND_NEGATIVE_VALUE, POWER), DELTA);
        assertEquals(RAISE_NEGATIVE_TO_NEGATIVE, helloWorld.calculate(SECOND_NEGATIVE_VALUE,
                SECOND_NEGATIVE_VALUE, POWER), DELTA);
    }

    @Test
    void calculate_RaisingPositiveAndNegativeValueToZero_Ok() {
        assertEquals(RAISE_TO_ZERO, helloWorld.calculate(FIRST_POSITIVE_VALUE,
                ZERO, POWER), DELTA);
        assertEquals(RAISE_TO_ZERO, helloWorld.calculate(SECOND_NEGATIVE_VALUE,
                ZERO, POWER), DELTA);
    }

    @Test
    void calculate_RaisingZeroToPower_Ok() {
        assertEquals(ZERO, helloWorld.calculate(ZERO,
                FIRST_POSITIVE_VALUE, POWER), DELTA);
    }

    @Test
    void calculate_illegalOperation_Ok() {
        assertThrows(IllegalArgumentException.class, () -> {
            helloWorld.calculate(FIRST_NEGATIVE_VALUE, SECOND_POSITIVE_VALUE, ILLEGAL_OPERATION);
        });
    }
}
