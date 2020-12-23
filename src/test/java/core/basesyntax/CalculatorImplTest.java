package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private static Calculator calculator;
    private static double expected;

    @BeforeAll
    static void beforeAll() {
        calculator = new CalculatorImpl();
    }

    @BeforeEach
    void setUp() {
        expected = 25.7;
    }

    @Test
    void whenWrongOperator_expectExceptionTest() {
        assertThrows(RuntimeException.class,
                () -> {
                    calculator.calculate(1, '?', 1);
                });
    }

    @Test
    void whenBothParamsIsDoubleMaxValue_expectExceptionTest() {
        assertThrows(ArithmeticException.class,
                () -> {
                    calculator.calculate(Double.MAX_VALUE, '+', Double.MAX_VALUE);
                });
        assertThrows(ArithmeticException.class,
                () -> {
                    calculator.calculate(Double.MAX_VALUE, '-', Double.MAX_VALUE);
                });
        assertThrows(ArithmeticException.class,
                () -> {
                    calculator.calculate(Double.MAX_VALUE, '*', Double.MAX_VALUE);
                });
        assertThrows(ArithmeticException.class,
                () -> {
                    calculator.calculate(Double.MAX_VALUE, '^', Double.MAX_VALUE);
                });
    }

    @Test
    void divisionByZeroWhenPassSecondNumericZero_expectExceptionTest() {
        assertThrows(RuntimeException.class, () -> {
            calculator.calculate(1, '/', 0);
        });
    }

    @Test
    void calculateAdditionWithNotMaxValues_PredictedResultTest() {
        double actual = calculator.calculate(10, '+', 15.7);
        assertEquals(expected, actual);
    }

    @Test
    void calculateSubtractionWithNotMaxValues_PredictedResultTest() {
        double actual = calculator.calculate(50, '-', 24.3);
        assertEquals(expected, actual);
    }

    @Test
    void calculateDivisionWithNotMaxValues_PredictedResultTest() {
        double actual = calculator.calculate(257, '/', 10);
        assertEquals(expected, actual);

    }

    @Test
    void calculateMultiplicationWithNotMaxValues_PredictedResultTest() {
        double actual = calculator.calculate(12.85, '*', 2);
        assertEquals(expected, actual);
    }

    @Test
    void calculateRaisingToPowerWithNotMaxValue_PredictedResultTest() {
        double expected = 25;
        double actual = calculator.calculate(5, '^', 2);
        assertEquals(expected, actual);
    }
}
