import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private static final double DELTA = 0.0001;
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void calculate_additionPositiveOperands_Ok() {
        double actual = calculator.calculate(10.5, 20, '+');
        double expected = 30.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_dditionNegativeOperands_Ok() {
        double actual = calculator.calculate(-10.5, -20, '+');
        double expected = -30.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(-10.5, 20, '+');
        double expected = 9.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithFirstZeroOperand_Ok() {
        double actual = calculator.calculate(0, 20, '+');
        double expected = 20;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithSecondZeroOperand_Ok() {
        double actual = calculator.calculate(10.5, 0, '+');
        double expected = 10.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithZeroOperands_Ok() {
        double actual = calculator.calculate(0, 0, '+');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_additionWithMaxDoubleValues_Ok() {
        double expected = Double.MAX_VALUE + Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '+');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractionPositiveOperands_Ok() {
        double actual = calculator.calculate(20.5, 10, '-');
        double expected = 10.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionNegativeOperands_Ok() {
        double actual = calculator.calculate(-10.5, -20, '-');
        double expected = 9.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(10.5, -20, '-');
        double expected = 30.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithFirstZeroOperand_Ok() {
        double actual = calculator.calculate(0, 20, '-');
        double expected = -20;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithSecondZeroOperand_Ok() {
        double actual = calculator.calculate(10.5, 0, '-');
        double expected = 10.5;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithZeroOperands_Ok() {
        double actual = calculator.calculate(0, 0, '-');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_subtractionWithMaxDoubleValues_Ok() {
        double expected = Double.MAX_VALUE - Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '-');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplicationPositiveOperands_Ok() {
        double actual = calculator.calculate(10.5, 20, '*');
        double expected = 210;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationNegativeOperands_Ok() {
        double actual = calculator.calculate(-10.5, -20, '*');
        double expected = 210;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(-10.5, 20, '*');
        double expected = -210;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithFirstZeroOperand_Ok() {
        double actual = calculator.calculate(0, 20, '*');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithSecondZeroOperand_Ok() {
        double actual = calculator.calculate(10.5, 0, '*');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithZeroOperands_Ok() {
        double actual = calculator.calculate(0, 0, '*');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_multiplicationWithMaxDoubleValues_Ok() {
        double expected = Double.MAX_VALUE * Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '*');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divisionPositiveOperands_Ok() {
        double actual = calculator.calculate(10.5, 20, '/');
        double expected = 0.525;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionNegativeOperands_Ok() {
        double actual = calculator.calculate(-10.5, -20, '/');
        double expected = 0.525;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionPositiveAndNegativeOperands_Ok() {
        double actual = calculator.calculate(-10.5, 20, '/');
        double expected = -0.525;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithFirstZeroOperand_Ok() {
        double actual = calculator.calculate(0, 20, '/');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_divisionWithSecondZeroOperand_notOk() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(10.5,0, '/');
        });
    }

    @Test
    void calculate_divisionWithZeroOperands_notOk() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(0,0, '/');
        });
    }

    @Test
    void calculate_divisionWithMaxDoubleValues_Ok() {
        double expected = Double.MAX_VALUE / Double.MIN_VALUE;
        double actual = calculator.calculate(Double.MAX_VALUE, Double.MIN_VALUE, '/');
        assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raisingPositiveValueToPositivePower_Ok() {
        double actual = calculator.calculate(10, 2, '^');
        double expected = 100;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToPositivePower_Ok() {
        double actual = calculator.calculate(-10, 2, '^');
        double expected = 100;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingPositiveValueToNegativePower_Ok() {
        double actual = calculator.calculate(100, -1, '^');
        double expected = 0.01;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingNegativeValueToNegativePower_Ok() {
        double actual = calculator.calculate(-1, -1, '^');
        double expected = -1;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_raisingZetoToPower_Ok() {
        double actual = calculator.calculate(0, 2, '^');
        double expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void calculate_illegalOperation_notOk() {
        char illegalOperation = '%';
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(10.5,0, illegalOperation);
        });
    }

}
