package core.basesyntax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    public static final double DELTA = 0.0001;
    private static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @Test
    void calculate_addTwoPositiveValues_OK() {
        double actual = calculator.calculate(25.3554, 87.2445, '+');
        double expected = 112.5999;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addTwoNegativeValues_OK() {
        double actual = calculator.calculate(-745.9523, -943.9534, '+');
        double expected = -1689.9057;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addPositiveAndNegativeValues_OK() {
        double actual = calculator.calculate(-25.3554, 87.2445, '+');
        double expected = 61.8891;
        Assertions.assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(-87.2445, 25.3554, '+');
        expected = -61.8891;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addZeroInDifferentPlaces_OK() {
        double actual = calculator.calculate(25.3554, 0, '+');
        double expected = 25.3554;
        Assertions.assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(0, 25.3554, '+');
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addDoubleMaxValue_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, 87.2445, '+');
        double expected = 1.7976931348623157E308;
        Assertions.assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(25.3554, Double.MAX_VALUE, '+');
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_addDoubleMinValue_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, 25.3554, '+');
        double expected = 25.3554;
        Assertions.assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(25.3554, Double.MIN_VALUE, '+');
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractTwoPositiveValues_OK() {
        double actual = calculator.calculate(25.3554, 87.2445,'-');
        double expected = -61.8891;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractTwoNegativeValues_OK() {
        double actual = calculator.calculate(-745.9523, -943.9534,'-');
        double expected = 198.00109999999995;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractPositiveAndNegativeValues_OK() {
        double actual = calculator.calculate(-25.3554, 87.2445,'-');
        double expected = -112.5999;
        Assertions.assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(25.3554, -87.2445,'-');
        expected = 112.5999;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractZeroInDifferentPlaces_OK() {
        double actual = calculator.calculate(25.3554, 0,'-');
        double expected = 25.3554;
        Assertions.assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(0, 25.3554,'-');
        expected = -25.3554;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractDoubleMaxValue_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, 87.2445,'-');
        double expected = 1.7976931348623157E308;
        Assertions.assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(25.3554, Double.MAX_VALUE,'-');
        expected = -1.7976931348623157E308;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_subtractDoubleMinValue_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, 25.3554,'-');
        double expected = -25.3554;
        Assertions.assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(25.3554, Double.MIN_VALUE,'-');
        expected = 25.3554;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divideTwoPositiveValues_OK() {
        double actual = calculator.calculate(87.2445,25.3554,'/');
        double expected = 3.440864667881398;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divideTwoNegativeValues_OK() {
        double actual = calculator.calculate(-87.2445,-25.3554,'/');
        double expected = 3.440864667881398;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_dividePositiveAndNegativeValues_OK() {
        double actual = calculator.calculate(-25.3554, 87.2445,'/');
        double expected = -0.2906246239017932;
        Assertions.assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(87.2445, -25.3554,'/');
        expected = -3.440864667881398;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divideZeroInDifferentPlaces_OK() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator
                .calculate(25.3554, 0,'/'));
        double actual = calculator.calculate(0, 25.3554,'/');
        double expected = 0.0;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divideDoubleMaxValue_OK() {
        double actual = calculator.calculate(Double.MAX_VALUE, 87.2445,'/');
        double expected = 2.0605231674917222E306;
        Assertions.assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(87.2445, Double.MAX_VALUE,'/');
        expected = 4.853136406213289E-307;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_divideDoubleMinValue_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, 87.2445,'/');
        double expected = 0.0;
        Assertions.assertEquals(expected, actual, DELTA);
        Assertions.assertThrows(ArithmeticException.class, () -> calculator
                .calculate(25.3554, Double.MIN_VALUE,'/'));
    }

    @Test
    void calculate_multiplyTwoPositiveValues_OK() {
        double actual = calculator.calculate(25.3554, 87.2445,'*');
        double expected = 2212.1191953000002;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyTwoNegativeValues_OK() {
        double actual = calculator.calculate(-745.9523, -943.9534,'*');
        double expected = 704144.20982282;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyPositiveAndNegativeValues_OK() {
        double actual = calculator.calculate(-25.3554, 87.2445,'*');
        double expected = -2212.1191953000002;
        Assertions.assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(-87.2445, 25.3554,'*');
        expected = -2212.1191953000002;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyZeroInDifferentPlaces_OK() {
        double actual = calculator.calculate(25.3554, 0,'*');
        double expected = 0;
        Assertions.assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(0, 25.3554,'*');
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyDoubleMaxValue_OK() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator
                .calculate(Double.MAX_VALUE, 1.1,'*'));
        Assertions.assertThrows(ArithmeticException.class, () -> calculator
                .calculate(1.1, Double.MAX_VALUE,'*'));
        double actual = calculator.calculate(0.7, Double.MAX_VALUE,'*');
        double expected = 1.2583851944036209E308;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_multiplyDoubleMinValue_OK() {
        double actual = calculator.calculate(Double.MIN_VALUE, 25.3554,'*');
        double expected = 1.24E-322;
        Assertions.assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(25.3554, Double.MIN_VALUE,'*');
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raiseToPositivePower_OK() {
        double actual = calculator.calculate(87.2445, 2.532,'^');
        double expected = 82025.47668849025;
        Assertions.assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(-25.3554, 3.0,'^');
        expected = -16300.893077275463;
        Assertions.assertEquals(expected, actual, DELTA);
        Assertions.assertThrows(ArithmeticException.class, () -> calculator
                .calculate(-25.3554, 3.3,'^'));

    }

    @Test
    void calculate_raiseToNegativePower_OK() {
        double actual = calculator.calculate(87.2445, -2.532,'^');
        double expected = 1.2191334209464207E-5;
        Assertions.assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(-87.2445, -3.0,'^');
        expected = -1.5058642598673879E-6;
        Assertions.assertEquals(expected, actual, DELTA);
        Assertions.assertThrows(ArithmeticException.class, () -> calculator
                .calculate(-87.2445, -3.3,'^'));
    }

    @Test
    void calculate_raiseToZeroPower_OK() {
        double actual = calculator.calculate(87.2445, 0,'^');
        double expected = 1;
        Assertions.assertEquals(expected, actual, DELTA);
        actual = calculator.calculate(-87.2445, 0,'^');
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_raiseZeroToPower_OK() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator
                .calculate(0, -3.3,'^'));
        double actual = calculator.calculate(0, 2.325,'^');
        double expected = 0.0;
        Assertions.assertEquals(expected, actual, DELTA);
    }

    @Test
    void calculate_wrongOperation_NotOK() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator
                .calculate(5,5,'j'));
    }
}
