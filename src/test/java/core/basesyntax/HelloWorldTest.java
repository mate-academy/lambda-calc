package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {
    private static HelloWorld helloWorld;
    private static final double MAX_VALUE = Double.MAX_VALUE;
    private static final double MIN_VALUE = Double.MIN_VALUE;
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
        double actual = helloWorld.calculate(5,
                7, ADDITION);
        assertEquals(12, actual, DELTA);
    }

    @Test
    void calculate_SumOfTwoNegativeNumbers_Ok() {
        double actual = helloWorld.calculate(-12,
                -3, ADDITION);
        assertEquals(-15, actual, DELTA);
    }

    @Test
    void calculate_SumOfNegativeAndPositiveNumbers_Ok() {
        double actual = helloWorld.calculate(-3,
                5, ADDITION);
        assertEquals(2, actual, DELTA);
    }

    @Test
    void calculate_SumOf0InDifferentPlaces_Ok() {
        double actual = helloWorld.calculate(0,
                5, ADDITION);
        assertEquals(5, actual, DELTA);
        actual = helloWorld.calculate(5,
                0, ADDITION);
        assertEquals(5, actual, DELTA);
    }

    @Test
    void calculate_SumWithMaxAndMinDoubleValues_Ok() {
        double actual = helloWorld.calculate(MAX_VALUE,
                MIN_VALUE, ADDITION);
        assertEquals(MAX_VALUE, actual, DELTA);
        actual = helloWorld.calculate(MAX_VALUE,
                MAX_VALUE, ADDITION);
        assertEquals(Double.POSITIVE_INFINITY, actual, DELTA);
        actual = helloWorld.calculate(MIN_VALUE,
                MIN_VALUE, ADDITION);
        assertEquals(0, actual, DELTA);
    }

    @Test
    void calculate_SubtractionOfTwoPositiveNumbers_Ok() {
        double actual = helloWorld.calculate(5,
                7, SUBTRACTION);
        assertEquals(-2, actual, DELTA);
    }

    @Test
    void calculate_SubtractionOfTwoNegativeNumbers_Ok() {
        double actual = helloWorld.calculate(-12,
                -3, SUBTRACTION);
        assertEquals(-9, actual, DELTA);
    }

    @Test
    void calculate_SubtractionOfNegativeAndPositiveNumbers_Ok() {
        double actual = helloWorld.calculate(-12,
                5, SUBTRACTION);
        assertEquals(-17, actual, DELTA);
    }

    @Test
    void calculate_SubtractionOf0InDifferentPlaces_Ok() {
        double actual = helloWorld.calculate(0,
                5, SUBTRACTION);
        assertEquals(5 * (-1), actual, DELTA);
        actual = helloWorld.calculate(5,
                0, SUBTRACTION);
        assertEquals(5, actual, DELTA);
    }

    @Test
    void calculate_SubtractionWithMaxAndMinDoubleValues_Ok() {
        double actual = helloWorld.calculate(MAX_VALUE,
                MIN_VALUE, SUBTRACTION);
        assertEquals(MAX_VALUE, actual, DELTA);
        actual = helloWorld.calculate(-MAX_VALUE,
                MAX_VALUE, SUBTRACTION);
        assertEquals(Double.NEGATIVE_INFINITY, actual, DELTA);
        actual = helloWorld.calculate(MAX_VALUE,
                MAX_VALUE, SUBTRACTION);
        assertEquals(0, actual, DELTA);
        actual = helloWorld.calculate(MIN_VALUE,
                MIN_VALUE, SUBTRACTION);
        assertEquals(0, actual, DELTA);
    }

    @Test
    void calculate_MultiplicationOfTwoPositiveNumbers_Ok() {
        double actual = helloWorld.calculate(5,
                7, MULTIPLICATION);
        assertEquals(35, actual, DELTA);
    }

    @Test
    void calculate_MultiplicationOfTwoNegativeNumbers_Ok() {
        double actual = helloWorld.calculate(-12,
                -3, MULTIPLICATION);
        assertEquals(36, actual, DELTA);
    }

    @Test
    void calculate_MultiplicationOfNegativeAndPositiveNumbers_Ok() {
        double actual = helloWorld.calculate(5,
                -12, MULTIPLICATION);
        assertEquals(-60, actual, DELTA);
    }

    @Test
    void calculate_MultiplicationOf0InDifferentPlaces_Ok() {
        double actual = helloWorld.calculate(0,
                5, MULTIPLICATION);
        assertEquals(0, actual, DELTA);
        actual = helloWorld.calculate(5,
                0, MULTIPLICATION);
        assertEquals(0, actual, DELTA);
    }

    @Test
    void calculate_MultiplicationWithMaxAndMinDoubleValues_Ok() {
        double actual = helloWorld.calculate(MAX_VALUE,
                MIN_VALUE, MULTIPLICATION);
        assertEquals(0, actual, DELTA);
        actual = helloWorld.calculate(MAX_VALUE,
                MAX_VALUE, MULTIPLICATION);
        assertEquals(Double.POSITIVE_INFINITY, actual, DELTA);
        actual = helloWorld.calculate(MIN_VALUE,
                MIN_VALUE, MULTIPLICATION);
        assertEquals(0, actual, DELTA);
    }

    @Test
    void calculate_DivisionOfTwoPositiveNumbers_Ok() {
        double actual = helloWorld.calculate(5,
                7, DIVISION);
        assertEquals(0.7142857142857143, actual, DELTA);
    }

    @Test
    void calculate_DivisionOfTwoNegativeNumbers_Ok() {
        double actual = helloWorld.calculate(-12,
                -3, DIVISION);
        assertEquals(4, actual, DELTA);
    }

    @Test
    void calculate_DivisionOfNegativeAndPositiveNumbers_Ok() {
        double actual = helloWorld.calculate(5,
                -12, DIVISION);
        assertEquals(-0.4166666666666667, actual, DELTA);
    }

    @Test
    void calculate_DivisionOf0InDifferentPlaces_Ok() {
        double actual = helloWorld.calculate(0,
                5, DIVISION);
        assertEquals(0, actual, DELTA);
        assertThrows(IllegalArgumentException.class, () -> {
            helloWorld.calculate(5, 0, DIVISION);
        });
    }

    @Test
    void calculate_DivisionWithMaxAndMinDoubleValues_Ok() {
        double actual = helloWorld.calculate(MAX_VALUE,
                MIN_VALUE, DIVISION);
        assertEquals(Double.POSITIVE_INFINITY, actual, DELTA);
        actual = helloWorld.calculate(MAX_VALUE,
                MAX_VALUE, DIVISION);
        assertEquals(1, actual, DELTA);
        actual = helloWorld.calculate(MIN_VALUE,
                MIN_VALUE, DIVISION);
        assertEquals(1, actual, DELTA);
        actual = helloWorld.calculate(MIN_VALUE,
                MAX_VALUE, DIVISION);
        assertEquals(0, actual, DELTA);
    }

    @Test
    void calculate_RaisingPositiveAndNegativeValueToPositive_Ok() {
        double actual = helloWorld.calculate(5,
                5, POWER);
        assertEquals(3125, actual, DELTA);
        actual = helloWorld.calculate(-3,
                5, POWER);
        assertEquals(-243, actual, DELTA);
    }

    @Test
    void calculate_RaisingPositiveAndNegativeValueToNegative_Ok() {
        double actual = helloWorld.calculate(5,
                -3, POWER);
        assertEquals(0.008, actual, DELTA);
        actual = helloWorld.calculate(-3,
                -3, POWER);
        assertEquals(-0.037037037037037, actual, DELTA);
    }

    @Test
    void calculate_RaisingPositiveAndNegativeValueTo0_Ok() {
        double actual = helloWorld.calculate(5,
                0, POWER);
        assertEquals(1, actual, DELTA);
        actual = helloWorld.calculate(-3,
                0, POWER);
        assertEquals(1, actual, DELTA);
    }

    @Test
    void calculate_Raising0ToPower_Ok() {
        double actual = helloWorld.calculate(0,
                5, POWER);
        assertEquals(0, actual, DELTA);
        actual = helloWorld.calculate(0,
                -3, POWER);
        assertEquals(Double.POSITIVE_INFINITY, actual, DELTA);
    }

    @Test
    void calculate_illegalOperation_Ok() {
        assertThrows(IllegalArgumentException.class, () -> {
            helloWorld.calculate(-12, 7, '#');
        });
    }
}
