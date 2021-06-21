package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class CalculatorTest {
    private static final double POSITIVE_NUMBER = 253.00932;
    private static final double NEGATIVE_NUMBER = -137.057;
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POW = '^';
    private static Calculator calculator;

    @BeforeAll
    static void creatCalculator() {
        calculator = new Calculator();
    }

    @Test
    void summationOfTwoPositiveNumber() {
        double actual = POSITIVE_NUMBER + POSITIVE_NUMBER;
        double expected = calculator.calculate(POSITIVE_NUMBER, POSITIVE_NUMBER, PLUS);
        assertEquals(expected, actual);
    }

}
