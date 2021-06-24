package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private static final double DELTA = 0.0001;
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new CalculatorImpl();
    }

    @Test
    void calculate_twoPositiveOperands_Ok() {
        double first = 2.035487;
        double second = 65.215803;
        assertEquals(first + second, calculator.calculate(first, second, '+'), DELTA,
                "Error in addition operation!");
        assertEquals(first - second, calculator.calculate(first, second, '-'), DELTA,
                "Error in subtraction operation!");
        assertEquals(first / second, calculator.calculate(first, second, '/'), DELTA,
                "Error in division operation!");
        assertEquals(first * second, calculator.calculate(first, second, '*'), DELTA,
                "Error in multiplication operation!");
        assertEquals(Math.pow(first, second), calculator.calculate(first, second, '^'), DELTA,
                "Error in raising in power operation!");
    }

    @Test
    void calculate_twoNegativeOperands_Ok() {
        double first = -241.2158709;
        double second = -20.658702;
        assertEquals(first + second, calculator.calculate(first, second, '+'), DELTA,
                "Error in addition operation!");
        assertEquals(first - second, calculator.calculate(first, second, '-'), DELTA,
                "Error in subtraction operation!");
        assertEquals(first / second, calculator.calculate(first, second, '/'), DELTA,
                "Error in division operation!");
        assertEquals(first * second, calculator.calculate(first, second, '*'), DELTA,
                "Error in multiplication operation!");
        assertEquals(Math.pow(first, second), calculator.calculate(first, second, '^'), DELTA,
                "Error in raising in power operation!");
    }

    @Test
    void calculate_firstNegativeSecondPositiveOperands_Ok() {
        double first = -241.2158709;
        double second = 2.035487;
        assertEquals(first + second, calculator.calculate(first, second, '+'), DELTA,
                "Error in addition operation!");
        assertEquals(first - second, calculator.calculate(first, second, '-'), DELTA,
                "Error in subtraction operation!");
        assertEquals(first / second, calculator.calculate(first, second, '/'), DELTA,
                "Error in division operation!");
        assertEquals(first * second, calculator.calculate(first, second, '*'), DELTA,
                "Error in multiplication operation!");
        assertEquals(Math.pow(first, second), calculator.calculate(first, second, '^'), DELTA,
                "Error in raising in power operation!");
    }

    @Test
    void calculate_firstPositiveSecondNegativeOperands_Ok() {
        double first = 65.215803;
        double second = -20.658702;
        assertEquals(first + second, calculator.calculate(first, second, '+'), DELTA,
                "Error in addition operation!");
        assertEquals(first - second, calculator.calculate(first, second, '-'), DELTA,
                "Error in subtraction operation!");
        assertEquals(first / second, calculator.calculate(first, second, '/'), DELTA,
                "Error in division operation!");
        assertEquals(first * second, calculator.calculate(first, second, '*'), DELTA,
                "Error in multiplication operation!");
        assertEquals(Math.pow(first, second), calculator.calculate(first, second, '^'), DELTA,
                "Error in raising in power operation!");
    }

    @Test
    void calculate_firstZeroValueSecondPositiveOperands_Ok() {
        double first = 0;
        double second = 65.21874803;
        assertEquals(first + second, calculator.calculate(first, second, '+'), DELTA,
                "Error in addition operation!");
        assertEquals(first - second, calculator.calculate(first, second, '-'), DELTA,
                "Error in subtraction operation!");
        assertEquals(first / second, calculator.calculate(first, second, '/'), DELTA,
                "Error in division operation!");
        assertEquals(first * second, calculator.calculate(first, second, '*'), DELTA,
                "Error in multiplication operation!");
        assertEquals(Math.pow(first, second), calculator.calculate(first, second, '^'), DELTA,
                "Error in raising in power operation!");
    }

    @Test
    void calculate_twoDoubleMaxValuesOperands_Ok() {
        double first = Double.MAX_VALUE;
        double second = Double.MAX_VALUE;
        assertEquals(first + second, calculator.calculate(first, second, '+'), DELTA,
                "Error in addition operation!");
        assertEquals(first - second, calculator.calculate(first, second, '-'), DELTA,
                "Error in subtraction operation!");
        assertEquals(first / second, calculator.calculate(first, second, '/'), DELTA,
                "Error in division operation!");
        assertEquals(first * second, calculator.calculate(first, second, '*'), DELTA,
                "Error in multiplication operation!");
        assertEquals(Math.pow(first, second), calculator.calculate(first, second, '^'), DELTA,
                "Error in raising in power operation!");
    }

    @Test
    void calculate_twoDoubleMinValuesOperands_Ok() {
        double first = Double.MIN_VALUE;
        double second = Double.MIN_VALUE;
        assertEquals(first + second, calculator.calculate(first, second, '+'), DELTA,
                "Error in addition operation!");
        assertEquals(first - second, calculator.calculate(first, second, '-'), DELTA,
                "Error in subtraction operation!");
        assertEquals(first / second, calculator.calculate(first, second, '/'), DELTA,
                "Error in division operation!");
        assertEquals(first * second, calculator.calculate(first, second, '*'), DELTA,
                "Error in multiplication operation!");
        assertEquals(Math.pow(first, second), calculator.calculate(first, second, '^'), DELTA,
                "Error in raising in power operation!");
    }

    @Test
    void calculate_ZeroValueSecondOperand_OK() {
        double first = 695.21874803;
        double second = 0;
        assertEquals(first + second, calculator.calculate(first, second, '+'),
                "Error in addition operation!");
        assertEquals(first - second, calculator.calculate(first, second, '-'),
                "Error in subtraction operation!");
        assertEquals(first * second, calculator.calculate(first, second, '*'),
                "Error in multiplication operation!");
        assertEquals(Math.pow(first, second), calculator.calculate(first, second, '^'),
                "Error in raising in power operation!");
    }

    @Test
    void calculate_DivisionByZero_NotOk() {
        double first = 3.6581;
        double second = 0;
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.calculate(first,
                second, '/'));
    }

    @Test
    void calculate_NullValueFirstOperand_NotOK() {
        Double first = null;
        double second = -69.0123;
        Assertions.assertThrows(NullPointerException.class, () -> calculator.calculate(first,
                second, '+'), "Error in addition operation!");
        Assertions.assertThrows(NullPointerException.class, () -> calculator.calculate(first,
                second, '-'), "Error in subtraction operation!");
        Assertions.assertThrows(NullPointerException.class, () -> calculator.calculate(first,
                second, '/'), "Error in division operation!");
        Assertions.assertThrows(NullPointerException.class, () -> calculator.calculate(first,
                second, '*'), "Error in multiplication operation!");
        Assertions.assertThrows(NullPointerException.class, () -> calculator.calculate(first,
                second, '^'), "Error in raising in power operation!");
    }

    @Test
    void calculate_NullValueSecondOperand_NotOK() {
        double first = 98.02105;
        Double second = null;
        Assertions.assertThrows(NullPointerException.class, () -> calculator.calculate(first,
                second, '+'), "Error in addition operation!");
        Assertions.assertThrows(NullPointerException.class, () -> calculator.calculate(first,
                second, '-'), "Error in subtraction operation!");
        Assertions.assertThrows(NullPointerException.class, () -> calculator.calculate(first,
                second, '/'), "Error in division operation!");
        Assertions.assertThrows(NullPointerException.class, () -> calculator.calculate(first,
                second, '*'), "Error in multiplication operation!");
        Assertions.assertThrows(NullPointerException.class, () -> calculator.calculate(first,
                second, '^'), "Error in raising in power operation!");
    }

    @Test
    void calculate_UnknownOperationCharacter_NotOk() {
        double first = 87.0126;
        double second = -98.01236;
        Assertions.assertThrows(OperationNonValidException.class, () -> calculator.calculate(first,
                second, '&'));
    }
}


