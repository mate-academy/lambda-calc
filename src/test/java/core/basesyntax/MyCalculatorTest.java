package core.basesyntax;

import static java.lang.Double.MAX_VALUE;
import static java.lang.Double.MIN_VALUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MyCalculatorTest {
    private static Calculator myCalculatorTest;
    private static final double DELTA = 0.00001;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char RAISING_TO_A_POWER = '^';
    private double actual;
    private double expected;

    @BeforeAll
    static void beforeAll() {
        myCalculatorTest = new MyCalculator();
    }

    @Test
    void addition_PositiveNumbers_Ok() {
        expected = 155.5;
        actual = myCalculatorTest.calculate(90.5, ADDITION, 65.0);
        assertEquals(expected, actual);
    }

    @Test
    void addition_NegativeNumbers_Ok() {
        expected = -241.1;
        actual = myCalculatorTest.calculate(-177.6, ADDITION, -63.5);
        assertEquals(expected, actual);
    }

    @Test
    void addition_PositiveAndNegativeNumbers_Ok() {
        expected = 136.5;
        actual = myCalculatorTest.calculate(200.0, ADDITION, -63.5);
        assertEquals(expected, actual);
    }

    @Test
    void addition_ZeroFirstNumberPosition_Ok() {
        expected = -77;
        actual = myCalculatorTest.calculate(0, ADDITION, -77.0);
        assertEquals(expected, actual);
    }

    @Test
    void addition_ZeroSecondNumberPosition_Ok() {
        expected = 200;
        actual = myCalculatorTest.calculate(200.0, ADDITION, 0);
        assertEquals(expected, actual);
    }

    @Test
    void addition_MaxValues_NotOk() {
        assertThrows(OperationTypeException.class, () ->
                myCalculatorTest.calculate(MAX_VALUE, ADDITION, MAX_VALUE));
    }

    @Test
    void addition_MinValues_Ok() {
        expected = 0;
        actual = myCalculatorTest.calculate(MIN_VALUE, ADDITION, MIN_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void subtraction_PositiveNumbers_Ok() {
        expected = 25.5;
        actual = myCalculatorTest.calculate(90.5, SUBTRACTION, 65.0);
        assertEquals(expected, actual);
    }

    @Test
    void subtraction_NegativeNumbers_Ok() {
        expected = -114.1;
        actual = myCalculatorTest.calculate(-177.6, SUBTRACTION, -63.5);
        assertEquals(expected, actual);
    }

    @Test
    void subtraction_PositiveAndNegativeNumbers_Ok() {
        expected = 263.5;
        actual = myCalculatorTest.calculate(200.0, SUBTRACTION, -63.5);
        assertEquals(expected, actual);
    }

    @Test
    void subtraction_ZeroFirstNumberPosition_Ok() {
        expected = 77.0;
        actual = myCalculatorTest.calculate(0, SUBTRACTION, -77.0);
        assertEquals(expected, actual);
    }

    @Test
    void subtraction_ZeroSecondNumberPosition_Ok() {
        expected = 200;
        actual = myCalculatorTest.calculate(200.0, SUBTRACTION, 0);
        assertEquals(expected, actual);
    }

    @Test
    void subtraction_MaxValues_Ok() {
        expected = 0;
        actual = myCalculatorTest.calculate(MAX_VALUE, SUBTRACTION, MAX_VALUE);
        assertEquals(expected, actual);
    }

    @Test
    void subtraction_MinValues_Ok() {
        expected = 0;
        actual = myCalculatorTest.calculate(MIN_VALUE, SUBTRACTION, MIN_VALUE);
        assertEquals(expected, actual);
    }

    @Test
    void multiplication_PositiveNumbers_Ok() {
        expected = 50.0;
        actual = myCalculatorTest.calculate(10.0, MULTIPLICATION, 5.0);
        assertEquals(expected, actual);
    }

    @Test
    void multiplication_NegativeNumbers_Ok() {
        expected = 50.0;
        actual = myCalculatorTest.calculate(-10.0, MULTIPLICATION, -5.0);
        assertEquals(expected, actual);
    }

    @Test
    void multiplication_PositiveAndNegativeNumbers_Ok() {
        expected = -1000.0;
        actual = myCalculatorTest.calculate(200.0, MULTIPLICATION, -5.0);
        assertEquals(expected, actual);
    }

    @Test
    void multiplication_ZeroFirstNumberPosition_Ok() {
        expected = 0;
        actual = myCalculatorTest.calculate(0, MULTIPLICATION, 77.0);
        assertEquals(expected, actual);
    }

    @Test
    void multiplication_ZeroSecondNumberPosition_Ok() {
        expected = 0;
        actual = myCalculatorTest.calculate(200.0, MULTIPLICATION, 0);
        assertEquals(expected, actual);
    }

    @Test
    void multiplication_MaxValues_NotOk() {
        assertThrows(OperationTypeException.class, () ->
                myCalculatorTest.calculate(MAX_VALUE, MULTIPLICATION, MAX_VALUE));
    }

    @Test
    void multiplication_MinValues_Ok() {
        expected = 0;
        actual = myCalculatorTest.calculate(MIN_VALUE, MULTIPLICATION, MIN_VALUE);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void division_PositiveNumbers_Ok() {
        expected = 1.3923;
        actual = myCalculatorTest.calculate(90.5, DIVISION, 65.0);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void division_NegativeNumbers_Ok() {
        expected = 4.0;
        actual = myCalculatorTest.calculate(-20.0, DIVISION, -5.0);
        assertEquals(expected, actual);
    }

    @Test
    void division_PositiveAndNegativeNumbers_Ok() {
        expected = -4.0;
        actual = myCalculatorTest.calculate(20.0, DIVISION, -5.0);
        assertEquals(expected, actual);
    }

    @Test
    void division_ZeroFirstNumberPosition_Ok() {
        expected = 0;
        actual = myCalculatorTest.calculate(0, DIVISION, 77.0);
        assertEquals(expected, actual);
    }

    @Test
    void division_ZeroSecondNumberPosition_NotOk() {
        assertThrows(OperationTypeException.class, () ->
                myCalculatorTest.calculate(200.0, DIVISION, 0));
    }

    @Test
    void division_MaxValues_Ok() {
        expected = 1.0;
        actual = myCalculatorTest.calculate(MAX_VALUE, DIVISION, MAX_VALUE);
        assertEquals(expected, actual);
    }

    @Test
    void division_MinValues_Ok() {
        expected = 1.0;
        actual = myCalculatorTest.calculate(MIN_VALUE, DIVISION, MIN_VALUE);
        assertEquals(expected, actual);
    }

    @Test
    void raising_PositiveValue_PositivePower_Ok() {
        expected = 400.0;
        actual = myCalculatorTest.calculate(20.0, RAISING_TO_A_POWER, 2.0);
        assertEquals(expected, actual);
    }

    @Test
    void raising_NegativeValue_PositivePower_Ok() {
        expected = 400.0;
        actual = myCalculatorTest.calculate(-20.0, RAISING_TO_A_POWER, 2.0);
        assertEquals(expected, actual);
    }

    @Test
    void raising_PositiveValue_NegativePower_Ok() {
        expected = 0.0025;
        actual = myCalculatorTest.calculate(20.0, RAISING_TO_A_POWER, -2.0);
        assertEquals(expected, actual);
    }

    @Test
    void raising_NegativeValue_NegativePower_Ok() {
        expected = 0.0025;
        actual = myCalculatorTest.calculate(-20.0, RAISING_TO_A_POWER, -2.0);
        assertEquals(expected, actual);
    }

    @Test
    void raising_PositiveValue_ZeroPower_Ok() {
        expected = 1.0;
        actual = myCalculatorTest.calculate(20.0, RAISING_TO_A_POWER, 0);
        assertEquals(expected, actual);
    }

    @Test
    void raising_NegativeValue_ZeroPower_Ok() {
        expected = 1.0;
        actual = myCalculatorTest.calculate(-20.0, RAISING_TO_A_POWER, 0);
        assertEquals(expected, actual);
    }

    @Test
    void raising_ZeroValue_PositivePower_Ok() {
        expected = 0;
        actual = myCalculatorTest.calculate(0, RAISING_TO_A_POWER, 2.0);
        assertEquals(expected, actual);
    }

    @Test
    void illegalOperation_NotOk() {
        assertThrows(OperationTypeException.class, () ->
                myCalculatorTest.calculate(65.0, '!', 50.0));
    }
}
