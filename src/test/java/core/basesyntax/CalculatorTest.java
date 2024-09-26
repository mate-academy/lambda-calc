package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;
    private static int numberFirst;
    private static int numberSecond;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void additionPositiveValues() {
        int numberFirst = 5;
        int numberSecond = 15;
        double expected = 20.0;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void additionNegativeValues() {
        numberFirst = -5;
        numberSecond = -10;
        double expected = -15.0;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void additionMaxValue() {
        numberFirst = Integer.MAX_VALUE;
        numberSecond = 5;
        assertThrows(CalculatorException.class, () ->
                        calculator.calculate(numberFirst, numberSecond, ArephmeticActs.PLUS)
        );
    }

    @Test
    void additionMinValue() {
        numberFirst = Integer.MIN_VALUE;
        numberSecond = Integer.MIN_VALUE;
        assertThrows(CalculatorException.class, () ->
                calculator.calculate(numberFirst, numberSecond, ArephmeticActs.PLUS)
        );
    }

    @Test
    void additionPositiveAndNegative() {
        numberFirst = 55;
        numberSecond = -100;
        double expected = -45.0;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void additionWithZeroOnFirst() {
        numberFirst = 0;
        numberSecond = 89;
        double expected = 89;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void additionWithZeroOnSecond() {
        numberFirst = 89;
        numberSecond = 0;
        double expected = 89;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.PLUS);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionPositiveValues() {
        numberFirst = 5;
        numberSecond = 15;
        double expected = -10.0;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionNegativeValues() {
        numberFirst = -5;
        numberSecond = -10;
        double expected = 5.0;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionMaxValue() {
        numberFirst = Integer.MAX_VALUE;
        numberSecond = Integer.MAX_VALUE;
        double expected = 0;
        double actual = calculator.calculate(numberFirst, numberSecond,ArephmeticActs.MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionMinValue() {
        numberFirst = Integer.MIN_VALUE;
        numberSecond = Integer.MIN_VALUE;

        double expected = 0;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionPositiveAndNegative() {
        numberFirst = 55;
        numberSecond = -100;
        double expected = 155;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithZeroOnFirst() {
        numberFirst = 0;
        numberSecond = 89;
        double expected = -89;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void subtractionWithZeroOnSecond() {
        numberFirst = 89;
        numberSecond = 0;
        double expected = 89;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.MINUS);
        assertEquals(expected, actual);
    }

    @Test
    void multiplyPositiveValues() {
        numberFirst = 5;
        numberSecond = 15;
        double expected = 75;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void multiplyNegativeValues() {
        numberFirst = -5;
        numberSecond = -10;
        double expected = 50.0;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void multiplyMaxValue() {
        numberFirst = Integer.MAX_VALUE;
        numberSecond = Integer.MAX_VALUE;
        assertThrows(CalculatorException.class, () ->
                calculator.calculate(numberFirst, numberSecond, ArephmeticActs.MULTIPLY)
        );
    }

    @Test
    void multiplyMinValue() {
        numberFirst = Integer.MIN_VALUE;
        numberSecond = Integer.MIN_VALUE;
        assertThrows(CalculatorException.class, () ->
                calculator.calculate(numberFirst, numberSecond, ArephmeticActs.MULTIPLY)
        );
    }

    @Test
    void multiplyPositiveAndNegative() {
        numberFirst = 55;
        numberSecond = -100;
        double expected = -5500.0;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void multiplyWithZeroOnFirst() {
        numberFirst = 0;
        numberSecond = 85;
        double expected = 0;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void multiplyWithZeroOnSecond() {
        numberFirst = 89;
        numberSecond = 0;
        double expected = 0;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.MULTIPLY);
        assertEquals(expected, actual);
    }

    @Test
    void divisionPositiveValues() {
        numberFirst = 5;
        numberSecond = 16;
        double expected = 0.3125;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void divisionNegativeValues() {
        numberFirst = -5;
        numberSecond = -10;
        double expected = 0.5;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void divisionMaxValue() {
        numberFirst = Integer.MAX_VALUE;
        numberSecond = Integer.MAX_VALUE;
        double expected = 1;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void divisionMinValue() {
        numberFirst = Integer.MIN_VALUE;
        numberSecond = Integer.MIN_VALUE;
        double expected = 1;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void divisionPositiveAndNegative() {
        numberFirst = 55;
        numberSecond = -100;
        double expected = -0.55;
        double actual = calculator.calculate(numberFirst, numberSecond, ArephmeticActs.DIVIDE);
        assertEquals(expected, actual);
    }

    @Test
    void divisionWithZeroOnFirst() {
        numberFirst = 0;
        numberSecond = 89;
        assertThrows(CalculatorException.class, () ->
                calculator.calculate(numberFirst, numberSecond, ArephmeticActs.DIVIDE)
        );
    }

    @Test
    void divisionWithZeroOnSecond() {
        numberFirst = 50;
        numberSecond = 0;
        assertThrows(CalculatorException.class, () ->
                calculator.calculate(numberFirst, numberSecond, ArephmeticActs.DIVIDE)
        );
    }

    @Test
    void positiveValuesOnPositivePower() {
        numberFirst = 5;
        numberSecond = 3;
        double expected = 125;
        double actual = calculator.calculate(numberFirst, numberSecond,
                ArephmeticActs.POWER);
        assertEquals(expected, actual);
    }

    @Test
    void negativeValuesOnPositivePower() {
        numberFirst = -5;
        numberSecond = 3;
        double expected = -125.0;
        double actual = calculator.calculate(numberFirst, numberSecond,
                ArephmeticActs.POWER);
        assertEquals(expected, actual);
    }

    @Test
    void valueOnMaxPower() {
        numberFirst = Integer.MAX_VALUE;
        numberSecond = Integer.MAX_VALUE;
        assertThrows(CalculatorException.class, () ->
                calculator.calculate(numberFirst, numberSecond, ArephmeticActs.POWER)
        );
    }

    @Test
    void positiveValueOnNegativePower() {
        numberFirst = 5;
        numberSecond = -2;
        double expected = 0.04;
        double actual = calculator.calculate(numberFirst, numberSecond,
                ArephmeticActs.POWER);
        assertEquals(expected, actual);
    }

    @Test
    void valueZeroOnPower() {
        numberFirst = 0;
        numberSecond = 89;
        double expected = 0;
        double actual = calculator.calculate(numberFirst, numberSecond,
                ArephmeticActs.POWER);
        assertEquals(expected, actual);
    }

    @Test
    void valueOnPowerZero() {
        numberFirst = 89;
        numberSecond = 0;
        double expected = 1;
        double actual = calculator.calculate(numberFirst, numberSecond,
                ArephmeticActs.POWER);
        assertEquals(expected, actual);
    }

    @Test
    void actionNull() {
        assertThrows(NullPointerException.class, () ->
                calculator.calculate(4, 9, null)
        );
    }

    @AfterAll
    static void afterAll() {
        calculator = null;
    }
}
