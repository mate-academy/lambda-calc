package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AdditionalTest {
    private static final double DELTA = 0.001;
    private static final double MAX = Double.MAX_VALUE;
    private static final double MIN = Double.MIN_VALUE;
    private static final char ADDITION = '+';
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
    void additionalWithTwoPositive_Ok() {
        double actual = calculator.calculate(firstElement, secondElement, ADDITION);
        double expected = firstElement + secondElement;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionalWithTwoNegative_Ok() {
        double actual = calculator.calculate(-firstElement, -secondElement, ADDITION);
        double expected = -firstElement - secondElement;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionalWithOneNegativeElement_Ok() {
        double actual = calculator.calculate(firstElement, -secondElement, ADDITION);
        double expected = firstElement - secondElement;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void additionalWithFirstElementZero_Ok() {
        double actual = calculator.calculate(firstElement, 0, ADDITION);
        double expected = firstElement;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void additionalWithSecondElementZero_Ok() {
        double actual = calculator.calculate(0, secondElement, ADDITION);
        double expected = secondElement;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void additionalWithMaxDoubleValueAndZero_Ok() {
        double actual = calculator.calculate(MAX, 0, ADDITION);
        double expected = MAX;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void additionalWithMaxDoubleValue_Ok() {
        double actual = calculator.calculate(MAX, secondElement, ADDITION);
        double expected = MAX + secondElement;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void additionalMaxDoubleToMaxDouble_Ok() {
        double actual = calculator.calculate(MAX, MAX, ADDITION);
        double expected = MAX + MAX;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void additionalWithMinDoubleValue_Ok() {
        double actual = calculator.calculate(MIN, firstElement, ADDITION);
        double expected = firstElement;
        Assertions.assertEquals(expected, actual);
    }
}
