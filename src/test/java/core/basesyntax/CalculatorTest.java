package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final double MAX_DOUBLE = Double.MAX_VALUE;
    private static final double MIN_DOUBLE = Double.MIN_VALUE;
    private static Random random;
    private static Calculable calculable;
    private static ArithmeticOperators[] operations;

    @BeforeAll
    public static void init() {
        random = new Random();
        calculable = new Calculator();
        operations = ArithmeticOperators.values();
    }

    @Test
    public void randomTest() {
        int operator = random.nextInt(5);
        ArithmeticOperators characterOperator = operations[operator];
        double firstNumber = random.nextDouble() * MAX_DOUBLE;
        double secondNumber = random.nextDouble() * MAX_DOUBLE;
        double expected = operations[operator] == ArithmeticOperators.ADDITION
                ? firstNumber + secondNumber
                : operations[operator] == ArithmeticOperators.SUBTRACTION
                ? firstNumber - secondNumber
                : operations[operator] == ArithmeticOperators.DIVISION
                ? firstNumber / secondNumber
                : operations[operator] == ArithmeticOperators.MULTIPLICATION
                ? firstNumber * secondNumber
                : Math.pow(firstNumber, secondNumber);
        double actual = calculable.calculate(characterOperator.getCharacter(),
                firstNumber, secondNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void additionWithTwoPositiveOperands() {
        ArithmeticOperators operator = operations[0];
        assertEquals(MAX_DOUBLE + MAX_DOUBLE,
                calculable
                        .calculate(operator.getCharacter(), MAX_DOUBLE, MAX_DOUBLE));
    }

    @Test
    public void additionWithTwoNegativeOperands() {
        ArithmeticOperators operator = operations[0];
        assertEquals(MIN_DOUBLE + MIN_DOUBLE,
                calculable
                        .calculate(operator.getCharacter(), MIN_DOUBLE, MIN_DOUBLE));
    }

    @Test
    public void additionWithPositiveAndNegativeOperands() {
        ArithmeticOperators operator = operations[0];
        assertEquals(MAX_DOUBLE + MIN_DOUBLE,
                calculable
                        .calculate(operator.getCharacter(), MAX_DOUBLE, MIN_DOUBLE));
    }

    @Test
    public void additionWithZeroInDifferentPlaces() {
        ArithmeticOperators operator = operations[0];
        assertEquals(MAX_DOUBLE + 0,
                calculable
                        .calculate(operator.getCharacter(), MAX_DOUBLE, 0));
        assertEquals(0 + MAX_DOUBLE,
                calculable
                        .calculate(operator.getCharacter(), 0, MAX_DOUBLE));
    }

    @Test
    public void subtractionWithTwoPositiveOperands() {
        ArithmeticOperators operator = operations[1];
        assertEquals(MAX_DOUBLE - MAX_DOUBLE,
                calculable
                        .calculate(operator.getCharacter(), MAX_DOUBLE, MAX_DOUBLE));
    }

    @Test
    public void subtractionWithTwoNegativeOperands() {
        ArithmeticOperators operator = operations[1];
        assertEquals(MIN_DOUBLE - MIN_DOUBLE,
                calculable
                        .calculate(operator.getCharacter(), MIN_DOUBLE, MIN_DOUBLE));
    }

    @Test
    public void subtractionWithPositiveAndNegativeOperands() {
        ArithmeticOperators operator = operations[1];
        assertEquals(MAX_DOUBLE - MIN_DOUBLE,
                calculable
                        .calculate(operator.getCharacter(), MAX_DOUBLE, MIN_DOUBLE));
    }

    @Test
    public void subtractionWithZeroInDifferentPlaces() {
        ArithmeticOperators operator = operations[1];
        assertEquals(MAX_DOUBLE - 0.0,
                calculable
                        .calculate(operator.getCharacter(), MAX_DOUBLE, 0.0));
        assertEquals(0.0 - MAX_DOUBLE,
                calculable
                        .calculate(operator.getCharacter(), 0.0, MAX_DOUBLE));
    }

    @Test
    public void divisionWithTwoPositiveOperands() {
        ArithmeticOperators operator = operations[2];
        assertEquals(MAX_DOUBLE / MAX_DOUBLE,
                calculable
                        .calculate(operator.getCharacter(), MAX_DOUBLE, MAX_DOUBLE));
    }

    @Test
    public void divisionWithTwoNegativeOperands() {
        ArithmeticOperators operator = operations[2];
        assertEquals(MIN_DOUBLE / MIN_DOUBLE,
                calculable
                        .calculate(operator.getCharacter(), MIN_DOUBLE, MIN_DOUBLE));
    }

    @Test
    public void divisionWithPositiveAndNegativeOperands() {
        ArithmeticOperators operator = operations[2];
        assertEquals(MAX_DOUBLE / MIN_DOUBLE,
                calculable
                        .calculate(operator.getCharacter(), MAX_DOUBLE, MIN_DOUBLE));
    }

    @Test
    public void divisionWithWithZeroInDifferentPlaces() {
        ArithmeticOperators operator = operations[2];
        assertEquals(0 / MAX_DOUBLE,
                calculable
                        .calculate(operator.getCharacter(), 0, MAX_DOUBLE));
        assertThrows(ArithmeticException.class, () -> {
            calculable
                    .calculate(operator.getCharacter(), MAX_DOUBLE, 0);
        });
        assertThrows(ArithmeticException.class, () -> {
            calculable
                    .calculate(operator.getCharacter(), 0, 0);
        });
    }

    @Test
    public void multiplicationWithTwoPositiveOperands() {
        ArithmeticOperators operator = operations[3];
        assertEquals(MAX_DOUBLE * MAX_DOUBLE,
                calculable
                        .calculate(operator.getCharacter(), MAX_DOUBLE, MAX_DOUBLE));
    }

    @Test
    public void multiplicationWithTwoNegativeOperands() {
        ArithmeticOperators operator = operations[3];
        assertEquals(MIN_DOUBLE * MIN_DOUBLE,
                calculable
                        .calculate(operator.getCharacter(), MIN_DOUBLE, MIN_DOUBLE));
    }

    @Test
    public void multiplicationWithPositiveAndNegativeOperands() {
        ArithmeticOperators operator = operations[3];
        assertEquals(MAX_DOUBLE * MIN_DOUBLE,
                calculable
                        .calculate(operator.getCharacter(), MAX_DOUBLE, MIN_DOUBLE));
    }

    @Test
    public void multiplicationWithWithZeroInDifferentPlaces() {
        ArithmeticOperators operator = operations[3];
        assertEquals(0 * MAX_DOUBLE,
                calculable
                        .calculate(operator.getCharacter(), 0, MAX_DOUBLE));
        assertEquals(MAX_DOUBLE * 0,
                calculable
                        .calculate(operator.getCharacter(), MAX_DOUBLE, 0));
    }

    @Test
    public void raisingWithTwoPositiveValues() {
        ArithmeticOperators operator = operations[4];
        assertEquals(Math.pow(MAX_DOUBLE, MAX_DOUBLE),
                calculable
                        .calculate(operator.getCharacter(), MAX_DOUBLE, MAX_DOUBLE));
    }

    @Test
    public void raisingWithTwoNegativeValues() {
        ArithmeticOperators operator = operations[4];
        assertEquals(Math.pow(MIN_DOUBLE, MIN_DOUBLE),
                calculable
                        .calculate(operator.getCharacter(), MIN_DOUBLE, MIN_DOUBLE));
    }

    @Test
    public void raisingWithPOsitiveAndNegativeValues() {
        ArithmeticOperators raising = operations[4];
        assertEquals(Math.pow(MAX_DOUBLE, MIN_DOUBLE),
                calculable
                        .calculate(raising.getCharacter(), MAX_DOUBLE, MIN_DOUBLE));
    }

    @Test
    public void raisingWithZeroInDifferentPlaces() {
        ArithmeticOperators raising = operations[4];
        assertEquals(Math.pow(0, MIN_DOUBLE),
                calculable
                        .calculate(raising.getCharacter(), 0, MIN_DOUBLE));
        assertEquals(Math.pow(MAX_DOUBLE, 0),
                calculable
                        .calculate(raising.getCharacter(), MAX_DOUBLE, 0));
        assertEquals(Math.pow(0, 0),
                calculable
                        .calculate(raising.getCharacter(), 0, 0));
    }

    @Test
    public void wrongArithmeticOperator() {
        assertThrows(ArithmeticException.class, () -> {
            calculable.calculate('&', 0, 0);
        });
        assertThrows(ArithmeticException.class, () -> {
            calculable.calculate('=', 0, 0);
        });
        assertThrows(ArithmeticException.class, () -> {
            calculable.calculate('.', 0, 0);
        });
        assertThrows(ArithmeticException.class, () -> {
            calculable.calculate('~', 0, 0);
        });
        assertThrows(ArithmeticException.class, () -> {
            calculable.calculate(',', 0, 0);
        });
        assertThrows(ArithmeticException.class, () -> {
            calculable.calculate(':', 0, 0);
        });
        assertThrows(ArithmeticException.class, () -> {
            calculable.calculate('@', 0, 0);
        });
    }
}
