package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double MAX_DOUBLE = Double.MAX_EXPONENT;
    private static final double MIN_DOUBLE = Double.MIN_EXPONENT;
    private double firstNumber;
    private double secondNumber;
    private Random random = new Random();
    private ArithmeticalOperator arithmeticalOperator = new Calculator();
    private ArithmeticOperators[] arrayEnum;

    @Test
    void randomTest() {
        arrayEnum = ArithmeticOperators.values();
        int operator = random.nextInt(5);
        firstNumber = random.nextDouble() * MAX_DOUBLE;
        secondNumber = random.nextDouble() * MAX_DOUBLE;
        double expected = arrayEnum[operator] == ArithmeticOperators.ADDITION
                ? firstNumber + secondNumber
                : arrayEnum[operator] == ArithmeticOperators.SUBTRACTION
                ? firstNumber - secondNumber
                : arrayEnum[operator] == ArithmeticOperators.DIVISION
                ? firstNumber / secondNumber
                : arrayEnum[operator] == ArithmeticOperators.MULTIPLICATION
                ? firstNumber * secondNumber
                : Math.pow(firstNumber, secondNumber);
        double actual = arithmeticalOperator.calculate(arrayEnum[operator],
                firstNumber, secondNumber);
        assertEquals(expected, actual);
    }

    @Test
    void additionWithTwoPositiveOperands() {
        assertEquals(MAX_DOUBLE + MAX_DOUBLE,
                arithmeticalOperator
                        .calculate(ArithmeticOperators.ADDITION, MAX_DOUBLE, MAX_DOUBLE));
    }

    @Test
    void additionWithTwoNegativeOperands() {
        assertEquals(MIN_DOUBLE + MIN_DOUBLE,
                arithmeticalOperator
                        .calculate(ArithmeticOperators.ADDITION, MIN_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void additionWithPositiveAndNegativeOperands() {
        assertEquals(MAX_DOUBLE + MIN_DOUBLE,
                arithmeticalOperator
                        .calculate(ArithmeticOperators.ADDITION, MAX_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void additionWithZeroInDifferentPlaces() {
        assertEquals(MAX_DOUBLE + 0,
                arithmeticalOperator
                        .calculate(ArithmeticOperators.ADDITION, MAX_DOUBLE, 0));
        assertEquals(0 + MAX_DOUBLE,
                arithmeticalOperator
                        .calculate(ArithmeticOperators.ADDITION, 0, MAX_DOUBLE));
    }

    @Test
    void subtractionWithTwoPositiveOperands() {
        assertEquals(MAX_DOUBLE - MAX_DOUBLE,
                arithmeticalOperator
                        .calculate(ArithmeticOperators.SUBTRACTION, MAX_DOUBLE, MAX_DOUBLE));
    }

    @Test
    void subtractionWithTwoNegativeOperands() {
        assertEquals(MIN_DOUBLE - MIN_DOUBLE,
                arithmeticalOperator
                        .calculate(ArithmeticOperators.SUBTRACTION, MIN_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void subtractionWithPositiveAndNegativeOperands() {
        assertEquals(MAX_DOUBLE - MIN_DOUBLE,
                arithmeticalOperator
                        .calculate(ArithmeticOperators.SUBTRACTION, MAX_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void subtractionWithZeroInDifferentPlaces() {
        assertEquals(MAX_DOUBLE - 0.0,
                arithmeticalOperator
                        .calculate(ArithmeticOperators.SUBTRACTION, MAX_DOUBLE, 0.0));
        assertEquals(0.0 - MAX_DOUBLE,
                arithmeticalOperator
                        .calculate(ArithmeticOperators.SUBTRACTION, 0.0, MAX_DOUBLE));
    }

    @Test
    void divisionWithTwoPositiveOperands() {
        assertEquals(MAX_DOUBLE / MAX_DOUBLE,
                arithmeticalOperator
                        .calculate(ArithmeticOperators.DIVISION, MAX_DOUBLE, MAX_DOUBLE));
    }

    @Test
    void divisionWithTwoNegativeOperands() {
        assertEquals(MIN_DOUBLE / MIN_DOUBLE,
                arithmeticalOperator
                        .calculate(ArithmeticOperators.DIVISION, MIN_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void divisionWithPositiveAndNegativeOperands() {
        assertEquals(MAX_DOUBLE / MIN_DOUBLE,
                arithmeticalOperator
                        .calculate(ArithmeticOperators.DIVISION, MAX_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void divisionWithWithZeroInDifferentPlaces() {
        assertEquals(0 / MAX_DOUBLE,
                arithmeticalOperator
                        .calculate(ArithmeticOperators.DIVISION, 0, MAX_DOUBLE));
        assertThrows(ArithmeticException.class, () -> {
            arithmeticalOperator
                    .calculate(ArithmeticOperators.DIVISION, MAX_DOUBLE, 0);
        });
        assertThrows(ArithmeticException.class, () -> {
            arithmeticalOperator
                    .calculate(ArithmeticOperators.DIVISION,0, 0);
        });
    }

    @Test
    void multiplicationWithTwoPositiveOperands() {
        assertEquals(MAX_DOUBLE * MAX_DOUBLE,
                arithmeticalOperator
                        .calculate(ArithmeticOperators.MULTIPLICATION, MAX_DOUBLE, MAX_DOUBLE));
    }

    @Test
    void multiplicationWithTwoNegativeOperands() {
        assertEquals(MIN_DOUBLE * MIN_DOUBLE,
                arithmeticalOperator
                        .calculate(ArithmeticOperators.MULTIPLICATION, MIN_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void multiplicationWithPositiveAndNegativeOperands() {
        assertEquals(MAX_DOUBLE * MIN_DOUBLE,
                arithmeticalOperator
                        .calculate(ArithmeticOperators.MULTIPLICATION, MAX_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void multiplicationWithWithZeroInDifferentPlaces() {
        assertEquals(0 * MAX_DOUBLE,
                arithmeticalOperator
                        .calculate(ArithmeticOperators.MULTIPLICATION, 0, MAX_DOUBLE));
        assertEquals(MAX_DOUBLE * 0,
                arithmeticalOperator
                        .calculate(ArithmeticOperators.MULTIPLICATION, MAX_DOUBLE, 0));
    }

    @Test
    void raisingWithTwoPositiveValues() {
        assertEquals(Math.pow(MAX_DOUBLE, MAX_DOUBLE),
                arithmeticalOperator
                        .calculate(ArithmeticOperators.RISING_TO_POWER, MAX_DOUBLE, MAX_DOUBLE));
    }

    @Test
    void raisingWithTwoNegativeValues() {
        assertEquals(Math.pow(MIN_DOUBLE, MIN_DOUBLE),
                arithmeticalOperator
                        .calculate(ArithmeticOperators.RISING_TO_POWER, MIN_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void raisingWithPOsitiveAndNegativeValues() {
        assertEquals(Math.pow(MAX_DOUBLE, MIN_DOUBLE),
                arithmeticalOperator
                        .calculate(ArithmeticOperators.RISING_TO_POWER, MAX_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void raisingWithZeroInDifferentPlaces() {
        assertEquals(Math.pow(0, MIN_DOUBLE),
                arithmeticalOperator
                        .calculate(ArithmeticOperators.RISING_TO_POWER, 0, MIN_DOUBLE));
        assertEquals(Math.pow(MAX_DOUBLE, 0),
                arithmeticalOperator
                        .calculate(ArithmeticOperators.RISING_TO_POWER, MAX_DOUBLE, 0));
        assertEquals(Math.pow(0, 0),
                arithmeticalOperator
                        .calculate(ArithmeticOperators.RISING_TO_POWER, 0, 0));
    }
}
