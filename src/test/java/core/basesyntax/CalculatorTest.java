package core.basesyntax;

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
    private final double accuracy = 0.0001;

    @Test
    void adition_positive() {
        double expected = posA + posB;
        double actual = calculator.calculate(posA, posB, '+');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void adition_negative() {
        double expected = negA + negB;
        double actual = calculator.calculate(negA, negB, '+');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void adition_positive_negative() {
        double expected = posA + negB;
        double actual = calculator.calculate(posA, negB, '+');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void adition_zero() {
        double expected = zero + posB;
        double actual = calculator.calculate(zero, posB, '+');
        Assertions.assertEquals(expected, actual, accuracy);

        expected = posA + zero;
        actual = calculator.calculate(posA, zero, '+');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void adition_max_min() {
        double expected = minDouble + minDouble;
        double actual = calculator.calculate(minDouble, minDouble, '+');
        Assertions.assertEquals(expected, actual, accuracy);

        expected = maxDouble + maxDouble;
        actual = calculator.calculate(maxDouble, maxDouble, '+');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void subtraction_positive() {
        double expected = posA - posB;
        double actual = calculator.calculate(posA, posB, '-');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void subtraction_negative() {
        double expected = negA - negB;
        double actual = calculator.calculate(negA, negB, '-');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void subtraction_positive_negative() {
        double expected = posA - negB;
        double actual = calculator.calculate(posA, negB, '-');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void subtraction_zero() {
        double expected = zero - posB;
        double actual = calculator.calculate(zero, posB, '-');
        Assertions.assertEquals(expected, actual, accuracy);

        expected = posA - zero;
        actual = calculator.calculate(posA, zero, '-');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void subtraction_max_min() {
        double expected = 0;
        double actual = calculator.calculate(minDouble, minDouble, '-');
        Assertions.assertEquals(expected, actual, accuracy);

        expected = 0;
        actual = calculator.calculate(maxDouble, maxDouble, '-');
        Assertions.assertEquals(expected, actual, accuracy);

        expected = maxDouble - minDouble;
        actual = calculator.calculate(maxDouble, minDouble, '-');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void division_positive() {
        double expected = posA / posB;
        double actual = calculator.calculate(posA, posB, '/');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void division_negative() {
        double expected = negA / negB;
        double actual = calculator.calculate(negA, negB, '/');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void division_positive_negative() {
        double expected = posA / negB;
        double actual = calculator.calculate(posA, negB, '/');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void division_zero() {
        double expected = 0;
        double actual = calculator.calculate(zero, posB, '/');
        Assertions.assertEquals(expected, actual, accuracy);

        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(posA, zero, '/');
        });
    }

    @Test
    void division_max_min() {
        double expected = 1;
        double actual = calculator.calculate(minDouble, minDouble, '/');
        Assertions.assertEquals(expected, actual, accuracy);

        actual = calculator.calculate(maxDouble, maxDouble, '/');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void multiplication_positive() {
        double expected = posA * posB;
        double actual = calculator.calculate(posA, posB, '*');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void multiplication_negative() {
        double expected = negA * negB;
        double actual = calculator.calculate(negA, negB, '*');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void multiplication_positive_negative() {
        double expected = posA * negB;
        double actual = calculator.calculate(posA, negB, '*');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void multiplication_zero() {
        double expected = 0;
        double actual = calculator.calculate(zero, posB, '*');
        Assertions.assertEquals(expected, actual, accuracy);

        actual = calculator.calculate(posA, zero, '*');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void multiplication_max_min() {
        double expected = minDouble * minDouble;
        double actual = calculator.calculate(minDouble, minDouble, '*');
        Assertions.assertEquals(expected, actual, accuracy);

        expected = maxDouble * maxDouble;
        actual = calculator.calculate(maxDouble, maxDouble, '*');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void power_positive() {
        double expected = Math.pow(posA, posB);
        double actual = calculator.calculate(posA, posB, '^');
        Assertions.assertEquals(expected, actual, accuracy);

        expected = Math.pow(negA, posB);
        actual = calculator.calculate(negA, posB, '^');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void power_negative() {
        double expected = Math.pow(negA, negB);
        double actual = calculator.calculate(negA, negB, '^');
        Assertions.assertEquals(expected, actual, accuracy);

        expected = Math.pow(posA, negB);
        actual = calculator.calculate(posA, negB, '^');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void power_zero() {
        double expected = Math.pow(zero, posB);
        double actual = calculator.calculate(zero, posB, '^');
        Assertions.assertEquals(expected, actual, accuracy);

        expected = Math.pow(posA, zero);
        actual = calculator.calculate(posA, zero, '^');
        Assertions.assertEquals(expected, actual, accuracy);
    }

    @Test
    void illegal_operation() {
        char illegalOperation = '?';
        try {
            calculator.calculate(posA, posB, illegalOperation);
        } catch (RuntimeException e) {
            return;
        }
        Assertions.fail("Illegal operation!");
    }

}
