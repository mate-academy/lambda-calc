package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DividingTest {
    private static final double DELTA = 0.001;
    private static final double MAX = Double.MAX_VALUE;
    private static final double MIN = Double.MIN_VALUE;
    private static final char DIVIDE = '/';
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
    void divisionWithTwoElementsPositive_Ok() {
        double actual = calculator.calculate(firstElement, secondElement, DIVIDE);
        double expected = firstElement / secondElement;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithTwoElementsNegative_Ok() {
        double actual = calculator.calculate(-firstElement, -secondElement, DIVIDE);
        double expected = firstElement / secondElement;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionWithOneElementNegative_Ok() {
        double actual = calculator.calculate(firstElement, -secondElement, DIVIDE);
        double expected = firstElement / (-secondElement);
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void divisionOnZero_NotOk() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(firstElement, 0, DIVIDE);
        });
    }

    @Test
    void divisionWithZeroOnSecondElement_Ok() {
        double actual = calculator.calculate(0, secondElement, DIVIDE);
        double expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void divisionWithMaxDoubleValue_Ok() {
        double actual = calculator.calculate(MAX, firstElement, DIVIDE);
        double expected = MAX / firstElement;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void divisionWithMinDoubleValue_Ok() {
        double actual = calculator.calculate(MIN, secondElement, DIVIDE);
        double expected = MIN / secondElement;
        Assertions.assertEquals(expected, actual);
    }
}
