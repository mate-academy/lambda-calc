package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorTest {
    private double actual;
    private double expected;
    private final String additional = "Addition test failed ! Look difference";
    private final String subtraction = "Subtraction test failed ! Look difference";
    private final String multiplication = "Multiplication test failed ! Look difference";
    private final String division = "Division test failed ! Look difference";
    private final String risingPower = "Rising Power test failed ! Look difference";

    private final Calculator calculator = new Calculator();

    @Test
    void sumTwoPositiveNumbers_isOk() throws ValidationExceptions {
        actual = calculator.calculate(9.3,10.7,'+');
        expected = 20;
        assertEquals(expected, actual, additional);
    }

    @Test
    void sumTwoNegativeNumbers_isOk() throws ValidationExceptions {
        actual = calculator.calculate(-0.5,-0.7,'+');
        expected = -1.2;
        assertEquals(expected, actual, 0.0001, additional);
    }

    @Test
    void sumPositiveAndNegativeNumbers_isOk() throws ValidationExceptions {
        actual = calculator.calculate(4,-6.6,'+');
        expected = -2.6;
        assertEquals(expected, actual, 0.0001,additional);
    }

    @Test
    void additionWithZero_isOk() throws ValidationExceptions {
        actual = calculator.calculate(10.4,0,'+');
        expected = 10.4;
        assertEquals(expected, actual, additional);

        actual = calculator.calculate(0,0.5,'+');
        expected = 0.5;
        assertEquals(expected, actual, additional);

        actual = calculator.calculate(0,0,'+');
        expected = 0;
        assertEquals(expected, actual, additional);
    }

    @Test
    void aumMaxAndMinNumbers_isOk() throws ValidationExceptions {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '+');
        expected = Double.MIN_VALUE + Double.MAX_VALUE;
        assertEquals(expected, actual, additional);
    }

    // Subtraction tests
    @Test
    void subtractionTwoPositiveNumbers_isOk() throws ValidationExceptions {
        actual = calculator.calculate(9.3,10.7,'-');
        expected = -1.4;
        assertEquals(expected, actual, 0.0001,subtraction);
    }

    @Test
    void subtractionTwoNegativeNumbers_isOk() throws ValidationExceptions {
        actual = calculator.calculate(-100.8,-18.7,'-');
        expected = -82.1;
        assertEquals(expected, actual,subtraction);
    }

    @Test
    void subtractionPositiveAndNegativeNumbers_isOk() throws ValidationExceptions {
        actual = calculator.calculate(4,-6.6,'-');
        expected = 10.6;
        assertEquals(expected, actual, 0.0001,subtraction);
    }

    @Test
    void subtractionWithZero_isOk() throws ValidationExceptions {
        actual = calculator.calculate(10.4,0,'-');
        expected = 10.4;
        assertEquals(expected, actual, subtraction);

        actual = calculator.calculate(0,0.5,'-');
        expected = -0.5;
        assertEquals(expected, actual, subtraction);

        actual = calculator.calculate(0,0,'-');
        expected = 0;
        assertEquals(expected, actual, subtraction);
    }

    @Test
    void subtractionMaxAndMinNumbers_isOk() throws ValidationExceptions {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '-');
        expected = Double.MIN_VALUE - Double.MAX_VALUE;
        assertEquals(expected, actual, subtraction);
    }

    // Multiplication tests
    @Test
    void multiplicationTwoPositiveNumbers_isOk() throws ValidationExceptions {
        actual = calculator.calculate(9.3,10.7,'*');
        expected = 99.51;
        assertEquals(expected, actual,multiplication);
    }

    @Test
    void multiplicationTwoNegativeNumbers_isOk() throws ValidationExceptions {
        actual = calculator.calculate(-11.1,-11.1,'*');
        expected = 123.21;
        assertEquals(expected, actual,multiplication);
    }

    @Test
    void multiplicationPositiveAndNegativeNumbers_isOk() throws ValidationExceptions {
        actual = calculator.calculate(4,-6.6,'*');
        expected = -26.4;
        assertEquals(expected, actual, 0.0001,multiplication);
    }

    @Test
    void multiplicationWithZero_isOk() throws ValidationExceptions {
        actual = calculator.calculate(10.4,0,'*');
        expected = 0;
        assertEquals(expected, actual, multiplication);

        actual = calculator.calculate(0,0.5,'*');
        expected = 0;
        assertEquals(expected, actual, multiplication);

        actual = calculator.calculate(0,0,'*');
        expected = 0;
        assertEquals(expected, actual, multiplication);
    }

    @Test
    void multiplicationMaxAndMinNumbers_isOk() throws ValidationExceptions {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '*');
        expected = Double.MIN_VALUE * Double.MAX_VALUE;
        assertEquals(expected, actual, multiplication);
    }

    // Division tests
    @Test
    void divisionTwoPositiveNumbers_isOk() throws ValidationExceptions {
        actual = calculator.calculate(9.3,10.7,'/');
        expected = 0.869158878504673;
        assertEquals(expected, actual,division);
    }

    @Test
    void divisionTwoNegativeNumbers_isOk() throws ValidationExceptions {
        actual = calculator.calculate(-11.1,-11.1,'/');
        expected = 1.0;
        assertEquals(expected, actual,division);
    }

    @Test
    void divisionPositiveAndNegativeNumbers_isOk() throws ValidationExceptions {
        actual = calculator.calculate(10.5,-5.25,'/');
        expected = -2.0;
        assertEquals(expected, actual, 0.0001,division);
    }

    @Test
    void divisionZeroToNumber_isOk() throws ValidationExceptions {
        actual = calculator.calculate(0,0.5,'/');
        expected = 0;
        assertEquals(expected, actual, division);
    }

    @Test
    void divisionMaxAndMinNumbers_isOk() throws ValidationExceptions {
        actual = calculator.calculate(Double.MIN_VALUE, Double.MAX_VALUE, '/');
        expected = 0.0;
        assertEquals(expected, actual, division);
    }

    @Test
    void divisionByZero_isNotOk() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(0, 0, '/'));
    }

    // Raising operation
    @Test
    void raisingPositiveToPositive_isOk() throws ValidationExceptions {
        actual = calculator.calculate(2,3,'^');
        expected = 8;
        assertEquals(expected, actual,risingPower);
    }

    @Test
    void raisingNegativeToPositive_isOk() throws ValidationExceptions {
        actual = calculator.calculate(-2,3,'^');
        expected = -8;
        assertEquals(expected, actual,risingPower);
    }

    @Test
    void raisingPositiveToNegative_isOk() throws ValidationExceptions {
        actual = calculator.calculate(2,-3,'^');
        expected = 0.125;
        assertEquals(expected, actual,risingPower);
    }

    @Test
    void raisingNegativeToNegative_isOk() throws ValidationExceptions {
        actual = calculator.calculate(-2,-3,'^');
        expected = -0.125;
        assertEquals(expected, actual,risingPower);
    }

    @Test
    void raisingPositiveToZero_isOk() throws ValidationExceptions {
        actual = calculator.calculate(6,0,'^');
        expected = 1;
        assertEquals(expected, actual,risingPower);
    }

    @Test
    void raisingNegativeToZero_isOk() throws ValidationExceptions {
        actual = calculator.calculate(-4,0,'^');
        expected = 1;
        assertEquals(expected, actual,risingPower);
    }

    @Test
    void raisingZeroToPower_isOk() throws ValidationExceptions {
        actual = calculator.calculate(0,16,'^');
        expected = 0;
        assertEquals(expected, actual,risingPower);
    }

    // Illegal
    @Test
    void illegalOperation() {
        assertThrows(ValidationExceptions.class, () -> calculator.calculate(1, 0, '#'));
    }
}
