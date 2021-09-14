package core.basesyntax;

import static java.lang.Double.MAX_VALUE;
import static java.lang.Double.MIN_VALUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MyCalculatorTest {
    private static final double DELTA = 0.00001;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char RAISING_TO_A_POWER = '^';
    private static Calculator myCalculatorTest;
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        myCalculatorTest = new MyCalculator();
    }

    @Test
    void calculate_addPositiveNumbers_Ok() {
        expected = 155.5;
        actual = myCalculatorTest.calculate(90.5, ADDITION, 65.0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addNegativeNumbers_Ok() {
        expected = -241.1;
        actual = myCalculatorTest.calculate(-177.6, ADDITION, -63.5);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addPositiveAndNegativeNumbers_Ok() {
        expected = 136.5;
        actual = myCalculatorTest.calculate(200.0, ADDITION, -63.5);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addZeroFirstNumberPosition_Ok() {
        expected = -77;
        actual = myCalculatorTest.calculate(0, ADDITION, -77.0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addZeroSecondNumberPosition_Ok() {
        expected = 200;
        actual = myCalculatorTest.calculate(200.0, ADDITION, 0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_addMaxValues_NotOk() {
        assertThrows(OperationTypeException.class, () ->
                myCalculatorTest.calculate(MAX_VALUE, ADDITION, MAX_VALUE));
    }

    @Test
    void calculate_addMinValues_Ok() {
        expected = 0;
        actual = myCalculatorTest.calculate(MIN_VALUE, ADDITION, MIN_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionPositiveNumbers_Ok() {
        expected = 25.5;
        actual = myCalculatorTest.calculate(90.5, SUBTRACTION, 65.0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionNegativeNumbers_Ok() {
        expected = -114.1;
        actual = myCalculatorTest.calculate(-177.6, SUBTRACTION, -63.5);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionPositiveAndNegativeNumbers_Ok() {
        expected = 263.5;
        actual = myCalculatorTest.calculate(200.0, SUBTRACTION, -63.5);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionZeroFirstNumberPosition_Ok() {
        expected = 77.0;
        actual = myCalculatorTest.calculate(0, SUBTRACTION, -77.0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionZeroSecondNumberPosition_Ok() {
        expected = 200;
        actual = myCalculatorTest.calculate(200.0, SUBTRACTION, 0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMaxValues_Ok() {
        expected = 0;
        actual = myCalculatorTest.calculate(MAX_VALUE, SUBTRACTION, MAX_VALUE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionMinValues_Ok() {
        expected = 0;
        actual = myCalculatorTest.calculate(MIN_VALUE, SUBTRACTION, MIN_VALUE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationPositiveNumbers_Ok() {
        expected = 50.0;
        actual = myCalculatorTest.calculate(10.0, MULTIPLICATION, 5.0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationNegativeNumbers_Ok() {
        expected = 50.0;
        actual = myCalculatorTest.calculate(-10.0, MULTIPLICATION, -5.0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationPositiveAndNegativeNumbers_Ok() {
        expected = -1000.0;
        actual = myCalculatorTest.calculate(200.0, MULTIPLICATION, -5.0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationZeroFirstNumberPosition_Ok() {
        expected = 0;
        actual = myCalculatorTest.calculate(0, MULTIPLICATION, 77.0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationZeroSecondNumberPosition_Ok() {
        expected = 0;
        actual = myCalculatorTest.calculate(200.0, MULTIPLICATION, 0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationMaxValues_NotOk() {
        assertThrows(OperationTypeException.class, () ->
                myCalculatorTest.calculate(MAX_VALUE, MULTIPLICATION, MAX_VALUE));
    }

    @Test
    void calculate_multiplicationMinValues_Ok() {
        expected = 0;
        actual = myCalculatorTest.calculate(MIN_VALUE, MULTIPLICATION, MIN_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionPositiveNumbers_Ok() {
        expected = 1.3923;
        actual = myCalculatorTest.calculate(90.5, DIVISION, 65.0);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionNegativeNumbers_Ok() {
        expected = 4.0;
        actual = myCalculatorTest.calculate(-20.0, DIVISION, -5.0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionPositiveAndNegativeNumbers_Ok() {
        expected = -4.0;
        actual = myCalculatorTest.calculate(20.0, DIVISION, -5.0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionZeroFirstNumberPosition_Ok() {
        expected = 0;
        actual = myCalculatorTest.calculate(0, DIVISION, 77.0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionZeroSecondNumberPosition_NotOk() {
        assertThrows(OperationTypeException.class, () ->
                myCalculatorTest.calculate(200.0, DIVISION, 0));
    }

    @Test
    void calculate_divisionMaxValues_Ok() {
        expected = 1.0;
        actual = myCalculatorTest.calculate(MAX_VALUE, DIVISION, MAX_VALUE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionMinValues_Ok() {
        expected = 1.0;
        actual = myCalculatorTest.calculate(MIN_VALUE, DIVISION, MIN_VALUE);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveValuePositivePower_Ok() {
        expected = 400.0;
        actual = myCalculatorTest.calculate(20.0, RAISING_TO_A_POWER, 2.0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValuePositivePower_Ok() {
        expected = 400.0;
        actual = myCalculatorTest.calculate(-20.0, RAISING_TO_A_POWER, 2.0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveValueNegativePower_Ok() {
        expected = 0.0025;
        actual = myCalculatorTest.calculate(20.0, RAISING_TO_A_POWER, -2.0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueNegativePower_Ok() {
        expected = 0.0025;
        actual = myCalculatorTest.calculate(-20.0, RAISING_TO_A_POWER, -2.0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveValueZeroPower_Ok() {
        expected = 1.0;
        actual = myCalculatorTest.calculate(20.0, RAISING_TO_A_POWER, 0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueZeroPower_Ok() {
        expected = 1.0;
        actual = myCalculatorTest.calculate(-20.0, RAISING_TO_A_POWER, 0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZeroValuePositivePower_Ok() {
        expected = 0;
        actual = myCalculatorTest.calculate(0, RAISING_TO_A_POWER, 2.0);
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperation_NotOk() {
        assertThrows(OperationTypeException.class, () ->
                myCalculatorTest.calculate(65.0, '!', 50.0));
    }
}
