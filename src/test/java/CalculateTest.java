import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class CalculateTest {
    private static final Calculate CALCULATOR = new Calculate();
    private double actual;
    private double answer;

    @Test
    void additionWithTwoPositiveOperands_Ok() {
        actual = CALCULATOR.calculate(6, 8, Calculate.PLUS);
        answer = 14;
        assertEquals(answer, actual);
    }

    @Test
    void additionWithTwoNegativeOperands_Ok() {
        actual = CALCULATOR.calculate(-6, -8, Calculate.PLUS);
        answer = -14;
        assertEquals(answer, actual);
    }

    @Test
    void additionWithPositiveAndNegativeOperands_Ok() {
        double actual = CALCULATOR.calculate(-6, 8, Calculate.PLUS);
        double answer = 2;
        assertEquals(answer, actual);
    }

    @Test
    void additionWithZeroInDifferentPlaces_Ok() {
        actual = CALCULATOR.calculate(0, 8, Calculate.PLUS);
        answer = 8;
        assertEquals(answer,actual);

        actual = CALCULATOR.calculate(6, 0, Calculate.PLUS);
        answer = 6;
        assertEquals(answer,actual);

        actual = CALCULATOR.calculate(0, 0, Calculate.PLUS);
        answer = 0;
        assertEquals(answer,actual);
    }

    @Test
    void subtractionWithTwoPositiveOperands_Ok() {
        actual = CALCULATOR.calculate(6, 8, Calculate.MINUS);
        answer = -2;
        assertEquals(answer, actual);
    }

    @Test
    void subtractionWithTwoNegativeOperands_Ok() {
        actual = CALCULATOR.calculate(-6, -8, Calculate.MINUS);
        answer = 2;
        assertEquals(answer, actual);
    }

    @Test
    void subtractionWithPositiveAndNegativeOperands_Ok() {
        actual = CALCULATOR.calculate(-6, 8, Calculate.MINUS);
        answer = -14;
        assertEquals(answer, actual);
    }

    @Test
    void subtractionWithZeroInDifferentPlaces_Ok() {
        actual = CALCULATOR.calculate(0, 8, Calculate.MINUS);
        answer = -8;
        assertEquals(answer,actual);

        actual = CALCULATOR.calculate(6, 0, Calculate.MINUS);
        answer = 6;
        assertEquals(answer,actual);

        actual = CALCULATOR.calculate(0, 0, Calculate.MINUS);
        answer = 0;
        assertEquals(answer,actual);
    }

    @Test
    void divisionWithTwoPositiveOperands_Ok() {
        actual = CALCULATOR.calculate(6, 2, Calculate.DIVISION);
        answer = 3;
        assertEquals(answer, actual);
    }

    @Test
    void divisionWithTwoNegativeOperands_Ok() {
        actual = CALCULATOR.calculate(-6, -2, Calculate.DIVISION);
        answer = 3;
        assertEquals(answer, actual);
    }

    @Test
    void divisionWithPositiveAndNegativeOperands_Ok() {
        actual = CALCULATOR.calculate(-6, 2, Calculate.DIVISION);
        answer = -3;
        assertEquals(answer, actual);
    }

    @Test
    void divisionWithZeroInStart_Ok() {
        actual = CALCULATOR.calculate(0, 8, Calculate.DIVISION);
        answer = 0;
        assertEquals(answer, actual);
    }

    @Test
    void divisionWithZeroInEnd_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            CALCULATOR.calculate(6, 0, Calculate.DIVISION);
        });
    }

    @Test
    void divisionWithZeroInStartAndEnd_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            CALCULATOR.calculate(0, 0, Calculate.DIVISION);
        });
    }

    @Test
    void multiplicationWithTwoPositiveOperands_Ok() {
        actual = CALCULATOR.calculate(6, 8, Calculate.MULTIPLICATION);
        answer = 48;
        assertEquals(answer, actual);
    }

    @Test
    void multiplicationWithTwoNegativeOperands_Ok() {
        actual = CALCULATOR.calculate(-6, -8, Calculate.MULTIPLICATION);
        answer = 48;
        assertEquals(answer, actual);
    }

    @Test
    void multiplicationWithPositiveAndNegativeOperands_Ok() {
        actual = CALCULATOR.calculate(-6, 8, Calculate.MULTIPLICATION);
        answer = -48;
        assertEquals(answer, actual);
    }

    @Test
    void multiplicationWithZeroInDifferentPlaces_Ok() {
        actual = CALCULATOR.calculate(0, 8, Calculate.MULTIPLICATION);
        answer = 0;
        assertEquals(answer,actual);

        actual = CALCULATOR.calculate(6, 0, Calculate.MULTIPLICATION);
        answer = 0;
        assertEquals(answer,actual);

        actual = CALCULATOR.calculate(0, 0, Calculate.MULTIPLICATION);
        answer = 0;
        assertEquals(answer,actual);
    }

    @Test
    void raisingPositiveValueToThePositivePower_Ok() {
        actual = CALCULATOR.calculate(5, 2, Calculate.EXPONENTIATION);
        answer = 25;
        assertEquals(answer,actual);
    }

    @Test
    void raisingNegativeValueToThePositivePower_Ok() {
        actual = CALCULATOR.calculate(-5, 2, Calculate.EXPONENTIATION);
        answer = 25;
        assertEquals(answer,actual);
    }

    @Test
    void raisingPositiveValueToTheNegativePower_Ok() {
        actual = CALCULATOR.calculate(10, -3, Calculate.EXPONENTIATION);
        answer = 0.001;
        assertEquals(answer,actual);
    }

    @Test
    void raisingNegativeValueToTheNegativePower_Ok() {
        actual = CALCULATOR.calculate(-10, -3, Calculate.EXPONENTIATION);
        answer = -0.001;
        assertEquals(answer,actual);
    }

    @Test
    void raisingPositiveValueToZeroPower_Ok() {
        actual = CALCULATOR.calculate(5, 0, Calculate.EXPONENTIATION);
        answer = 1;
        assertEquals(answer,actual);
    }

    @Test
    void raisingNegativeValueToZeroPower_Ok() {
        actual = CALCULATOR.calculate(-5, 0, Calculate.EXPONENTIATION);
        answer = 1;
        assertEquals(answer,actual);
    }

    @Test
    void raisingZeroToPower_Ok() {
        actual = CALCULATOR.calculate(0, 0, Calculate.EXPONENTIATION);
        answer = 1;
        assertEquals(answer,actual);

        actual = CALCULATOR.calculate(0, 5, Calculate.EXPONENTIATION);
        answer = 0;
        assertEquals(answer,actual);
    }

    @Test
    void raisingZeroToNegativePower_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            CALCULATOR.calculate(0, -5, Calculate.EXPONENTIATION);
        });
    }

    @Test
    void illegalOperation_notOk() {
        assertThrows(NoSuchElementException.class, () -> {
            CALCULATOR.calculate(0, 0, '&');
        });
    }
}
