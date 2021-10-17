package core.basesyntax;

import exceptions.IllegalOperationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private final Calculator calculator = new Calculator();
    private final double posA = 5.923;
    private final double posB = 123.47;
    private final double negA = - 25.888;
    private final double negB = - 237.0052;
    private final double zero = 0;
    private final double minDouble = Double.MIN_VALUE;
    private final double maxDouble = Double.MAX_VALUE;

    @Test
    void adition_positive() throws IllegalOperationException {
        double expected = posA + posB;
        Double actual = calculator.calculate(posA, posB, '+');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void adition_negative() throws IllegalOperationException {
        double expected = negA + negB;
        Double actual = calculator.calculate(negA, negB, '+');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void adition_positive_negative() throws IllegalOperationException {
        double expected = posA + negB;
        Double actual = calculator.calculate(posA, negB, '+');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void adition_zero() throws IllegalOperationException {
        double expected = zero + posB;
        Double actual = calculator.calculate(zero, posB, '+');
        Assertions.assertEquals(expected, actual);

        expected = posA + zero;
        actual = calculator.calculate(posA, zero, '+');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void adition_max_min() throws IllegalOperationException {
        double expected = minDouble + minDouble;
        Double actual = calculator.calculate(minDouble, minDouble, '+');
        Assertions.assertEquals(expected, actual);

        expected = maxDouble + maxDouble;
        actual = calculator.calculate(maxDouble, maxDouble, '+');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subtraction_positive() throws IllegalOperationException {
        double expected = posA - posB;
        Double actual = calculator.calculate(posA, posB, '-');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subtraction_negative() throws IllegalOperationException {
        double expected = negA - negB;
        Double actual = calculator.calculate(negA, negB, '-');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subtraction_positive_negative() throws IllegalOperationException {
        double expected = posA - negB;
        Double actual = calculator.calculate(posA, negB, '-');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subtraction_zero() throws IllegalOperationException {
        double expected = zero - posB;
        Double actual = calculator.calculate(zero, posB, '-');
        Assertions.assertEquals(expected, actual);

        expected = posA - zero;
        actual = calculator.calculate(posA, zero, '-');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void subtraction_max_min() throws IllegalOperationException {
        double expected = 0;
        Double actual = calculator.calculate(minDouble, minDouble, '-');
        Assertions.assertEquals(expected, actual);

        expected = 0;
        actual = calculator.calculate(maxDouble, maxDouble, '-');
        Assertions.assertEquals(expected, actual);

        expected = maxDouble - minDouble;
        actual = calculator.calculate(maxDouble, minDouble, '-');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void division_positive() throws IllegalOperationException {
        double expected = posA / posB;
        Double actual = calculator.calculate(posA, posB, '/');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void division_negative() throws IllegalOperationException {
        double expected = negA / negB;
        Double actual = calculator.calculate(negA, negB, '/');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void division_positive_negative() throws IllegalOperationException {
        double expected = posA / negB;
        Double actual = calculator.calculate(posA, negB, '/');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void division_zero() throws IllegalOperationException {
        double expected = 0;
        Double actual = calculator.calculate(zero, posB, '/');
        Assertions.assertEquals(expected, actual);

        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(posA, zero, '/');
        });
    }

    @Test
    void division_max_min() throws IllegalOperationException {
        double expected = 1;
        Double actual = calculator.calculate(minDouble, minDouble, '/');
        Assertions.assertEquals(expected, actual);

        actual = calculator.calculate(maxDouble, maxDouble, '/');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void multiplication_positive() throws IllegalOperationException {
        double expected = posA * posB;
        Double actual = calculator.calculate(posA, posB, '*');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void multiplication_negative() throws IllegalOperationException {
        double expected = negA * negB;
        Double actual = calculator.calculate(negA, negB, '*');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void multiplication_positive_negative() throws IllegalOperationException {
        double expected = posA * negB;
        Double actual = calculator.calculate(posA, negB, '*');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void multiplication_zero() throws IllegalOperationException {
        double expected = 0;
        Double actual = calculator.calculate(zero, posB, '*');
        Assertions.assertEquals(expected, actual);

        actual = calculator.calculate(posA, zero, '*');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void multiplication_max_min() throws IllegalOperationException {
        double expected = minDouble * minDouble;
        Double actual = calculator.calculate(minDouble, minDouble, '*');
        Assertions.assertEquals(expected, actual);

        expected = maxDouble * maxDouble;
        actual = calculator.calculate(maxDouble, maxDouble, '*');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void power_positive() throws IllegalOperationException {
        double expected = Math.pow(posA, posB);
        Double actual = calculator.calculate(posA, posB, '^');
        Assertions.assertEquals(expected, actual);

        expected = Math.pow(negA, posB);
        actual = calculator.calculate(negA, posB, '^');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void power_negative() throws IllegalOperationException {
        double expected = Math.pow(negA, negB);
        Double actual = calculator.calculate(negA, negB, '^');
        Assertions.assertEquals(expected, actual);

        expected = Math.pow(posA, negB);
        actual = calculator.calculate(posA, negB, '^');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void power_zero() throws IllegalOperationException {
        double expected = Math.pow(zero, posB);
        Double actual = calculator.calculate(zero, posB, '^');
        Assertions.assertEquals(expected, actual);

        expected = Math.pow(posA, zero);
        actual = calculator.calculate(posA, zero, '^');
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void illegal_operation() {
        try {
            calculator.calculate(posA, posB, '?');
        } catch (IllegalOperationException e) {
            return;
        }
        Assertions.fail("Illegal operation!");
    }

}
