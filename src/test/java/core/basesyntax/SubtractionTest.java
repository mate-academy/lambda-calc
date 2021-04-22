package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SubtractionTest {
    private static final double DELTA = 0.001;
    private static final double MAX = Double.MAX_VALUE;
    private static final double MIN = Double.MIN_VALUE;
    private static final double ZERO = 0;
    private static final char SUBTRACTION = '-';
    private static Calculator calculator;
    private static double firstElement;
    private static double secondElement;

    @BeforeAll
    static void beforeAll() {
        calculator = new CalculatorImpl();
        firstElement = 2.02432;
        secondElement = 1.04321;
    }

    @Test
    void subtractionWithTwoElementPositive_Ok() {
        double actual = calculator.calculate(firstElement, secondElement, SUBTRACTION);
        double expected = firstElement - secondElement;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithTwoElementNegative_Ok() {
        double actual = calculator.calculate(-firstElement, -secondElement, SUBTRACTION);
        double expected = -firstElement + secondElement;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithOneElementNegative_Ok() {
        double actual = calculator.calculate(firstElement, -secondElement, SUBTRACTION);
        double expected = firstElement + secondElement;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtractionWithSecondElementZero_Ok() {
        double actual = calculator.calculate(firstElement, ZERO, SUBTRACTION);
        double expected = firstElement;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subtractionWithFirstElementZero_Ok() {
        double actual = calculator.calculate(ZERO, secondElement, SUBTRACTION);
        double expected = -secondElement;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subtractionWithMaxDoubleValueAndPositiveOne_Ok() {
        double actual = calculator.calculate(MAX, firstElement, SUBTRACTION);
        double expected = MAX - firstElement;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subtractionWithMaxDoubleValueAndNegativeOne_Ok() {
        double actual = calculator.calculate(MAX, -firstElement, SUBTRACTION);
        double expected = MAX + firstElement;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subtractionWithMinDoubleValue_Ok() {
        double actual = calculator.calculate(MIN, firstElement, SUBTRACTION);
        double expected = -firstElement;
        Assertions.assertEquals(expected, actual);
    }
}
