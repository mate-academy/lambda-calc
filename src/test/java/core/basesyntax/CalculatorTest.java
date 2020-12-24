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
    private ArithmeticOperators[] operations = ArithmeticOperators.values();

    @Test
    void randomTest() {
        int operator = random.nextInt(5);
        ArithmeticOperators characterOperator = operations[operator];
        firstNumber = random.nextDouble() * MAX_DOUBLE;
        secondNumber = random.nextDouble() * MAX_DOUBLE;
        double expected = operations[operator] == ArithmeticOperators.ADDITION
                ? firstNumber + secondNumber
                : operations[operator] == ArithmeticOperators.SUBTRACTION
                ? firstNumber - secondNumber
                : operations[operator] == ArithmeticOperators.DIVISION
                ? firstNumber / secondNumber
                : operations[operator] == ArithmeticOperators.MULTIPLICATION
                ? firstNumber * secondNumber
                : Math.pow(firstNumber, secondNumber);
        double actual = arithmeticalOperator.calculate(characterOperator.getCharacter(),
                firstNumber, secondNumber);
        assertEquals(expected, actual);
    }

    @Test
    void additionWithTwoPositiveOperands() {
        ArithmeticOperators addition = operations[0];
        assertEquals(MAX_DOUBLE + MAX_DOUBLE,
                arithmeticalOperator
                        .calculate(addition.getCharacter(), MAX_DOUBLE, MAX_DOUBLE));
    }

    @Test
    void additionWithTwoNegativeOperands() {
        ArithmeticOperators addition = operations[0];
        assertEquals(MIN_DOUBLE + MIN_DOUBLE,
                arithmeticalOperator
                        .calculate(addition.getCharacter(), MIN_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void additionWithPositiveAndNegativeOperands() {
        ArithmeticOperators addition = operations[0];
        assertEquals(MAX_DOUBLE + MIN_DOUBLE,
                arithmeticalOperator
                        .calculate(addition.getCharacter(), MAX_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void additionWithZeroInDifferentPlaces() {
        ArithmeticOperators addition = operations[0];
        assertEquals(MAX_DOUBLE + 0,
                arithmeticalOperator
                        .calculate(addition.getCharacter(), MAX_DOUBLE, 0));
        assertEquals(0 + MAX_DOUBLE,
                arithmeticalOperator
                        .calculate(addition.getCharacter(), 0, MAX_DOUBLE));
    }

    @Test
    void subtractionWithTwoPositiveOperands() {
        ArithmeticOperators subtract = operations[1];
        assertEquals(MAX_DOUBLE - MAX_DOUBLE,
                arithmeticalOperator
                        .calculate(subtract.getCharacter(), MAX_DOUBLE, MAX_DOUBLE));
    }

    @Test
    void subtractionWithTwoNegativeOperands() {
        ArithmeticOperators subtract = operations[1];
        assertEquals(MIN_DOUBLE - MIN_DOUBLE,
                arithmeticalOperator
                        .calculate(subtract.getCharacter(), MIN_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void subtractionWithPositiveAndNegativeOperands() {
        ArithmeticOperators subtract = operations[1];
        assertEquals(MAX_DOUBLE - MIN_DOUBLE,
                arithmeticalOperator
                        .calculate(subtract.getCharacter(), MAX_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void subtractionWithZeroInDifferentPlaces() {
        ArithmeticOperators subtract = operations[1];
        assertEquals(MAX_DOUBLE - 0.0,
                arithmeticalOperator
                        .calculate(subtract.getCharacter(), MAX_DOUBLE, 0.0));
        assertEquals(0.0 - MAX_DOUBLE,
                arithmeticalOperator
                        .calculate(subtract.getCharacter(), 0.0, MAX_DOUBLE));
    }

    @Test
    void divisionWithTwoPositiveOperands() {
        ArithmeticOperators division = operations[2];
        assertEquals(MAX_DOUBLE / MAX_DOUBLE,
                arithmeticalOperator
                        .calculate(division.getCharacter(), MAX_DOUBLE, MAX_DOUBLE));
    }

    @Test
    void divisionWithTwoNegativeOperands() {
        ArithmeticOperators division = operations[2];
        assertEquals(MIN_DOUBLE / MIN_DOUBLE,
                arithmeticalOperator
                        .calculate(division.getCharacter(), MIN_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void divisionWithPositiveAndNegativeOperands() {
        ArithmeticOperators division = operations[2];
        assertEquals(MAX_DOUBLE / MIN_DOUBLE,
                arithmeticalOperator
                        .calculate(division.getCharacter(), MAX_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void divisionWithWithZeroInDifferentPlaces() {
        ArithmeticOperators division = operations[2];
        assertEquals(0 / MAX_DOUBLE,
                arithmeticalOperator
                        .calculate(division.getCharacter(), 0, MAX_DOUBLE));
        assertThrows(ArithmeticException.class, () -> {
            arithmeticalOperator
                    .calculate(division.getCharacter(), MAX_DOUBLE, 0);
        });
        assertThrows(ArithmeticException.class, () -> {
            arithmeticalOperator
                    .calculate(division.getCharacter(), 0, 0);
        });
    }

    @Test
    void multiplicationWithTwoPositiveOperands() {
        ArithmeticOperators multiplication = operations[3];
        assertEquals(MAX_DOUBLE * MAX_DOUBLE,
                arithmeticalOperator
                        .calculate(multiplication.getCharacter(), MAX_DOUBLE, MAX_DOUBLE));
    }

    @Test
    void multiplicationWithTwoNegativeOperands() {
        ArithmeticOperators multiplication = operations[3];
        assertEquals(MIN_DOUBLE * MIN_DOUBLE,
                arithmeticalOperator
                        .calculate(multiplication.getCharacter(), MIN_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void multiplicationWithPositiveAndNegativeOperands() {
        ArithmeticOperators multiplication = operations[3];
        assertEquals(MAX_DOUBLE * MIN_DOUBLE,
                arithmeticalOperator
                        .calculate(multiplication.getCharacter(), MAX_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void multiplicationWithWithZeroInDifferentPlaces() {
        ArithmeticOperators multiplication = operations[3];
        assertEquals(0 * MAX_DOUBLE,
                arithmeticalOperator
                        .calculate(multiplication.getCharacter(), 0, MAX_DOUBLE));
        assertEquals(MAX_DOUBLE * 0,
                arithmeticalOperator
                        .calculate(multiplication.getCharacter(), MAX_DOUBLE, 0));
    }

    @Test
    void raisingWithTwoPositiveValues() {
        ArithmeticOperators raising = operations[4];
        assertEquals(Math.pow(MAX_DOUBLE, MAX_DOUBLE),
                arithmeticalOperator
                        .calculate(raising.getCharacter(), MAX_DOUBLE, MAX_DOUBLE));
    }

    @Test
    void raisingWithTwoNegativeValues() {
        ArithmeticOperators raising = operations[4];
        assertEquals(Math.pow(MIN_DOUBLE, MIN_DOUBLE),
                arithmeticalOperator
                        .calculate(raising.getCharacter(), MIN_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void raisingWithPOsitiveAndNegativeValues() {
        ArithmeticOperators raising = operations[4];
        assertEquals(Math.pow(MAX_DOUBLE, MIN_DOUBLE),
                arithmeticalOperator
                        .calculate(raising.getCharacter(), MAX_DOUBLE, MIN_DOUBLE));
    }

    @Test
    void raisingWithZeroInDifferentPlaces() {
        ArithmeticOperators raising = operations[4];
        assertEquals(Math.pow(0, MIN_DOUBLE),
                arithmeticalOperator
                        .calculate(raising.getCharacter(), 0, MIN_DOUBLE));
        assertEquals(Math.pow(MAX_DOUBLE, 0),
                arithmeticalOperator
                        .calculate(raising.getCharacter(), MAX_DOUBLE, 0));
        assertEquals(Math.pow(0, 0),
                arithmeticalOperator
                        .calculate(raising.getCharacter(), 0, 0));
    }
}
