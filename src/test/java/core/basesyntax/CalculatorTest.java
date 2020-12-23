package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void additingTwoPositiveNumber_Ok() {
        double actual = calculator.calculate(100.5, 200.3, '+');
        double expected = 300.8;
        assertEquals(actual, expected, "Failed additing two positive numbers");
    }

    @Test
    void additingOnePositiveAndOneNegative_Ok() {
        double actual = calculator.calculate(-10.1, 50.4, '+');
        double expected = 40.3;
        assertEquals(actual, expected, "Failed additing negative and positive numbers");
    }

    @Test
    void additingTwoNegativeNumber_Ok() {
        double actual = calculator.calculate(-15.55, -5000.45, '+');
        double expected = -5016;
        assertEquals(actual, expected, "Failed additing two negative numbers");
    }

    @Test
    void additingFirstZeroTest_Ok() {
        double actual = calculator.calculate(0, 356, '+');
        double expected = 356;
        assertEquals(actual, expected, "Failed additing first zero positive number");
    }

    @Test
    void additingSecondZeroTest_Ok() {
        double actual = calculator.calculate(2000.89, 0, '+');
        double expected = 2000.89;
        assertEquals(actual, expected, "Failed additing number and zero");
    }

    @Test
    void additingOneInfinityTest_Ok() {
        double actual = calculator.calculate(86.0, Double.POSITIVE_INFINITY, '+');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(actual, expected, "Failed additing number and positive infinity");
    }

    @Test
    void additingTwoInfinityTest_NotOk() {
        double actual = calculator.calculate(Double.POSITIVE_INFINITY,
                 Double.POSITIVE_INFINITY, '+');
        double expected = 0.0;
        assertNotEquals(actual, expected);
    }

    @Test
    void additingMinAndMaxVaueTest_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+');
        double exprected = 1.0E-323;
        assertEquals(actual, exprected, "Failed additing MinValue and MaxValue");
    }

    @Test
    void substractionTwoPositiveNumberTest_Ok() {
        double actual = calculator.calculate(300.3, 200.3, '-');
        double expected = 100;
        assertEquals(actual, expected, "Failed substraction two positive numbers");
    }

    @Test
    void substractionOnePositiveAndOneNegativeTest_Ok() {
        double actual = calculator.calculate(-10.1, 50.4, '-');
        double expected = -60.5;
        assertEquals(actual, expected, "Failed substraction negative and positive numbers");
    }

    @Test
    void substractionTwoNegativeNumberTest_Ok() {
        double actual = calculator.calculate(-15.55, -5000.45, '-');
        double expected = 4984.9;
        assertEquals(actual, expected, "Failed substraction two negative numbers");
    }

    @Test
    void substractionFirstZeroTest_Ok() {
        double actual = calculator.calculate(0, 356, '-');
        double expected = -356;
        assertEquals(actual, expected, "Failed substraction first zero positive number");
    }

    @Test
    void substractionNumberAndSecondZeroTest_Ok() {
        double expected = 2000.89;
        double actual = calculator.calculate(2000.89, 0.0, '-');
        assertEquals(actual, expected, "Failed substraction number and zero");
    }

    @Test
    void substractionOneInfinityTest_Ok() {
        double actual = calculator.calculate(86.0, Double.POSITIVE_INFINITY, '-');
        double expected = Double.NEGATIVE_INFINITY;
        assertEquals(actual, expected, "Failed substraction number and positive infinity");
    }

    @Test
    void substractionTwoInfinityTest_NotOk() {
        double actual = calculator.calculate(Double.POSITIVE_INFINITY,
                 Double.POSITIVE_INFINITY, '-');
        double expected = 0.0;
        assertNotEquals(actual, expected);
    }

    @Test
    void substractionMinAndMaxVaueTest_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-');
        double exprected = 0.0;
        assertEquals(actual, exprected, "Failed substraction MinValue and MaxValue");
    }

    @Test
    void multiplyTwoPositiveNumberTest_Ok() {
        double actual = calculator.calculate(100.5, 200.3, '*');
        double expected = 20130.15;
        assertEquals(actual, expected, "Failed multiplying two positive numbers");
    }

    @Test
    void multiplyOnePositiveAndOneNegativeTest_Ok() {
        double actual = calculator.calculate(-3.2, 50.5, '*');
        double expected = -161.6;
        double delta = 0.1;
        assertEquals(actual, expected, delta, "Failed multiplying negative and positive numbers");
    }

    @Test
    void multiplyTwoNegativeNumberTest_Ok() {
        double actual = calculator.calculate(-17.1, -521.4, '*');
        double expected = 8915.94;
        assertEquals(actual, expected, "Failed multiplying two negative numbers");
    }

    @Test
    void multiplyFirstZeroTest_Ok() {
        double actual = calculator.calculate(0, 356, '*');
        double expected = 0;
        assertEquals(actual, expected, "Failed multiplying first zero positive number");
    }

    @Test
    void multiplySecondZeroTest_Ok() {
        double actual = calculator.calculate(2000.89, 0.0, '*');
        double expected = 0;
        assertEquals(actual, expected, "Failed multiplying number and zero");
    }

    @Test
    void multiplyOneInfinityTest_Ok() {
        double actual = calculator.calculate(86.0, Double.POSITIVE_INFINITY, '*');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(actual, expected, "Failed multiplying number and positive infinity");
    }

    @Test
    void multiplyTwoInfinityTest_NotOk() {
        double actual = calculator.calculate(Double.POSITIVE_INFINITY,
                 Double.POSITIVE_INFINITY, '*');
        double expected = Double.NEGATIVE_INFINITY;
        assertNotEquals(actual, expected);
    }

    @Test
    void multiplyMinAndMaxVaueTest_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '*');
        double exprected = 0.0;
        assertEquals(actual, exprected, "Failed multiplying MinValue and MaxValue");
    }

    @Test
    void divideTwoPositiveNumberTest_Ok() {
        double actual = calculator.calculate(186.85, 10.1, '/');
        double expected = 18.5;
        assertEquals(actual, expected, "Failed dividing two positive numbers");
    }

    @Test
    void divideOnePositiveAndOneNegativeTest_Ok() {
        double actual = calculator.calculate(-75.4, 14.5, '/');
        double expected = -5.2;
        assertEquals(actual, expected, "Failed dividing negative and positive numbers");
    }

    @Test
    void divideTwoNegativeNumberTest_Ok() {
        double actual = calculator.calculate(-5000.45, -100.009, '/');
        double expected = 50;
        assertEquals(actual, expected, "Failed dividing two negative numbers");
    }

    @Test
    void divideFirstZeroTestTest_Ok() {
        double actual = calculator.calculate(0, 356, '/');
        double expected = 0;
        assertEquals(actual, expected, "Failed dividing first zero positive number");
    }

    @Test
    void divideOneInfinityTestTest_Ok() {
        double actual = calculator.calculate(86.0, Double.POSITIVE_INFINITY, '/');
        double expected = 0.0;
        assertEquals(actual, expected, "Failed dividing number and positive infinity");
    }

    @Test
    void divideTwoInfinityTestTest_NotOk() {
        double actual = calculator.calculate(Double.POSITIVE_INFINITY,
                 Double.POSITIVE_INFINITY, '/');
        double expected = 0.0;
        assertNotEquals(actual, expected);
    }

    @Test
    void divideMinAndMaxVaueTest_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '/');
        double exprected = 1.0;
        assertEquals(actual, exprected, "Failed dividing MinValue and MaxValue");
    }

    @Test
    void raisingtoPowerTwoPositiveNumberTest_Ok() {
        double actual = calculator.calculate(10, 2, '^');
        double expected = 100;
        assertEquals(actual, expected, "Failed raising one positive "
                + "number to power second positive numbers");
    }

    @Test
    void raisingOnePositiveToPowerNegativeTest_Ok() {
        double actual = calculator.calculate(10, -2, '^');
        double expected = 0.01;
        assertEquals(actual, expected, "Failed raising one positive "
                + "number to power second negative power");
    }

    @Test
    void raisingZeroToPowerPositiveNumberTest_Ok() {
        double actual = calculator.calculate(0, 3, '^');
        double expected = 0;
        assertEquals(actual, expected, "Failed raising zero to positive power");
    }

    @Test
    void raisingNumberToZeroPowerTest_Ok() {
        double actual = calculator.calculate(125.1, 0, '^');
        double expected = 1;
        assertEquals(actual, expected, "Failed raising number to zero power");
    }

    @Test
    void raisingNumberToInfinityPowerTest_Ok() {
        double actual = calculator.calculate(86.0, Double.POSITIVE_INFINITY, '^');
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(actual, expected, "Failed raising number to infinity power");
    }

    @Test
    void raisingInfinityToInfinityPowerTest_NotOk() {
        double actual = calculator.calculate(Double.POSITIVE_INFINITY,
                 Double.POSITIVE_INFINITY, '^');
        double expected = 0.0;
        assertNotEquals(actual, expected);
    }

    @Test
    void raisingMinValueToPowerMaxVaueTest_Ok() {
        double actual = calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '^');
        double exprected = 1.0;
        assertEquals(actual, exprected, "Failed additing MinValue and MaxValue");
    }

    @Test
    void edgeCasesTests() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(2000.89, 0, '/');
        });
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.calculate(100.5, 25.98, '~');
        });
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.calculate(0, 8, 'y');
        });
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.calculate(67.98, 352.12, '&');
        });
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(-25, 0.5, '^');
        });
    }

    @Test
    void falseCasesTests_NotOk() {
        double actual = calculator.calculate(123, 456, '+');
        double notExperted = 123456;
        assertFalse(actual == notExperted);
        double actualExcrection = calculator.calculate(123456, 123, '-');
        double notExpertedExctraction = 456;
        assertFalse(actualExcrection == notExpertedExctraction);
        double actualMultiply = calculator.calculate(3, 45, '*');
        double notExpertedMutliply = 48;
        assertFalse(actualMultiply == notExpertedMutliply);
        double actualDivide = calculator.calculate(30, 3, '/');
        double notExpertedDivide = 15;
        assertFalse(actualDivide == notExpertedDivide);
        double actualRisePower = calculator.calculate(2, 3, '^');
        double notExpertedRisePower = 6;
        assertFalse(actualRisePower == notExpertedRisePower);
    }
}
