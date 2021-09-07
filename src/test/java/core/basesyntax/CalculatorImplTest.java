package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {
    private static final double delta = 0.0001;
    private static Calculator calculator;
    private double expected;

    @BeforeAll
    static void createCalculatorInstance() {
        calculator = new CalculatorImpl();
    }

    @Test
    void addition_positive_numbersOk() {
        expected = 12;
        assertEquals(expected, calculator.calculate(5, 7, '+'));
    }

    @Test
    void addition_oneNegative_numberOk() {
        expected = 3;
        assertEquals(expected, calculator.calculate(8,-5,'+'));
        assertEquals(expected, calculator.calculate(-5, 8, '+'));
    }

    @Test
    void addition_twoNegativeNumsOk() {
        expected = -23;
        assertEquals(expected, calculator.calculate(-7, -16, '+'));
    }

    @Test
    void addition_zeroNumOk() {
        expected = 41;
        assertEquals(expected, calculator.calculate(41, 0, '+'));
        assertEquals(expected, calculator.calculate(0, 41, '+'));
    }

    @Test
    void addition_floatingPointNumsOk() {
        expected = 64.2;
        assertEquals(expected,calculator.calculate(28.4, 35.8, '+'), delta);
        assertEquals(expected, calculator.calculate(35.8, 28.4, '+'), delta);
        expected = 24.3;
        assertEquals(expected, calculator.calculate(-12.1, 36.4, '+'), delta);
    }

    @Test
    void addition_positive_maxValuesOk() {
        expected = Double.MAX_VALUE;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, 741.5, '+'));
        assertEquals(expected, calculator.calculate(741.5, Double.MAX_VALUE, '+'));
    }

    @Test
    void addiction_maxAndMinValuesOk() {
        expected = 1.7976931348623157E308;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, -232157, '+'));
        assertEquals(expected, calculator.calculate(-232157, Double.MAX_VALUE, '+'));
        expected = 1.0E-323;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '+'));
    }

    @Test
    void infinityTestOk() {
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '+'));
    }

    @Test
    void defaultChar_actionNotOk() {
        assertThrows(RuntimeException.class, () -> calculator.calculate(13, 28, '\u0000'));
    }

    @Test
    void subtraction_twoPositiveNumsOk() {
        expected = 15;
        assertEquals(expected, calculator.calculate(43, 28, '-'));
    }

    @Test
    void subtraction_twoNegativeNumsOk() {
        expected = -11;
        assertEquals(expected, calculator.calculate(-32, -21, '-'));
    }

    @Test
    void subtraction_oneNegativeNumOk() {
        expected = -76;
        assertEquals(expected, calculator.calculate(-53, 23, '-'));
        expected = 76;
        assertEquals(expected, calculator.calculate(23, -53, '-'));
    }

    @Test
    void subtraction_zeroNumOk() {
        expected = -38;
        assertEquals(expected, calculator.calculate(0, 38, '-'));
        expected = 38;
        assertEquals(38, calculator.calculate(38, 0, '-'));
    }

    @Test
    void subtraction_floatingPointNumsOk() {
        expected = -12.2;
        assertEquals(expected, calculator.calculate(33.4, 45.6,'-'), delta);
        expected = 12.2;
        assertEquals(12.2, calculator.calculate(45.6, 33.4, '-'), delta);
    }

    @Test
    void subtraction_minValuesOk() {
        expected = 0;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, Double.MIN_VALUE, '-'));
    }

    @Test
    void subtraction_oneMinValuesOk() {
        expected = -543.4;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, 543.4, '-'), delta);
        expected = 543.4;
        assertEquals(expected, calculator.calculate(543.4, Double.MIN_VALUE, '-'), delta);

    }

    @Test
    void subtraction_MaxValuesOk() {
        expected = 0;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '-'));
    }

    @Test
    void subtraction_oneMaxValueOk() {
        expected = 1.7976931348623157E308;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, 21345, '-'));
        expected = 1.7976931348623157E308;
        assertEquals(-expected, calculator.calculate(21345, Double.MAX_VALUE,'-'));
    }

    @Test
    void multiply_positiveNumsOk() {
        expected = 32;
        assertEquals(expected, calculator.calculate(4, 8, '*'));
        assertEquals(expected, calculator.calculate(8, 4, '*'));
    }

    @Test
    void multiply_negativeNumsOk() {
        expected = 24;
        assertEquals(expected, calculator.calculate(-4, -6, '*'));
        assertEquals(expected, calculator.calculate(-6, -4, '*'));
    }

    @Test
    void multiply_oneNegativeNumOk() {
        expected = -60;
        assertEquals(expected, calculator.calculate(-6, 10, '*'));
        assertEquals(expected, calculator.calculate(10, -6, '*'));
    }

    @Test
    void multiply_byZeroOk() {
        expected = 0;
        assertEquals(expected, calculator.calculate(24, 0, '*'));
        assertEquals(expected, calculator.calculate(0, 24, '*'));
        assertEquals(expected, calculator.calculate(-24, 0, '*'));
    }

    @Test
    void multiply_maxValueByOneOk() {
        expected = Double.MAX_VALUE;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, 1, '*'));
        assertEquals(expected, calculator.calculate(1, Double.MAX_VALUE, '*'));
        assertEquals(-expected, calculator.calculate(Double.MAX_VALUE, -1, '*'));
    }

    @Test
    void multiply_maxValueOk() {
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '*'));
        assertEquals(-expected, calculator.calculate(Double.MAX_VALUE, -Double.MAX_VALUE, '*'));
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, 48, '*'));
    }

    @Test
    void multiply_minValuesOk() {
        expected = 0;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, -Double.MIN_VALUE, '*'));
        expected = 1.14E-322;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, 23, '*'));
        assertEquals(expected, calculator.calculate(23, Double.MIN_VALUE, '*'));
        assertEquals(-expected, calculator.calculate(-23, Double.MIN_VALUE, '*'));
    }

    @Test
    void multiply_floatingPointNumbersOk() {
        expected = 176.64;
        assertEquals(expected, calculator.calculate(38.4, 4.6,'*'), delta);
        assertEquals(-expected, calculator.calculate(-38.4, 4.6, '*'), delta);
    }

    @Test
    void division_positiveNumsOk() {
        expected = 3;
        assertEquals(expected, calculator.calculate(9, 3,'/'));
        expected = 0.3333333333333333;
        assertEquals(expected, calculator.calculate(3, 9, '/'), delta);
    }

    @Test
    void division_byZeroNotOk() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(4, 0, '/'));
    }

    @Test
    void division_negativeNumsOk() {
        expected = 1.25;
        assertEquals(expected, calculator.calculate(-5, -4, '/'), delta);
    }

    @Test
    void division_oneNegitiveNumOk() {
        expected = -4;
        assertEquals(expected, calculator.calculate(32, -8, '/'));
        expected = -0.25;
        assertEquals(expected, calculator.calculate(-8, 32, '/'), delta);
    }

    @Test
    void division_floatingPointNumsOk() {
        expected = 4.982456140350877;
        assertEquals(expected, calculator.calculate(28.4, 5.7, '/'), delta);
    }

    @Test
    void division_MaxNumsOk() {
        expected = 1;
        assertEquals(expected, calculator.calculate(Double.MAX_VALUE, Double.MAX_VALUE, '/'));
        expected = 2.9482228625220422E-307;
        assertEquals(expected, calculator.calculate(53, Double.MAX_VALUE,'/'), delta);
        expected = -2.9482228625220422E-307;
        assertEquals(expected, calculator.calculate(53, -Double.MAX_VALUE, '/'), delta);
    }

    @Test
    void division_minValueOk() {
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(48, Double.MIN_VALUE, '/'));
        assertEquals(-expected, calculator.calculate(-48, Double.MIN_VALUE, '/'));
        expected = 0;
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, 48, '/'));
        assertEquals(expected, calculator.calculate(Double.MIN_VALUE, -48, '/'));
    }

    @Test
    void raisingToAPower_NegativePowerOk() {
        expected = 0.015625;
        assertEquals(expected, calculator.calculate(4, -3, '^'), delta);
        expected = -0.015625;
        assertEquals(expected, calculator.calculate(-4, -3, '^'), delta);
    }

    @Test
    void raisingToPower_PositivePowerOk() {
        expected = -243;
        assertEquals(expected, calculator.calculate(-3, 5, '^'));
        assertEquals(-expected, calculator.calculate(3, 5, '^'));
    }

    @Test
    void infinityValuesNotOk() {
        assertThrows(RuntimeException.class, () ->
                calculator.calculate(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, '/'));
    }

    @Test
    void raisingToPower_zeroToPowerOk() {
        expected = 0;
        assertEquals(expected, calculator.calculate(0, 12,'^'));
        expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, calculator.calculate(0, -12, '^'));
    }

    @Test
    void raisingToPower_zeroPowerOk() {
        expected = 1;
        assertEquals(expected, calculator.calculate(80, 0, '^'));
        assertEquals(expected, calculator.calculate(-80, 0, '^'));
    }
}
