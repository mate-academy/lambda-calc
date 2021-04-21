package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MultiplyTest {
    private static final double DELTA = 0.001;
    private static final double MAX = Double.MAX_VALUE;
    private static final double MIN = Double.MIN_VALUE;
    private static final char MULTIPLY = '*';
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
    void multiplicationWithTwoElementsPositive_Ok() {
        double actual = calculator.calculate(firstElement, secondElement, MULTIPLY);
        double expected = firstElement * secondElement;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithTwoElementsNegative_Ok() {
        double actual = calculator.calculate(-firstElement, -secondElement, MULTIPLY);
        double expected = firstElement * secondElement;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithOneElementNegative_Ok() {
        double actual = calculator.calculate(firstElement, -secondElement, MULTIPLY);
        double expected = firstElement * (-secondElement);
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void multiplicationWithFirstElementZero_Ok() {
        double actual = calculator.calculate(firstElement, 0, MULTIPLY);
        double expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithSecondElementZero_Ok() {
        double actual = calculator.calculate(0, secondElement, MULTIPLY);
        double expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithMaxDoubleValue_Ok() {
        double actual = calculator.calculate(MAX, firstElement, MULTIPLY);
        double expected = MAX * firstElement;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void multiplicationWithMinDoubleValue_Ok() {
        double actual = calculator.calculate(MIN, firstElement, MULTIPLY);
        double expected = MIN * firstElement;
        Assertions.assertEquals(expected, actual);
    }
}
