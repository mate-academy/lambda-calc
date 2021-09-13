import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class CalculateTest {
    private static final Calculate calculate = new Calculate();

    @Test
    void additionWithTwoPositiveOperands_Ok() {
        double actual = calculate.calculate(6, 8, Calculate.PLUS);
        double answer = 14;
        assertEquals(answer, actual);
    }

    @Test
    void additionWithTwoNegativeOperands_Ok() {
        double actual = calculate.calculate(-6, -8, Calculate.PLUS);
        double answer = -14;
        assertEquals(answer, actual);
    }

    @Test
    void additionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculate.calculate(-6, 8, Calculate.PLUS);
        double answer = 2;
        assertEquals(answer, actual);
    }

    @Test
    void additionWithZeroInDifferentPlaces_Ok() {
        double actual = calculate.calculate(0, 8, Calculate.PLUS);
        double answer = 8;
        assertEquals(answer,actual);

        actual = calculate.calculate(6, 0, Calculate.PLUS);
        answer = 6;
        assertEquals(answer,actual);

        actual = calculate.calculate(0, 0, Calculate.PLUS);
        answer = 0;
        assertEquals(answer,actual);
    }

    @Test
    void subtractionWithTwoPositiveOperands_Ok() {
        double actual = calculate.calculate(6, 8, Calculate.MINUS);
        double answer = -2;
        assertEquals(answer, actual);
    }

    @Test
    void subtractionWithTwoNegativeOperands_Ok() {
        double actual = calculate.calculate(-6, -8, Calculate.MINUS);
        double answer = 2;
        assertEquals(answer, actual);
    }

    @Test
    void subtractionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculate.calculate(-6, 8, Calculate.MINUS);
        double answer = -14;
        assertEquals(answer, actual);
    }

    @Test
    void subtractionWithZeroInDifferentPlaces_Ok() {
        double actual = calculate.calculate(0, 8, Calculate.MINUS);
        double answer = -8;
        assertEquals(answer,actual);

        actual = calculate.calculate(6, 0, Calculate.MINUS);
        answer = 6;
        assertEquals(answer,actual);

        actual = calculate.calculate(0, 0, Calculate.MINUS);
        answer = 0;
        assertEquals(answer,actual);
    }

    @Test
    void divisionWithTwoPositiveOperands_Ok() {
        double actual = calculate.calculate(6, 2, Calculate.DIVISION);
        double answer = 3;
        assertEquals(answer, actual);
    }

    @Test
    void divisionWithTwoNegativeOperands_Ok() {
        double actual = calculate.calculate(-6, -2, Calculate.DIVISION);
        double answer = 3;
        assertEquals(answer, actual);
    }

    @Test
    void divisionWithPositiveAndNegativeOperands_Ok() {
        double actual = calculate.calculate(-6, 2, Calculate.DIVISION);
        double answer = -3;
        assertEquals(answer, actual);
    }

    @Test
    void divisionWithZeroInStart_Ok() {
        double actual = calculate.calculate(0, 8, Calculate.DIVISION);
        double answer = 0;
        assertEquals(answer, actual);
    }

    @Test
    void divisionWithZeroInEnd_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculate.calculate(6, 0, Calculate.DIVISION);
        });
    }

    @Test
    void divisionWithZeroInStartAndEnd_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculate.calculate(0, 0, Calculate.DIVISION);
        });
    }

    @Test
    void multiplicationWithTwoPositiveOperands_Ok() {
        double actual = calculate.calculate(6, 8, Calculate.MULTIPLICATION);
        double answer = 48;
        assertEquals(answer, actual);
    }

    @Test
    void multiplicationWithTwoNegativeOperands_Ok() {
        double actual = calculate.calculate(-6, -8, Calculate.MULTIPLICATION);
        double answer = 48;
        assertEquals(answer, actual);
    }

    @Test
    void multiplicationWithPositiveAndNegativeOperands_Ok() {
        double actual = calculate.calculate(-6, 8, Calculate.MULTIPLICATION);
        double answer = -48;
        assertEquals(answer, actual);
    }

    @Test
    void multiplicationWithZeroInDifferentPlaces_Ok() {
        double actual = calculate.calculate(0, 8, Calculate.MULTIPLICATION);
        double answer = 0;
        assertEquals(answer,actual);

        actual = calculate.calculate(6, 0, Calculate.MULTIPLICATION);
        answer = 0;
        assertEquals(answer,actual);

        actual = calculate.calculate(0, 0, Calculate.MULTIPLICATION);
        answer = 0;
        assertEquals(answer,actual);
    }

    @Test
    void raisingPositiveValueToThePositivePower_Ok() {
        double actual = calculate.calculate(5, 2, Calculate.EXPONENTIATION);
        double answer = 25;
        assertEquals(answer,actual);
    }

    @Test
    void raisingNegativeValueToThePositivePower_Ok() {
        double actual = calculate.calculate(-5, 2, Calculate.EXPONENTIATION);
        double answer = 25;
        assertEquals(answer,actual);
    }

    @Test
    void raisingPositiveValueToTheNegativePower_Ok() {
        double actual = calculate.calculate(10, -3, Calculate.EXPONENTIATION);
        double answer = 0.001;
        assertEquals(answer,actual);
    }

    @Test
    void raisingNegativeValueToTheNegativePower_Ok() {
        double actual = calculate.calculate(-10, -3, Calculate.EXPONENTIATION);
        double answer = -0.001;
        assertEquals(answer,actual);
    }

    @Test
    void raisingPositiveValueToZeroPower_Ok() {
        double actual = calculate.calculate(5, 0, Calculate.EXPONENTIATION);
        double answer = 1;
        assertEquals(answer,actual);
    }

    @Test
    void raisingNegativeValueToZeroPower_Ok() {
        double actual = calculate.calculate(-5, 0, Calculate.EXPONENTIATION);
        double answer = 1;
        assertEquals(answer,actual);
    }

    @Test
    void raisingZeroToPower_Ok() {
        double actual = calculate.calculate(0, 0, Calculate.EXPONENTIATION);
        double answer = 1;
        assertEquals(answer,actual);

        actual = calculate.calculate(0, 5, Calculate.EXPONENTIATION);
        answer = 0;
        assertEquals(answer,actual);
    }

    @Test
    void raisingZeroToNegativePower_notOk() {
        assertThrows(ArithmeticException.class, () -> {
            calculate.calculate(0, -5, Calculate.EXPONENTIATION);
        });
    }

    @Test
    void illegalOperation_notOk() {
        assertThrows(NoSuchElementException.class, () -> {
            calculate.calculate(0, 0, '&');
        });
    }
}
